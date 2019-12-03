package be.intecbrussel.webcomponents.jspdemo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;

//shows time of first login
@WebServlet("/session")
public class SessionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        int count =0;
        if (session.isNew()) {
            LocalDateTime time = LocalDateTime.now();
            session.setAttribute("message", "welcome, new friend");
        } else {
            String name;
            if(session.getAttribute("name")==null){
                name = "old friend";
            }else{
                name= (String) session.getAttribute("name");
            }
            count = (int) session.getAttribute("count");
            session.setAttribute("message", "hello "+name +", thank you for your " + count + " th visit.");
        }
        session.setAttribute("count", ++count);
        req.getRequestDispatcher("WEB-INF/pages/firstloginsession.jsp")
                .forward(req, resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        req.getSession().setAttribute("name",name);
        resp.sendRedirect("session");
    }
}
