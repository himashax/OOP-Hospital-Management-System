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
		
		<div class = "add_bill">
		<form action="AddBill"  method="post" >
		PATIENTID <input type="text" name="patientid"><br>
		BILLID <input type="text" name="billid"><br>
		AMOUNT <input type="text" name="amount"><br>
		
		<input type="submit" name="submit" value="Add Bill">
	</form>
	
	 
	<img src = "recep3.jpg">
	</div>
</body>
</html>