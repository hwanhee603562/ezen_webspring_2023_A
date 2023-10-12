package example.day03.restful;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller // 해당 클래스를 스프링MVC 중 컨트롤러 객체로 사용
public class RestController1 {
    // 1. GET
    @RequestMapping( value = "/example/day03/black", method= RequestMethod.GET )
    public void getBlack(HttpServletRequest request, HttpServletResponse response) throws IOException{
        // 1. 요청
        String param1 = request.getParameter("param1");
        System.out.println("param1 = " +param1);
        // 2. 응답
        response.setContentType("text/html; charset=utf-8");
        response.getWriter().println("정상응답");
    }

    // 2. POST
    @RequestMapping( value = "/example/day03/black", method= RequestMethod.POST )
    public void postBlack(HttpServletRequest request, HttpServletResponse response) throws IOException{
        // 1. 요청
        String param1 = request.getParameter("param1");
        System.out.println("param1 = " +param1);
        // 2. 응답
        response.setContentType("text/html; charset=utf-8");
        response.getWriter().println("정상응답");
    }

    // 3. PUT
    @RequestMapping( value = "/example/day03/black", method= RequestMethod.PUT )
    public void putBlack(HttpServletRequest request, HttpServletResponse response) throws IOException{
        // 1. 요청
        String param1 = request.getParameter("param1");
        System.out.println("param1 = " +param1);
        // 2. 응답
        response.setContentType("text/html; charset=utf-8");
        response.getWriter().println("정상응답");
    }

    // 4. DELETE
    @RequestMapping( value = "/example/day03/black", method= RequestMethod.DELETE )
    public void deleteBlack(HttpServletRequest request, HttpServletResponse response) throws IOException{
        // 1. 요청
        String param1 = request.getParameter("param1");
        System.out.println("param1 = " +param1);
        // 2. 응답
        response.setContentType("text/html; charset=utf-8");
        response.getWriter().println("정상응답");
    }
}
