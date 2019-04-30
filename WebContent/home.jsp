<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body>
	<!-- Include the header.jsp into this page -->
	<%@ include file="header.jsp"%>

	<%
		// We are capturing the value of the userName here
		String userName = (String) session.getAttribute("userName");
	%>

	<div align="center">
		<h2>Product Management System</h2>
		<!-- We using a label to display the captured userName -->
		<label>Welcome <%=userName%></label>
	</div>

</body>
</html>