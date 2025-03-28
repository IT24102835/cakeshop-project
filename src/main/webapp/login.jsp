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
	<form action="Login" method="post">
		<label for="userIdentifier">Username:</label><br>
		<input type="text" id="userIdentifier" name="userIdentifier"><br><br>
		<label for="password">Password:</label><br>
		<input type="password" id="password" name="password"><br><br>
		
		<button type="submit">Login</button><br><br>
		
		<p>Don't have an account? <a href="customer-signup.jsp">Register</a></p>
        <% if (request.getAttribute("error") != null) { %>
        	<p style="color: red;"><%= request.getAttribute("error") %></p>
        <% } %>
	</form>
</body>
</html>