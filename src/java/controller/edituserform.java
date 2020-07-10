package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.UserBean;
import model.UserDao;

@WebServlet("/EditUserForm")
public class edituserform extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html");
//        try (PrintWriter out = response.getWriter()) {
//            out.print("<!DOCTYPE html>");
//            out.print("<html>");
//            out.println("<head>");
//            out.println("<title>Edit User Form</title>");
//            out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
//            out.println("</head>");
//            out.println("<body>");
//
//            HttpSession session = request.getSession();
//            if(session.getAttribute("userrole").equals("admin")){
//                request.getRequestDispatcher("navigationadmin.html").include(request, response);
//            }
//            else if(session.getAttribute("userrole").equals("leader")){
//                request.getRequestDispatcher("navigationleader.html").include(request, response);
//            }
//            else if(session.getAttribute("userrole").equals("member")){
//                request.getRequestDispatcher("navigationmember.html").include(request, response);
//            }
//            else{
//                request.getRequestDispatcher("navigationhome.html").include(request, response);
//            }
//            out.println("<div class='container'>");
//            String sid = request.getParameter("id");
//            int id = Integer.parseInt(sid);
//
//            UserBean bean = UserDao.viewById(id);
//
//            out.print("<form action='EditUser' method='post' style='width:300px'>");
//            out.print("<div class='form-group'>");
//            out.print("<input type='hidden' name='id' value='" + bean.getId() + "'/>");
//            out.print("<label for='name1'>Name</label>");
//            out.print("<input type='text' class='form-control' value='" + bean.getUsername()+ "' name='name' id='name1' placeholder='Name'/>");
//            out.print("</div>");
//            out.print("<div class='form-group'>");
//            out.print("<label for='password1'>Password</label>");
//            out.print("<input type='password' class='form-control' value='" + bean.getPassword() + "'  name='password' id='password1' placeholder='Password'/>");
//            out.print("</div>  ");
//            out.print("<div class='form-group'>");
//            out.print("<button type='submit' class='btn btn-primary'>Update</button>");
//            out.print("</form>");
//
//            out.println("</div>");
//            request.getRequestDispatcher("footer.html").include(request, response);
//            out.close();

//        }
            String sid = request.getParameter("id");
            int id = Integer.parseInt(sid);

            UserBean user = UserDao.viewById(id);
            request.setAttribute("user", user);
            request.getRequestDispatcher("edituserform.jsp").include(request, response);

    }
}
