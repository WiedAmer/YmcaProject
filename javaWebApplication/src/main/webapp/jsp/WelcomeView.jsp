<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%@ include file="Header.jsp"%>
<body>
<div id="carouselExampleControls" class="carousel slide" 
	data-ride="carousel">
  	<div class="carousel-inner">
    <div class="carousel-item active">
      <img src="/javaWebApplication/image/1.jpg" class="d-block w-100" 
      	alt="..." height="300px">
    </div>
    <div class="carousel-item">
      <img src="/javaWebApplication/image/1.jpg" class="d-block w-100" 
      	alt="..." height="300px">
    </div>
    <div class="carousel-item">
      <img src="/javaWebApplication/image/1.jpg" class="d-block w-100" 
      	alt="..." height="300px">
      	
    </div>
  </div>
  <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>
<h1 style="padding: 50px"><%="Welcome: " + (String)session.getAttribute("user") %></h1>

</body>
<%@ include file="Footer.jsp"%>
</html>