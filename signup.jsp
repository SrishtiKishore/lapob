<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SIGN UP</title>
         <style>body {
            background-image: url("login.jpg");
            text-align: center;
}</style>
    </head>
    
    <body> 
        <form action=".\signup"  method="post">
            <br><br><br>
            <b>
            <center>NAME &nbsp; :</center>
            <input type="text" name="name" ><br><br>
            <center>EMAIL ID &nbsp; :</center>
            <input type="email" name="emailid"><br><br>
            <center>PHONE NO. &nbsp;  :</center>
            <input type="number" name="mobno"><br><br>
            <center>PASSWORD &nbsp; :</center>
            <input type="password" name="pswd"><br><br>
            <center><input type="submit" class="center"></center>
            </b>
        </form>
    
</body>
</html>