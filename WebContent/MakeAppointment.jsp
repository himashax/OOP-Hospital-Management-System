<!-- IT19128696 -->

<%@ page import="Model.Doctor" %>
<%@ page import="Services.IDoctorService" %>
<%@ page import="Services.DoctorServiceimpl" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import = "Model.OutPatient" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style.css">
<title>Make An Appointment</title>
</head>
<body>

	<jsp:include page = "DashBoard_OutPatient.jsp" />
	<div class = "makeApp1">
		<form action="<% request.getContextPath(); %> AddAppointment" method="post">
		Enter Doctor ID <input type="text" name = "doctorID" placeholder = "Doctor ID" /><br><br>
		Enter Date and Time <input type="datetime-local" name = "date" placeholder = "yyyy/mm/dd : hh/mm" /><br><br>
		<input type="submit" name="submit" value="Enter"> 
	</form>
	
	<div class = "makeApp2">
	<img src = "img3.png">

	<table class = "doctorList">
	<tr id = "appTR">
	<td>Doctor ID</td>
	<td>First Name</td>
	<td>Last Name</td>
	</tr>

	<%  IDoctorService iDoctor = new DoctorServiceimpl();
	ArrayList<Doctor> arraylist = iDoctor.listDoctors();
	for(Doctor doctor : arraylist) { %> 

	<tr class = "data">
	<td> <%=doctor.getDoctorID()%> </td>
	<td> <%=doctor.getFirstName()%> </td>
	<td> <%=doctor.getLastName()%> </td>
	</tr>
		
	<% } %>
	
	</table>
	</div>
</div>
</body>
</html>