package ezenweb.model.dto;

import ezenweb.model.entity.MemberEntity;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class MemberDto {

    private int mno;            // 1. 회원번호
    private String memail;      // 2. 이메일[ 회원아이디 대체 ]
    private String mpassword;    // 3. 비밀번호
    private String mname;       // 4. 이름
    private String mphone;      // 5. 연락처
    private String mrole;       // 6. 회원등급( 일반회원=user / 관리자회원=admin )

    // + baseTime
    private LocalDateTime cdate;
    private LocalDateTime udate;

    // dto --> entity 변환 함수
        // service 에서 dto 정보를 DB테이블로 이동하기 위해
    public MemberEntity toEntity() {

        return MemberEntity.builder()
                .mno( this.mno )
                .memail( this.memail )
                .mpassword( this.mpassword )
                .mname( this.mname )
                .mphone( this.mphone )
                .mrole( this.mrole )
                .build();

    }

}





















