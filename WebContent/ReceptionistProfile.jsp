<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="style.css">

</head>
<body>
	
	<ul>
	<li><a href = "Receptionist_Page.jsp">Home</a></li>
	<li><a href = "ListOutPatients.jsp">Patients</a></li>
	<li><a href="Billing.jsp">Payments</a></li>
	<li><a href = "CheckBilling.jsp">Check Billing</a></li>
	</ul>
	
	<form method = "post" action = "Logout">
	<input class="logout" type = "submit" value = "Logout" />
	</form>

</body>
</html>