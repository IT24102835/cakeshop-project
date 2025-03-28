<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="com.userMgr.model.Users" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile</title>
</head>
<body>
	<% Users user = (Users)session.getAttribute("user"); %>
	
	<%if (user != null) { %>
		<h2>Name: <%= user.getUserName() %></h2>
		<h2>Email: <%= user.getEmail() %></h2>
		<h2>Password: <%= user.getPassword() %></h2>
	<%} else {%>
		<h2>No user found. <a href="login.jsp">Login here</a></h2>
	<% }%>
	
</body>
</html>