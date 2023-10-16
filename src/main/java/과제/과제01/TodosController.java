package 과제.과제01;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/todos")
public class TodosController {

    @Autowired
    private TodosService todosService;

    @PostMapping
    public boolean doPost( @RequestBody TodosDto todosDto){
        // @RequestBody => Dto 와 매개변수가 동일해야 하고 setter가 있어야한다!.
        boolean result = todosService.doPost(todosDto);
        return result;
    }

    @GetMapping
    public List<TodosDto> doGet(){
        List<TodosDto> result = todosService.doGet();

        return result;

    }

    @PutMapping
    public boolean doPut(@RequestBody TodosDto todosDto ){
        // @RequestBody => Dto 와 매개변수가 동일해야 하고 setter가 있어야한다!.
        System.out.println( todosDto.getPname());
        System.out.println( todosDto.getPhone());

        boolean result = todosService.doPut(todosDto);
        return result;

    }

    @DeleteMapping
    public boolean doDelete(@RequestParam int pno){
        boolean result = todosService.doDelete(pno);
        return result;
    }


    @GetMapping("/index")
    public Resource getIndex() {
        return new ClassPathResource("templates/todos.html");
    }

}
