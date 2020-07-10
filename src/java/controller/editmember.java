package controller;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberBean;
import model.MemberDao;
@WebServlet("/EditMember")
public class editmember extends HttpServlet {
        @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String nmobile=request.getParameter("mobile");
		long mobile=Long.parseLong(nmobile);
		MemberBean bean=new MemberBean(id,name, email, password, mobile);
		MemberDao.update(bean);
		response.sendRedirect("ViewProjectMember");
	}

}
