<!-- IT19128696 -->

<%@ page import = "Model.Appointments" %>
<%@ page import="Model.Doctor" %>
<%@ page import="Services.IDoctorService" %>
<%@ page import="Services.DoctorServiceimpl" %>
<%@ page import="java.util.ArrayList" %>

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
	
	<jsp:include page = "DashBoard_OutPatient.jsp" />
	
	<% 
		Appointments appointment = (Appointments) request.getAttribute("appointment"); 
	%>

	<form action = "UpdateAppointment" method = "post">
		<input type = "hidden" name = "appId" value = "<%= appointment.getAppID() %>"/>
		Doctor ID: <input type = "text" name = "doctorID" /><br/><br/>
		Appointment Date and Time: <input type = "datetime-local" name = "date_time"/><br/><br/>
		<input type="submit" name="submit" value="Update">
	</form>
	
	<div class = "updateApp2">
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


</body>
</html>
