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
<%="Welcome: " + (String)session.getAttribute("user") %>
<h1>Welcome to the YMCA program registration</h1>

</body>
<%@ include file="Footer.jsp"%>
</html>