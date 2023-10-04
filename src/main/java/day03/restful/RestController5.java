package day03.restful;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController // @ResponseBody가 포함되어 있는 controller 어노테이션
@RequestMapping( value = "/day03" ) // URL 경로 상 'day03'이 중복되기 때문에 공통 url로 사용하는 것을 의미함
public class RestController5 {
    // 1. GET
    @GetMapping( "/pink" )
    public String getPink(HttpServletRequest request) throws IOException{
        // 1. 요청
        String param1 = request.getParameter("param1");
        System.out.println("param1 = " +param1);

        return "정상응답";
    }

    // 2. POST
    @PostMapping( "/pink" )
    public String postPink(HttpServletRequest request) throws IOException{
        // 1. 요청
        String param1 = request.getParameter("param1");
        System.out.println("param1 = " +param1);

        return "정상응답";
    }

    // 3. PUT
    @PutMapping( "/pink" )
    public String putPink(HttpServletRequest request) throws IOException{
        // 1. 요청
        String param1 = request.getParameter("param1");
        System.out.println("param1 = " +param1);

        return "정상응답";
    }

    // 4. DELETE
    @DeleteMapping( "/pink" )
    public String deletePink(HttpServletRequest request) throws IOException{
        // 1. 요청
        String param1 = request.getParameter("param1");
        System.out.println("param1 = " +param1);

        return "정상응답";
    }
}
