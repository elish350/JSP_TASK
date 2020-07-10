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
import model.ProjectBean;
import model.ProjectDao;
import model.StateBean;
import model.StateDao;

import model.TaskBean;
import model.TaskDao;

@WebServlet("/EditTaskForm")
public class edittaskform extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html");
//        try (PrintWriter out = response.getWriter()) {
//            out.print("<!DOCTYPE html>");
//            out.print("<html>");
//            out.println("<head>");
//            out.println("<title>Edit Task Form</title>");
//            out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
//            out.println("</head>");
//            out.println("<body>");
//            
//            HttpSession session = request.getSession();
//            if(session.getAttribute("userrole").equals("admin")){
//                request.getRequestDispatcher("navigationadmin.html").include(request, response);
//            }
//            else if(session.getAttribute("userrole").equals("leader")){
//                request.getRequestDispatcher("navigationleader.html").include(request, response);
//            }
//            else if(session.getAttribute("userrole").equals("member")){
//                request.getRequestDispatcher("navigationmember.html").include(request, response);
//            }
//            else{
//                request.getRequestDispatcher("navigationhome.html").include(request, response);
//            }
//            out.println("<div class='container'><h1>Edit Task</h1>");
            String nid = request.getParameter("id");
            int id = Integer.parseInt(nid);
//            if(session.getAttribute("userrole").equals("leader")){
                TaskBean task = TaskDao.viewById(id);

//                out.print("<form action='EditTask' method='post' style='width:300px'>");
//                out.print("<div class='form-group'>");
//                out.print("<input type='hidden' name='id' value='" + bean.getId()+ "'/>");
//                out.print("<label for='name1'>Title</label>");
//                out.print("<input type='text' class='form-control' value='" + bean.getTitle()+ "' name='title' id='title1' placeholder='Title'/>");
//                out.print("</div>");
//                out.print("<div class='form-group'>");
//                out.print("<label for='description'>Description</label>");
//                out.print("<textarea class='form-control' name='description' id='description' placeholder='Description'>" + bean.getDescription()+ "</textarea>");
//                out.print("</div>");
//                out.print("<div class='form-group'>");
//                out.print("<label for='deadline'>Deadline</label>");
//                out.print("<input type='date' class='form-control' value='" + bean.getDeadline()+ "'  name='deadline' id='deadline' placeholder='Deadline'/>");
//                out.print("</div>  ");
                List<StateBean> all_state=StateDao.view();
                String State_list = "  <div class=\"form-group\">\n" +
                "    <label for=\"Type\">State</label>\n" +
                "    <select class=\"form-control\" name=\"state\" id=\"project\" placeholder=\"Select state\">\n";
                for(StateBean state_item : all_state){
                    if(Integer.parseInt(task.getState())==state_item.getId())
                        State_list += "<option value=\""+state_item.getId()+"\" selected>"+state_item.getName()+"</option>";
                    else
                        State_list += "<option value=\""+state_item.getId()+"\">"+state_item.getName()+"</option>";
                }
                State_list += "</select></div>";
//                out.print(State_list);
                List<ProjectBean> list=ProjectDao.view();
                String Project_list = "  <div class=\"form-group\">\n" +
                "    <label for=\"Type\">Project</label>\n" +
                "    <select class=\"form-control\" name=\"project\" id=\"project\" placeholder=\"Select Project\">\n";
                for(ProjectBean project_item : list){
                    if(project_item.getId()==task.getId())
                        Project_list += "<option value=\""+project_item.getId()+"\" selected>"+project_item.getTitle()+"</option>";
                    else
                        Project_list += "<option value=\""+project_item.getId()+"\">"+project_item.getTitle()+"</option>";
                }
                Project_list += "</select></div>";
//                out.print(Leaders_list);
//                out.print("<button type='submit' class='btn btn-primary'>Update</button>");
//                out.print("</form>");
//
//                out.println("</div>");
//            }
//            if(session.getAttribute("userrole").equals("member")){
//                TaskBean bean = TaskDao.viewById(id);
//
//                out.print("<form action='EditTask' method='post' style='width:300px'>");
//                out.print("<div class='form-group'>");
//                out.print("<input type='hidden' name='id' value='" + bean.getId()+ "'/>");
//                out.print("<label for='name1'>Title</label>");
//                out.print("<input type='text' class='form-control' value='" + bean.getTitle()+ "' name='title' id='title1' placeholder='Title' readonly/>");
//                out.print("</div>");
//                out.print("<div class='form-group'>");
//                out.print("<label for='description'>Description</label>");
//                out.print("<textarea class='form-control' name='description' id='description' placeholder='Description' readonly>" + bean.getDescription()+ "</textarea>");
//                out.print("</div>");
//                out.print("<div class='form-group'>");
//                out.print("<label for='deadline'>Deadline</label>");
//                out.print("<input type='date' class='form-control' value='" + bean.getDeadline()+ "'  name='deadline' id='deadline' placeholder='Deadline' readonly/>");
//                out.print("</div>  ");
//                List<StateBean> all_state=StateDao.view();
//                String State_list = "  <div class=\"form-group\">\n" +
//                "    <label for=\"Type\">State</label>\n" +
//                "    <select class=\"form-control\" name=\"state\" id=\"project\" placeholder=\"Select state\">\n"+
//                "<option value=\"0\">None</option>\n";
//                for(StateBean state_item : all_state){
//                    if(Integer.parseInt(bean.getState())==state_item.getId())
//                        State_list += "<option value=\""+state_item.getId()+"\" selected>"+state_item.getName()+"</option>";
//                    else
//                        State_list += "<option value=\""+state_item.getId()+"\">"+state_item.getName()+"</option>";
//                }
//                State_list += "</select></div>";
//                out.print(State_list);
//                List<ProjectBean> list=ProjectDao.view();
//                String Leaders_list = "  <div class=\"form-group\">\n" +
//                "    <label for=\"Type\">Project</label>\n" +
//                "    <select class=\"form-control\" name=\"project\" id=\"project\" placeholder=\"Select Project\" readonly>\n"+
//                "<option value=\"0\">None</option>\n";
//                for(ProjectBean project_item : list){
//                    if(project_item.getId()==bean.getId())
//                        Leaders_list += "<option value=\""+project_item.getId()+"\" selected>"+project_item.getTitle()+"</option>";
//                    else
//                        Leaders_list += "<option value=\""+project_item.getId()+"\">"+project_item.getTitle()+"</option>";
//                }
//                Leaders_list += "</select></div>";
//                out.print(Leaders_list);
//                out.print("<button type='submit' class='btn btn-primary'>Update</button>");
//                out.print("</form>");
//
//                out.println("</div>");
//            }
            request.setAttribute("task", task);
            request.setAttribute("stateList", State_list);
            request.setAttribute("projectList", Project_list);
            request.getRequestDispatcher("edittaskform.jsp").include(request, response);
//        }

    }
}
