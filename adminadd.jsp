<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin</title>
<style>
.nav a{
text-decoration:none;
}
.nav1 a{
text-decoration:none;
}
</style>
</head>
<body>

<div class="nav" style="height:60px ;text-align:right;background-color:black">
  <br>
  <a href="index.jsp" >HOME</a><br><br>
  
</div>

<center>
<form action=".\adminadd"  enctype="multipart/form-data" method="post">
 <center>Product :</center><br>
<input type="radio" value="lap" name="product">LAPTOP&nbsp;
<input type="radio" value="mob" name="product">MOBILE<br>
 <center>Name :</center><br>
<input type="text" name="name"><br>
<center>Os :</center><br>
<input type="text" name="os"><br>
<center> Processor:</center><br>
<input type="text" name="processor"><br>
<center>RAM :</center><br>
<input type="text" name="ram"><br>
<center>Processing_speed :</center><br>
<input type="text" name="processing_speed"><br>
<center>Architecture :</center><br>
<input type="text" name="architecture"><br>
<center>Brand :</center><br>
<input type="text" name="brand"><br>
<center>Price:</center><br>
<input type="text" name="price"><br>
<center>In Stock:</center><br>
<input type="text" name="avail" length=1><br>
<center>Image :</center><br>
<input type="file" name="fileupload"  accept=".jpeg,.jpg,.png" value="fileupload" id="fileupload"><label for="fileupload"> Select a file to upload</label> <br>

<input type="submit" >


</form>
</center>
</body>
</html>