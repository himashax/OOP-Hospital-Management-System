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


		<jsp:include page = "ReceptionistProfile.jsp" />
	
		<div class = "search_bill">
		<form action="ValidateBill" method="post">
	
		PATIENT ID <input type="text" name="patientid" > <br>
		BILL ID <input type="text" name="billid"><br>
		
		<input type="submit" name="submit" value="Enter">
		</form>
		
		<img src = "recep1.png">
		</div>
	
</body>
</html>