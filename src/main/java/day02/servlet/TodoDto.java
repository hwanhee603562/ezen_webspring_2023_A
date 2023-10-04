package day02.servlet;

import lombok.*;

import java.time.LocalDate;

// 롬복 라이브러리 설치되었다는 가정 하에
@Getter // 각 필드별 get메소드 자동 생성
@Setter // 각 필드별 set메소드 자동 생성
@ToString   // 객체의 필드정보를 출력하는 toString 메소드를 자동생성 
@NoArgsConstructor  // 빈생성자
@AllArgsConstructor // 풀생성자
@Builder            // 뷜더패턴 : 객체 생성시 사용할 수 있는 함수 [ 생성자보다 자율성이 높음 ]
public class TodoDto {
    
    private Long tno;
    private String title;
    private LocalDate dueDate;
    private boolean finished;


    
}
