package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.MemberDao;

@WebServlet("/MemberLogin")
public class memberlogin extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html");
//        try (PrintWriter out = response.getWriter()) {
//            out.print("<!DOCTYPE html>");
//            out.print("<html>");
//            out.println("<head>");
//            out.println("<title>Member</title>");
//            out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
//            out.println("</head>");
//            out.println("<body>");

            String username = request.getParameter("email");
            String password = request.getParameter("password");
            if (MemberDao.authenticate(username, password)) {
                HttpSession session = request.getSession();
//                session.setAttribute("member", "true");
                session.setAttribute("userrole", "member");
//                request.getRequestDispatcher("navigationmember.html").include(request, response);
                response.sendRedirect("ViewTask");
            } else {
//                request.getRequestDispatcher("navigationhome.html").include(request, response);
//                out.println("<div class='container'>");
//                out.println("<h3>Username or password you entered does not match</h3>");
//                request.getRequestDispatcher("memberloginform.html").include(request, response);
//                out.println("</div>");
                request.setAttribute("title", "Project Member Login");
                request.setAttribute("loginform", "MemberLogin");
                getServletContext().getRequestDispatcher("/loginform.jsp").forward(request, response);
            }
//            request.getRequestDispatcher("footer.html").include(request, response);
//        }
    }

}
