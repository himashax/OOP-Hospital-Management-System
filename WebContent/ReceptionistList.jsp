<%@ page import = "Model.Receptionist" %>
<%@ page import = "Services.IReceptionistService" %>
<%@ page import = "Services.ReceptionistServiceimpl" %>
<%@ page import = "java.util.ArrayList" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css">
<meta charset="ISO-8859-1">
<title>Receptionist List</title>
</head>
<body>

<jsp:include page = "/Admin.jsp" />

<div class = "page">
<table>
	<tr class = "tableCols">
	<td>Receptionist ID</td>
	<td>First Name</td>
	<td>Last Name</td>
	<td>Age</td>
	<td>Gender</td>
	<td>Phone</td>
	<td>Email</td>
	<td>Address</td>
	<td>Salary</td>
	<td>password</td>
	</tr>

	<%  IReceptionistService iReceptionist = new ReceptionistServiceimpl();
	ArrayList<Receptionist> arraylist = iReceptionist.listReceptionists();
	for(Receptionist receptionist : arraylist) { %> 
	
	<tr class = "tableData">
	<td> <%=receptionist.getReceptionistID()%> </td>
	<td> <%=receptionist.getFirstName()%> </td>
	<td> <%=receptionist.getLastName()%> </td>
	<td> <%=receptionist.getAge()%> </td>
	<td> <%=receptionist.getGender()%> </td>
	<td> <%=receptionist.getPhone()%> </td>
	<td> <%=receptionist.getEmail()%> </td>
	<td> <%=receptionist.getAddress()%> </td>
	<td> <%=receptionist.getSalary()%> </td>
	<td> <%=receptionist.getPassword()%> </td>
	<td class = "updateButton">
	<form method="post" action = "GetReceptionist">
	<input type="hidden" name="recepID" value = "<%= receptionist.getReceptionistID() %>">
	<input type="submit" value="Update Receptionist"/>
	</form>
	</td>

	<td class = "deleteButton">
	<form method="post" action = "DeleteReceptionist">
	<input type="hidden" name="recepID" value = "<%= receptionist.getReceptionistID() %>">
	<input type="submit" value="Delete Receptionist"/>
	</form>
	</td>
	</tr>
	
	<% } %>
	
	</table>
	
	<br><br><a href="AddReceptionist.jsp"><button class="block">Add Receptionist</button></a>
</div>
</body>
</html>