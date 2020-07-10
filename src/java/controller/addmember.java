package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MemberBean;
import model.MemberDao;
@WebServlet("/AddMember")
public class addmember extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>Add Member Form</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
		HttpSession session = request.getSession();
                if(session.getAttribute("userrole").equals("admin")){
                    request.getRequestDispatcher("navigationadmin.html").include(request, response);
                }
                else if(session.getAttribute("userrole").equals("leader")){
                    request.getRequestDispatcher("navigationleader.html").include(request, response);
                }
                else if(session.getAttribute("userrole").equals("member")){
                    request.getRequestDispatcher("navigationmember.html").include(request, response);
                }
                else{
                    request.getRequestDispatcher("navigationhome.html").include(request, response);
                }
		out.println("<div class='container'>");
		String callno=request.getParameter("callno");
		String name=request.getParameter("name");
		String author=request.getParameter("author");
		String publisher=request.getParameter("publisher");
		String squantity=request.getParameter("quantity");
		int quantity=Integer.parseInt(squantity);
		MemberBean bean=new MemberBean(Integer.parseInt(callno),name,author,publisher,quantity);
		int i=MemberDao.save(bean);
		if(i>0){
			out.println("<h3>Member saved successfully</h3>");
		}
		request.getRequestDispatcher("addmemberform.html").include(request, response);
		out.println("</div>");
		
		
		request.getRequestDispatcher("footer.html").include(request, response);
		out.close();
	}

}
