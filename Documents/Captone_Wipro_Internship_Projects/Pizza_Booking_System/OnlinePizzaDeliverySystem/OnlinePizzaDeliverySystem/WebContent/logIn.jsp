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

.h1box{
	position:absolute;
	left:50%;
	top:10%;
	transform: translate(-50%,-50%);
    background-color:  rgba(0, 0, 0, 0.70);
	border-radius:3px;
	
	
	color: white;
	box-shadow: white;
	 border: 2px solid;
	  padding-left:20px;
	  padding-right:20px;
	  box-shadow: 5px 10px 18px black;
	
}

.signUp-container{
position : absolute;
left: 67% ;
top: 75%;

}
.singUp{

	margin-top: 10px;
}

</style>

<link rel="stylesheet" type="text/css" href="style/btn.css">
<link rel="stylesheet" type="text/css" href="style/logIn.css">

</head>
<body>
<div class = "h1box">
<h1 align="center">Online Pizza Store</h1>
</div>
<br>
<div class="box">
	<form action = "logIn"  >
		
		<div class="input-container">
			  <input type = "text" name = "uname">
			  <label style="font-size: 16px"><b>Username</b></label>
		</div>
		<div class="input-container">
			<input type = "password" name = "pass"><br><br>
			<label style="font-size: 16px"><b>Password</b></label>
		</div>
		<button class="btn" role="button"><b>Log In</b></button>
		
	</form>
</div>
<form action = "signUp.jsp" >

<div class="signUp-container">

	<label style="font-size: 16px"><b>New Here ?</b></label>
	<div class = "singUp">
		<button class="button-75" role="button"><span class="text">Sign Up</span></button>
	</div>

</form>
</div>
</body>
</html>


