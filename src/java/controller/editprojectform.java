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
import model.LeaderBean;
import model.LeaderDao;
import model.ProjectBean;
import model.ProjectDao;
import model.StateBean;
import model.StateDao;

@WebServlet("/EditProjectForm")
public class editprojectform extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html");
//        try (PrintWriter out = response.getWriter()) {
//            out.print("<!DOCTYPE html>");
//            out.print("<html>");
//            out.println("<head>");
//            out.println("<title>Edit Project Form</title>");
//            out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
//            out.println("</head>");
//            out.println("<body>");
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
            String sid = request.getParameter("id");
            int id = Integer.parseInt(sid);
//            
//            out.println("<div class='container'>");
            
            ProjectBean project = ProjectDao.viewById(id);
            
            List<LeaderBean> list=LeaderDao.view();
//            request.setAttribute("leaders", list);
            String Leaders_list = "<div class=\"form-group\"><label for=\"leader\">Leader</label>\n<select name=\"leader\" class=\"form-control\">";
            Leaders_list += "<option value=\"0\">None</option>";
            for(LeaderBean leader : list){
                if(leader.getId() == project.getId())
                    Leaders_list += "<option value=\""+leader.getId()+"\" selected>"+leader.getName()+"</option>";
                else
                    Leaders_list += "<option value=\""+leader.getId()+"\">"+leader.getName()+"</option>";
            }
            Leaders_list += "</select></div>";
            request.setAttribute("leaders_list", Leaders_list);
            request.setAttribute("project", project);
            List<StateBean> state_list=StateDao.view();
            String States_list = "<div class=\"form-group\"><label for=\"state\">Status</label>\n<select name=\"status\" class=\"form-control\">";
//            States_list += "<option value=\"0\">None</option>";
            for(StateBean state : state_list){
                if(state.getId() == project.getId())
                    States_list += "<option value=\""+state.getId()+"\" selected>"+state.getName()+"</option>";
                else
                    States_list += "<option value=\""+state.getId()+"\">"+state.getName()+"</option>";
            }
            States_list += "</select></div>";
            request.setAttribute("stateList",States_list);
            
            
//            out.println("<div>\n" +
//                "            <h3>Edit Project Form</h3>\n" +
//                "  <form action=\"EditProject\" method=\"post\" style=\"width:300px\">\n" +
//                "\n" +"<input type=\"hidden\" name=\"id\" value=\""+id+"\">"+
//                "  <div class=\"form-group\">\n" +
//                "    <label for=\"name1\">Title</label>\n" +
//                "    <input type=\"text\" class=\"form-control\" name=\"title\" id=\"title\" placeholder=\"Title\" value=\""+bean.getTitle()+"\"/>\n" +
//                "  </div>\n" +
//                "  <div class=\"form-group\">\n" +
//                "    <label for=\"Type\">StartDate</label>\n" +
//                "    <input type=\"date\" class=\"form-control\" name=\"startdate\" id=\"startdate\" placeholder=\"StartDate\" value=\""+bean.getStartdate()+"\"/>\n" +
//                "  </div>\n" +
//                "  <div class=\"form-group\">\n" +
//                "    <label for=\"Type\">EndDate</label>\n" +
//                "    <input type=\"date\" class=\"form-control\" name=\"enddate\" id=\"enddate\" placeholder=\"EndDate\" value=\""+bean.getEnddate()+"\"/>\n" +
//                "  </div>\n" +
//                "  <div class=\"form-group\">\n" +
//                "    <label for=\"Type\">Status</label>\n" +
//                "    <input type=\"text\" class=\"form-control\" name=\"status\" id=\"status\" placeholder=\"Status\" value=\""+bean.getStatus()+"\"/>\n" +
//                "  </div>\n" +Leaders_list+
//                " \n" +
//                "  <button type=\"submit\" class=\"btn btn-primary\">Save Project</button>\n" +
//                "</form>\n" +
//                "        </div>");
//            request.getRequestDispatcher("createprojectform.html").include(request, response);
//            out.println("</div>");

            request.getRequestDispatcher("editprojectform.jsp").include(request, response);
//        }
    }

}
