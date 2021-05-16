<!-- IT19128696 -->

<%@ page import = "Model.OutPatient" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet" type="text/css" href="style.css">

<title>Patient Details</title>
</head>
<body>

	<jsp:include page = "Dashboard_Doctor.jsp"/>
	
	<% OutPatient out_patient = (OutPatient) request.getAttribute("out_patient"); %>
	
	<div class = "patient_details">
	
	<table class = "cls_table">
	<tr class= "tableCols">
	<td>Patient ID</td>
	<td>First Name</td>
	<td>Last Name</td>
	<td>Age</td>
	<td>Gender</td>
	</tr>
	
	<tr class = "data">
	<td><%= out_patient.getOutPatientID() %></td>
	<td><%= out_patient.getFirstName() %></td>
	<td><%= out_patient.getLastName() %></td>
	<td><%= out_patient.getAge() %></td>
	<td><%= out_patient.getGender() %></td>
	</tr>
	</table>
	</div>

	<table class = "options">
	<tr>
	<td><form method = "post" action = "AddMedicalRecord.jsp">
		<input type="submit" Value = "Add Medical Record"/>
	</form></td>

	<td><form method = "post" action = "PrescribeMedicine.jsp">
		<input type="submit" Value = "Add Prescriptions"/>
	</form></td>

	</tr>
	</table>
	
	<img id="img17" src = "img17.png">

</body>

</html>