package ezenweb.service;

import ezenweb.model.dto.MemberDto;
import ezenweb.model.entity.MemberEntity;
import ezenweb.model.repository.MemberEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
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
public class MemberService {

    @Autowired
    private MemberEntityRepository memberEntityRepository;

    // 1-1. [c] 회원가입
    @Transactional
    public boolean postMember( MemberDto memberDto) {

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
    public boolean login( String memail, String mpassword, HttpSession session ) {

        Optional< MemberEntity > optionlMemberEntity = memberEntityRepository.findByMemail( memail );
        Optional< MemberEntity > optionlMemberEntity2 = memberEntityRepository.findByMpassword( mpassword );
        
        // 2. optional클래스로 검색한 반환값 확인
        if( optionlMemberEntity.isPresent() && optionlMemberEntity2.isPresent() ){
            // 3. 만일 optional 클래스 안에 엔티티가 들어있으면

            // 4. optional 클래스에서 엔티티 꺼내기
            MemberEntity memberEntity = optionlMemberEntity.get();

            // 5. 세션 저장
            session.setAttribute("loginEntity", memberEntity); // 세션에 로그인 정보 저장

            MemberEntity loggedInMember = (MemberEntity) session.getAttribute("loginEntity");

            System.out.println("로그인 성공");
            System.out.println(loggedInMember);

            return true;
        }
        
        

        return false;
    }


    // 2-1. [r] 회원정보 호출 [ 1명 ]
    @Transactional
    public MemberDto getMember( int mno){

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
    // 2-2 로그아웃
    @Transactional
    public boolean logout( HttpSession session ) {

        session.removeAttribute("loginEntity");

        System.out.println("로그아웃에 성공하였습니다");
        return true;
    }

    @Transactional
    // 2-3 아이디 찾기
    public String findId( String mname, String mphone ){
        System.out.println( mname );
        System.out.println( mphone );

        Optional< MemberEntity > optionlMemberEntity = memberEntityRepository.findByMnameAndMphone(mname, mphone);

        // 2. optional클래스로 검색한 반환값 확인
        if( optionlMemberEntity.isPresent() ){
            // 3. 만일 optional 클래스 안에 엔티티가 들어있으면

            // 4. optional 클래스에서 엔티티 꺼내기
            MemberEntity memberEntity = optionlMemberEntity.get();

            System.out.println(memberEntity);
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
    public boolean updateMember( MemberDto memberDto){

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
    public boolean deleteMember( int mno){

        // 1. 삭제할 엔티티 찾기 [ mno ]
        Optional<MemberEntity> optionlMemberEntity = memberEntityRepository.findById( mno );

        // 2. 만약에 삭제할 엔티티가 반환/검색 존재하면
        if( optionlMemberEntity.isPresent() ){
            memberEntityRepository.deleteById( mno );
            return true;
        }
        
        return false;
    }

}
