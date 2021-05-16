

<%@ page import = "Model.Prescription" %>

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
	
	<jsp:include page = "Dashboard_Doctor.jsp"/>

	<% Prescription prescription = (Prescription) request.getAttribute("prescription"); %>
	
		<div class = "prescription_doc">
		<table class = "cls_table">
		<tr class= "tableCols">
			<td> Prescription ID </td>
			<td> Patient ID </td>
			<td> Drug Name </td>
			<td> Dose </td>
		</tr>
		
		<tr class = "data">
		<td> <%= prescription.getPrescriptionID() %> </td>
		<td> <%= prescription.getPatientID() %> </td>
		<td> <%= prescription.getName() %> </td>
		<td> <%= prescription.getDose() %> </td>
		
		<td>
		<form method = "post" action = "GetPrescription">
		<input type = "hidden" name = "patientID" value=" <%= prescription.getPrescriptionID() %>" />
		<input type = "submit" value = "Update Prescriptions" />
		</form>
		</td>
		
		</tr>
		</table>
		</div>
</body>
</html>