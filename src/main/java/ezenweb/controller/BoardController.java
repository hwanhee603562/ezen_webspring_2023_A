package ezenweb.controller;

import ezenweb.model.dto.BoardDto;
import ezenweb.model.dto.PageDto;
import ezenweb.service.BoardService;
import ezenweb.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private FileService fileService;

    @Autowired
    private BoardService boardService;

    // 1.
    @PostMapping("")
    public boolean write( BoardDto boardDto ){
        System.out.println(boardDto);
        return boardService.write(boardDto);
    }

    // 2.
    @GetMapping("")
    public PageDto getAll(
                            @RequestParam int page,
                            @RequestParam String key,
                            @RequestParam String keyword,
                            @RequestParam int view
                                                    ){

        return boardService.getAll( page, key, keyword, view );
    }

    // 2-2
    @GetMapping("/doGet")
    public BoardDto doGet( @RequestParam int bno ){
        return boardService.doGet(bno);
    }

    // 3.
    @PutMapping("")
    public boolean update( BoardDto boardDto ){

        System.out.println( "boardDto : "+boardDto );
        return boardService.update(boardDto);
    }

    // 4.
    @DeleteMapping("")
    public boolean delete( @RequestParam int bno ){
        return boardService.delete(bno);
    }

    // 5. 첨부파일 다운로드 요청
        // file 이름을 매개변수로 받음
    @GetMapping("/filedownload")
    public void filedownload( @RequestParam String uuidFile ){
        fileService.fileDownload( uuidFile );
    }


}












