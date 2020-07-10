package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ProjectBean;
import model.ProjectDao;

import model.TaskBean;
import model.TaskDao;

@WebServlet("/EditProject")
public class editproject extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int nid = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String startdate = request.getParameter("startdate");
        String enddate = request.getParameter("enddate");
        String status = request.getParameter("status");
        int leader = Integer.parseInt(request.getParameter("leader"));
      
        ProjectBean bean = new ProjectBean(nid, title, startdate, enddate, status, leader);
        System.out.println(bean.toString());
        ProjectDao.update(bean);
        response.sendRedirect("ViewProject");
    }

}
