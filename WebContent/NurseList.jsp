<%@ page import = "Model.Nurse" %>
<%@ page import = "Services.INurseService" %>
<%@ page import = "Services.NurseServiceimpl" %>
<%@ page import = "java.util.ArrayList" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css">
<meta charset="ISO-8859-1">
<title>Nurse List</title>
</head>
<body>
<jsp:include page = "/Admin.jsp" />
<div class = "page">
	<table>
		<tr class = "tableCols">
		<td>Nurse ID</td>
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

	<%  INurseService iNurse = new NurseServiceimpl();
	ArrayList<Nurse> arraylist = iNurse.listNurses();
	for(Nurse nurse : arraylist) { %> 

	<tr class = "tableData">
	<td> <%=nurse.getNurseID()%> </td>
	<td> <%=nurse.getFirstName()%> </td>
	<td> <%=nurse.getLastName()%> </td>
	<td> <%=nurse.getAge()%> </td>
	<td> <%=nurse.getGender()%> </td>
	<td> <%=nurse.getPhone()%> </td>
	<td> <%=nurse.getEmail()%> </td>
	<td> <%=nurse.getAddress()%> </td>
	<td> <%=nurse.getSalary()%> </td>
	<td> <%=nurse.getPassword()%> </td>
	<td class = "updateButton">
	<form method="post" action = "GetNurse">
	<input type="hidden" name="nurseID" value = "<%= nurse.getNurseID() %>">
	<input type="submit" value="Update Nurse"/>
	</form>
	</td>
	
	<td class = "deleteButton">
	<form method="post" action = "DeleteNurse">
	<input type="hidden" name="nurseID" value = "<%= nurse.getNurseID() %>">
	<input type="submit" value="Delete Nurse"/>
	</form>
	</td>
	</tr>
	
	<% } %>
	</table>
	
	<br><br><a href="AddNurse.jsp"><button class="block">Add Nurse</button></a>
</div>
</body>
</html>