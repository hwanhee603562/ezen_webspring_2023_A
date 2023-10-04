package day01.lombok;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor  // 빈생성자 자동생성
@AllArgsConstructor // 풀생성자  자동생성
@Getter@Setter      // getter setter
@ToString           // toString 메소드 자동생성
@Builder            // 빌더 패턴

public class LombokDto {

    private int tno;         // todo 번호
    private String title;   // todo 내용
    private LocalDate dueDate; // todo 작성일
    private boolean finished;   // todo 실행여부

    
}
