<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin </title>
<script type="text/javascript">
	window.history.forward();
	function noBack() { window.history.forward(); }
</script>
<style>
body{
background-image:url("adminlogin.jpg");
image-align:bottom;
text-align:center;
}
</style>

</head>
<body onload="noBack();" 
	onpageshow="if (event.persisted) noBack();" onunload="">


<center>
<form action="./admin" method="post">

<input type="text" name="uid"><br>
<input type="password" name="pswd"><br>
<input type="submit" ><br>

</form>
</center>

</body>
</html>

