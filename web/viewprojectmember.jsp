<%@page import="java.util.List"%>
<%@page import="model.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<jsp:include page="navigation.jsp"></jsp:include>
<div class="container"><h1>Member List</h1>
    <table class='table table-bordered table-striped'>
    <% 
        String userrole = (String)session.getAttribute("userrole");
        System.out.println(userrole);
    %>
    <table class='table table-bordered table-striped'>
    <c:choose>
        <c:when test="${userrole == 'leader' || userrole == 'admin'}">
            <tr><th>Id</th><th>Name</th><th>Email</th><th>Password</th><th>Mobile</th><th>Edit</th><th>Delete</th></tr>
            <c:forEach var="item" items="${memberList}">
                <tr>
                    <td><c:out value="${item.id}"/></td>
                    <td><c:out value="${item.name}"/></td>
                    <td><c:out value="${item.email}"/></td>
                    <td><c:out value="${item.password}"/></td>
                    <td><c:out value="${item.mobile}"/></td>
                    <td><a href="EditMemberForm?id=<c:out value='${item.id}' />">Edit</a></td>
                    <td><a href="RemoveMember?id=<c:out value='${item.id}' />">Delete</a></td>

                </tr>
            </c:forEach>
        </c:when>
        <c:otherwise>
            <tr><th>Id</th><th>Name</th><th>Email</th><th>Password</th><th>Mobile</th><th>Edit</th></tr>
            <c:forEach var="item" items="${memberList}">
                <tr>
                    <td><c:out value="${item.id}"/></td>
                    <td><c:out value="${item.name}"/></td>
                    <td><c:out value="${item.email}"/></td>
                    <td><c:out value="${item.password}"/></td>
                    <td><c:out value="${item.mobile}"/></td>
                    <td><a href="EditMemberForm?id=<c:out value='${item.id}' />">Edit</a></td>
                </tr>
            </c:forEach>
        </c:otherwise>
    </c:choose>
    </table>
</div>
<jsp:include page="footer.jsp"></jsp:include>