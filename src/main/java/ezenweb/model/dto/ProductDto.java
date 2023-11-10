package ezenweb.model.dto;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Column;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Builder
public class ProductDto {
    private String pno;         // 제품번호 [pk]
    private String pname;       // 제품명
    private String pcomment;    // 제품설명
    private int pprice;         // 제품가격
    private byte pstate;        // 제품상태     [0:판매중  1:판매중지  2:재고없음  3:폐기]
    private int pstock;         // 제품재고
}
