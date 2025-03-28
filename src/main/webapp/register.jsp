<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
</head>
<body>
	<h1>Sign up</h1>
	<form action="UserServlet" method="post">
		<label for="name">Name:</label>
		<input type="text" id="name" name="name">
		<br>
		
		<label for="email">Email:</label>
		<input type="text" id="email" name="email">
		<br>
		
		
		<label for="password">Password:</label>
		<input type="text" id="password" name="password">
		<br>
		
		<button type="submit" class="button">SignUp</button>
		<br>
		<a href="login.jsp">Login here.</a>
		
	
		
		
		<% if (request.getAttribute("errorMessage") != null) { %>
			<br>
    	   <p style="color: red;"><%= request.getAttribute("errorMessage") %></p>
    	        	    	
        <% } %>
     
		
	</form>
</body>
</html>