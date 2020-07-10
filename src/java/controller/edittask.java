package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TaskBean;
import model.TaskDao;

@WebServlet("/EditTask")
public class edittask extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int nid = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String deadline = request.getParameter("deadline");
        String state = request.getParameter("state");
        int project = Integer.parseInt(request.getParameter("project"));
      
        TaskBean bean = new TaskBean(nid, title, description, deadline,state,project);
        TaskDao.update(bean);
        response.sendRedirect("ViewTask");
    }

}
