package ezenweb.service;

import ezenweb.model.dto.BoardDto;
import ezenweb.model.entity.BoardEntity;
import ezenweb.model.repository.BoardEntityRepository;
import ezenweb.model.repository.MemberEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BoardService {

    @Autowired
    private BoardEntityRepository boardEntityRepository;

    @Transactional
    public boolean write( BoardDto boardDto ){
        
        // 1. dto -> entity 변환 후 저장된 엔티티 반환
        BoardEntity boardEntity = boardEntityRepository.save( boardDto.saveToEntity() );

        // 2.
        if( boardEntity.getBno() >= 1 ){
            return true;
        }

        return false;
    }

    // 2.
    @Transactional
    public List<BoardDto> getAll(){

        // 1. 모든 게시물 호출
        List<BoardEntity> boardEntities = boardEntityRepository.findAll();
        // 2. List<BoardEntity>  -->  List<BoardDto>
        List<BoardDto> boardDtos = new ArrayList<>();

        boardEntities.forEach( e-> {
           boardDtos.add( e.allToDto() );
        });

        return boardDtos;
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














}
