<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>

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
body{
background: rgb(2,0,36);
background: linear-gradient(90deg, rgba(2,0,36,1) 0%, rgba(95,182,196,1) 59%, rgba(0,212,255,1) 100%);
}
.Container{

width: 60%;
height: 40%;
margin-left: 20%;
margin-top: 5%;
padding: 20px;
background-color: #FBAB7E;
background-image: linear-gradient(62deg, #FBAB7E 0%, #F7CE68 100%);
border: 2px solid black;
border-radius: 5px;
}
.input-container{


padding: 20px;

}
.btn{
padding: 10x;
margin-left: 350px;
border: 2px solid black;
border-radius: 5px;
background-color: #FBAB7E;
background-image: linear-gradient(62deg, #FBAB7E 0%, #F7CE68 100%);"
}

.btn:HOVER{


box-shadow: 2px 5px 10px black;
}

.input-container:HOVER{


box-shadow: 2px 5px 10px black;
}
</style>
</head>
<body>
<h1>Confirm Order</h1>
<br>
<hr>

<div class = "Container">
	<form action = "payment">
	<label style="font-size: 16px; padding: 20px;"><b>Firstname</label>
	<div class="input-container">
	
		<input type = "text" name = "fName" style="background-color: #FBAB7E;
background-image: linear-gradient(62deg, #FBAB7E 0%, #F7CE68 100%);">
		
	</div>
	<label style="font-size: 16px; padding: 20px;"><b>Lastname</label>
	<div class="input-container">
		<input type = "text" name = "lName" style="background-color: #FBAB7E;
background-image: linear-gradient(62deg, #FBAB7E 0%, #F7CE68 100%);">
		
	</div>
	<label style="font-size: 16px; padding: 20px;"><b>Email</label>
	<div class="input-container">
	
		<input type = "text" name = "email" style="background-color: #FBAB7E;
background-image: linear-gradient(62deg, #FBAB7E 0%, #F7CE68 100%);">
		
	</div>
	<label style="font-size: 16px; padding: 20px;"><b>Contact Number</label>
	<div class="input-container">
	
		<input type = "text" name = "cNumber" style="background-color: #FBAB7E;
background-image: linear-gradient(62deg, #FBAB7E 0%, #F7CE68 100%);">
		
	</div>
	<label style="font-size: 16px; padding: 20px;"><b>Password</label>
	<div class="input-container">
	
		<input type = "password" name = "password" style="background-color: #FBAB7E;
background-image: linear-gradient(62deg, #FBAB7E 0%, #F7CE68 100%);">
		
	</div>
	
	<button class = "btn" type = "submit" style="font-size: 16px;"><b>Proceed </button>
	</form>
</div>
</body>
</html>