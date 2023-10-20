package example.객체연관관계;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class 상위클래스 {
    private String data;
    @Builder.Default    // 해당 필드를 null이 아닌 '비어있는', 즉, 참조하위객체들.length == 0;이 됨
    private List<하위클래스> 참조하위객체들 = new ArrayList<>();
}
