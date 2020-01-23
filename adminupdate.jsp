<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html >
<head>
<title>CSS Template</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
.nav a{
text-decoration:none;
}

</style>

</head>
<body>

<div class="nav" style="height:40px ;text-align:right;background-color:black">
  <br>
  <a href="index.jsp" >HOME</a><br><br>
 
</div>

<section>
<article style="float:top; text-align:center;padding:80px">
<form action="article1" method="post">
 Made changes in
 Name:<input type="text" name="name"><br><br>
   OS:<input type="text" name="os"><br><br>
Brand:<input type="text" name="brand"><br><br>

<input type="submit">

</form>
</article>


</section>


</body>
</html>
