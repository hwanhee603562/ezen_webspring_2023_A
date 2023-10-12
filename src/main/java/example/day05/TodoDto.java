package example.day05;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Getter@Setter
public class TodoDto {
    private  int tno;
    private String tcontent;    //내용
    private boolean tstate;      // 상태

}
