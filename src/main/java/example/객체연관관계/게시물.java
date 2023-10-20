package example.객체연관관계;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class 게시물 {
    private int 게시물번호;
    private String 게시물제목;
    private String 게시물내용;
    @ToString.Exclude   // 해당 필드는 @ToString에서 제외
                        // 주로 fk에서 사용하는 것을 권장
    private 회원 작성한회원;


}
