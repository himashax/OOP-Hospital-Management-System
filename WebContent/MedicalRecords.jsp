<!-- IT19128696 -->

<%@ page import = "Model.MedicalRecord" %>
<%@ page import = "Services.IMedicalRecordService" %>
<%@ page import = "Services.MedicalRecordServiceimpl" %>

<%@ page import = "java.util.ArrayList" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet" type="text/css" href="style.css">

<title>Medical Records</title>

</head>
<body>
	
	<jsp:include page = "DashBoard_OutPatient.jsp" />
	
	<div class = "hu">
	<div class = "image8">
	<img src = "img8.png">
	</div>
	
	<div class = "medicalPatient">
	
	<table class = "cls_table">
	<tr class= "tableCols">
	<td> Medical Record ID </td>
	<td> Doctor ID </td>
	<td> Symptoms </td>
	<td> Observation </td>
	<td> Diagnosis </td>
	<td> Notes </td>
	</tr>
	
	<%  IMedicalRecordService imedicalRecordService = new MedicalRecordServiceimpl();
	String id = (String) session.getAttribute("id");
	ArrayList <MedicalRecord> arrayList = imedicalRecordService.listMedicalRecords(id);
	for(MedicalRecord medical_record : arrayList) { %> 

	<tr class = "data">
	<td> <%= medical_record.getMedRecordID() %> </td>
	<td> <%= medical_record.getDoctorID() %> </td>
	<td> <%= medical_record.getSymptoms() %> </td>
	<td> <%= medical_record.getObservation() %> </td>
	<td> <%= medical_record.getDiagnosis() %> </td>
	<td> <%= medical_record.getNotes() %> </td>
	</tr>
	
	<% } %>
	
	</table>
	</div>
	</div>
</body>
</html>