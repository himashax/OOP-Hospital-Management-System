<%@ page import = "Model.Doctor" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<jsp:include page = "Admin.jsp"/>

	<%
		Doctor doctor = (Doctor) request.getAttribute("doctor");
	%>

	<form method="POST" action="GetDoctor">
		<table>
			<tr>
				<td>Doctor ID</td>
				<td><input type="text" name="doctorID" disabled="disabled" value="<%=doctor.getDoctorID()%>"/></td>
			</tr>
			<tr>
				<td>First Name</td>
				<td><input type="text" name="firstName" value="<%=doctor.getFirstName()%>" /></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><input type="text" name="lastName" value="<%=doctor.getLastName()%>" /></td>
			</tr>
			<tr>
				<td>Age</td>
				<td><input type="text" name="age" value="<%=doctor.getAge()%>" /></td>
			</tr>
			<tr>
				<td>Gender</td>
				<td><input type="text" name="gender" value="<%=doctor.getGender()%>" /></td>
			</tr>
			<tr>
				<td>Phone</td>
				<td><input type="text" name="phone" value="<%=doctor.getPhone()%>" /></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="text" name="email" value="<%=doctor.getEmail()%>" /></td>
			</tr>
			<tr>
				<td>Address</td>
				<td><input type="text" name="address" value="<%=doctor.getAddress()%>" /></td>
			</tr>
			<tr>
				<td>Salary</td>
				<td><input type="text" name="salary" value="<%=doctor.getSalary()%>" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="text" name="password" value="<%=doctor.getPassword()%>" /></td>
			</tr>
			
		</table>
	</form>


</body>
</html>