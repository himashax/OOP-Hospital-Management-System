<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style.css">
<title>Insert title here</title>
</head>
<body class = "admin">

<ul>
<li><a href = "admin_homePage.jsp">Home</a></li>
<li><a 	href="DoctorList.jsp">Doctor</a></li>
<li><a  href="NurseList.jsp">Nurse</a></li>
<li><a  href="ReceptionistList.jsp">Receptionist</a></li>
</ul>

<form action = "Logout" method = "post">
		<input class = "logout" type="submit" value = "Logout"/>
	</form>

</body>
</html>