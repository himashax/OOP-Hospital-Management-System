<%@ page import="Model.Doctor" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style.css">
<title>Insert title here</title>
</head>
<body>
	 <%
	 
	 	Doctor doctor = (Doctor) request.getAttribute("doctor");
	 
	%>
	
	
	<div class = "form">
	<form method="post" action="<% request.getContextPath(); %> UpdateDoctor">
	
	<input type= "hidden" name="doctorID" value = "<%=doctor.getDoctorID()%>" /><br/><br/>
	
		FirstName:<input type="text" name = "firstName"><br/><br/>
		LastName: <input type="text" name = "lastName"><br/><br/>
		Age:      <input type="number" name = "age"><br/><br/>
		Gender:   <input type="radio" name="gender" value="male">
				  <label for="male">Male</label>
				  <input type="radio" name="gender" value="female">
				  <label for="female">Female</label><br/><br/>
		Phone:    <input type="number" name = "phone"><br/><br/>
		Email:    <input type="email" name = "email"><br/><br/>
		Address:  <input type="text" name = "address"><br/><br/>
		Salary:   <input type="number" name = "salary"><br/><br/>
		password: <input type="text" name = "password"><br/><br/>
	
	<input type="submit" name="submit" value="Update">
	
	</form>
	</div>
</body>
</html>