package example.day04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// 스프링 빈 : 스프링 컨테이너(저장소)에 저장된 객체
// [ 이유 : 스프링이 대신 객체 관리 => 여러개발자들이 작업했을 때 기준 ]


@Controller // Spring mvc 중 해당 클래스를 Controller로 사용
            // 스프링 컨테이너 빈 등록
@RestController         // Controller + ResponseBody
@RequestMapping("/todo")    // HTTP로부터의 해당 클래스의 매핑 주소 만들기
                            // 공통 URL
public class TodoController {

    // 미리 등록된 스프링 컨테이너(빈)을 찾아서 주입
    @Autowired
    private TodoService todoService; // 서비스 객체
    // 이전에  사용하였던 '싱글톤'을 대체한다

    // REST : HTTP기반으로 메소드 GET, POST, PUT, DELETE 메소드 이용한 웹 서비스
    
    // 1.
    @PostMapping("")        // @RequestMapping 에서 지정한 공통 url에서 추가하지않음
    //@ResponseBody  : 응답 객체 자동 지원 [단, 해당 클래스가 @RestController일 경우 생략가능]
    public boolean doPost( @RequestBody TodoDto todoDto ){    // 요청 매개변수 : 입력받은 정보들 [ DTO ]
        // @RequestBody : JSON 형식으로 요청 매핑
        System.out.println("Controller doPost");
        System.out.println("todoDto : "+todoDto);
        return todoService.doPost( todoDto );
    }
    // 2.
    @GetMapping("")
    public List<TodoDto> doGet(){     // 요청 매개변수 : 출력에 필요한 정보들 [ x ]
        System.out.println("Controller doGet");
        return todoService.doGet();
    }
    // 3.
    @PutMapping("")
    public boolean doPut( @RequestBody TodoDto todoDto ){     // 요청 매개변수 : 수정에 필요한 정보들 [ DTO ]
        System.out.println("Controller doPut");
        System.out.println("todoDto : "+todoDto);
        return todoService.doPut( todoDto );
    }
    // 4.
    @DeleteMapping("")
    public boolean doDelete( @RequestParam int tno ){  // 요청 매개변수 : 삭제에 필요한 정보들 [ int ]
        // @RequestParam : 쿼리스트링 매개변수
        System.out.println("Controller doDelete");
        System.out.println("tno : "+tno);

        return todoService.doDelete( tno );
    }
    // 5. HTML 반환 매핑 주소만들기
    @GetMapping("/index")
    public Resource index(){

        return new ClassPathResource("templates/todo.html");
    }

}






















