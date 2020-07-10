package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import static javax.servlet.jsp.tagext.TagAttributeInfo.ID;

import model.LeaderBean;
import model.LeaderDao;
@WebServlet("/CreateLeader")
public class createleader extends HttpServlet {
        @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.setContentType("text/html");
//            try (PrintWriter out = response.getWriter()) {
//                out.print("<!DOCTYPE html>");
//                out.print("<html>");
//                out.println("<head>");
//                out.println("<title>Create Leader Form</title>");
//                out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
//                out.println("</head>");
//                out.println("<body>");
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
//                
//                out.println("<div class='container'>");
                String name=request.getParameter("name");
                String email=request.getParameter("email");
                String phone=request.getParameter("mobile");
                String password=request.getParameter("password");
                LeaderBean bean=new LeaderBean(name, email, password, Long.parseLong(phone));
                int i=LeaderDao.save(bean);
                
                if(i>0){
//                    out.println("<h3>Leader saved successfully</h3>");
                    response.sendRedirect("ViewLeader");
                }
                else{
                    response.sendRedirect("CreateLeaderForm");                 
                }
//                request.getRequestDispatcher("createleaderform.html").include(request, response);
//                out.println("</div>");
//                
//                
//                request.getRequestDispatcher("footer.html").include(request, response);
//            }
	}

}
