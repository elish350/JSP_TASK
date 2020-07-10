<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="navigation.jsp"></jsp:include>
<div class="container">
    <h1>Web-based Project Management System</h1>

    <div class="row">
        <div class="col-md-6">
            <h3>Admin Login</h3>
            <form action="AdminLogin" method="post" style="width:300px">
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

        <div class="col-md-6">
            <h3> Leader Login</h3>
            <form action="LeaderLogin" method="post" style="width:300px">
                <div class="form-group">
                    <label for="email2">Email address</label>
                    <input type="email" class="form-control" id="email1" name="email" placeholder="Email"/>
                </div>
                <div class="form-group">
                    <label for="password2">Password</label>
                    <input type="password" class="form-control" id="password1" name="password" placeholder="Password"/>
                </div>  
                <button type="submit" class="btn btn-primary">Login</button>
            </form>
        </div>

        <div class="col-md-6">
          <h3>Project Member Login</h3>
            <form action="MemberLogin" method="post" style="width:300px">
                <div class="form-group">
                  <label for="email3">Email address</label>
                  <input type="email" class="form-control" name="email" id="email1" placeholder="Email"/>
                </div>
                <div class="form-group">
                  <label for="password3">Password</label>
                  <input type="password" class="form-control" name="password" id="password1" placeholder="Password"/>
                </div>  
                <button type="submit" class="btn btn-primary">Login</button>
            </form>
        </div>
    </div>
</div>

<jsp:include page="footer.jsp"></jsp:include>