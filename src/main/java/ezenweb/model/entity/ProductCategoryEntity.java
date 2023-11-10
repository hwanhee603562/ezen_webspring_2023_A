package ezenweb.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Entity
@Table(name = "productcategory")
public class ProductCategoryEntity extends BaseTime{
    /* 제품 카테고리 */
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private int pcno;       // 카테고리번호 [pk]
    @Column
    private String pcname;  // 카테고리명
    @OneToMany( fetch=FetchType.LAZY  , mappedBy = "productCategoryEntity" , cascade = CascadeType.ALL )
    private List<ProductEntity> productEntityList = new ArrayList<>();











}
