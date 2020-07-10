<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
    <title>User Management Application</title>

    <link rel="stylesheet"
            href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
            integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
            crossorigin="anonymous">
    <link rel="stylesheet" href="bootstrap.min.css" type="text/css">
    
    <style type="text/css">
        .navbar .container{
            display:inline-block;
        }
        .navbar .container .navbar-header{
            float: left;
        }
        .navbar .container .collapse{
            float: right;
        }
        .navbar .container .collapse .nav.navbar-nav{
            display: inline-block;
        }
        .nav.navbar-nav .dropdown:focus{
            border:0px;
            outline:0px;
        }
        .nav.navbar-nav .dropdown .dropdown-toggle{
            background-color: transparent;
            color: #9d9d9d;
            border: 0px !important;
            padding:15px;
        }
        .navbar-nav .dropdown-menu{
            position: absolute;
        }
        .btn.focus, .btn:focus, .btn:active, .btn:visited{
            box-shadow: none;
        }
    </style>
    </head>

    <body>
        <div>
            <nav class="navbar navbar-inverse">
                <div class="container">
                  <!-- Brand and toggle get grouped for better mobile display -->
                  <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                      <span class="sr-only">Toggle navigation</span>
                      <span class="icon-bar"></span>
                      <span class="icon-bar"></span>
                      <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href=".">web0based project managment system</a>
                  </div>
                  <% 
                      String userrole = (String)session.getAttribute("userrole");
                  %>
                  <!-- Collect the nav links, forms, and other content for toggling -->
                  <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <c:if test = "${userrole == 'admin'}">
                            <ul class="nav navbar-nav">
                                <li><a href=".">Home</a></li>
                                <li class="dropdown">
                                    <button class="btn dropdown-toggle" type="button" data-toggle="dropdown" style="background-color: transparent;">User
                                    </button>
                                    <ul class="dropdown-menu">
                                        <li><a href="CreateUserForm">Create User</a></li>
                                        <li><a href="ViewUser">View User</a></li>
                                    </ul>
                                </li>
                                <li class="dropdown">
                                    <button class="btn dropdown-toggle" type="button" data-toggle="dropdown" style="background-color: transparent;">Project
                                    </button>
                                    <ul class="dropdown-menu">
                                        <li><a href="CreateProjectForm">Create Project</a></li>
                                        <li><a href="ViewProject">View Project</a></li>
                                    </ul>
                                </li>
                                <li class="dropdown">
                                    <button class="btn dropdown-toggle" type="button" data-toggle="dropdown" style="background-color: transparent;">Leader
                                    </button>
                                    <ul class="dropdown-menu">
                                        <li><a href="CreateLeaderForm">Create Leader</a></li>
                                        <li><a href="ViewLeader">View Leader</a></li>
                                    </ul>
                                </li>
                                <li class="dropdown">
                                    <button class="btn dropdown-toggle" type="button" data-toggle="dropdown" style="background-color: transparent;">Member
                                    </button>
                                    <ul class="dropdown-menu">
                                        <li><a href="CreateMemberForm">Create Member</a></li>
                                        <li><a href="ViewProjectMember">View Member</a></li>
                                    </ul>
                                </li>

                                <li><a href="Logout">Logout</a></li>
                            </ul>
                        </c:if>
                        <c:if test = "${userrole == 'leader'}">
                            <ul class="nav navbar-nav">
                                <li><a href=".">Home</a></li>
                                <li class="dropdown">
                                    <button class="btn dropdown-toggle" type="button" data-toggle="dropdown" style="background-color: transparent;">Task
                                    </button>
                                    <ul class="dropdown-menu">
                                        <li><a href="CreateTaskForm">Create Task</a></li>
                                        <li><a href="ViewTask">View Task</a></li>
                                    </ul>
                                </li>
                                <li class="dropdown">
                                    <button class="btn dropdown-toggle" type="button" data-toggle="dropdown" style="background-color: transparent;">Member
                                    </button>
                                    <ul class="dropdown-menu">
                                        <li><a href="CreateMemberForm">Create Member</a></li>
                                        <li><a href="ViewProjectMember">View Members</a></li>
                                    </ul>
                                </li>
                                <li><a href="Logout">Logout</a></li>
                            </ul>
                        </c:if>
                        <c:if test = "${userrole == 'member'}">
                            <ul class="nav navbar-nav">
                                <li><a href=".">Home</a></li>
                                <li><a href="ViewTask">Task</a></li>
                                <li><a href="ViewProjectMember">Members</a></li>
                                <li><a href="Logout">Logout</a></li>
                            </ul>
                        </c:if>
                        <c:if test = "${userrole == null}">
                            <ul class="nav navbar-nav">
                                <li><a href="." class="active">Home</a></li>
                                <li><a href="#">Admin</a></li>
                                <li><a href="#">Leader</a></li>
                                <li><a href="#">Member</a></li>
                            </ul>
                        </c:if>
                  </div><!-- /.navbar-collapse -->
                </div><!-- /.container-fluid -->
            </nav>
        </div>