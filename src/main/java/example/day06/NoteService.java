package example.day06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NoteService {

    @Autowired
    private NoteEntityRepository noteEntityRepository;

    // 1. C
    public boolean bWrite( NoteDto noteDto ){

        // 1. dto --> 엔티티 변경

        noteEntityRepository.save( noteDto.toEntity());
        return false;
    }
    // 2. R
    public List<NoteDto> bList(){
        // 1. 엔티티 -> dto 변경
        List<NoteEntity> entities = noteEntityRepository.findAll();
        List<NoteDto> noteDtos = new ArrayList<>();
        entities.forEach(e -> {noteDtos.add( e.toDto() ); } );


        return noteDtos;
    }
    // 3. U
    @Transactional
    public boolean bUpdate(  NoteDto noteDto ){
        // 1. 수정할 pk번호에 해당하는 엔티티 찾기. ( 엔티티를 포장[Option]안전 = null 방지) 해서 반환
        Optional<NoteEntity>optionalNoteEntity
                = noteEntityRepository.findById( noteDto.getNo());
        // 2. 포장내 내용물이 있는지 체크 = 안전하게 검토.. 과정
        if( optionalNoteEntity.isPresent() ) {
            // 3. 포장내 내용물 꺼내기 = 포장된곳에서 엔티티 꺼내는 과정
            NoteEntity noteEntity = optionalNoteEntity.get();
            // 4. 수정 : 별도의 수정함수가 없고요.. 엔티티 객체의 필드를 수정하면 DB도 같이 수정 [ 매핑이 된 상태니까 ]
            noteEntity.setTitle( noteDto.getTitle() );
            noteEntity.setWriter( noteDto.getWriter() );
        }

        return false;
    }
    // 4. D
    public boolean bDelete( int no ){
        noteEntityRepository.deleteById(no ); // 삭제할 pk번호를 대입하여 엔티티 삭제
        return false;
    }




}
