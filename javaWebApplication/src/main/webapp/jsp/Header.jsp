<%@page import="javawebapplication.controller.JWAView"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
<link rel="stylesheet" href= "../css/style.css">
<link rel="stylesheet" href= "css/style.css">
</head>
<body>
<%String userSession = (String)session.getAttribute("user"); %>
<nav class="navbar navbar-expand-lg navbar-light bg-secondary">
  <a class="navbar-brand" href="#">Navbar</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
  <%if (userSession==null) {%>
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="jsp/Home.jsp">Home<span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="<%=JWAView.LoginCTL%>">Login</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="<%=JWAView.UserCTL %>">Registration</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="<%=JWAView.ProgramListCTL %>">Programs</a>
      </li>
      <% } else{%>
      <%String name = userSession.toString();%>
     	<%if(name.equals("staff")){%>
      	<ul class="navbar-nav">
      	<li class="nav-item active">
        	<a class="nav-link" href="jsp/Home.jsp">Home <span class="sr-only">(current)</span></a>
      	</li>
      	<li class="nav-item">
        	<a class="nav-link" href="<%=JWAView.StaffPLCTL %>">Programs</a>
      	</li>
      	<li class="nav-item">
        	<a class="nav-link" href="<%=JWAView.ProgramCTL %>">Program Registration</a>
      	</li>
      	<li class="nav-item">
        	<a class="nav-link" href=<%=JWAView.LoginCTL+ "?operation=logout" %>>Logout</a>
      	</li>
    	</ul>
    <%}else{ %>
    <%int userMemberSession = (int)session.getAttribute("isMember"); %>
    	<%int isMember = userMemberSession;%>
    	<%if(isMember==1){ %>
     	<ul class="navbar-nav">
      	<li class="nav-item active">
        	<a class="nav-link" href="jsp/Home.jsp">Home <span class="sr-only">(current)</span></a>
      	</li>
      	<li class="nav-item">
        	<a class="nav-link" href="<%=JWAView.MemberPLCTL %>">Programs</a>
      	</li>
     	<li class="nav-item">
        	<a class="nav-link" href=<%=JWAView.LoginCTL+ "?operation=logout" %>>Logout</a>
      	</li>
    	</ul>
    	<%}else{ %>
    	     <ul class="navbar-nav">
      	<li class="nav-item active">
        	<a class="nav-link" href="jsp/Home.jsp">Home <span class="sr-only">(current)</span></a>
      	</li>
      	<li class="nav-item">
        	<a class="nav-link" href="<%=JWAView.NonMemberPLCTL%>">Programs</a>
      	</li>
     	<li class="nav-item">
        	<a class="nav-link" href=<%=JWAView.LoginCTL+ "?operation=logout" %>>Logout</a>
      	</li>
    	</ul>
    	<% } %>
    	<% } %>
    <% } %>
  </div>
</nav>

</body>
</html>