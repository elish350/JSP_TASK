package controller;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UserBean;
import model.UserDao;
@WebServlet("/EditUser")
public class edituser extends HttpServlet {
        @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		UserBean bean=new UserBean(id,name, password);
		UserDao.update(bean);
		response.sendRedirect("ViewUser");
	}

}
