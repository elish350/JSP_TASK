package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TaskBean;
import model.TaskDao;

@WebServlet("/MemberViewTask")
public class memberviewtask extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        try (PrintWriter out = response.getWriter()) {
            out.print("<!DOCTYPE html>");
            out.print("<html>");
            out.println("<head>");
            out.println("<title>View Task</title>");
            out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
            out.println("</head>");
            out.println("<body>");
            request.getRequestDispatcher("navigationmember.html").include(request, response);

            out.println("<div class='container'>");

            List<TaskBean> list = TaskDao.view();

            out.println("<table class='table table-bordered table-striped'>");
            out.println("<tr><th>Id</th><th>Title</th><th>Description</th><th>Deadline</th></tr>");
            list.forEach((bean) -> {
                out.println("<tr><td>" + bean.getId()+ "</td><td>" + bean.getTitle()+ "</td><td>" + bean.getDescription()+ "</td><td>" + bean.getDeadline()+ "</td><td></td></tr>");
            });
            out.println("</table>");

            out.println("</div>");

            request.getRequestDispatcher("footer.html").include(request, response);
        }   //.request.;\    
    }
}
