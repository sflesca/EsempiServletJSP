package psw.servlet;

import javax.annotation.Resource;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Arrays;

@WebServlet(name = "CiaoServlet", urlPatterns = {"/ciao"}, initParams = {@WebInitParam(name = "cont", value="2")})
public class CiaoServlet extends HttpServlet {

    int cont;

    @Resource(mappedName = "java:/SergioPostgresDS")
    DataSource db;

    @Override
    public void init(){
        ServletConfig config = getServletConfig();
        cont = Integer.parseInt(config.getInitParameter("cont"));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        Connection c = null;
        cont++;
        out.println("<HTML>" +
                "<HEAD><TITLE>Che bello la mia prima Servlet</TITLE></HEAD>"+
                "<BODY>"+"numero di accessi:"+cont+"<br>");
        out.println("<p>Request Method:"+ request.getMethod());
        out.println("<p>Request URI:" + request.getRequestURI());
        out.println("<p>Request Protocol:"+request.getProtocol());
        out.println("<p>Query String:"+request.getQueryString());
        out.println("<p>Primo valore del parametro cicc:"+request.getParameter("cicc"));
        out.println("<p>Tutti i valori del parametro cicc:"+ Arrays.toString(
                request.getParameterValues("cicc")));

        Cookie cc = new Cookie("cicc",request.getParameter("cicc"));
        cc.setMaxAge(100000);

        response.addCookie(cc);

        Cookie[] vCookies = request.getCookies();
        for (Cookie cx:vCookies){
            out.println("Cookie:"+cx.getName()+" "+ cx.getValue()+"<br>");
        }

        try {
            c = db.getConnection();
            Statement s = c.createStatement();
            String query="SELECT * FROM cliente";
            ResultSet rs=s.executeQuery(query);
            out.println("<ul>");
            while(rs.next()) {
                out.println("<li>");
                out.print("id:" + rs.getInt(1) +
                        ", nome:" + rs.getString(2) + "\n</li>");
            }
            out.println("</ul>");
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
            out.println("</BODY></HTML>");
        }

    }
}
