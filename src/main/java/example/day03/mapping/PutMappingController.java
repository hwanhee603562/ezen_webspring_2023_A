package example.day03.mapping;


import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController //@Controller와 @ResponseBody를 같이 사용하는 어노테이션
@RequestMapping("/example/day03/put")
public class PutMappingController {
    // 1.
    @PutMapping("/method1")
    public ParamDto method1(@RequestBody ParamDto paramDto){
        return paramDto;
    }
    // 2.
    @PutMapping("/method2")
    public Map<String, String> method2(@RequestBody Map<String, String> map){
        return map;
    }

}
