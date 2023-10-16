package ezenweb.model.entity;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;
import java.time.LocalDateTime;

@MappedSuperclass   // 엔티티X [ 여러 엔티티가 공통으로 사용하는 필드에 대해 구성할 때 ]
                    // JPA 엔티티 클래스들의 공통 필드를 상송할 때 사용하는 어노테이션
@EntityListeners( AuditingEntityListener.class )
// EzenWebStart클래스에서 @EnableJpaAuditing으로 인해 이벤트를 JPA를 감지하여
// @EntityListeners로 인해 이벤트가 실행됨
@Getter
public class BaseTime {

    @CreatedDate        // 엔티티가 생성될 때 시간이 자동 저장/주입
    private LocalDateTime cdate;    // 레코드/엔티티 생성날짜
    @LastModifiedDate   // 엔티티가 변경될 때 시간이 자동 저장/주입
    private LocalDateTime udate;    // 레코드/엔티티 수정날짜

}
/*

    엔티티의 생성/수정 일시를 감지해서 자동 업데이트 해주는 클래스
    어노테이션
        1. @CreatedDate
        2. @LastModifiedDate
        3. @MappedSuperclass


*/

















