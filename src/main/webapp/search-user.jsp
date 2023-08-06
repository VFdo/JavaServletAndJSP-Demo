<%@ page import="model.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Search</title>
</head>
<body>
	<h2> User Results: </h2>
	
	<%
	String status = "";
	if(request.getAttribute("status").equals("true")){
		User user = (User)request.getAttribute("user");
		out.println(user.toString());
	} else{
		status = "User Not Found.";
	}
	%>
	<h3><%=status %></h3>
	
   
</body>
</html>