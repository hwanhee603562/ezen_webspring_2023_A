package example.day04;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Component
// 자체적으로 생성한 클래스는 컴포넌트로 따로 빈에 등록해주어야함 [ 즉, 컴포넌트 ]
public class TodoDao {

    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    // 비어있는 생성자에 DB연동
    public TodoDao(){
        // SQL 연동
        try{

            Class.forName("com.mysql.cj.jdbc.Driver");
            this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/springweb"
                    , "root", "1234");
            System.out.println("연동성공");

        } catch (Exception e){
            System.out.println(e);
            System.out.println("연동실패");
        }
    }

    // 1.
    public boolean doPost( @RequestBody TodoDto todoDto ){    // 요청 매개변수 : 입력받은 정보들 [ DTO ]

        // SQL
        String sql = "insert into todo( tcontent, tstate ) values(?, ?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString( 1, todoDto.getTcontent() );
            ps.setBoolean( 2, todoDto.isTstate() );

            ps.executeUpdate();

            return true;
        } catch ( Exception e ) {
            System.out.println(e);
        }

        return false;
    }
    // 2.
    public List<TodoDto> doGet(){     // 요청 매개변수 : 출력에 필요한 정보들 [ x ]

        List<TodoDto> list = new ArrayList<>();
        String sql = "select * from todo";

        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while( rs.next() ){
                list.add(
                        TodoDto.builder()
                                .tno( rs.getInt("tno") )
                                .tcontent( rs.getString("tcontent") )
                                .tstate( rs.getBoolean("tstate") )
                                .build()
                );
            }

            return list;

        } catch (Exception e){
            System.out.println(e);
        }

        return null;
    }
    // 3.
    public boolean doPut( TodoDto todoDto ){     // 요청 매개변수 : 수정에 필요한 정보들 [ DTO ]

        String sql = "update todo set tcontent = ?, tstate = ? where tno = ?";

        try {
            ps = conn.prepareStatement(sql);

            ps.setString( 1, todoDto.getTcontent() );
            ps.setBoolean( 2, todoDto.isTstate() );
            ps.setInt( 3, todoDto.getTno() );

            ps.executeUpdate();

            return true;
        } catch (Exception e){
            System.out.println(e);
        }

        return false;
    }
    // 4.
    public boolean doDelete( @RequestParam int tno ){  // 요청 매개변수 : 삭제에 필요한 정보들 [ int ]

        String sql = "delete from todo where tno = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt( 1, tno );
            ps.executeUpdate();

            return true;
        } catch (Exception e){
            System.out.println(e);
        }

        return false;
    }
}
