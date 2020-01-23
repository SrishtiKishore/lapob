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


<div class="nav" style="color:white; background-color: black; text-align: right; height:40px;" >
  <a href="index.jsp" >HOME</a>&nbsp;
<button onclick="myfunction()" class="dropbtn"  style="cursor:pointer;overflow:hidden;">
 <%= request.getParameter("uid")%>
  </button>
  <div id="myDropdown" class="dropdown-content">
    <a href="#">Link 1</a>
    <a href="#">Link 2</a>
    <a href="logout.jsp">Logout</a>
</div>
  
  
</div>
<script>
	  function myfunction() {
		  document.getElementById("myDropdown").classList.toggle("show");
		}
	  </script>
	  
<section>

<div class="nav1" style="float:left;min-height:100vh ;width:200px;background-color:skyblue">
  <br>
  <a href="adminadd.jsp" >ADD items</a><br><br>
  <a href="admindelet.jsp">DELETE</a><br><br>
  <a href="adminupdate.jsp">UPDATE</a><br><br>
  <a href="contact.jsp">Contact</a><br><br>
</div>

<p style="float :center;">
welcome <%=request.getParameter("uid") %> </p>


</section>
</body>
</html>