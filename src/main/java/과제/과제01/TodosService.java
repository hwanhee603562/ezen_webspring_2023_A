package 과제.과제01;


import example.day05.TodoEntity;
import example.day05.TodoEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TodosService {

    @Autowired  // 스프링 컨테이너에서 빈(객체) 주입
    // (전제조건 : 컨테이너에 등록되어있어야 함)

    // 엔티티 인터페이스
    private TodosEntityRepository todosEntityRepository;

    public boolean doPost( TodosDto todosDto){

        // 1. 엔티티 insert

        // 1. 저장할 객체 호출
        TodosEntity todosEntity = TodosEntity.builder().
                pname( todosDto.getPname() ).
                phone( todosDto.getPhone() ).
                build();

        // 2. 엔티티 insert 기능 실행
        todosEntityRepository.save(todosEntity);
        return false;

    }

    public List<TodosDto> doGet(){

        // 2. 엔티티 select

        // 1. 모든 엔티티 호출
        List<TodosEntity> todosEntities = todosEntityRepository.findAll();

        // 2. List<TodoEntity> -> List<TodoDto> 변환
        List<TodosDto> list = new ArrayList<>();

        // 2-1 호출된 todoEntities 꺼내기
        todosEntities.forEach( entity ->{
            // 2-2 각 호출된 필드를 저장
            TodosDto todosDto = TodosDto.builder().
                    pno( entity.getPno() ).
                    pname( entity.getPname() ).
                    phone( entity.getPhone() ).
                    build();

            // 2-3 변환된 Dto 1개 list에 저장
            list.add( todosDto );

        });

        return list;

        /*
            주의

            Application.properties 에 "spring.jpa.hibernate.ddl-auto = create" 로 인해
            서버를 다시 실행할 시 테이블이 초기화 됨

            ※ 임시적으로 update로 변경 필요

         */



    }

    @Transactional
    // 사실상 트랜잭션은 모든 함수에서 사용해야 한다
    public boolean doPut( TodosDto todosDto ){

        // 3. 수정할 엔티티 찾은 후 수정하기 update

        // 3-1 수정할 pk 찾기
        // Optional클래스를 통해 null에 대한 안전성을 보장
        // => findById의 반환타입은 Optional
        Optional<TodosEntity> todosEntity = todosEntityRepository.findById( todosDto.getPno() );

        // isPresent() : Optional클래스의 함수로서, 값이 null이면 false / 존재하면 true
        if ( todosEntity.isPresent() ){

            // 3-2. Optional 객체에 엔티티 꺼내기
            TodosEntity updateEntity = todosEntity.get();

            // 3-3. 수정 객체를 필드 저장
            // 엔티티를 찾았기 때문에 해당 필드를 이용하여 수정
            updateEntity.setPname( todosDto.getPname() );
            updateEntity.setPhone( todosDto.getPhone() );

            // 3-4. 수정
            todosEntityRepository.save( updateEntity );

            return true;

        }

        return false;
    }

    public boolean doDelete(int pno) {

        // 4. 삭제할 엔티티 찾은 후 삭제하기 delete

        todosEntityRepository.deleteById( pno );

        return false;
    }

}
