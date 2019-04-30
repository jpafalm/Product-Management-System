<%@page import="dao.ProductManagementDAO"%>
<%@page import="pojo.Product"%>

<%
	// We first get all the values the user will enter
	String productId = request.getParameter("prodId");
	String productName = request.getParameter("prodName");
	String productCategory = request.getParameter("prodCategory");
	Integer productPrice = Integer.parseInt(request.getParameter("prodPrice"));

	// Then we use those values to construct our product object
	Product product = new Product(productId, productName, productCategory, productPrice);

	// We pass the product object to the updateProduct method
	int status = ProductManagementDAO.updateProduct(product);
	if (status == 1) {
		response.sendRedirect("viewProducts.jsp");
	} else {
		response.sendRedirect("error.jsp");
	}
%>