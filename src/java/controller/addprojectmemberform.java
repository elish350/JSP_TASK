package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AddProjectMemberForm")
public class addprojectmemberform extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public addprojectmemberform(){
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("title", "test");
        HttpSession session = request.getSession();
//        session.setAttribute("userrole", "test");
        getServletContext().setAttribute("msgAppContext", "addProjectMemberForm");
        getServletContext().getRequestDispatcher("/addprojectmemberform.jsp").forward(request, response);

//        response.setContentType("text/html");
//        try (PrintWriter out = response.getWriter()) {
//            out.print("<!DOCTYPE html>");
//            out.print("<html>");
//            out.println("<head>");
//            out.println("<title>Add Project member Form</title>");
//            out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
//            out.println("</head>");
//            out.println("<body>");
//
//            HttpSession session = request.getSession();
////            request.getRequestDispatcher("addmemberform.jsp").include(request, response);
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
//            request.getRequestDispatcher("addprojectmemberform.html").include(request, response);
//            out.println("</div>");
//
//            request.getRequestDispatcher("footer.html").include(request, response);
//        }
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
