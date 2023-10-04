package day02.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// http://localhost:8080/hello-servlet
@WebServlet( name="helloServlet", value= "/hello-servlet" )
public class HelloServlet extends HttpServlet {
    // 우클릭 -> 생성 -> 오버라이딩메소드
    // -- 서블릿의 라이프 사이클 [생명주기] : 서블릿객체가 생성되고 제거되기까지의 사이클
        // init(), doGet(), service(), destroy()
        // : 개발자가 아닌 서블릿 컨테이너가 서블릿들을 관리하며 호출
    
    private String message;
    
    // 1. 최초로 해당 서블릿의 URL 요청했을 때 1번 실행
        // [다음 요청부터는 동일한 서블릿객체를 사용하므로 끝]
    @Override
    public void init() throws ServletException {
        System.out.println("HelloServlet.init");
        message = "서블릿 객체 탄생";
    }

    // 2. 해당 서블릿의 URL 요청했을 때 GET, POST, PUT, DELETE 등 메소드 매핑 연결[ 매 요청마다 실행 ]
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("helloServlet.service");
        super.service(req, res);
    }

    // 3. 서비스가 호출한 메소드들 GET, POST, PUT, DELETE 등 실행 [ 매 요청마다 실행 ]
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HelloServlet.doget");
        resp.setContentType("text/html; charset=utf-8");
        resp.getWriter().println( message );
    }

    // 4. 톰캣[서버]가 종료될 때 [ 서블릿객체 사라짐 ] 실행
    @Override
    public void destroy() {
        System.out.println("HelloServlet.destroy");
    }
}
