package example.day01.webMvc;

import lombok.*;

import java.time.LocalDate;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
// [ p.76 ] 참고
public class WebDto {   // todo

    private int no;         // todo 번호
    private String title;   // todo 내용
    private LocalDate dueDate; // todo 작성일
    private boolean finished;   // todo 실행여부

}
