<%@ page import = "Model.OutPatient" %>
<%@ page import = "Services.IOutPatientService" %>
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

<jsp:include page = "ReceptionistProfile.jsp" />

 	<%
	 OutPatient out_patient = (OutPatient) request.getAttribute("out_patient");
	%>
	<div class = "form">
	<form method="post" action="<% request.getContextPath(); %> UpdateOutPatient">
	
	<input type="hidden" name = "outPatientID" value="<%= out_patient.getOutPatientID() %>"><br/><br/>
	FirstName:<input type="text" name = "firstName"><br/><br/>
	LastName:<input type="text" name = "lastName"><br/><br/>
	Age:<input type="number" name = "age"><br/><br/>
	Gender: <input type="radio" name="gender" value="male">
			<label for="male">Male</label>
		    <input type="radio" name="gender" value="female">
			<label for="female">Female</label><br/><br/>
	Phone:<input type="number" name = "phone"><br/><br/>
	Email:<input type="email" name = "email"><br/><br/>
	Address:<input type="text" name = "address"><br/><br/>
	password:<input type="text" name = "password"><br/><br/>
	<input type="submit" name="submit" value="Update">

</form>
</div>
</body>
</html>