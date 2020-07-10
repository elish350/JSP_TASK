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
@WebServlet("/createuser")
public class createuser extends HttpServlet {
        @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.setContentType("text/html");
//            try (PrintWriter out = response.getWriter()) {
//                out.print("<!DOCTYPE html>");
//                out.print("<html>");
//                out.println("<head>");
//                out.println("<title>Create User</title>");
//                out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
//                out.println("</head>");
//                out.println("<body>");
//                
//                HttpSession session = request.getSession();
//                if(session.getAttribute("userrole").equals("admin")){
//                    request.getRequestDispatcher("navigationadmin.html").include(request, response);
//                }
//                else if(session.getAttribute("userrole").equals("leader")){
//                    request.getRequestDispatcher("navigationleader.html").include(request, response);
//                }
//                else if(session.getAttribute("userrole").equals("member")){
//                    request.getRequestDispatcher("navigationmember.html").include(request, response);
//                }
//                else{
//                    request.getRequestDispatcher("navigationhome.html").include(request, response);
//                }
//                out.println("<div class='container'>");
                
                String name=request.getParameter("name");
                String password=request.getParameter("password");
                UserBean bean=new UserBean(name, password);
                int i= UserDao.save(bean);
                if(i>0){
                    response.sendRedirect("ViewUser");
                }
//                out.print("<h4>User Created successfully</h4>");
                response.sendRedirect("CreateUserForm");
                
                
//                out.println("</div>");
//                request.getRequestDispatcher("footer.html").include(request, response);
//                out.close();
//            }
	}

}
