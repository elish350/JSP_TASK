<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="navigation.jsp"></jsp:include>
<div class="container">
    <h3>Email or password you entered does not match</h3>
    <h3>${title}</h3>
    <form action="${loginform}" method="post" style="width:300px">
        <div class="form-group">
            <label for="email1">Email address</label>
            <input type="email" class="form-control" name="email" id="email1" placeholder="Email"/>
        </div>
        <div class="form-group">
            <label for="password1">Password</label>
            <input type="password" class="form-control" name="password" id="password1" placeholder="Password"/>
        </div>  
        <button type="submit" class="btn btn-primary">Login</button>
    </form>
</div>
<jsp:include page="footer.jsp"></jsp:include>