<%@page import="dao.ProductManagementDAO"%>
<%@page import="pojo.Product"%>

<%
	// We take the value that the user insert in the form
	String productId = request.getParameter("prodId");
	String productName = request.getParameter("prodName");
	String productCategory = request.getParameter("prodCategory");
	Integer productPrice = Integer.parseInt(request.getParameter("prodPrice"));
	// Construct a product object by using those values
	Product product = new Product(productId, productName, productCategory, productPrice);
	// Call addProduct method and pass the product object to this method
	int status = ProductManagementDAO.addProduct(product);

	if (status == 1) {
		response.sendRedirect("viewProducts.jsp");
	} else {
		response.sendRedirect("error.jsp");
	}
%>