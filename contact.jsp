<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contact us</title>
<style>
.nav a{
text-decoration:none;
}

</style>
</head>
<body >
<div class="nav" style="color:white; background-color:lightseagreen; text-align: right;height:40px;" >
  
  <br>
  <a href="index.jsp" >HOME</a>&nbsp;
  <%if(session.getAttribute("logout")!="y"){ %>
  <a href="useracct.jsp">
  <%=session.getAttribute("uid")%></a>
  <%}
  else{%>
  <a href="login.jsp">
  LOGIN</a>
  <%}%>
  &nbsp;
  <a href="cart.jsp" >Cart</a>&nbsp;
</div>
<br>
<br>
<br>
<br>
<br>

<font size="5">
<b>Phone :</b>9999999,9888888<br><br>
<b>Email :</b>myhub@mail.com

</font>
</body>
</html>