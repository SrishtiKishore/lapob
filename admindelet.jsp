<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html >
<head>
<title>Admin Delete</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
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


<section>
<div class="nav1" style="float:left;min-height:100vh ;width:200px;background-color:lightseagreen">
  <br>
  <a href="adminadd.jsp" >ADD items</a><br><br>
  <a href="admindelet.jsp">DELETE</a><br><br>
  <a href="adminupdate.jsp">UPDATE</a><br><br>
  <a href="contact.jsp">Contact</a><br><br>
</div>
  
  <article style="float:center; text-align:center;padding:30px">
    <form action=".\admindelet" method="post">
    ID: <input type="number" name="id">
    <input type="submit">
    </form>
     </article>
</section>



</body>
</html>
