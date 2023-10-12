package example.day03.mapping;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/example/day03/post")
public class PostMappingController {

    /*
        HttpServletRequest를 사용하여도 요청 가능
     */
    // 1.
    @PostMapping("/method1")
    //public String method1(@RequestParam String param1){   // form
    public String method1(@RequestBody String param1){     // json
        System.out.println( "param1 = "+param1 );
        return "정상응답";
    }

    // 2.
    @PostMapping("/method2")
    //public String method2(@RequestParam Map<String, String> map){ // form
    public String method2(@RequestBody Map<String, String> map){ // json
        // DTO 권장하지만 DTO가 없을 때 여러 개 매개변수 매핑할 때
        System.out.println( "map = "+map );

        return "정상응답";
    }
        // 출력 map = {param1=강호동, param2=유재석}
        // map 프레임웍도 key - value로 이루어져 있음

    // 3.
    @PostMapping("/method3")
    //public String method3(@RequestParam ParamDto paramDto ){ // form
    public String method3(@RequestBody ParamDto paramDto ){ // json
        System.out.println("paramDto = "+paramDto);

        return "정상응답";
    }
    

}












