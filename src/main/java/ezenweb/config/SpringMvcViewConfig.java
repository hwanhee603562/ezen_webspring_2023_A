package ezenweb.config;

/*
    기존 스프링 MVC 아키텍처에서는
        CONTROLLER가 VIEW 반환하는 작업 진행
        - 문제점   : 리액트와 스프링이 통합되었을 때
            리액트 라우터( Link, get ), 스프링( get )
        - 스프링 안에 리액트가 포함되므로 get요청시 스프링 매핑 우선
        - 문제해결 : get요청시 view 매핑 경로를 찾을 때
*/

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class SpringMvcViewConfig extends WebMvcConfigurerAdapter{

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        //super.addViewControllers(registry);
        registry.addViewController("/{spring:\\w+}").setViewName("forward:/");
        registry.addViewController("/**/{spring:\\w+}").setViewName("forward:/");
        registry.addViewController("/{spring:\\w+}/**{spring:?!(\\.js|\\.css)$}").setViewName("forward:/");


    }
}
