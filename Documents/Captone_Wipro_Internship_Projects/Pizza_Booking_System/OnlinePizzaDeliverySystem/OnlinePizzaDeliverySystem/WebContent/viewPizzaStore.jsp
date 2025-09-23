<%@page import="java.sql.ResultSet"%>
<%@page import="com.admin.pizzaStoreDao"%>
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

 h1 {
     text-align: center;
     margin-top: 5vw;
     background-color: #FBAB7E;
background-image: linear-gradient(62deg, #FBAB7E 0%, #F7CE68 100%);"
     color: black;
 }
 
</style>
<link rel="stylesheet" type="text/css" href="style/table.css">
</head>
<body>

<%
if(session.getAttribute("username") == null)
{
	response.sendRedirect("logIn.jsp");
}
%>
<h1>Pizza Stores</h1>
<hr>
<br>
<center>
	<table>
	
	<tr>
	<th> Store Id </th>
	<th> Store Name </th>
	<th> Address </th>
	<th> Contact Number </th>
	</tr>
	


<%
 	

	ResultSet rs = pizzaStoreDao.viewPizzaStore();
	
	if(rs == null)
	{
		out.println("<html>");
		out.println("<h2>OOPS Something Worng!!</h2><br>");
		out.println("<a href = adminHome.jsp>Go to home page </a>");
		out.println("</html>");
	}
	else
	{
		while(rs.next())
		{
		%>
			<tr>
				<td><b><%= rs.getInt(1) %></td>
				<td><b><%= rs.getString(2) %></td>
				<td><b><%= rs.getString(3) %></td>
				<td><b><%= rs.getString(4) %></td>
			</tr>
		<% 
		}
	}

%>

</table>
</center>
</body>
</html>