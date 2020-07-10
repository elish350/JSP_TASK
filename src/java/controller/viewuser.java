package controller;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.UserBean;
import model.UserDao;
//import static org.apache.coyote.http11.Constants.a;
@WebServlet("/ViewUser")
public class viewuser extends HttpServlet {
        @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.setAttribute("title", "View User");
            List<UserBean> list=UserDao.view();
            request.setAttribute("userList",list);
            HttpSession session = request.getSession();
            getServletContext().getRequestDispatcher("/viewuser.jsp").forward(request, response);
		
	}
}
