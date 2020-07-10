package controller;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.LeaderBean;
import model.LeaderDao;
@WebServlet("/EditLeader")
public class editleader extends HttpServlet {
        @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String nmobile=request.getParameter("mobile");
		long mobile=Long.parseLong(nmobile);
		LeaderBean bean=new LeaderBean(id,name, email, password, mobile);
		LeaderDao.update(bean);
		response.sendRedirect("ViewLeader");
	}

}
