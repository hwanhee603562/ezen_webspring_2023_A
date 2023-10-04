package day03.restful;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController // @ResponseBody가 포함되어 있는 controller 어노테이션
public class RestController4 {
    // 1. GET
    @GetMapping( "/day03/blue" )    // @RequestMapping과 기능은 동일하지만 더 이후에 나온 것으로 짧게 줄일 수 있음
    public String getBlue(HttpServletRequest request) throws IOException{
        // 1. 요청
        String param1 = request.getParameter("param1");
        System.out.println("param1 = " +param1);

        return "정상응답";
    }

    // 2. POST
    @PostMapping( "/day03/blue" )
    public String postBlue(HttpServletRequest request) throws IOException{
        // 1. 요청
        String param1 = request.getParameter("param1");
        System.out.println("param1 = " +param1);

        return "정상응답";
    }

    // 3. PUT
    @PutMapping( "/day03/blue" )
    public String putBlue(HttpServletRequest request) throws IOException{
        // 1. 요청
        String param1 = request.getParameter("param1");
        System.out.println("param1 = " +param1);

        return "정상응답";
    }

    // 4. DELETE
    @DeleteMapping( "/day03/blue" )
    public String deleteBlue(HttpServletRequest request) throws IOException{
        // 1. 요청
        String param1 = request.getParameter("param1");
        System.out.println("param1 = " +param1);

        return "정상응답";
    }
}
