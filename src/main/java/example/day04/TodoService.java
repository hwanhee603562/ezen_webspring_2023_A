package example.day04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// MVC 3티어 계층에서 사용되는 Service 계층
// [ 비즈니스로직 : 기능 처리 공간 ]
@Service    // Spring MVC 중 해당 클래스를 Service로 사용 // 스프링 빈 등록
public class TodoService {

    // 미리 등록된 스프링 컨테이너(빈)을 찾아서 주입
    @Autowired
    private TodoDao todoDao; // 서비스 객체
    // 이전에  사용하였던 '싱글톤'을 대체한다

    // 1. [ C ]
    public boolean doPost(TodoDto todoDto) {
        System.out.println("Service doPost");
        System.out.println("todoDto : " + todoDto);
        return todoDao.doPost(todoDto);
    }

    // 2. [ R ]
    public List<TodoDto> doGet() {
        System.out.println("Service doGet");
        return todoDao.doGet();
    }

    // 3. [ U ]
    public boolean doPut(TodoDto todoDto) {

        todoDto.setTstate( !todoDto.isTstate() );


        return todoDao.doPut(todoDto);
    }

    // 4. [ D ]
    public boolean doDelete(int tno) {
        System.out.println("Service doDelete");
        System.out.println("tno : " + tno);
        return todoDao.doDelete(tno);
    }


}
