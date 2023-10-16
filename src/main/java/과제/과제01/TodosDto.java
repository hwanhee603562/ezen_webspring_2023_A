package 과제.과제01;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Getter
@Setter
public class TodosDto {

    private int pno;
    private String pname;    //이름
    private int phone;  // 상태

}
