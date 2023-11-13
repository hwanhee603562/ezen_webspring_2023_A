package ezenweb.model.dto;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Column;
import java.util.List;

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


    // ===================== 등록용
    // + 첨부파일이 여러개 일때
    private List<MultipartFile> fileList;
    // + 카테고리
    private int pcno;           // 카테고리 번호


    // ===================== 출력용
    private ProductCategoryDto categoryDto;
    private List<ProductImgDto> imgList;


}






























