package day01.webMvc;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication      // springboot 의존성 [ MVC, RESTful, 내장톰캣 등 지원 ]
public class WebStart {
    public static void main(String[] args) {
        SpringApplication.run( WebStart.class );    // spring 시작
    }
}
