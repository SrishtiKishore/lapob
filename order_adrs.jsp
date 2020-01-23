<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%@ page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order Confirm</title>
<style >
.nav a{
text-decoration:none;
}
</style>
</head>
<body>

<div class="nav" style="color:white; background-color:#F778A1; text-align: right;height:60px;" >
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
  &nbsp;&nbsp;
</div>

<center>
<font size="10">
<b></b><c:out value='${requestScope.item_id}'></c:out></b>
</font>
</center>

<center>
<br><br>
<font size="5">
<b>Name      :</b><input type="text" name="name" widttexth="80px" height="90px"><br><br>
<b>Address   :</b><input type="text" name="adrs" width="80px" height="90px"><br><br>
<b>Order Date:</b><c:out value="${Date() }"></c:out><br><br>
<b>Mobile    :</b><input type="number" name="mobile" ><br><br>
 <input type="button"  value="CONFIRM" onclick="func()" width="60px" height="20px">
</font>
</center>

<script type="text/javascript">
function func(){
	alert("Order confirmed.Deliver by "+n+"/"+m+"/"+d.getFullyear());
}
</script>

<c:catch var="useracct.jsp"></c:catch>


</body>
</html>