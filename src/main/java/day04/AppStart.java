package day04;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 모든 컴포넌트들을 찾아서 빈에 등록
@SpringBootApplication
public class AppStart {
    public static void main(String[] args) {
        SpringApplication.run( AppStart.class );
    }
}

/*

    - 정적파일 생성 위치
    스프링이 view 파일들을 찾는 위치 resources폴더
    HTML : resources -> templates -> html파일
    JS/CSS/IMAGE : resources -> static -> JS/CSS/Image파일

    - JSP프로젝트와 SPRING 프로젝트의 정적파일 경로 차이
        - JSP는 패키지의 경로와 패키지의 파일명이 곧 URL
    - SPRING은 정적파일 호출하는 URL 매핑



*/
















