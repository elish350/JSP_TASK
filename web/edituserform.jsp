<%@page import="java.util.List"%>
<%@page import="model.ProjectBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<jsp:include page="navigation.jsp"></jsp:include>
<div class="container">
    <h3>Update User</h3>
    <form action="EditUser" method="post" style="width:300px">
        <input type="hidden" name="id" value="${user.id}">
        <div class="form-group">
          <label for="name1">Name</label>
          <input type="text" class="form-control" name="name" id="name1" placeholder="Name" value="${user.username}"/>
        </div>
        <div class="form-group">
          <label for="Type">Password</label>
          <input type="password" class="form-control" name="password" id="password1" placeholder="Password" value="${user.password}"/>
        </div>

        <button type="submit" class="btn btn-primary">Update User</button>
    </form>
</div>
<jsp:include page="footer.jsp"></jsp:include>