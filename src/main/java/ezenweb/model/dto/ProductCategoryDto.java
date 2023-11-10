package ezenweb.model.dto;

import ezenweb.model.entity.ProductEntity;
import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Builder
public class ProductCategoryDto {

    private int pcno;       // 카테고리번호 [pk]
    private String pcname;  // 카테고리명


}
