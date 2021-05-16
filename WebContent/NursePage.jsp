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

<ul>
<li><a href = "nurse_dashboard.jsp">Home</a></li>
<li><a href = "GetPatientDetails.jsp">Patient Details</a></li>
<li><a href = "GetPatientMedicals.jsp">Medical Records</a></li>
</ul>

<form action = "Logout" method = "post">
		<input class = "logout" type="submit" value = "Logout"/>
	</form>


</body>
</html>