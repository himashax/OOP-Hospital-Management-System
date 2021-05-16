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

<div class = "update_bill">
	<form action="UpdateBill" method="post">
		AMOUNT <input type="text" name="ammou" value=""> <br>
	<input type="submit" name="submit" value="update Bill"><br>
		
	</form>

<img src = "recep1.png">
</div>
</body>
</html>