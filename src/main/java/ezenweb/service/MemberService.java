package ezenweb.service;

import ezenweb.model.dto.MemberDto;
import ezenweb.model.entity.MemberEntity;
import ezenweb.model.repository.MemberEntityRepository;
import jdk.nashorn.internal.ir.RuntimeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

    /*

        JPA 엔티티 테이블 CRUD
            삽입                      : insert     인터페이스명.save(저장할 엔티티)
            조회                      : select     인터페이스명.findAll()
                                                  인터페이스명.findId()
            수정                      : update     인터페이스명.save(수정할 엔티티)
            삭제                      : delete     인터페이스명.delete()
            삭제할 아이디 찾아서 삭제     : delete     인터페이스명.deleteById(pk번호)
                - ( 반환타입 : 검색된 엔티티 1개 Optional<TodoEntity>  )

        Optional 클래스 : null 관련 메소드 제공 [ nullPointerException 발생에 대한 안전성을 보장 ]
        - nullPointerException : null 상태인 객체에 접근( '.' )하고자 할 때 발생

     */


@Service
public class MemberService implements UserDetailsService {


    // -------------------------------------------------- //
        // 1. UserDetailsService 구현체
        // 2. 인증처리 해주는 메소드 구현 (localUserByUsername)
        // 3. loadUserByUsername 메소드 무조건 UserDetails 객체를 반환해야 한다
        // 4. UserDetails객체를 이용한 패스워드 검증과 사용자 권한을 확인하는 확인하는 동작(메소드)


    // @Autowired : 사용불가( 스프링 컨테이너에 등록 안된 빈(객체) 이므로 불가능 / 우리가 만든 클래스 또는 인터페이스가 아님 )
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    // 9. 회원정보 호출
    @Transactional
    public MemberDto getMember() {

        // ! : 시큐리티 사용하기 전에는 서블릿 세션을 이용한 로그인상태 저장
        // 시큐리티 사용할 때는 일단 서블릿 세션이 아닌 시큐리티 저장소를 이용
        System.out.println( "시큐리티에 저장된 세션 정보 저장소 : "
                + SecurityContextHolder.getContext());
        System.out.println( "시큐리티에 저장된 세션 정보 저장소에 저장된 인증 : "
                + SecurityContextHolder.getContext().getAuthentication() );
        System.out.println( "시큐리티에 저장된 세션 정보 저장소에 저장된 인증 호출 : "
                + SecurityContextHolder.getContext().getAuthentication().getPrincipal() ); // 해당 서비스를 호출한 HTTP

        // * 인증에 성공한 정보 호출 [ 세션 호출 ]
        Object o = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println( o.toString() );
        // 1. 만약에 인증결과가 실패/없으면
        if( o.equals("anonymousUser") ) return null;
        // 2. 인증결과에 저장된 UserDetails로 반환
        UserDetails userDetails = (UserDetails)o;
        // 3. UserDetails의 정보를 memberDto에 담아서 반환
        return MemberDto.builder()
                .memail( userDetails.getUsername() )
                .build();

    }



    // 8. 로그인
    @Override
    public UserDetails loadUserByUsername(String memail) throws UsernameNotFoundException {

        // * login 페이지에서 form을 통해 전송된 아이디 받고 (패스워드는 없음)
        System.out.println("loadUserByUsername username = "+memail);

        // 1. 사용자의 아이디만으로 사용자 정보[엔티티]를 로딩 [불러오기]
        MemberEntity memberEntity = memberEntityRepository.findByMemail( memail );
            // 없는 아이디이면
            // throw : 예외처리 던지기
            // new UsernameNotFoundException(  ) : username이 없을 때 사용하는 예외 클래스
        if( memberEntity == null ){
            throw new UsernameNotFoundException( "없는 아이디입니다" );
        }
        UserDetails userDetails = User.builder()
                .username( memberEntity.getMemail() )       // 찾은 사용자 정보의 아이디
                .password( memberEntity.getMpassword() )    // 찾은 사용자의 정보 내 패스워드
                .authorities( memberEntity.getMrole() )     // 찾은 사용자 정보의 권한
                .build();

        // 2. 로딩된 사용자의 정보를 이용해서 패스워드를 검증

        return userDetails;
    }


    // 2. 인증처리 해주는 메소드 구현



    // -------------------------------------------------- //


    @Autowired
    private MemberEntityRepository memberEntityRepository;

    // 1-1. [c] 회원가입
    @Transactional
    public boolean postMember( MemberDto memberDto) {

        // ------------------- 암호화 -------------------- //

        // 입력받은 비밀번호[ passwordEncoder.encode() ]를 암호화해서 memberDto에 저장
        memberDto.setMpassword( passwordEncoder.encode( memberDto.getMpassword() ));


        // ---------------------------------------------- //


        // 1. dto -> entity 변경 후 repository 통한 insert 후 결과 entity 받기
        MemberEntity memberEntity = memberEntityRepository.save( memberDto.toEntity() );

        // 2. insert 된 엔티티 확인 후 성공/실패 유무
        if( memberEntity.getMno() >= 1 ){
            return true;
        }

        return false;
    }
    // 1-2. 로그인
    @Transactional
    public boolean login( MemberDto memberDto  ) {
        // 1. 입력받은 데이터[아이디/패스워드] 검증하기
        List<MemberEntity> memberEntities = memberEntityRepository.findAll();
        // 2. 동일한 아이디 / 비밀번호 찾기
        for( int i = 0 ; i < memberEntities.size() ; i++ ) {
            MemberEntity m = memberEntities.get(i);
            // 3. 동일한 데이터 엔티티 찾았다.
            if (m.getMemail().equals(memberDto.getMemail()) &&
                    m.getMpassword().equals(memberDto.getMpassword())) {
                // 4. 세션 부여      // 세션 저장
                request.getSession().setAttribute("loginDto", m.toDto());
                return true;
            }
        }
        return false;
    }


    /*
    // 2-1. [r] 회원정보 호출 [ 1명 ]
    @Transactional
    public MemberDto getMember( int mno ){

        // 1. mno[ 회원번호 pk ]를 이용한 회원 엔티티 찾기
        Optional<MemberEntity> optionlMemberEntity = memberEntityRepository.findById( mno );

        // 2. optional클래스로 검색한 반환값 확인
        if( optionlMemberEntity.isPresent() ){
            // 3. 만일 optional 클래스 안에 엔티티가 들어있으면

            // 4. optional 클래스에서 엔티티 꺼내기
            MemberEntity memberEntity = optionlMemberEntity.get();

            // 5. entity -> dto 변환해서 반환
            return memberEntity.toDto();

        }

        return null;
    }
    */

    @Autowired
    private HttpServletRequest request;
    
    /*
    // 2-1. [r] 회원정보 호출 [ 1명 ]
    public MemberDto getMember(){
        // 1. 세션 호출
        Object session = request.getSession().getAttribute("loginDto");
        // 2. 세션 검증
        if( session != null ){
            return (MemberDto) session;
        }
        return null;
    }

    // 2-2 로그아웃
    @Transactional
    public boolean logout( HttpSession session ) {

        session.removeAttribute("loginDto");

        return true;
    }
    */
    
    
    @Transactional
    // 2-3 아이디 찾기
    public String findId( String mname, String mphone ){

        Optional< MemberEntity > optionlMemberEntity = memberEntityRepository.findByMnameAndMphone(mname, mphone);

        // 2. optional클래스로 검색한 반환값 확인
        if( optionlMemberEntity.isPresent() ){
            // 3. 만일 optional 클래스 안에 엔티티가 들어있으면

            // 4. optional 클래스에서 엔티티 꺼내기
            MemberEntity memberEntity = optionlMemberEntity.get();

            return memberEntity.getMemail();
        }

        return "입력 정보를 확인해주세요";
    }

    @Transactional
    // 2-4 비밀번호 찾기
    public String findByPassword( String memail, String mphone ){

        Optional< MemberEntity > optionlMemberEntity = memberEntityRepository.findByMemailAndMphone(memail, mphone);

        // 2. optional클래스로 검색한 반환값 확인
        if( optionlMemberEntity.isPresent() ){
            // 3. 만일 optional 클래스 안에 엔티티가 들어있으면

            // 4. optional 클래스에서 엔티티 꺼내기
            MemberEntity memberEntity = optionlMemberEntity.get();


            return memberEntity.getMpassword();
        }

        return "입력 정보를 확인해주세요";

    }


    // 3. [u] 회원정보 수정
    @Transactional
    public boolean updateMember( MemberDto memberDto ){

        // 1. 수정할 엔티티 찾기 [ mno ]
        Optional< MemberEntity > optionlMemberEntity = memberEntityRepository.findById( memberDto.getMno() );

        // 2. optional클래스로 검색한 반환값 확인
        if( optionlMemberEntity.isPresent() ){

            // 3. 엔티티 꺼내기
            MemberEntity memberEntity = optionlMemberEntity.get();

            // 4. 엔티티 수정 [ 엔티티 객체를 수정하면 엔티티는 테이블과 매핑된 상태이므로 DB의 정보도 같이 수정 ]
            memberEntity.setMname( memberDto.getMname() );
            memberEntity.setMpassword( memberDto.getMpassword() );
            memberEntity.setMphone( memberDto.getMphone() );

            // 5. 성공시
            return true;

        }

        return false;
    }


    // 4. [d] 회원탈퇴
    @Transactional
    public boolean deleteMember( int mno, HttpSession session ){

        // 1. 삭제할 엔티티 찾기 [ mno ]
        Optional<MemberEntity> optionlMemberEntity = memberEntityRepository.findById( mno );

        // 2. 만약에 삭제할 엔티티가 반환/검색 존재하면
        if( optionlMemberEntity.isPresent() ){
            memberEntityRepository.deleteById( mno );
            // 3. 삭제 성공시 세션 제거를 위해 로그아웃
            //logout( session );
            return true;
        }

        return false;
    }

    // 7. [r] 이메일 중복검사
    public boolean getFindMemail(String memail){

        // 1. 이메일을 이용한 엔티티 찾기
        return memberEntityRepository.existsByMemail( memail );
    
    }

}















