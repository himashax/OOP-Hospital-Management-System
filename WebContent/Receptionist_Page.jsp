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
	
	<div class = "buttons">
	<a href = "ListOutPatients.jsp">Patients</a>
	<a href="Billing.jsp">Payments</a>
	<a href = "CheckBilling.jsp">Check Billing</a>
	</div>
	
	<img class = "recep2" src = "recep2.png">
	
</body>
</html>