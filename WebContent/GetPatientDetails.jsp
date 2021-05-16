<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<jsp:include page = "NursePage.jsp" />
<div class = "common">
<form action = "Nurse_GetPatient" method = "post">
	Enter the Patient's ID 
	<input type="text" name = "pid">
	<input type="submit" value = "Enter">
</form>

<div class = "getDetails">
<img src = "nurse5.png">
</div>
</div>

</body>
</html>