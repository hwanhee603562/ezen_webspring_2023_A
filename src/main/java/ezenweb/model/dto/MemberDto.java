package ezenweb.model.dto;

import ezenweb.model.entity.MemberEntity;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class MemberDto implements UserDetails, OAuth2User {


    // ------------------ OAuth2User 오버라이드 ------------------- //

    private Map<String, Object> 소셜회원정보;

    @Override   // oauth2 회원의 정보
    public Map<String, Object> getAttributes() {
        return null;
    }

    @Override   // oauth2 회원의 아이디
    public String getName() {
        return memail;
    }


    // ------------------ UserDetails 오버라이드 ------------------- //
        // 일반회원 + OAUTH2 통합회원 = DTO 같이 쓰기

    // Collection : 컬렉션 프레임워크 : set , list , map
    private List<GrantedAuthority> 권한목록;

    @Override   // 계정 권한 목록
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return 권한목록;
    }

    @Override   // 계정 비밀번호
    public String getPassword() {
        return mpassword;
    }

    @Override   // 계정 아이디
    public String getUsername() {
        return memail;
    }

    @Override   // 계정 만료 여부
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override   // 계정 잠금 여부
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override   // 계정 증명 여부
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override   // 계정 활성화 여부
    public boolean isEnabled() {
        return true;
    }


    // ------------------------------------------------ //


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





















