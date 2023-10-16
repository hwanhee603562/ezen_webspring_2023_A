package example.day06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/note")
public class NoteController {

    @Autowired
    private NoteService noteService;

    // 1. c
    @PostMapping("/do")
    public boolean bWrite( @RequestBody NoteDto noteDto ){
        boolean result = noteService.bWrite( noteDto );
        return result;
    }

    // 2. r
    @GetMapping("/do")
    public List<NoteDto> bList(){
        List<NoteDto> result = noteService.bList();

        return result;
    }

    // 3. u
    @PutMapping("/do")
    public boolean bUpdate( @RequestBody NoteDto noteDto ){
        boolean result = noteService.bUpdate( noteDto );
        return result;
    }

    // 4. d
    @DeleteMapping("/do")
    public boolean bDelete( int no ){
        boolean result = noteService.bDelete( no );
        return result;
    }


}
