package ezenweb.model.entity;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Entity
@Table(name = "productimg")
public class ProductImgEntity extends BaseTime {
    /* 제품이미지 파일 */
    @Id
    private String uuidFileName;        // 이미지 식별이름 [pk]
    @Column
    private String realFileName;    // 이미지실제이름
    @ToString.Exclude // toString() 함수에서 제외되는 필드
    @JoinColumn( name = "pno" ) // FK필드로 사용
    @ManyToOne        // 다수가 하나에게
    private ProductEntity productEntity;
}
