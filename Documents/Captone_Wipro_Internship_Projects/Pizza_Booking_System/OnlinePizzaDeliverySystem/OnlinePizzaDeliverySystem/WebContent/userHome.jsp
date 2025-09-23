<%@page import="com.admin.FoodItemDetails"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.admin.foodItemDAO"%>
    <%@page import="com.user.Cart"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>

td{

padding-left: 200px ;

}

td:FIRST-CHILD {

padding-left: 0px ;
	
}
td:LAST-CHILD {

padding-right: 0px ;
	
}

h1{

text-align: center;
            width: 400px;
            color: black;
            margin-left:35%;
            background-color: #FBAB7E;
background-image: linear-gradient(62deg, #FBAB7E 0%, #F7CE68 100%);



            height: 40px;
            padding: 0px 10px;
            border-bottom: 3px solid #556B2F;
            border-radius: 5px 5px 0px 0px;
}


</style>

<link rel="stylesheet" type="text/css" href="style/card.css">
</head>
<body>


<% 
ArrayList<Cart> cart_list = (ArrayList<Cart>)session.getAttribute("cart_list");
if(cart_list != null)
	{
		request.setAttribute("cart_list", cart_list);
	}
%>



	<h1>Online Pizza Store </h1>
	<form action="cart.jsp" method = "post">
	<button type = "submit" style = "margin-left: 90%; padding: 5px; border: 1px solid; border-radius: 5px; background-color: #FBAB7E;
background-image: linear-gradient(62deg, #FBAB7E 0%, #F7CE68 100%);
	" >CART</button>${cart_list.size()}
	</form>
	<a href = "logOut"><button type = "submit" style = "margin-left: 90% ; margin-top: 10px;padding: 5px; border: 1px solid; border-radius: 5px;background-color: #FBAB7E;
background-image: linear-gradient(62deg, #FBAB7E 0%, #F7CE68 100%);
	" >LOG OUT</button></a>

<%-- <%
if(session.getAttribute("username") == null)
{
	response.sendRedirect("logIn.jsp");
}
%> --%>

<br><hr>

<h2 style="margin-left: 15px; border: 1px solid black;background-color: gray; color: white;">All Products</h2>

<br>
	
<%
 	

	ResultSet rs = foodItemDAO.getFoodIetms();
	
	if(rs == null)
	{
		out.println("<html>");
		out.println("<h2>OOPS Something Worng!!</h2><br>");
		out.println("<a href = adminHome.jsp>Go to home page </a>");
		out.println("</html>");
	}
	else
	{
		ArrayList<FoodItemDetails> product = new ArrayList<>();
		while(rs.next())
		{
			
			
			
			FoodItemDetails fd = new FoodItemDetails();
			
			fd.setFoodId(rs.getInt(1));
			fd.setFoodName(rs.getString(2));
			fd.setCost(rs.getInt(3));
			
			product.add(fd);
			
			
			
		%>
		<div class = "container">
		<div class = "cards">
			<div class = "image">
				<img src = "image/pizza3.jpg"/>
			</div>
			<div class = "about">
			<b style="color: white;">Id   :<%= rs.getInt(1) %><br>
			Name :<%= rs.getString(2) %><br>
			Price:<%= rs.getInt(3) %> Rs.<br></b>
			<div class = "button">
			<a href="addToCart?id=<%=fd.getFoodId()%>"><button style="background-color: gray;"><b style="color: white;">Add To Cart</b></button></a>
			</div>
			</div>
			</div>
		
		</div>
			
		<% 
		}
		
	}

%>
	

</body>
</html>