<%@ page import = "Model.OutPatient" %>

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

	<jsp:include page = "NursePage.jsp" />

<% OutPatient out_patient = (OutPatient) request.getAttribute("outpatient"); %>

<div class = "details_nurse">

<table class= "table_nurse">
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

<div class = "class_nurse">
<img class="nurse_img" src = "nurse3.png">
</div>

</body>
</html>