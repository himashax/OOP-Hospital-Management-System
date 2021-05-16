<!-- IT19128696 -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css">

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div class = "registration">


	<div class = "reg_form">
		<form method="post" action="AddOutPatient">
		First Name<input type="text" name = "firstName">
		Last Name<input type="text" name = "lastName">
		Age<input type="number" name = "age">
		Gender<input type="radio" name="gender" value="male">
		  <label for="male">Male</label>
		  <input type="radio" name="gender" value="female">
		  <label for="female">Female</label><br><br>
		Phone<input type="number" name = "phone">
		Email<input type="email" name = "email">
		Address<input type="text" name = "address">
		password<input type="password" name = "password">
		<a href = "LoginPage.jsp">Already have an Account? Click here</a>
		<input class = "submitButton" type="submit" name="submit" value="Register">
		</form>
	</div>
	

	</div>

</body>
</html>