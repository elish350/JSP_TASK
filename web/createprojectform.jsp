<%@page import="java.util.List"%>
<%@page import="model.ProjectBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<jsp:include page="navigation.jsp"></jsp:include>
<div class="container">
    <h3>Create Project</h3>
  <form action="CreateProject" method="post" style="width:300px">

  <div class="form-group">
    <label for="name1">Title</label>
    <input type="text" class="form-control" name="title" id="title" placeholder="Title"/>
  </div>
  <div class="form-group">
    <label for="Type">StartDate</label>
    <input type="date" class="form-control" name="startdate" id="startdate" placeholder="StartDate"/>
  </div>
  <div class="form-group">
    <label for="Type">EndDate</label>
    <input type="date" class="form-control" name="enddate" id="enddate" placeholder="EndDate"/>
  </div>
  ${state_list}
  ${leaders_list}
  <button type="submit" class="btn btn-primary">Create Project</button>
</form>
</div>
<jsp:include page="footer.jsp"></jsp:include>