package example.day03.restful;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller // 해당 클래스를 스프링MVC 중 컨트롤러 객체로 사용
public class RestController2 {
    // 1. GET
    @RequestMapping( value = "/example/day03/orange", method= RequestMethod.GET )
    @ResponseBody
    public String getBlack(HttpServletRequest request) throws IOException{
        // 1. 요청
        String param1 = request.getParameter("param1");
        System.out.println("param1 = " +param1);

        return "정상응답";
    }

    // 2. POST
    @RequestMapping( value = "/example/day03/orange", method= RequestMethod.POST )
    @ResponseBody
    public String postBlack(HttpServletRequest request) throws IOException{
        // 1. 요청
        String param1 = request.getParameter("param1");
        System.out.println("param1 = " +param1);

        return "정상응답";
    }

    // 3. PUT
    @RequestMapping( value = "/example/day03/orange", method= RequestMethod.PUT )
    @ResponseBody
    public String putBlack(HttpServletRequest request) throws IOException{
        // 1. 요청
        String param1 = request.getParameter("param1");
        System.out.println("param1 = " +param1);

        return "정상응답";
    }

    // 4. DELETE
    @RequestMapping( value = "/example/day03/orange", method= RequestMethod.DELETE )
    @ResponseBody
    public String deleteBlack(HttpServletRequest request) throws IOException{
        // 1. 요청
        String param1 = request.getParameter("param1");
        System.out.println("param1 = " +param1);

        return "정상응답";
    }
}
