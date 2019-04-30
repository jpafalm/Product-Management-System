<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<%
		// We check if the userName session atribute is equal to null
		if (session.getAttribute("userName") == null) {
			// Send user back to the login.jsp
			response.sendRedirect("login.jsp");
		}
	%>
	<!-- This is the navigation menu -->
	<nav class="navbar">
		<ul class="navbar-nav">
			<li><a href="home.jsp">Home</a></li>
			<li><a href="addProduct.jsp">Add Product</a></li>
			<li><a href="viewProducts.jsp">View Products</a></li>
			<li><a href="searchProduct.jsp">Search Product</a></li>
			<li style="float: right; margin-right: 10px"><a
				href="logout.jsp">Logout</a></li>
		</ul>
	</nav>
</body>
</html>