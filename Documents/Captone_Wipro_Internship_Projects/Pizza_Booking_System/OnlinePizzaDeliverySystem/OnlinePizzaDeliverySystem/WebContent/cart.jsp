<%@page import="com.admin.foodItemDAO"%>
<%@page import="com.user.Cart"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
table{

background: rgb(195, 186, 184, 0.3);
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
td{

padding-left: 200px ;

}

td:FIRST-CHILD {

padding-left: 0px ;
	
}
td:LAST-CHILD {

padding-right: 0px ;
	
}
body
{
background-color: #e0d674;
background-image: linear-gradient(0deg, #e0d674 0%, #925b8b 100%);
-webkit-background-size: cover; 
-moz-background-size: cover; 
-o-background-size: cover; 
background-size: cover;
}

</style>
</head>
<body>
<%-- <%
if(session.getAttribute("username") == null)
{
	response.sendRedirect("logIn.jsp");
}
%> --%>
<h1>My Cart</h1>

<br><hr>
	
	<%
	
	ArrayList<Cart> cart_list = (ArrayList<Cart>)session.getAttribute("cart_list");
	
	List<Cart> cartProduct = null ;
	
	if(cart_list != null)
	{
		foodItemDAO fd = new foodItemDAO();
		
		cartProduct = fd.getCartFoodItem(cart_list);
		
		double sum = fd.getTotalPrice(cart_list);
		
		request.setAttribute("cart_list", cart_list);
		request.setAttribute("sum", sum);
	}
	
	%>
	
	<table  cellspacing="25" cellpadding="3"  >
	
	<tr align="center">
	<td > Food Id </td>
	<td > Food Name </td>
	<td> Cost </td>
	<td> Quantity </td>
	</tr>
	
	
	<%
	if(cart_list != null)
	{
		for(Cart c : cartProduct)
		{	
			%>
			
			<tr>
			 <td> <%= c.getFoodId() %></td>
			 
			 <td> <%= c.getFoodName() %> </td>
			 
			  <td> <%= c.getCost() %> </td>
			  
			  <td><a href = "quantityIncDecr?action=inc&id=<%= c.getFoodId()%>" ><button style="background-color: #FBAB7E;
background-image: linear-gradient(62deg, #FBAB7E 0%, #F7CE68 100%);">+</button></a> <%= c.getQuantity() %> <a href = "quantityIncDecr?action=dec&id=<%= c.getFoodId()%>" ><button style="background-color: #FBAB7E;
background-image: linear-gradient(62deg, #FBAB7E 0%, #F7CE68 100%);"">-</button></a></td>
			  
			  <td> <a href = "removeFromCart?id=<%= c.getFoodId()%>" ><button style = "margin-left: 70%; padding: 5px; border: 1px solid; border-radius: 5px; background-color: #FBAB7E;
background-image: linear-gradient(62deg, #FBAB7E 0%, #F7CE68 100%);"><b>Remove</button></a>
			  
			  
			  </td>
			 
			 </tr>
			
			<% 
		}
	}
	
	%>
	
	</table>
	
	<hr>
	
	<h2 style=" border: 1px solid black;background-color: #FBAB7E;
background-image: linear-gradient(62deg, #FBAB7E 0%, #F7CE68 100%);" color: black;">Total Price : RS. ${sum}</h2>
<form action="payment.jsp">
	<button style = "padding: 5px; border: 1px solid; border-radius: 5px; background-color: #FBAB7E;
background-image: linear-gradient(62deg, #FBAB7E 0%, #F7CE68 100%);"><b>Check Out</button>
	
	</form>	
	

</body>
</html>