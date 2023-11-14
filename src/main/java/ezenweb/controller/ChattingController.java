package ezenweb.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class ChattingController extends TextWebSocketHandler {

    // 1. 클라이언트 소켓과 연동을 성공했을 때
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("session = " + session);
    }

    // 2. 클라이언트 소켓과 연동 오류가 발생했을 때
    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        System.out.println("session = " + session + ", exception = " + exception);
    }

    // 3. 클라이언트 소켓과 연동이 끊겼을 때
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        System.out.println("session = " + session + ", status = " + status);
    }

    // 4. 클라이언트 소켓으로부터 메시지를 받았을 때
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        System.out.println("session = " + session + ", message = " + message);
    }

}



















