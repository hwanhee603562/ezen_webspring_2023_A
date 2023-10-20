package 과제.과제02;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Order {

    private int ono;
    private int oprice;
    @ToString.Exclude
    private ProductEntity product;


}
