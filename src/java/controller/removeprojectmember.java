package controller;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDao;
@WebServlet("/RemoveMember")
public class removeprojectmember extends HttpServlet {
        @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nid=request.getParameter("id");
		int id=Integer.parseInt(nid);
		MemberDao.delete(id);
		response.sendRedirect("ViewProjectMember");
	}
}
