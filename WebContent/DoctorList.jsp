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
<title>Doctor List</title>
</head>
<body>

<jsp:include page = "/Admin.jsp" />

<div class = "page">
	<table>
		<tr class = "tableCols">
		<td>Doctor ID</td>
		<td>First Name</td>
		<td>Last Name</td>
		<td>Age</td>
		<td>Gender</td>
		<td>Phone</td>
		<td>Email</td>
		<td>Address</td>
		<td>Salary</td>
		<td>Password</td>
		</tr>

	<%  IDoctorService iDoctor = new DoctorServiceimpl();
	ArrayList<Doctor> arraylist = iDoctor.listDoctors();
	for(Doctor doctor : arraylist) { %> 
	
	<tr class = "tableData">
	<td> <%=doctor.getDoctorID()%> </td>
	<td> <%=doctor.getFirstName()%> </td>
	<td> <%=doctor.getLastName()%> </td>
	<td> <%=doctor.getAge()%> </td>
	<td> <%=doctor.getGender()%> </td>
	<td> <%=doctor.getPhone()%> </td>
	<td> <%=doctor.getEmail()%> </td>
	<td> <%=doctor.getAddress()%> </td>
	<td> <%=doctor.getSalary()%> </td>
	<td> <%=doctor.getPassword()%> </td>
	
	<td class = "updateButton">
	<form method="post" action = "GetDoctor">
	<input type="hidden" name="doctorID" value = "<%= doctor.getDoctorID() %>">
	<input type="submit" name="update" value="Update Doctor"/>
	</form>
	</td>
	
	<td class = "deleteButton">
	<form method="post" action = "DeleteDoctor">
	<input type="hidden" name="doctorID" value = "<%= doctor.getDoctorID() %>">
	<input type="submit" name="delete" value="Delete Doctor"/>
	</form>
	</td>
	</tr>
	
	<% } %>
	
	</table>
	
	<br><br>
	<a href="AddDoctor.jsp"><button class="block">Add Doctor</button></a>


</div>

</body>
</html>