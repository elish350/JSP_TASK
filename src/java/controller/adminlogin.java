package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.UserBean;
import model.UserDao;

@WebServlet("/AdminLogin")
public class adminlogin extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html");
//        try (PrintWriter out = response.getWriter()) {
//            out.print("<!DOCTYPE html>");
//            out.print("<html>");
//            out.println("<head>");
//            out.println("<title>Admin</title>");
//            out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
//            out.println("</head>");
//            out.println("<body>");

            String email = request.getParameter("email");
            String password = request.getParameter("password");
            if (email.equals("info@admin.com") && password.equals("12345")) {
                HttpSession session = request.getSession();
                session.setAttribute("userrole", "admin");
                response.sendRedirect("ViewUser");
                
            } else {
                HttpSession session = request.getSession();
//        session.setAttribute("userrole", "test");
//                getServletContext().setAttribute("msgAppContext", "addProjectMemberForm");
                request.setAttribute("title", "Admin Login");
                request.setAttribute("loginform", "AdminLogin");
                getServletContext().getRequestDispatcher("/loginform.jsp").forward(request, response);

//                request.getRequestDispatcher("navigationhome.html").include(request, response);
//                out.println("<div class='container'>");
//                out.println("<h3>Username or password you entered does not match</h3>");
//                request.getRequestDispatcher("adminloginform.html").include(request, response);
//                out.println("</div>");
            }
//            request.getRequestDispatcher("footer.html").include(request, response);
//            out.close();
//        }
    }

}
