package ezenweb.model.entity;


import ezenweb.model.dto.BoardDto;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@Entity
@Table(name = "board")
@DynamicInsert  // @ColumnDefault 가 적용될 수 있도록 해주는 어노테이션
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Builder
public class BoardEntity extends BaseTime {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int bno;
  @Column(name = "btitle", length = 200, nullable = false)
  private String btitle;
  @Column( name = "bcontent", columnDefinition="longtext" )
  private String bcontent;
  @Column
  @ColumnDefault("0")
  private int bview;

  // private LocalDtaeTime bdate // BaseTime 클래스로부터 상속받으면 자동
  @Column( columnDefinition="longtext")
  private String bfile;

  @ToString.Exclude // toString() 함수에서 제외되는 필드
  @JoinColumn( name = "mno" ) // FK필드로 사용
  @ManyToOne        // 다수가 하나에게
  private MemberEntity memberEntity;
  // 해당 엔티티의 pk 즉, MemberEntity의 @ID로 지정된 PK인 mno만 저장됨


  // entity -> Dto
  public BoardDto allToDto() {

    return BoardDto.builder()
            .bno(this.bno)
            .btitle(this.btitle)
            .bcontent(this.bcontent)
            .bview(this.bview)
            .bfile(this.bfile)
            .bview(this.bview)
            .mno(this.memberEntity.getMno())
            .cdate(this.getCdate())
            .udate(this.getUdate())
            .build();
  }

}
