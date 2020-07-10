package controller;

import java.io.IOException;
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

@WebServlet("/ViewProject")
public class viewproject extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html");
//        try (PrintWriter out = response.getWriter()) {
//            out.print("<!DOCTYPE html>");
//            out.print("<html>");
//            out.println("<head>");
//            out.println("<title>View Task</title>");
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
//
//            List<ProjectBean> list = ProjectDao.view();
//            List<LeaderBean> leader_list = LeaderDao.view();
////            String Leaders_list = ;
////            Leaders_list += ;
//            out.println("<h1>Project List</h1>");
//            out.println("<table class='table table-bordered table-striped'>");
//            out.println("<tr><th>Id</th><th>Title</th><th>StartDate</th><th>EndDate</th><th>Status</th><th>Leader</th><th>Edit</th><th>Remove</th></tr>");
//            list.forEach((bean) -> {
//                String temp = "";
//                for(LeaderBean leader_item : leader_list){
//                    if(leader_item.getId()==bean.getId()){
//                        temp += leader_item.getName();
//                    }
//                }
//                
//                out.println("<tr><td>" + bean.getId()+ "</td><td>" + bean.getTitle()+ "</td><td>" + bean.getStartdate()+ "</td><td>" + bean.getEnddate()+ "</td><td>" + bean.getStatus()+ "</td><td>"+temp+"</td><td><a href='EditProjectForm?id="+bean.getId()+"'>Edit</a></td><td><a href='RemoveProject?id="+bean.getId()+"'>Remove</a></td></tr>");
//
//            });
//            out.println("</table>");
//
//            out.println("</div>");
//
//            request.getRequestDispatcher("footer.html").include(request, response);
//        }
            request.setAttribute("title", "View Project");
            List<ProjectBean> list=ProjectDao.view();
            request.setAttribute("projectList",list);
            List<StateBean> state_list=StateDao.view();
            request.setAttribute("stateList",state_list);
            List<LeaderBean> leader_list=LeaderDao.view();
            request.setAttribute("leaderList",leader_list);
            getServletContext().getRequestDispatcher("/viewproject.jsp").forward(request, response);
    }
}
