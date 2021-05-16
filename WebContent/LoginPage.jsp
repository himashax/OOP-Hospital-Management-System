<!-- IT19128696 -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css">
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
	<body>

	<div class = "login">
	<img id = "loginImage" src = "img1.png">
	<div class = "login1">
	<form action="LoginValidation" method="post">
	
	Username <input type="text" name="userName" required />
	Password <input type="password" name="password" required />
	<a href = "PatientRegistration.jsp">Don't have an Account? Register Here</a>
	<input class = "submitButton" type="submit" value="Login" />
	</form>	
	</div>
	

</div>	
	</body>
</html>