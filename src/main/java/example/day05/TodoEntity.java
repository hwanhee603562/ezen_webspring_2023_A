package example.day05;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity // JPA(ORM매핑) MYSQL 테이블과 매핑
@Builder // 빌더 패턴
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TodoEntity {

    /*
        기존 사용했던 SQL DB 테이블 생성

            drop table if exists todo;
            create table todo(
            tno int auto_increment,
            tcontent varchar(100),
            tstate boolean,
            primary key(tno)
    );
     */

    // Application.properties 에 "spring.jpa.hibernate.ddl-auto = create" 로 인해
    // 아래 필드가 DB에 컬럼으로 생성됨

    @Id // PK로 선정할 필드 => tno
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private int tno;
    private String tcontent;
    private boolean tstate;

}
