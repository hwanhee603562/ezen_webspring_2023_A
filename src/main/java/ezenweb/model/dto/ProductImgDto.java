package ezenweb.model.dto;

import lombok.*;

import javax.persistence.Column;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Builder
public class ProductImgDto {
    private String uuidFileName;        // 이미지 식별이름 [pk]
    private String realFileName;    // 이미지실제이름
}
