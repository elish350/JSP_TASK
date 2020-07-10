<%@page import="java.util.List"%>
<%@page import="model.LeaderBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<jsp:include page="navigation.jsp"></jsp:include>
<div class="container"><h1>Leader List</h1>
    <table class='table table-bordered table-striped'>
        <tr><th>Id</th><th>Name</th><th>Email</th><th>Password</th><th>Mobile</th><th>Edit</th><th>Remove</th></tr>
        <c:forEach var="item" items="${leaderList}">
            <tr>
                <td><c:out value="${item.id}"/></td>
                <td><c:out value="${item.name}"/></td>
                <td><c:out value="${item.email}"/></td>
                <td><c:out value="${item.password}"/></td>
                <td><c:out value="${item.mobile}"/></td>
                <td><a href="EditLeaderForm?id=<c:out value='${item.id}' />">Edit</a></td>
                <td><a href="RemoveLeader?id=<c:out value='${item.id}' />">Remove</a></td>

            </tr>
        </c:forEach>
    </table>
</div>
<jsp:include page="footer.jsp"></jsp:include>