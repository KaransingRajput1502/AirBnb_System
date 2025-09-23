<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
</head>
<body>

<%
if(session.getAttribute("username") == null)
{
	response.sendRedirect("logIn.jsp");
}
%>


<div class = "box">

	<form action = "addPizzaStore" method = "post">
	<span class="text-center">Add Pizza Store</span>
		<div class="input-container">
			<input type = "text" name = "storeName">
			<label style="font-size: 16px">Store Name </label>
		</div>
		<div class="input-container">
			<input type = "text" name = "storeAdd">
			<label style="font-size: 16px">Store Address</label>
		</div>
		<div class="input-container">
			<input type = "text" name = "cNumber">
			<label style="font-size: 16px">Contact Number</label>
		</div>
		
		<button class="btn" type = " submit"><b>Add Store</b></button>
		
	
	</form>
</div>
</body>
</html>