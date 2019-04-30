<%@page import="dao.LoginDAO"%>
<%@page import="pojo.LoginInfo"%>
<%
	// We get the value that the user is entering inside the login form
	// The "userName" value should match with the name in the input from login.jsp
	String userName = request.getParameter("userName");
	// The "password" value should match with the name in the input from login.jsp
	String password = request.getParameter("password");
	
	// Then we check if the user is valid or not
	if (LoginDAO.isUserValid(new LoginInfo(userName, password))) {
		// We set an attribute on our section object
		session.setAttribute("userName", userName);
		// After 200s of inactivity the section will be invalidated
		session.setMaxInactiveInterval(200);
		// And send the user to the home.jsp
		response.sendRedirect("home.jsp");
	} else {
		// If the user is ot valid he will be taken to the loginFailed.jsp page
		response.sendRedirect("loginFailed.jsp");
	}
%>