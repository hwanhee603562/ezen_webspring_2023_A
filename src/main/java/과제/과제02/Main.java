package 과제.과제02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Scanner;

@SpringBootApplication
public class Main {
    // 카테고리 샘플

    public static void main(String[] args) {
        SpringApplication.run(Main.class);
        int count = 1;
        ProductEntity asd = new ProductEntity();

        OrderEntity wer = new OrderEntity();

        // 카테고리 리스트 선언
        ArrayList<Category> categoryList = new ArrayList<>();
        categoryList.add( Category.builder().cno(++count).cname("음료").build() );
        categoryList.add( Category.builder().cno(++count).cname("커피").build() );
        categoryList.add( Category.builder().cno(++count).cname("케이크").build() );

        count = 1;
        //제품 리스트 선언
        ArrayList<Product> pro1List = new ArrayList<>();
        pro1List.add(Product.builder().pno(++count).pname("사이다").category(categoryList.get(0)).build());
        pro1List.add(Product.builder().pno(++count).pname("콜라").category(categoryList.get(0)).build());
        pro1List.add(Product.builder().pno(++count).pname("환타").category(categoryList.get(0)).build());
        categoryList.get(0).setProductList(pro1List);

        ArrayList<Product> pro2List = new ArrayList<>();
        pro2List.add(Product.builder().pno(++count).pname("아메리카노").category(categoryList.get(1)).build());
        pro2List.add(Product.builder().pno(++count).pname("카페라떼").category(categoryList.get(1)).build());
        pro2List.add(Product.builder().pno(++count).pname("아인슈페너").category(categoryList.get(1)).build());
        categoryList.get(1).setProductList(pro2List);

        ArrayList<Product> pro3List = new ArrayList<>();
        pro3List.add(Product.builder().pno(++count).pname("치즈케이크").category(categoryList.get(2)).build());
        pro3List.add(Product.builder().pno(++count).pname("초코케이크").category(categoryList.get(2)).build());
        pro3List.add(Product.builder().pno(++count).pname("생크림케이크").category(categoryList.get(2)).build());
        categoryList.get(2).setProductList(pro3List);

        categoryList.get(1).getProductList().get(0).orderList.add(Order.builder().ono(1).oprice(8500).build());
        categoryList.get(1).getProductList().get(0).orderList.add(Order.builder().ono(2).oprice(7200).build());
        categoryList.get(0).getProductList().get(1).orderList.add(Order.builder().ono(3).oprice(5400).build());

        //제품 선택
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<categoryList.size();i++)
        {
            System.out.print((i+1)+"." + categoryList.get(i).getCname());
        }
        System.out.print("\n>> ");
        categoryList.get(sc.nextInt()-1).print();




    }

    
    
}
