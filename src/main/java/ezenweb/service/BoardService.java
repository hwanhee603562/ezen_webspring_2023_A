package ezenweb.service;

import ezenweb.model.dto.BoardDto;
import ezenweb.model.dto.MemberDto;
import ezenweb.model.dto.PageDto;
import ezenweb.model.entity.BoardEntity;
import ezenweb.model.entity.MemberEntity;
import ezenweb.model.repository.BoardEntityRepository;
import ezenweb.model.repository.MemberEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BoardService {

    @Autowired
    private BoardEntityRepository boardEntityRepository;
    @Autowired
    private MemberService memberService;
    @Autowired
    private MemberEntityRepository memberEntityRepository;
    @Autowired
    private FileService fileService;


    @Transactional
    public boolean write( BoardDto boardDto ){

        // ============== 단방향

        // 유효성 검사 [글쓰기 전 로그인 상태 확인
        MemberDto loginDto = memberService.getMember();
        if( loginDto == null ) return false;

        // 회원번호를 가지고 pk엔티티 찾기
        Optional<MemberEntity> memberEntityOptional =
                memberEntityRepository.findById( memberService.getMember().getMno() );

        // 유효성 검사 [로그인이 안된 상태 글쓰기 실패]
        if( !memberEntityOptional.isPresent() ) return false;

        // 단방향 저장
            // 게시물 생성
        BoardEntity boardEntity = boardEntityRepository.save( boardDto.saveToEntity() );
            // 게시물에 작성자 엔티티 넣어주기
        boardEntity.setMemberEntity(memberEntityOptional.get());


        // ============== 단방향 end


        // ============== 양방향 ( 위 코드는 기존 단방향 방식이기에 양방향을 사용할 때는 아래 코드를 추가 )
            // 회원 엔티티에 게시물 엔티티 넣어주기
        memberEntityOptional.get().getBoardEntityList().add( boardEntity );


        if( boardEntity.getBno() >= 1 ){
            // 게시물 쓰기 성공시 파일처리
            String filename
                    = fileService.fileUpload( boardDto.getFile() );
            // 파일처리 결과를 DB에 저장
            if( filename != null ) boardEntity.setBfile( filename );

            return true;
        }

        return false;
    }

    // 2.
    @Transactional
    public PageDto getAll( int page, String key, String keyword, int view ){

        // * JPA 페이징처리 라이브러리 지원
            // 1. Pageable : 페이지 인터페이스
            // 2. 구현체 : 
                // of (현재페이지, 페이지별게시물수) 
                    // 현재페이지 0 부터 시작
                    // 페이지별 게시물 수 : 만약 2일 때는 페이지마다 게시물 2개씩 출력
            // 3. Page : list와 마찬가지로 여러 개의 객체를 저장하는 타입
                //
        Pageable pageable = PageRequest.of( page-1, view );

        // 1. 모든 게시물 호출
        //Page<BoardEntity> boardEntities = boardEntityRepository.findAll( pageable );
        Page<BoardEntity> boardEntities = boardEntityRepository.findBySearch( key, keyword, pageable );

        // 2. List<BoardEntity>  -->  List<BoardDto>
        List<BoardDto> boardDtos = new ArrayList<>();

        boardEntities.forEach( e-> {
           boardDtos.add( e.allToDto() );
        });

        // 3. 총 페이지 수
        int totalPages = boardEntities.getTotalPages();

        // 4. 총 게시물 수
        Long totalCount = boardEntities.getTotalElements(); // 요소 : 게시물 1개

        // 5. pageDto 구성해서 axios에게 전달 DIS
        PageDto pageDto = PageDto.builder()
                .boardDtos( boardDtos )
                .totalPages( totalPages )
                .totalCount( totalCount )
                .build();


        return pageDto;
    }
    
    

    // 3.
    @Transactional
    public boolean update( BoardDto boardDto ){

        // 1. 수정할 엔티티 찾기 [ bno 해서 ]
        Optional<BoardEntity> optionalBoardEntity = boardEntityRepository.findById( boardDto.getBno() );

        // 2. 만약에 수정할 엔티티가 존재하면
        if( optionalBoardEntity.isPresent() ){
            // 3. 엔티티 꺼내기
            BoardEntity boardEntity = optionalBoardEntity.get();
            // 4. 엔티티 객체를 수정하면 테이블 내 레코드도 같이 수정
            boardEntity.setBtitle( boardDto.getBtitle() );
            boardEntity.setBcontent( boardDto.getBcontent() );
            boardEntity.setBfile( boardDto.getBfile() );

            return true;
        }

        return false;
    }

    // 4.
    @Transactional
    public boolean delete( @RequestParam int bno ){

        // 1. 엔티티 호출
        Optional<BoardEntity> optionalBoardEntity = boardEntityRepository.findById( bno );
        // 2. 엔티티가 호출 되었는지 확인
        if( optionalBoardEntity.isPresent() ){
            // 3. 삭제
            boardEntityRepository.deleteById( bno );
            return true;
        }

        return false;
    }


    // 5 [2-2] 개별게시물 출력
    @Transactional
    public BoardDto doGet( int bno ){

        // 1. pk번호에 해당하는 엔티티 찾기
        Optional<BoardEntity> optionalBoardEntity = boardEntityRepository.findById( bno );

        if( optionalBoardEntity.isPresent() ){
            // 3. 엔티티 꺼내기
            BoardEntity boardEntity = optionalBoardEntity.get();
    
            // 조회수 증가
            boardEntity.setBview( boardEntity.getBno()+1 );

            // 4. 엔티티 -> dto 변환
            BoardDto boardDto = boardEntity.allToDto();

            // 5. dto 반환
            return boardDto;
        }

        return null;
    }











}
