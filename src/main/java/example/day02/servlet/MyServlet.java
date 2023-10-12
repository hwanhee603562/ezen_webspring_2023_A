package example.day02.servlet;

    

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//  jsp 프로젝트에서는 자동으로 서블릿 클래스를 구성해줌
    // @WebServlet( name="서블릿이름[생략시클래스명으로자동]", urlPatterns = "서블릿연결할 HTTP 경로" )
    // @WebServlet( "/day02/my" )   // JSP프로젝트 때 사용했던 방식
@WebServlet( name = "myServlet", urlPatterns = "/example/day02/my")   // 브라우저의 경로와 해당 서블릿을 연결하는 설정을 위해 사용
// 괄호 안에 들어가는 name은 생략가능함

public class MyServlet  extends HttpServlet {
    
    // 서블릿 생성 방법
    // 1. MyServlet
    // 2. extends HttpServlet
        // 해당 HttpServlet 클래스로부터 다양한 rest메소드를 상속 받음
    // 3. 오른쪽 클릭 -> 생성 -> 메소드 재정의 [ doget, dopost, doput, dodelete ]


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html; charset=UTF-8");
        // resp.getWriter().println(); 아래코드와 같은 형식
        PrintWriter out = resp.getWriter();
        out.println("<html>");
            out.println("<body>");
                out.println("<h1>안녕 서블릿</h1>");
            out.println("</body>");
        out.println("</html>");


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }
}


/*
    p.28 Tip
        @ : 어노테이션
            - 주석이나 해석으로 할 수 있는데 주로 코드상에 추가적인 정보를 남겨주기 위해서 사용
            - 특정한 코드에 대해 추가적인 처리나 설정을 위해서 사용
            - 특정 클래스에 추가적인 외부 기능 부여할때 상속/구현체보다 확장성이 좋다.

        - 다른 클래스에게 데이터 전달하는 방법
            - extends : 상속 [ 클래스 설계도 연장 ]
            - implements : 구현 [ 인터페이스의 추상메소드 구현체 ]
                - 클래스 상속과 인터페이스 구현 한계..
                    1. 클래스는 상속 1번만 가능
                    2. 인터페이스는 메모리 전달 불가능.. [ 일반 필드를 가질 수 없다. 무조건 상수 필드 ]

        - @어노테이션
            1. 빌트인      : @Override : 내장(기능) 된 어노테이션
            2. 메타데이터    : 외부라이브러리나 생성된 어노테이션 ; 인터페이스 클래스들을 확장해서 구조화된 데이터를 전달해주는
            3. 사용자정의    : 개발자가 생성한 어노테이션
 */









