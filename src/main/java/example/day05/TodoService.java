package example.day05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

    /*

        JPA 엔티티 테이블 CRUD
            삽입                      : insert     인터페이스명.save(저장할 엔티티)
            조회                      : select     인터페이스명.findAll()
            삭제                      : delete     인터페이스명.delete()
            삭제할 아이디 찾아서 삭제     : delete     인터페이스명.deleteById(pk번호)
                - ( 반환타입 : 검색된 엔티티 1개 Optional<TodoEntity>  )
     */

@Service
public class TodoService {

    @Autowired  // 스프링 컨테이너에서 빈(객체) 주입
                // (전제조건 : 컨테이너에 등록되어있어야 함)

    // 엔티티 인터페이스
    private TodoEntityRepository todoEntityRepository;

    public boolean doPost( TodoDto todoDto){

        // 1. 엔티티 insert

            // 1. 저장할 객체 호출
        TodoEntity todoEntity = TodoEntity.builder().
                tcontent( todoDto.getTcontent() ).
                tstate( todoDto.isTstate() ).
            build();

            // 2. 엔티티 insert 기능 실행
        todoEntityRepository.save(todoEntity);
        return false;
    }

    public List<TodoDto> doGet(){

        // 2. 엔티티 select

            // 1. 모든 엔티티 호출
        List<TodoEntity> todoEntities = todoEntityRepository.findAll();

            // 2. List<TodoEntity> -> List<TodoDto> 변환
        List<TodoDto> list = new ArrayList<>();

                // 2-1 호출된 todoEntities 꺼내기
        todoEntities.forEach( entity ->{
                // 2-2 각 호출된 필드를 저장
            TodoDto todoDto = TodoDto.builder().
                tno( entity.getTno() ).
                tcontent( entity.getTcontent() ).
                tstate( entity.isTstate() ).
            build();

                // 2-3 변환된 Dto 1개 list에 저장
            list.add( todoDto );

        });

        return list;

        /*
            주의

            Application.properties 에 "spring.jpa.hibernate.ddl-auto = create" 로 인해
            서버를 다시 실행할 시 테이블이 초기화 됨
            
            ※ 임시적으로 update로 변경 필요

         */



    }

    public boolean doPut( TodoDto todoDto ){


        return false;
    }

    public boolean doDelete(int tno) {

        // 4. 삭제할 엔티티 찾기
        todoEntityRepository.deleteById( tno );

        return false;
    }
}




















