<!-- IT19128696 -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" type="text/css" href="style.css">

<meta charset="ISO-8859-1">
<title>Update Prescription</title>
</head>
<body>
	
	<jsp:include page = "Dashboard_Doctor.jsp" />
	
	<div class = "record_pres">
	<form action="UpdatePrescription" method = "post" >
	name <input type = "text" name = "name" />
	dose <input type = "text" name = "dose" />
	<input type="submit" value="Update MedicalRecord">
	</form>
	</div>
</body>
</html>