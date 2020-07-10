package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.LeaderDao;

import model.UserDao;

@WebServlet("/LeaderLogin")
public class leaderlogin extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html");
//        try (PrintWriter out = response.getWriter()) {
//            out.print("<!DOCTYPE html>");
//            out.print("<html>");
//            out.println("<head>");
//            out.println("<title>Leader Section</title>");
//            out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
//            out.println("</head>");
//            out.println("<body>");

            String username = request.getParameter("email");
            String password = request.getParameter("password");
            if (LeaderDao.authenticate(username, password)) {
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                session.setAttribute("userrole", "leader");
//                request.getRequestDispatcher("navigationleader.html").include(request, response);
                response.sendRedirect("ViewTask");
            } else {
//                request.getRequestDispatcher("navigationhome.html").include(request, response);
//                out.println("<div class='container'>");
//                out.println("<h3>Username or password you entered does not match</h3>");
//                request.getRequestDispatcher("leaderloginform.html").include(request, response);
//                out.println("</div>");
                request.setAttribute("title", "Leader Login");
                request.setAttribute("loginform", "LeaderLogin");
                getServletContext().getRequestDispatcher("/loginform.jsp").forward(request, response);
            }

//            request.getRequestDispatcher("footer.html").include(request, response);
//        }
    }

}
