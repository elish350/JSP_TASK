<%@page import="java.util.List"%>
<%@page import="model.ProjectBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<jsp:include page="navigation.jsp"></jsp:include>
<div class="container"><h1>Project List</h1>
    <table class='table table-bordered table-striped'>
        <tr><th>Id</th><th>Title</th><th>StartDate</th><th>EndDate</th><th>Status</th><th>Leader</th><th>Edit</th><th>Remove</th></tr>
        <c:forEach var="item" items="${projectList}">
            <tr>
                <td><c:out value="${item.id}"/></td>
                <td><c:out value="${item.title}"/></td>
                <td><c:out value="${item.startdate}"/></td>
                <td><c:out value="${item.enddate}"/></td>
                <c:forEach var="state_item" items="${stateList}">
                    <c:if test="${state_item.id == item.status}">
                        <td><c:out value="${state_item.name}"/></td>
                    </c:if>
                </c:forEach>
                <c:forEach var="leader" items="${leaderList}">
                    <c:if test="${leader.id == item.userid}">
                        <td><c:out value="${leader.name}"/></td>
                    </c:if>
                </c:forEach>
                <td><a href="EditProjectForm?id=<c:out value='${item.id}' />">Edit</a></td>
                <td><a href="RemoveProject?id=<c:out value='${item.id}' />">Remove</a></td>

            </tr>
        </c:forEach>
    </table>
</div>
<jsp:include page="footer.jsp"></jsp:include>