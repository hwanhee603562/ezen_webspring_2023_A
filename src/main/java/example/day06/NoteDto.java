package example.day06;

import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class NoteDto {

    private int no;             // 게시물번호
    private String title;     // 게시물내용
    private String writer;      // 작성자
    private String password;    // 비밀번호
    private LocalDate date;     // 작성일

    // + DTO를 엔티티로 변환해주는 함수 [service에서 사용]
    public NoteEntity toEntity(){

        return new NoteEntity().builder().no( no ).title( title ).writer( writer ).password( password ).date( date ).build();

    }
    
    
    
    
    
}

















