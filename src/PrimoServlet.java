import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "PrimoServlet", urlPatterns = {"/ciccio"})
public class PrimoServlet extends HttpServlet {

    @Resource(mappedName="java:/PostgresDS")
    DataSource db;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        Connection c= null;
        try {
            c= db.getConnection();
            Statement s = c.createStatement();
            String query="SELECT * FROM cliente";
            ResultSet rs=s.executeQuery(query);
            while(rs.next())
                out.print("id:"+rs.getInt(1)+
                        ", nome:"+rs.getString(2)+"\n");
            rs.close();
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            if (c!= null) {
                try {
                    c.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
