<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="dao.ProductManagementDAO"%>
<%@page import="pojo.Product"%>
<%@page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Products</title>
</head>
<body>
	<!-- This method includes the header into our page  -->
	<%@ include file="header.jsp"%>

	<!-- We create a table to display the values -->
	<table align="center" class="productTable">
		<thead>
			<tr>
				<th>Product ID</th>
				<th>Product Name</th>
				<th>Category</th>
				<th>Price</th>
				<th colspan="2">Actions</th>
			</tr>
		</thead>
		<%
			// Create a list of products and get the data from DB
			List<Product> productList = ProductManagementDAO.getAllProducts();
			for (Product p : productList) {
		%>
		<tr>
			<td><%=p.getProductId()%></td>
			<td><%=p.getProductName()%></td>
			<td><%=p.getProductCategory()%></td>
			<td><%=p.getProductPrice()%></td>
			<td><button class="actionBtn"
					onclick="location.href = 'editProduct.jsp?prodId=<%=p.getProductId()%>';">Edit</button></td>
			<td><button class="actionBtn"
					onclick="location.href = 'processDeleteProduct.jsp?prodId=<%=p.getProductId()%>';">Delete</button></td>
		</tr>

		<%
			}
		%>
	</table>

</body>
</html>