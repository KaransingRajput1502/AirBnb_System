<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="style/btn.css">

<style>
table{

background: rgb(195, 186, 184, 0.3);
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
html{
background: url(image/back_LogIn.jpg) no-repeat center center fixed #000; 
-webkit-background-size: cover; 
-moz-background-size: cover; 
-o-background-size: cover; 
background-size: cover;
}

.logout{
margin-top : 20px;
margin-left: 1150px;

}
h1{

text-align: center;
            width: 400px;
            color: white;
            margin-left:35%;
            background-image:linear-gradient(
                to bottom, #333036, #556B2F);
            height: 40px;
            padding: 0px 10px;
            border-bottom: 3px solid #556B2F;
            border-radius: 5px 5px 0px 0px;
}

</style>
</head>
<body>

<%
if(session.getAttribute("username") == null)
{
	response.sendRedirect("logIn.jsp");
}
%>

<h1 align="center">  Admin Dashboard </h1> <br>

	<table align="center"  cellspacing="10"  cellpadding="3" >
	
	<tr align="center">
	
	<td>
	<img src = "image/Store.png" height="70" width="70"/>
	</td>
	
	<td>
	<img src = "image/modifyPizzaStore.webp" height="70" width="70"/>
	</td>
	
	<td>
	<img src = "image/view.webp" height="70" width="70"/>
	</td>
	
	</tr>
	
	<tr align="center">
	<td>	<form action = "addPizzaStore.jsp" >
			<button class="button-75" role="button"><span class="text">Add Pizza Store</span></button>
			</form>
	</td>
	
	<td align="center">
			<form action = "modifyPizzaStore.jsp">
			<button class="button-75" role="button"><span class="text">Modify Pizza Store</span></button>
			</form>
	</td>
	
	<td>   
	    	<form action = "viewPizzaStore.jsp">
			<button class="button-75" role="button"><span class="text">View Pizza Store</span></button>
			</form>
	</td>
	
	</tr>
	
	<tr align="center">
	
	<td>
	<img src = "image/deletePizzaStore.png" height="70" width="70"/>
	</td>
	
	<td>
	<img src = "image/addPizza.png" height="70" width="70"/>
	</td>
	
	<td>
	<img src = "image/modify.png" height="70" width="70"/>
	</td>
	
	</tr>
	
	<tr align="center" >
	
	<td>
			<form action = "deletePizzaStore.jsp" >
			<button class="button-75" role="button"><span class="text">Delete Pizza Store</span></button>
			</form>
	</td>
			
	<td>
			<form action = "addFoodItem.jsp">
			<button class="button-75" role="button"><span class="text">Add Food Item</span></button>
			</form>
	</td>
	
	<td>
			<form action = "modifyFoodItem.jsp">
			<button class="button-75" role="button"><span class="text">modify Food Item</span></button>
			</form>
	</td>
	
	</tr>
	
	<tr align="center">
	
	<td>
	<img src = "image/viewItem.png" height="70" width="70"/>
	</td>
	
	<td>
	<img src = "image/removeItem.png" height="70" width="70"/>
	</td>
	
	<td>
	<img src = "image/users.png" height="70" width="70"/>
	</td>
	
	</tr>
	
	<tr align="center">
	
	<td>
			<form action = "viewFoodItem.jsp">
			<button class="button-75" role="button"><span class="text">View Food Item</span></button>
			</form>
	</td>
	
	<td>
			<form action = "deleteFoodItem.jsp">
			<button class="button-75" role="button"><span class="text">Delete Food Item</span></button>
			</form>
	</td>
	
	<td>
			<form action = "viewUsers.jsp" >
			<button class="button-75" role="button"><span class="text">View User</span></button>
			</form>
	</td>
	
	</tr>
	
	</table>

<hr>
<div class = "logout">
	<form action = "logOut">
			<button class="button-75" role="button"><span class="text">Log Out</span></button>
	</form>
</div>

</body>
</html>