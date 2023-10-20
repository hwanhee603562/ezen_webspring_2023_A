package 과제.과제02;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ono;
    @Column
    private int oprice;
    @ToString.Exclude @ManyToOne @JoinColumn(name="pno_fk")
    private ProductEntity product;


}
