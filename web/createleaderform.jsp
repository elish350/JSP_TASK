<%@page import="java.util.List"%>
<%@page import="model.ProjectBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<jsp:include page="navigation.jsp"></jsp:include>
<div class="container">
    <h3>Create Leader</h3>
        <form action="CreateLeader" method="post" style="width:300px">

        <div class="form-group">
          <label for="name1">Name</label>
          <input type="text" class="form-control" name="name" id="name1" placeholder="Name"/>
        </div>
        <div class="form-group">
          <label for="Type">Email</label>
          <input type="email" class="form-control" name="email" id="email1" placeholder="Email"/>
        </div>
        <div class="form-group">
          <label for="Type">Mobile</label>
          <input type="text" class="form-control" name="mobile" id="phone1" placeholder="Mobile"/>
        </div>
        <div class="form-group">
          <label for="Type">Password</label>
          <input type="password" class="form-control" name="password" id="password1" placeholder="Password"/>
        </div>

        <button type="submit" class="btn btn-primary">Create Leader</button>
      </form>
</div>
<jsp:include page="footer.jsp"></jsp:include>