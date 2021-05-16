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

	<jsp:include page = "Dashboard_Doctor.jsp" />

	<div class = "applist_doc">

	<table>
	
	<tr class= "tableCols">
	<td> Appointment ID </td>
	<td> Patient ID </td>
	<td> Appointment Date </td>
	</tr>
		
	<%  IAppointmentService appointmentService = new AppointmentServiceimpl();
	String id = (String)session.getAttribute("docid");
	ArrayList <Appointments> arrayList = appointmentService.listAppointmentsDoctor(id);
	for(Appointments appointment : arrayList) { %> 
	
	
	<tr class= "data">
	<td> <%= appointment.getAppID() %> </td>
	<td> <%= appointment.getOut_patientID() %> </td>
	<td> <%= appointment.getDate() %> </td>
	
	<td class = "checl_app">
	<form method="post" action = "GetOutPatientByID">
	<input type="hidden" name = "patientID" value="<%= appointment.getOut_patientID() %>"/>
	<input type="submit" value="Check Appointment"/>
	</form>
	</td>
	</tr>
	
	<% } %>
	
	</table>
	</div>
	
	<div class = "images">
	<img class = "image" src = "img14.png">
	<img class = "image" src = "img15.png">
	</div>
	
</body>
</html>