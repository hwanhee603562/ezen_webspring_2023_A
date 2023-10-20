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
public class ProductEntity {
    @Id
    private int pno;
    private String pname;
    @ToString.Exclude
    @JoinColumn(name = "cno_fk")
    @ManyToOne
    private CategoryEntity categoryEntity;
    @Builder.Default
    @OneToMany(mappedBy ="product")
    private List<OrderEntity> orderList = new ArrayList<>();


}
