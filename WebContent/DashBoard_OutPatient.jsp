<!-- IT19128696 -->

<%@ page import = "Model.OutPatient" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style.css">
<title>Navigation</title>
</head>
<body>


<ul>
	<li><a href = "Home_Patient.jsp">Home</a></li>
	<li><a href = "MakeAppointment.jsp">Make an Appointment</a></li>
	<li><a href="AppointmentList.jsp">Appointments</a></li>
	<li><a href = "MedicalRecords.jsp">Medical Records</a></li>
	<li><a href = "Patient_Prescriptions.jsp">Prescriptions</a></li>
</ul>

	<form action = "Logout" method = "post">
		<input class = "logout" type="submit" value = "<%= session.getAttribute("id") %> Logout"/>
	</form>

</body>
</html>