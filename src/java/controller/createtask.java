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
import static javax.servlet.jsp.tagext.TagAttributeInfo.ID;
import model.ProjectBean;
import model.ProjectDao;

import model.TaskBean;
import model.TaskDao;
@WebServlet("/CreateTask")
public class createtask extends HttpServlet {
        @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.setContentType("text/html");
//            try (PrintWriter out = response.getWriter()) {
//                out.print("<!DOCTYPE html>");
//                out.print("<html>");
//                out.println("<head>");
//                out.println("<title>Create Task Form</title>");
//                out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
//                out.println("</head>");
//                out.println("<body>");
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
//                
//                out.println("<div class='container'>");
                String Title=request.getParameter("title");
                String Description=request.getParameter("description");
                String Deadline=request.getParameter("deadline");
                String state=request.getParameter("state");
                int project=Integer.parseInt(request.getParameter("project"));
                TaskBean bean=new TaskBean(Title,Description,Deadline,state,project);
                int i=TaskDao.save(bean);
                
                if(i>0){
                    response.sendRedirect("ViewTask");
                }
                else{
                    response.sendRedirect("CreateTaskForm");
                }
//                request.getRequestDispatcher("createtaskform.html").include(request, response);
//                List<ProjectBean> list=ProjectDao.view();
//            String Leaders_list = "  <div class=\"form-group\">\n" +
//            "    <label for=\"Type\">Project</label>\n" +
//            "    <select class=\"form-control\" name=\"project\" id=\"project\" placeholder=\"Select Project\">\n"+
//            "<option value=\"0\">None</option>\n";
//            for(ProjectBean project_item : list){
//                Leaders_list += "<option value=\""+project_item.getId()+"\">"+project_item.getTitle()+"</option>";
//            }
//            Leaders_list += "</select></div>";
//            out.println("<div>\n" +
//            "            <h3>Create Task</h3>\n" +
//            "  <form action=\"CreateTask\" method=\"post\" style=\"width:300px\">\n" +
//            "\n" +
//            "  <div class=\"form-group\">\n" +
//            "    <label for=\"name1\">Title</label>\n" +
//            "    <input type=\"text\" class=\"form-control\" name=\"title\" id=\"title\" placeholder=\"Title\"/>\n" +
//            "  </div>\n" +
//            "  <div class=\"form-group\">\n" +
//            "    <label for=\"Type\">Description</label>\n" +
//            "    <textarea class=\"form-control\" name=\"description\" id=\"description\" placeholder=\"Description\"></textarea>\n" +
//            "  </div>\n" +
//            "  <div class=\"form-group\">\n" +
//            "    <label for=\"Type\">Deadline</label>\n" +
//            "    <input type=\"date\" class=\"form-control\" name=\"deadline\" id=\"deadline\" placeholder=\"Deadline\"/>\n" +
//            "  </div>\n" +
//            "  <div class=\"form-group\">\n" +
//            "    <label for=\"Type\">State</label>\n" +
//            "    <input type=\"text\" class=\"form-control\" name=\"state\" id=\"state\" placeholder=\"State\"/>\n" +
//            "  </div>\n" +Leaders_list+
//            "  <button type=\"submit\" class=\"btn btn-primary\">Create Task</button>\n" +
//            "</form>\n" +
//            "        </div>");
//                out.println("</div>");
//                
//                
//                request.getRequestDispatcher("footer.html").include(request, response);
//            }
	}

}
