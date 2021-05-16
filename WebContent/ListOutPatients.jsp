<%@ page import = "Model.OutPatient" %>
<%@ page import = "Services.IOutPatientService" %>
<%@ page import = "Services.OutPatientServiceimpl" %>
<%@ page import = "java.util.ArrayList" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Patient List</title>
</head>
<body>

		 <jsp:include page = "ReceptionistProfile.jsp" />
	
	<table class = "recep">
		<tr class= "tableCols">
		<td>Patient ID</td>
		<td>First Name</td>
		<td>Last Name</td>
		<td>Age</td>
		<td>Gender</td>
		<td>Phone</td>
		<td>Email</td>
		<td>Address</td>
		<td>Password</td>
		</tr>
	
		<%  IOutPatientService iout_patient = new OutPatientServiceimpl();
		ArrayList<OutPatient> arraylist = iout_patient.listOutPatients();
		
		for(OutPatient out_patient : arraylist) { %> 
		<tr class = "data">
		<td><%= out_patient.getOutPatientID() %></td>
		<td><%= out_patient.getFirstName() %>
		<td><%= out_patient.getLastName() %></td>
		<td><%= out_patient.getAge() %></td>
		<td><%= out_patient.getGender() %></td>
		<td><%= out_patient.getPhone() %></td>
		<td><%= out_patient.getEmail() %></td>
		<td><%= out_patient.getAddress() %></td>
		<td><%= out_patient.getPassword() %></td>
		
		<td>
		<form method ="post" action = "GetPatient" >
		<input type="hidden" name="outPatientID" value = "<%= out_patient.getOutPatientID() %>">
		<input type="submit" value="Update OutPatient"/>
		</form>
		</td>
		
		<td>
		<form method="post" action = "DeleteOutPatient">
		<input type="hidden" name="outPatientID" value = "<%= out_patient.getOutPatientID() %>">
		<input type="submit" value="Delete OutPatient"/>
		</form>
		</td>
		</tr>
		
	<% } %>
	</table>
	

</body>
</html>