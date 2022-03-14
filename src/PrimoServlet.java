import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Enumeration;

@WebServlet(name = "PrimoServlet", urlPatterns = {"/ciccio", "/ciccio.html"})
public class PrimoServlet extends HttpServlet {

    @Resource(mappedName="java:/PostgresDSPSW")
    DataSource db;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
/*
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        Integer num = (Integer) session.getAttribute("num");
        int num1 = (num == null)? 0: num.intValue();
        num1++;
        num = new Integer(num1);
        session.setAttribute("num", num);
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String msg = request.getParameter("msg");
        if(msg == null) msg = "default";
        out.println("<HTML><HEAD><TITLE>Hello WWW</TITLE></HEAD>" +
                "<BODY>" +
                "<H1>Ciao " + msg +"</H1>" +
                request.getRequestURI() +
                "<br/>" + request.getMethod() +
                "<br/>" + request.getQueryString() +
                "<br/>" + request.getContextPath() +
                "<br/>" + request.getPathTranslated()
                );
        Enumeration headerNames = request.getHeaderNames();
        while(headerNames.hasMoreElements()) {
            String headerName =
                    (String)headerNames.nextElement();
            out.println("<br/>" + headerName+"="+ request.getHeader(headerName));
        }


        out.println("<p>"+ num +"</p>");
        out.println("<p>"+ session.getMaxInactiveInterval() +"</p>");
        out.println("</BODY></HTML>");

    }
*/
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
