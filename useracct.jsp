<%@ page import="paraballo.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>USER PROFILE</title>
<style>
.navbar {
  overflow: hidden;
  background-color: black;
  font-family: Arial, Helvetica, sans-serif;
}

.navbar a {
  float: left;
  font-size: 16px;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}
.navbar.content a {
  float: right;
  font-size: 16px;
  color: white;
  text-align: right;
  padding: 14px 16px;
  text-decoration: none;
}
.dropdown {
  float: right;
  overflow: hidden;
}

.dropdown .dropbtn {
  cursor: pointer;
  font-size: 16px;  
  border: none;
  outline: none;
  color: white;
  padding: 14px 16px;
  background-color: inherit;
  font-family: inherit;
  margin: 0;
}
.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f9f9f9;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
}
.dropdown-content a {
  float: none;
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
  text-align: left;
}
.show {
  display: block;
}
.nav a{
  text-decoration:none;
  }
</style>
<script type = "text/javascript" >
   function preventBack(){window.history.forward(1);}
    setTimeout("preventBack()", 0);
    window.onunload=function(){null};
</script>
</head>


<body>
<div class="navbar">
<br>
  <a href="index.jsp" >HOME</a>&nbsp;
  <%if(session.getAttribute("logout")!="y"){ %>
  <a href="useracct.jsp"><%=session.getAttribute("uid")%></a>
  <%}
  else{%>
  <a href="login.jsp">LOGIN</a>
  <% }%>
 &nbsp;
  <a href="cart.jsp" >Cart</a>&nbsp;

<div class="dropdown">
<button onclick="myfunction()" class="dropbtn" >Home
    <i class="fa fa-caret-down"></i>
  </button>
  <div id="myDropdown" class="dropdown-content">
    <a href="#">Link 1</a>
    <a href="#">Link 2</a>
    <a href="logout.jsp">Logout</a>
</div>
</div>
</div>

<section>
<div class="nav" style="float:left;background-color:lightseagreen;width:100px;height:100vh;padding:30px">
<br>
<a href="useracct.jsp"><b>Your profile</b></a><br><br>
<a href="order.jsp">Your orders</a><br><br>
<a href="cart.jsp">Cart</a><br><br>

</div>

<article style="float:center;text-align:center;">



	   
	   welcome <%=request.getSession().getAttribute("uid")%>
 </article>
</section>
 <script>
	  function myfunction() {
		  document.getElementById("myDropdown").classList.toggle("show");
		}
	  </script>
</body>
</html>