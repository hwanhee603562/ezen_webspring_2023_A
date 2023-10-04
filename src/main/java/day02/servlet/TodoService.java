package day02.servlet;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// 서비스 계층
public class TodoService { // 서비스 : 실질적인 기능 처리 하는 구역

    // 1. 등록 서비스
    public void register( TodoDto todoDto) {
        System.out.println("TodoService.register"); // soutm
    }

    // 2. 출력 서비스
    public List<TodoDto> getList(){

        // 1. 스트림 문법을 사용하지 않을때.
       /* List<TodoDto> list = new ArrayList<>();
        for( int i = 0 ; i < 10 ; i++ ){
            TodoDto todoDto = TodoDto.builder().tno((long)i).title("Todo.."+i).dueDate(LocalDate.now()).build();
            list.add(todoDto);
        }
        return list;*/
        // 2. 스트림 문법을 사용했을때.
        // List<TodoDto> todoDtos = IntStream.range( 0 , 10 ).mapToObj(i->{}).collect(Collectors.toList());
        List<TodoDto> todoDtos = IntStream.range( 0 , 10 ).mapToObj(i->{
            TodoDto todoDto = TodoDto.builder().tno((long)i).title("Todo.."+i).dueDate(LocalDate.now()).build();
            return todoDto;
        }).collect(Collectors.toList());
        return todoDtos;
        // IntStream.range( 시작 , 끝 )
        // mapToObj() : return 값을 반환해서 배열/리스트에 대입
    }
}