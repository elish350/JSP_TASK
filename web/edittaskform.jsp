<%@page import="java.util.List"%>
<%@page import="model.ProjectBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<jsp:include page="navigation.jsp"></jsp:include>
<div class="container">
    <h3>Update Task</h3>
  <form action="EditTask" method="post" style="width:300px">
      <input type="hidden" name="id" value="${task.id}">
  <div class="form-group">
    <label for="title">Title</label>
    <input type="text" class="form-control" name="title" id="title" placeholder="Title" value="${task.title}"/>
  </div>
  <div class="form-group">
    <label for="Type">Description</label>
    <textarea class="form-control" name="description" id="userid1" placeholder="Description">${task.description}</textarea>
  </div>
  <div class="form-group">
    <label for="Type">Deadline</label>
    <input type="date" class="form-control" name="deadline" id="deadline" placeholder="Deadline" value="${task.deadline}"/>
  </div>
  ${stateList}
  ${projectList}
 
  <button type="submit" class="btn btn-primary">Update Task</button>
</form>
</div>
<jsp:include page="footer.jsp"></jsp:include>