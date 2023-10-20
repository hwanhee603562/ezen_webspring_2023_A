package example.객체연관관계;

public class Main2 {
    public static void main(String[] args) {
        // 1. 상위클래스 객체 만들기
        상위클래스 A객체 = 상위클래스.builder().data("A").build();
        // 2. 하위클래스 객체 만들기
        하위클래스 B객체 = 하위클래스.builder().data("B").build();
        하위클래스 C객체 = 하위클래스.builder().data("C").build();

        // 3. 관계
            // 상위클래스[1] <-------> 하위클래스[M]  : 1:M   하나의 여러개를 참조한다
            // A객체가 B/C객체를 참조한다
        A객체.get참조하위객체들().add(B객체);  // A객체  내 B객체를 참조할 수 있게 리스트 add
        A객체.get참조하위객체들().add(C객체);  // A객체  내 C객체를 참조할 수 있게 리스트 add

        System.out.println("A = "+A객체);

        // 양방향 참조
        // 상위객체를 통해 하위객체의 필드를 알 수 있다
        System.out.println("A객체가 가지고 있는 하위객체들 중 첫번째 객체의 데이터 출력 : "
                + A객체.get참조하위객체들().get(0).getData() );
        System.out.println("B객체가 가지고 있는 상위 객체의 데이터 출력 : "
                + B객체.get상위객체().getData() );


    }
}
