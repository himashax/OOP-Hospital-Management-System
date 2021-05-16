<%@ page import = "Model.MedicalRecord" %>

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

	<% MedicalRecord medical_records = (MedicalRecord) request.getAttribute("med_records"); %>
	
	<div class = "details_nurse">
	
	<table>
	<tr class= "tableCols">
	<td>Medical Record ID</td>
	<td>DoctorID</td>
	<td>Symptoms</td>
	<td>Observation</td>
	<td>Diagnosis</td>
	<td>Notes</td>
	</tr>
	
	<tr class = "data">
	<td><%= medical_records.getMedRecordID() %></td>
	<td><%= medical_records.getDoctorID() %></td>
	<td><%= medical_records.getSymptoms() %></td>
	<td><%= medical_records.getObservation() %></td>
	<td><%= medical_records.getDiagnosis() %></td>
	<td><%= medical_records.getNotes() %></td>
	</tr>
	</table>
	</div>
	
	<div class= "class_nurse">
	<img class="nurse_img" src = "nurse6.png">
	<img class="nurse_img" src = "nurse2.png">
	</div>
</body>
</html>