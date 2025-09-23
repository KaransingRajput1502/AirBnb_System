<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
    <%@page import="java.sql.ResultSet"%>
<%@page import="com.admin.pizzaStoreDao"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<style>

html{
background: url(image/back_LogIn.jpg) no-repeat center center fixed #000; 
-webkit-background-size: cover; 
-moz-background-size: cover; 
-o-background-size: cover; 
background-size: cover;
}
.text-center{
	color:#fff;	
	text-transform:uppercase;
    font-size: 23px;
    margin: -50px 0 80px 0;
    display: block;
    text-align: center;
    padding-top: 20px;
}
</style>
<link rel="stylesheet" type="text/css" href="style/logIn.css">
<link rel="stylesheet" type="text/css" href="style/btn.css">
</head>
<body>

<%
if(session.getAttribute("username") == null)
{
	response.sendRedirect("logIn.jsp");
}
%>
<div class = "box">
	<form action="deletPizzaStore">
	<span class="text-center">Delete Store</span>
	<div class="input-container">
		<input type = "number" name = "storeId">
		<label style="font-size: 16px"><b>Enter StoreId</b></label>
	</div>
		
		<button class="btn" type = "submit"><b>Delete</b></button>
	
	</form>
</div>
</body>
</html>