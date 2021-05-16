<%@ page import = "Model.MedicalRecord" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Medical Records</title>
</head>
	<body>
	
	<jsp:include page = "Dashboard_Doctor.jsp" />
	
	<div class = "record_pres">
		<form method="post" action = "AddMedicalRecord">	
			Symptoms <input type="text" name = "symptoms"/><br><br>
			Observation <input type="text" name = "observation"/><br><br>
			Diagnosis <input type="text" name = "diagnosis"/><br><br>
			Notes <input type="text" name = "notes"/><br><br>
			<input type="submit" value= "Add Medical Record"/>
		</form>
</div>
		
	</body>
</html>