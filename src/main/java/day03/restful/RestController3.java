package day03.restful;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController // @ResponseBody가 포함되어 있는 controller 어노테이션
public class RestController3 {
    // 1. GET
    @RequestMapping( value = "/day03/red", method= RequestMethod.GET )
    public String getRed(HttpServletRequest request) throws IOException{
        // 1. 요청
        String param1 = request.getParameter("param1");
        System.out.println("param1 = " +param1);

        return "정상응답";
    }

    // 2. POST
    @RequestMapping( value = "/day03/red", method= RequestMethod.POST )
    public String postRed(HttpServletRequest request) throws IOException{
        // 1. 요청
        String param1 = request.getParameter("param1");
        System.out.println("param1 = " +param1);

        return "정상응답";
    }

    // 3. PUT
    @RequestMapping( value = "/day03/red", method= RequestMethod.PUT )
    public String putRed(HttpServletRequest request) throws IOException{
        // 1. 요청
        String param1 = request.getParameter("param1");
        System.out.println("param1 = " +param1);

        return "정상응답";
    }

    // 4. DELETE
    @RequestMapping( value = "/day03/red", method= RequestMethod.DELETE )
    public String deleteRed(HttpServletRequest request) throws IOException{
        // 1. 요청
        String param1 = request.getParameter("param1");
        System.out.println("param1 = " +param1);

        return "정상응답";
    }
}
