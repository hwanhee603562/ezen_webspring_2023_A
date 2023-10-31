package ezenweb.config;

import ezenweb.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    // configure( HttpSecurity http ) : HTTP 관련된 보안 담당하는 메소드
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super.configure(http);

        // 0. 인증(로그인)된 인가(권한/허가) 통해 페이지 접근 제한
        http.authorizeHttpRequests()    // 1. 인증된 권한에 따른 HTTP 요청 제한
                .antMatchers( "/info" ).hasRole( "USER" )   // 인증된 권한 중 ROLE_USER이면 해당 HTTP 허용
                .antMatchers( "/**" ).permitAll();          // 모든 페이지는 권한을 모두 허용

        // 1. 인증(로그인) 커스텀
        http.formLogin()                                            // 1. 시큐리티 로그인 사용 [from 전송]
                        .loginPage("/login")                        // 2. 시큐리티 로그인으로 사용할 VIEW페이지의 HTTP 주소
                        .loginProcessingUrl("/member/login")        // 3. 시큐리티 로그인(인증)처리 요청시 사용할 HTTP 주소
                        // 시큐리티 사용하기 전에 MemberController 해서 정의한 로그인/로그아웃 함수를 없애기
                        // HTTP '/member/login' POST 요청시 --> MemberService의 loadUserByUsername 로 이동
                        .defaultSuccessUrl("/")                     // 4. 만약에 로그인 성공시 이동할 HTTP 주소
                        .failureUrl("/login")    // 5. 만약에 오그인 실패시 이동할 HTTP 주소
                        .usernameParameter("memail")                // 6. 로그인시 입력 받은 아이디의 변수명 정의
                        .passwordParameter("mpassword");            // 7. 로그인시 입력 받은 비밀번호의 변수명 정의

        // 2. 로그아웃 커스텀[ 시큐리티 사용 전 CONTROLLER, SERVICE에 구현한 logout 관련 메소드 제거 ]
        http.logout()                                       // 1. 로그인(인증) 로그아웃 처리
                                                            // 2. 로그아웃 처리할 HTTP 주소 정의
                .logoutRequestMatcher( new AntPathRequestMatcher("/member/logout") )
                .logoutSuccessUrl("/")                      // 3. 로그아웃 성공했을 때 이동할 HTTP 주소 ["/" 메인페이지]
                .invalidateHttpSession( true );             // 4. 로그아웃할 때 http 세션 모두 초기화 [true:초기화o / false:초기화x]

        // 3. CSRF 커스텀
        http.csrf().disable();  // 모든 HTTP에서 CSRF 사용안함
        //http.csrf().ignoringAntMatchers( "/member/post" );   // 특정 HTTP에서만 CSRF 사용안함
            // controller 매핑 경로
    }


    @Autowired
    private MemberService memberService;
        // MemberService클래스에서 UserDetailsService인터페이스를 implements 받은 후 진행

    // configure( AuthenticationManagerBuilder auth ) : 웹 시큐리티 보안 담당하는 메소드
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // super.configure(auth);
        auth.userDetailsService( memberService ).passwordEncoder( new BCryptPasswordEncoder() );
        // auth.userDetailsService( userDetailsService 구현체 ).passwordEncoder( new 사용할 암호화 객체 );

    }

    // 시큐리티 관련 메소드 커스텀하기
        // 1. 해당 클래스에 상속 받기 extends WebSecurityConfiguration
        // 2. 커스텀할 메소드 오버라이딩 하기


}
