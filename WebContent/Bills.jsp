<%@ page import = "Model.Bill" %>

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


	<jsp:include page = "ReceptionistProfile.jsp" />

	<%
		Bill bill = (Bill) request.getAttribute("bill");
	%>

 	<div class = "show_bill">
<table>

	<tr class = "tr">
	<td>PATIENT ID</td>
	<td>BILL ID</td>
	<td>AMOUNT</td>
	</tr>

	<tr>
	<td><%out.println(bill.getPatienID()); %> </td>
	<td><%=bill.getBillID() %></td>
	<td><%=bill.getAmount() %></td>
	</tr>
	
	<tr>
	<td>
	<form method = "post" action = "UpdateBill.jsp">
	<input type = "submit" value = "Update Bill" />
	</form></td>
	
	<td>
	<form method = "post" action = "DeleteBill">
	<input type = "hidden" name = "billid" value = "<%= bill.getBillID() %>"/>
	<input type = "submit" value = "Delete Bill" />
	</form>
	</td>
	</tr>
	</table>
	<img class = "recep4" src = "recep4.png">
	
	</div>
	

</body>
</html>