package ezenweb.model.entity;

import ezenweb.model.dto.MemberDto;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Table( name = "member" )    // DB테이블명 정의   [ 생략시 해당 클래스명이 곧 DB테이블명으로 자동 생성 ]
public class MemberEntity extends BaseTime {

    @Id             // 해당 필드를 pk로 선정
    @GeneratedValue( strategy = GenerationType.IDENTITY  )
    private int mno;            // 1. 회원번호
    @Column( name = "memail", length = 50, nullable = false, unique = true )   // 해당 필드 선정 [ 속성) name = "필드명" ]
    private String memail;      // 2. 이메일[ 회원아이디 대체 ]
    @Column( length = 30, nullable = false )
    private String mpassword;    // 3. 비밀번호
    @Column( length = 20, nullable = false )
    private String mname;       // 4. 이름
    @Column( length = 13, nullable = false, unique = true )
    private String mphone;      // 5. 연락처
    @ColumnDefault( "'user'" )  // default
    private String mrole;       // 6. 회원등급( 일반회원=user / 관리자회원=admin )



    // entity --> dto 변환 함수
        // service 에서 entity를 controller로 이동하기 위해
    public MemberDto toDto() {
    
        // 엔티티를 사용하는 곳은 Service인데
        // 여기서 사용되는 save / delete / find / entity.set 등으로 
        // HTTP 요청의 SELECT INSERT UPDATE DELETE 간 요청을 구분할 수 있다
        
        return MemberDto.builder()
              .mno( this.mno )
              .memail( this.memail )
              .mpassword( this.mpassword )
              .mname( this.mname )
              .mphone( this.mphone )
              .mrole( this.mrole )
              .cdate( this.getCdate() )
              .udate( this.getUdate() )
              .build();

    }


}














