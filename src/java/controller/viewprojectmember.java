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

import model.MemberBean;
import model.MemberDao;
@WebServlet("/ViewProjectMember")
public class viewprojectmember extends HttpServlet {
        @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.setContentType("text/html");
//            try (PrintWriter out = response.getWriter()) {
//                out.print("<!DOCTYPE html>");
//                out.print("<html>");
//                out.println("<head>");
//                out.println("<title>View Project Member</title>");
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
//                out.println("<div class='container'><h1>Member List</h1>");
//                if(session.getAttribute("userrole").equals("admin")||session.getAttribute("userrole").equals("leader")){
//                    List<MemberBean> list=MemberDao.view();
//
//                    out.println("<table class='table table-bordered table-striped'>");
//                    out.println("<tr><th>Id</th><th>Name</th><th>Email</th><th>Password</th><th>Mobile</th><th>Edit</th><th>Delete</th></tr>");
//                    for(MemberBean bean:list){
//                        out.println("<tr><td>"+bean.getId()+"</td><td>"+bean.getName()+"</td><td>"+bean.getEmail()+"</td><td>"+bean.getPassword()+"</td><td>"+bean.getMobile()+"</td><td><a href='EditMemberForm?id="+bean.getId()+"'>Edit</a></td><td><a href='removemember?id="+bean.getId()+"'>Delete</a></td></tr>");
//                    }
//                    out.println("</table>");
//                }
//                if(session.getAttribute("userrole").equals("member")){
//                    List<MemberBean> list=MemberDao.view();
//
//                    out.println("<table class='table table-bordered table-striped'>");
//                    out.println("<tr><th>Id</th><th>Name</th><th>Email</th><th>Password</th><th>Mobile</th></tr>");
//                    for(MemberBean bean:list){
//                        out.println("<tr><td>"+bean.getId()+"</td><td>"+bean.getName()+"</td><td>"+bean.getEmail()+"</td><td>"+bean.getPassword()+"</td><td>"+bean.getMobile()+"</td></tr>");
//                    }
//                    out.println("</table>");
//                }
//                out.println("</div>");
//                request.getRequestDispatcher("footer.html").include(request, response);
//            }
            request.setAttribute("title", "View Project Member");
            List<MemberBean> list=MemberDao.view();
            request.setAttribute("memberList",list);
            getServletContext().setAttribute("msgAppContext", "addProjectMemberForm");
            getServletContext().getRequestDispatcher("/viewprojectmember.jsp").forward(request, response);
	}
}
