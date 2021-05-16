<!-- IT19128696 -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<jsp:include page = "Dashboard_Doctor.jsp" />
	
	
	<form method = "post" action = "AddPrescription">
		Drug Name <input type = "text" name = "name"/>
		Dose <input type = "number" name = "dose"/>
		<input type = "submit" value = "Prescribe Medicine"/>
	</form>

</body>
</html>