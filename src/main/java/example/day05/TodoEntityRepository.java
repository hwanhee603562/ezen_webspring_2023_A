package example.day05;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// * 엔티티를 조작하는 (인터페이스) 리모컨 만들기
@Repository // 스프링 컨테이너에 빈 등록
public interface TodoEntityRepository extends JpaRepository< TodoEntity, Integer > {


// < (엔티티 컬럼을 지정한 클래스명), (해당 클래스의 pk 타입) >

    /*
        엔티티 조작 [인터페이스]
        - JPARepository
            * 기본적인 CRUD 해당하는 SQL 지원
        - JpaSpecificationExecutor
     */

}
