package 과제.과제01;

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
public class TodosEntity {

    @Id // PK로 선정할 필드 => tno
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private int pno;
    private String pname;
    private int phone;

}
