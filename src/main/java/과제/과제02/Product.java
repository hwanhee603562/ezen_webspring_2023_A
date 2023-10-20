package 과제.과제02;

import lombok.*;

import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Product {

    private int pno;
    private String pname;
    @ToString.Exclude
    private Category category;
    @Builder.Default
    @OneToMany(mappedBy = "orderEntity")
    List<Order> orderList = new ArrayList<>();

    public void print(){
        
        try {
            for(int i=0;i<orderList.size();i++)
            {
                System.out.printf("주문번호 :%d 주문 가격 :%d \n",orderList.get(i).getOno(),orderList.get(i).getOprice());
            }
        } catch ( Exception e ){
            System.out.println("다시 선택해주세요");
        }

    }
}
