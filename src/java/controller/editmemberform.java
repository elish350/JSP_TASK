package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MemberBean;
import model.MemberDao;

@WebServlet("/EditMemberForm")
public class editmemberform extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html");
//        try (PrintWriter out = response.getWriter()) {
//            out.print("<!DOCTYPE html>");
//            out.print("<html>");
//            out.println("<head>");
//            out.println("<title>Edit Member Form</title>");
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
//            out.println("<div class='container'><h1>Edit Member</h1>");
            String sid = request.getParameter("id");
            int id = Integer.parseInt(sid);

            MemberBean member = MemberDao.viewById(id);

//            out.print("<form action='EditMember' method='post' style='width:300px'>");
//            out.print("<div class='form-group'>");
//            out.print("<input type='hidden' name='id' value='" + bean.getId() + "'/>");
//            out.print("<label for='name1'>Name</label>");
//            out.print("<input type='text' class='form-control' value='" + bean.getName()+ "' name='name' id='name1' placeholder='Name'/>");
//            out.print("</div>");
//            out.print("<div class='form-group'>");
//            out.print("<label for='email1'>Email address</label>");
//            out.print("<input type='email' class='form-control' value='" + bean.getEmail() + "'  name='email' id='email1' placeholder='Email'/>");
//            out.print("</div>");
//            out.print("<div class='form-group'>");
//            out.print("<label for='password1'>Password</label>");
//            out.print("<input type='password' class='form-control' value='" + bean.getPassword() + "'  name='password' id='password1' placeholder='Password'/>");
//            out.print("</div>  ");
//            out.print("<div class='form-group'>");
//            out.print("<label for='mobile1'>Mobile Number</label>");
//            out.print("<input type='number' class='form-control' value='" + bean.getMobile() + "'  name='mobile' id='mobile1' placeholder='Mobile'/>");
//            out.print("</div>");
//            out.print("<button type='submit' class='btn btn-primary'>Update</button>");
//            out.print("</form>");
//
//            out.println("</div>");
            request.setAttribute("member", member);
            request.getRequestDispatcher("editmemberform.jsp").include(request, response);
//            out.close();
//        }

    }
}
