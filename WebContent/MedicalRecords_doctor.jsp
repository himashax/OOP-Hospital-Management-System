

<%@ page import = "Model.MedicalRecord" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<jsp:include page = "Dashboard_Doctor.jsp" />
	
	<% MedicalRecord medicalRecord = (MedicalRecord) request.getAttribute("medRecord"); %>

	<div class = "medRecords_doc">
	
	<table>
		<tr class= "tableCols">
			<td> Medical Record ID </td>
			<td> Patient ID </td>
			<td> Symptoms </td>
			<td> Observation </td>
			<td> Diagnosis </td>
			<td> Notes </td>
		</tr>
	
		<tr class = "data">
		<td> <%= medicalRecord.getMedRecordID() %> </td>
		<td> <%= medicalRecord.getPatientID() %> </td>
		<td> <%= medicalRecord.getSymptoms() %> </td>
		<td> <%= medicalRecord.getObservation() %> </td>
		<td> <%= medicalRecord.getDiagnosis() %> </td>
		<td> <%= medicalRecord.getNotes() %> </td>
		
		<td>
		<form action = "GetMedicalRecord" method="post">
		<input type = "hidden" name = "recordID" value=" <%= medicalRecord.getMedRecordID() %>" />
		<input type = "Submit" value="UpdateMedicalRecords"/>
		</form>
		
		</td>
		</tr>
		
	</table>
	
	</div>
	
	<img id = "img18" src="img18.png">

</body>
</html>