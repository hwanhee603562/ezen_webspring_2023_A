package ezenweb.model.entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

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
@Table(name = "product")
public class ProductEntity extends BaseTime {
    /* 제품테이블 */
    @Id
    private String pno;         // 제품번호 [pk]
    @Column
    private String pname;       // 제품명
    @Column( columnDefinition = "LONGTEXT" )
    private String pcomment;    // 제품설명
    @Column
    private int pprice;         // 제품가격
    @Column
    @ColumnDefault("0")
    private byte pstate;        // 제품상태     [0:판매중  1:판매중지  2:재고없음  3:폐기]
    @Column
    @ColumnDefault("0")
    private int pstock;         // 제품재고
    @OneToMany( fetch=FetchType.LAZY, mappedBy = "productEntity", cascade=CascadeType.ALL )   // 하나가 다수에게 [ pk ]
    private List<ProductImgEntity> productImgEntityList = new ArrayList<>();
    @ToString.Exclude
    @JoinColumn( name = "pcno" )
    @ManyToOne
    private ProductCategoryEntity productCategoryEntity;






}
