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

import model.LeaderBean;
import model.LeaderDao;
//import static org.apache.coyote.http11.Constants.a;
@WebServlet("/ViewLeader")
public class viewleader extends HttpServlet {
        @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.setContentType("text/html");
//            try (PrintWriter out = response.getWriter()) {
//                out.print("<!DOCTYPE html>");
//                out.print("<html>");
//                out.println("<head>");
//                out.println("<title>View User</title>");
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
//                
//                List<LeaderBean> list=LeaderDao.view();
//                
//                out.println("<table class='table table-bordered table-striped'>");
//                out.println("<tr><th>Id</th><th>Name</th><th>Email</th><th>Password</th><th>Mobile</th><th>Edit</th><th>Remove</th></tr>");
//                for(LeaderBean bean:list){
//                    out.println("<tr><td>"+bean.getId()+"</td><td>"+bean.getName()+"</td><td>"+bean.getEmail()+"</td><td>"+bean.getPassword()+"</td><td>"+bean.getMobile()+"</td><td><a href='EditLeaderForm?id="+bean.getId()+"'>Edit</a></td><td><a href='RemoveLeader?id="+bean.getId()+"'>Remove</a></td></tr>"+"</td>");
//                }
//                out.println("</table>");
//                
//                out.println("</div>");
//                request.getRequestDispatcher("footer.html").include(request, response);
//                out.close();
//            }
            request.setAttribute("title", "View Project");
            List<LeaderBean> list=LeaderDao.view();
            request.setAttribute("leaderList",list);
            getServletContext().getRequestDispatcher("/viewleader.jsp").forward(request, response);
		
	}
}
