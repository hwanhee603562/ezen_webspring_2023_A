package example.day06;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity // 해당 클래스가 엔티티임을 주입하여 실제 테이블 매핑 역할 수행
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class NoteEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY  )
    private int no;             // 게시물번호
    private String title;     // 게시물내용
    private String writer;      // 작성자
    private String password;    // 비밀번호
    private LocalDate date;     // 작성일

    // * 엔티티를 dto로 변환해주는 함수
    public NoteDto toDto(){

        return new NoteDto().builder().no( no ).title( title ).writer( writer ).password( password ).date(date).build();

    }


}





















