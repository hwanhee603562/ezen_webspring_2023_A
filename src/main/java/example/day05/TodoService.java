package example.day05;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class TodoService {

    public  boolean dopost( TodoDto todoDto){
        return false;
    }

    public List<TodoDto> doget(){
        return null;
    }
    public boolean doput( TodoDto todoDto ){


        return false;
    }
    public boolean dodelete( int tno ){


        return false;
    }
}