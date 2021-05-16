<!-- IT19128696 -->

<%@ page import= "javax.servlet.http.HttpSession" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" type="text/css" href="style.css">

<meta charset="ISO-8859-1">
<title>Update Medical Record</title>
</head>
<body>

<jsp:include page = "Dashboard_Doctor.jsp" />
	
	<div class = "record_pres">
	<form action="UpdateMedicalRecord" method = "post">
	Symptoms    <input type="text" name = "symptoms"><br/><br/>
	Observation	<input type="text" name = "observation"><br/><br/>
	Diagnosis   <input type="text" name = "diagnosis"><br/><br/>
	Notes		<input type="text" name = "notes"><br/><br/>
	<input type="submit" value="Update MedicalRecord">
	</form>
	</div>
</body>
</html>