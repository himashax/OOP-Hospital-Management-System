<!-- IT19128696 -->

<%@ page import = "Model.Prescription" %>
<%@ page import = "Services.IPrescriptionService" %>
<%@ page import = "Services.PrescriptionServiceimpl" %>

<%@ page import = "java.util.ArrayList" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Medical Records</title>

<link rel="stylesheet" type="text/css" href="style.css">

</head>
<body>

	<jsp:include page = "DashBoard_OutPatient.jsp" />
	
	<div class = "pres">
	
	<img class = "img" src = "img9.png">
	
	
	<table>
		<tr class= "tableCols">
			<td>Prescription ID</td>
			<td> Doctor ID </td>
			<td> Drug Name </td>
			<td> Dose </td>
		</tr>

	<% 	IPrescriptionService iPrescription = new PrescriptionServiceimpl();
		String patient_id = (String)session.getAttribute("id"); 
		ArrayList <Prescription> arrayList = iPrescription.listPrescriptions(patient_id);
		for(Prescription prescription : arrayList)
		{
	%>
	
		<tr class = "data">
			<td> <%= prescription.getPrescriptionID() %> </td>
			<td> <%= prescription.getDoctorID() %> </td>
			<td> <%= prescription.getName() %> </td>
			<td> <%= prescription.getDose() %> </td>
		</tr>
	
	<% } %>
	
	</table>
	
	<img class = "img" src = "img10.png">
	</div>
</body>
</html>