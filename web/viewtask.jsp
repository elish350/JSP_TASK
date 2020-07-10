<%@page import="java.util.List"%>
<%@page import="model.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<jsp:include page="navigation.jsp"></jsp:include>
<div class="container"><h1>Task List</h1>
    <% 
        String userrole = (String)session.getAttribute("userrole");
        System.out.println(userrole);
    %>
    <table class='table table-bordered table-striped'>
    <c:choose>
        <c:when test="${userrole == 'leader'}">
            <tr><th>Id</th><th>Title</th><th>Description</th><th>Deadline</th><th>State</th><th>Edit</th><th>Remove</th></tr>
            <c:forEach var="item" items="${task_list}">
                <tr>
                    <td><c:out value="${item.id}"/></td>
                    <td><c:out value="${item.title}"/></td>
                    <td><c:out value="${item.description}"/></td>
                    <td><c:out value="${item.deadline}"/></td>
                    <c:forEach var="state_item" items="${stateList}">
                        <c:if test="${state_item.id == item.state}">
                            <td><c:out value="${state_item.name}"/></td>
                        </c:if>
                    </c:forEach>
                    <td><a href="EditTaskForm?id=<c:out value='${item.id}' />">Edit</a></td>
                    <td><a href="RemoveTask?id=<c:out value='${item.id}' />">Remove</a></td>
                </tr>
            </c:forEach>
        </c:when>
        <c:otherwise>
            <tr><th>Id</th><th>Title</th><th>Description</th><th>Deadline</th><th>State</th><th>Edit</th></tr>
            <c:forEach var="item" items="${task_list}">
                <tr>
                    <td><c:out value="${item.id}"/></td>
                    <td><c:out value="${item.title}"/></td>
                    <td><c:out value="${item.description}"/></td>
                    <td><c:out value="${item.deadline}"/></td>
                    <c:forEach var="state_item" items="${stateList}">
                        <c:if test="${state_item.id == item.state}">
                            <td><c:out value="${state_item.name}"/></td>
                        </c:if>
                    </c:forEach>
                    <td><a href="EditTaskForm?id=<c:out value='${item.id}' />">Edit</a></td>
                </tr>
            </c:forEach>
        </c:otherwise>
    </c:choose>
    </table>
</div>
<jsp:include page="footer.jsp"></jsp:include>