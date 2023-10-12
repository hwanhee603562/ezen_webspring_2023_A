package example.day05;

import example.day05.TodoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {
    @Autowired
    private  TodoService todoService;

    @PostMapping
    public boolean doPost( @RequestBody TodoDto todoDto){
        // @RequestBody => Dto 와 매개변수가 동일해야 하고 setter가 있어야한다!.
        boolean result=todoService.dopost(todoDto);
        return result;
    }

    @GetMapping
    public List<TodoDto> doGet(){
        List<TodoDto> result=todoService.doget();
        return result;
    }

    @PutMapping
    public boolean doPut(@RequestBody TodoDto todoDto ){
        // @RequestBody => Dto 와 매개변수가 동일해야 하고 setter가 있어야한다!.
        boolean result=todoService.doput(todoDto);
        return result;

    }

    @DeleteMapping
    public boolean doDelete(@RequestParam int tno){
        boolean result=todoService.dodelete(tno);
        return result;
    }


    @GetMapping("/index")
    public Resource getIndex() {
        return new ClassPathResource("templates/index.html");
    }


}
