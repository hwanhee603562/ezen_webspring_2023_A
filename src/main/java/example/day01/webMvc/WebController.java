package example.day01.webMvc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController // 해당 클래스를 restful로 사용하겠다는 선언
public class WebController {    // Talend API를 통한 테스트 진행
    // chrome-extension://aejoelaoggembcahagimdiliamlcdmfm/index.html#requests
        // http://localhost:8080/day01/doget
        // http://localhost:8080/day01/dopost
    @GetMapping("/example/day01/doget")     // HTTP로 부터 GET 요청을 했을 때
    public List<WebDto> doGet(){

        WebDao webDao = new WebDao();
        List<WebDto> result = webDao.doGet();

        return result;
    }

    @PostMapping("/example/day01/dopost")   // HTTP로 부터 POST 요청을 했을 때
    public boolean doPost( String title ){

        // 1. 인수 받아서 DTO 생성
        WebDto webDto = new WebDto( 0, title, LocalDate.now(), true );
        WebDao webDao = new WebDao();
        boolean result = webDao.doPost(webDto);

        return false;

    }

    @GetMapping("/test")
    public String doGettest(){
        return "안녕 여기는 스프링 컨트롤이야";
    }




}
