<!-- IT19128696 -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" type="text/css" href="style.css">

<meta charset="ISO-8859-1">
<title>Dashboard</title>
</head>
<body>

<ul>
<li><a href = "/Home_Doctor">Home</a>
<li><a href="AppointmentList2.jsp">Appointments</a></li>
</ul>

<form action = "Logout" method = "post">
		<input class = "logout" type="submit" value = "<%= session.getAttribute("docid") %>  Logout"/>
	</form>

</body>
</html>