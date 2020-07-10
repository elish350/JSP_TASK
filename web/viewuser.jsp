<%@page import="java.util.List"%>
<%@page import="model.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<jsp:include page="navigation.jsp"></jsp:include>
<div class="container"><h1>User List</h1>
    <table class='table table-bordered table-striped'>
        <tr><th>Id</th><th>Name</th><th>Password</th><th>Edit</th></tr>
        <c:forEach var="item" items="${userList}">
            <tr>
                <td><c:out value="${item.id}"/></td>
                <td><c:out value="${item.username}"/></td>
                <td><c:out value="${item.password}"/></td>
                <td><a href="EditUserForm?id=<c:out value='${item.id}' />">Edit</a></td>

            </tr>
        </c:forEach>
    </table>
</div>
<jsp:include page="footer.jsp"></jsp:include>