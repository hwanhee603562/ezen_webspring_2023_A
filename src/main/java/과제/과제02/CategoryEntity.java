package 과제.과제02;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity
public class CategoryEntity {
    @Id
    private int cno;
    @Column
    private String cname;
    @Builder.Default
    @OneToMany(mappedBy = "categoryEntity")
    private List<ProductEntity> productList = new ArrayList<>();

}
