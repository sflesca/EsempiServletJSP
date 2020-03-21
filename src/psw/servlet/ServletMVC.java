package psw.servlet;

import psw.beans.TestiWeb;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletMVC extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TestiWeb tt = new TestiWeb("Titolo", "Corpo");
//        request.setAttribute("testi",tt);
        RequestDispatcher dsp = request.getRequestDispatcher("/index.jsp");
        dsp.forward(request,response);
    }
}
