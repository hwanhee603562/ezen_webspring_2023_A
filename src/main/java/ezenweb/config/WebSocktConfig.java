package ezenweb.config;

import ezenweb.controller.ChattingController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket    // 웹 소켓 연결
public class WebSocktConfig implements WebSocketConfigurer {

    @Autowired
    private ChattingController chattingController;

    @Override   // 사용할 서버소켓의 매핑주소와 접근제한 설정
                    // registerWebSocketHandlers 는 여러 핸들러를 지원하기에 만일 다수의 서버소켓이 필요하다면 그만큼 registry.addHandler()를 사용할 수 있다
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler( chattingController, "/chat" );
    }


}


















