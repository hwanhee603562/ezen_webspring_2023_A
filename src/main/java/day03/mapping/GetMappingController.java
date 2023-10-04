package day03.mapping;


import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;

@RestController // @Controller와 @ResponseBody를 같이 사용하는 어노테이션
@RequestMapping( "/day03/get" ) // 공통 URL
public class GetMappingController {
    // 1.
    @GetMapping("/method1")
    public String method1( HttpServletRequest request ){
        // 함수의 반환타입이 String인 이유     : @ResponseBody가 자동으로 반환타입이 String이면
        //                                   resp.setContentType( "Text/html; charset=utf-8" ) 을 제공

        String param1 = request.getParameter("param1");
        System.out.println("param1 = "+param1);

        return "정상응답";
        // return "정상응답"으로 작성한 이유   : @ResponseBody가 자동으로 resp.getWriter().println("정상응답") 을 제공
    }
    // 2.
    @GetMapping("/method2")
    public String method2(@RequestParam String param1){
    // @RequestParam + 문자열 + 변수명  :   HttpServletRequest request 을 제공
        System.out.println("param1 = "+param1);

        return "정상응답";
    }
    // 3. @RequestParam 두 개 이상 사용
    @GetMapping("/method3")
    public String method3( @RequestParam String param1, @RequestParam String param2 ){
        System.out.println("param1 = "+param1 + ", param2 = "+param2);
        return "정상응답";
    }
    // 4. 여러 개 매개변수를 DTO로 자동 변환 매핑
    @GetMapping("/method4")
    public String method4( ParamDto paramDto ){
        // DTO를 사용하기 위한 전제조건은 DTO 필드에 맞게 입력해야하며
        // @Getter @Setter를 사용해야한다
        System.out.println("paramDto = " + paramDto);

        return "정상응답";
    }
    // 5. 여러 개 매개변수를 @ModelAttribute / DTO로 자동 변환 제공
    @GetMapping("/method5")
    public String method5( @ModelAttribute ParamDto paramDto ){
        // DTO를 사용하기 위한 전제조건은 DTO 필드에 맞게 입력해야하며
        // @Getter @Setter를 사용해야한다
        System.out.println("paramDto = " + paramDto);

        return "정상응답";
    }
    // 6. 쿼리스트링( URL?매개변수=값 )   VS   경로매개변수( URL/값1/값2 )
        // 3번(쿼리스트링 방식)과 비교
            // PathVariable방식은 쿼리스트링과 달리 '키'가 없이 '값'만 존재하기에
            // 매개변수 상에 '키'를 별도로 지정해주어야 함
        // ServerSocket("URL/{매개변수}/{매개변수}")
    @GetMapping("/method6/{param1}/{param2}")   // PathVariable 방식
    public String method6( @PathVariable("param1") String param1, @PathVariable("param2") String param2 ){

        System.out.println("param1 = "+param1 + ", param2 = "+param2);

        return "정상응답";
    }
    // 7. 경로매개변수 방식도 DTO 지원
    @GetMapping("/method7/{param1}/{param2}")   // PathVariable 방식
    public String method7( ParamDto paramDto ){

        System.out.println("paramDto = "+paramDto);

        return "정상응답";
    }
    // 8. 경로매개변수 방식도 @ModelAttribute / DTO 지원
    @GetMapping("/method8/{param1}/{param2}")   // PathVariable 방식
    public String method8( @ModelAttribute ParamDto paramDto ){

        System.out.println("paramDto = "+paramDto);

        return "정상응답";
    }
}
