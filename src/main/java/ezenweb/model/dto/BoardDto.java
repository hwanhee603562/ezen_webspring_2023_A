package ezenweb.model.dto;

import ezenweb.model.entity.BoardEntity;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Column;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Builder
public class BoardDto {

    private int bno;
    private String btitle;
    private String bcontent;
    private int bview;
    private String bfile;
    private int mno;
    
    // cdate/udate는 상속받지 않기에 엔티티와 다르게 별도로 선언
    private String cdate;
    private String udate;

    // 작성자 아이디
    private String memail;

    // 첨부파일 [ spring에서 지원하는 첨부파일 라이브러리 ]
    private MultipartFile file;

    // dto -> entity
    // 1. entity 저장할 때
    public BoardEntity saveToEntity() {

        return BoardEntity.builder()
                .btitle(this.btitle)
                .bcontent(this.bcontent)
                .bfile(this.bfile)
                .build();

    }


}
















