package psw.servlet;

import psw.model.Cliente;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

@WebServlet(name = "ClientiListServlet", urlPatterns = {"/clienti"})
public class servlet extends HttpServlet {

    @Resource(mappedName = "java:/ProvaPostgresDS")
    DataSource db;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection c = null;
        try {
            c = db.getConnection();
            Statement s = c.createStatement();
            String query="SELECT * FROM cliente";
            ResultSet rs=s.executeQuery(query);
            List<Cliente> lc = new LinkedList<Cliente>();
            while(rs.next()) {
                Cliente cl = new Cliente();
                cl.setId(rs.getInt(1));
                cl.setNome(rs.getString(2));
                lc.add(cl);
            }
            rs.close();
            request.setAttribute("clienti", lc);
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
            RequestDispatcher rd = request.getRequestDispatcher("/clienti.jsp");
            rd.forward(request,response);
        }
    }
}
