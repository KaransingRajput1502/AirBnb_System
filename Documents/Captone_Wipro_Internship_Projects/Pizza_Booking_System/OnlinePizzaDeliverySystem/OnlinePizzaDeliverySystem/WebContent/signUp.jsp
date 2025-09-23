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
.login-container{
position : absolute;
left: 64% ;
top: 66%;

}
.login{

	margin-top: 10px;
}

</style>
<link rel="stylesheet" type="text/css" href="style/signUp.css">
<link rel="stylesheet" type="text/css" href="style/btn.css">
</head>
<body>

<h1 align="center" style="background-color: black; color: white; border: 2px solid white; border-radius: 5px; "><b>Online Pizza Ordering System</h1>



<div class = "box">
	<form action = "signUp" method = "post">
	<div class="input-container">
		<input type = "text" name = "fName">
		<label style="font-size: 16px">Firstname</label>
	</div>
	<div class="input-container">
		<input type = "text" name = "lName">
		<label style="font-size: 16px">Lastname</label>
	</div>
	<div class="input-container">
		<input type = "text" name = "email">
		<label style="font-size: 16px">Email</label>
	</div>
	<div class="input-container">
		<input type = "text" name = "cNumber">
		<label style="font-size: 16px">Contact Number</label>
	</div>
	<div class="input-container">
		<input type = "text" name = "userName">
		<label style="font-size: 16px">Username</label>
	</div>
	<div class="input-container">
		<input type = "password" name = "password">
		<label style="font-size: 16px">Password</label>
	</div>
	
	<button class = "btn" type = "submit">Sign Up </button>
	
	
	
	</form>
</div>

<form action = "logIn.jsp" >

<div class="login-container">

	<label style="font-size: 16px"><b>Already have a account ? ?</b></label>
	<div class = "login">
		<button class="button-75" role="button"><span class="text">Log In</span></button>
	</div>
</div>
</form>


</body>
</html>