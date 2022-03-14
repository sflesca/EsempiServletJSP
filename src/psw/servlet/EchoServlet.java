package psw.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Collections;

@WebServlet(name = "EchoServlet", urlPatterns = {"/echo", "/echoprova"})
public class EchoServlet extends HttpServlet {

    //private int valore = 0;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(true);
        int valore = 0;
        if(session.getAttribute("valore")!=null)
            valore = (Integer) session.getAttribute("valore");
//        for (String headerName : Collections.list(request.getHeaderNames())) {
//            out.println(headerName + " " + request.getHeader(headerName));
//            out.println("<br>");
//        }

        if(request.getParameter("mioparam")!=null)
            for(String s:request.getParameterValues("mioparam"))
                out.println(s);

        out.println("<h1>Il valore di value è" + valore +"</h1>");
        valore++;
        session.setAttribute("valore",valore);
    }
}
