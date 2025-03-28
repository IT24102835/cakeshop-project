<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<h1>Login</h1>
	<form action="LoginServlet" method="post">		
		<label for="userIdentifier">Username or Email:</label>
		<input type="text" id="userIdentifier" name="userIdentifier">
		<br>
		<label for="password">Password:</label>
		<input type="text" id="password" name="password">
		<br>
		<button type="submit" class="button">Login</button>
		<br>
		<a href="register.jsp">Register first.</a>
		
		<% if (request.getAttribute("error") != null) { %>
			<br>
    	   <p style="color: red;"><%= request.getAttribute("error") %></p>
    	        	    	
        <% } %>
		
	</form>
</body>
</html>