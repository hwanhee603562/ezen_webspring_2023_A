package 과제.과제02;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Category {

    private int cno;
    private String cname;
    @Builder.Default
    private List<Product> productList = new ArrayList<>();

    public void print(){
        for(int i=0;i<productList.size();i++)
        {
            System.out.print((i+1)+"." + productList.get(i).getPname());
        }
        System.out.print("\n>> ");
        Scanner sc = new Scanner(System.in);
        productList.get(sc.nextInt() -1 ).print();
    }
}
