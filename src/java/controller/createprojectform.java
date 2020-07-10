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
import model.StateBean;
import model.StateDao;

@WebServlet("/CreateProjectForm")
public class createprojectform extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html");
//        try (PrintWriter out = response.getWriter()) {
//            out.print("<!DOCTYPE html>");
//            out.print("<html>");
//            out.println("<head>");
//            out.println("<title>Create Task Form</title>");
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

//            out.println("<div class='container'>");
            
            
            List<LeaderBean> list=LeaderDao.view();
//            request.setAttribute("leaders", list);
            String Leaders_list = "<div class=\"form-group\"><label for=\"leader\">Leader</label>\n<select name=\"leader\" class=\"form-control\">";
            Leaders_list += "<option value=\"0\">None</option>";
            for(LeaderBean leader : list){
                Leaders_list += "<option value=\""+leader.getId()+"\">"+leader.getName()+"</option>";
            }
            Leaders_list += "</select></div>";
            request.setAttribute("leaders_list", Leaders_list);
            List<StateBean> state_list=StateDao.view();
//            request.setAttribute("leaders", list);
            String stateList = "<div class=\"form-group\"><label for=\"leader\">Status</label>\n<select name=\"status\" class=\"form-control\">";
            stateList += "<option value=\"0\">None</option>";
            for(StateBean state : state_list){
                stateList += "<option value=\""+state.getId()+"\">"+state.getName()+"</option>";
            }
            stateList += "</select></div>";
            request.setAttribute("state_list", stateList);
//            System.out.println(Leaders_list);
//            out.println("<div>\n" +
//                "            <h3>Create Project Form</h3>\n" +
//                "  <form action=\"CreateProject\" method=\"post\" style=\"width:300px\">\n" +
//                "\n" +
//                "  <div class=\"form-group\">\n" +
//                "    <label for=\"name1\">Title</label>\n" +
//                "    <input type=\"text\" class=\"form-control\" name=\"title\" id=\"title\" placeholder=\"Title\"/>\n" +
//                "  </div>\n" +
//                "  <div class=\"form-group\">\n" +
//                "    <label for=\"Type\">StartDate</label>\n" +
//                "    <input type=\"date\" class=\"form-control\" name=\"startdate\" id=\"startdate\" placeholder=\"StartDate\"/>\n" +
//                "  </div>\n" +
//                "  <div class=\"form-group\">\n" +
//                "    <label for=\"Type\">EndDate</label>\n" +
//                "    <input type=\"date\" class=\"form-control\" name=\"enddate\" id=\"enddate\" placeholder=\"EndDate\"/>\n" +
//                "  </div>\n" +
//                "  <div class=\"form-group\">\n" +
//                "    <label for=\"Type\">Status</label>\n" +
//                "    <input type=\"text\" class=\"form-control\" name=\"status\" id=\"status\" placeholder=\"Status\"/>\n" +
//                "  </div>\n" +Leaders_list+
//                " \n" +
//                "  <button type=\"submit\" class=\"btn btn-primary\">Create Project</button>\n" +
//                "</form>\n" +
//                "        </div>");
            request.getRequestDispatcher("createprojectform.jsp").include(request, response);
//            out.println("</div>");

//            request.getRequestDispatcher("footer.html").include(request, response);
//        }
    }

}
