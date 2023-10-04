package day02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
// Spring MVC 외 추가된 서블릿을 검색해서 컴포넌트 등록
// 개발자가 스프링외 추가등록된 코드를 스프링이 알 수 있도록 등록

@SpringBootApplication
public class WebStart {

    public static void main(String[] args) {
        SpringApplication.run( WebStart.class );
    }


}

/*



*/