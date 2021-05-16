<!-- IT19128696 -->

<%@ page import = "Model.Appointments" %>
<%@ page import = "Services.IAppointmentService" %>
<%@ page import = "Services.AppointmentServiceimpl" %>
<%@ page import = "java.util.ArrayList" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" type="text/css" href="style.css">

<meta charset="ISO-8859-1">
<title>Appointments</title>
</head>
<body>
	
	<jsp:include page = "DashBoard_OutPatient.jsp" />
	
	<table class = "appList">

	<tr class = "tableCols">
	<td> Appointment ID </td>
	<td> Doctor ID </td>
	<td> Appointment Date </td>
	</tr>
	
	<%  IAppointmentService appointmentService = new AppointmentServiceimpl();
	String id = (String)session.getAttribute("id");
	ArrayList <Appointments> arrayList = appointmentService.listAppointmentsPatient(id);
	for(Appointments appointment : arrayList) { %> 
	
	<tr class = "data">
	<td> <%= appointment.getAppID() %> </td>
	<td> <%= appointment.getDoctorID() %> </td>
	<td> <%= appointment.getDate() %> </td>
	
	
	<td class = "updateButton">
	<form method = "post" action = "GetAppointment">
	<input type="hidden" name = "appID" value="<%= appointment.getAppID() %>"/>
	<input type="submit" value="Update Appointment"/>
	</form>
	</td>
	
	<td class = "deleteButton">
	<form method="post" action = "DeleteAppointment">
	<input type="hidden" name = "appID" value="<%= appointment.getAppID() %>"/>
	<input type="submit" value="Cancel Appointment"/>
	</form>
	</td>
	</tr>

	<% } %>
	
	</table>
	<div class = "images">
	<img class = "image" src = "img4.png">
	<img class = "image" src = "img5.png">
	</div>
</body>
</html>