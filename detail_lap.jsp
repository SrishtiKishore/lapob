<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="paraballo.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>laptop</title>
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

<div class="nav" style="color:white; background-color:lightseagreen; text-align: right;height:60px;" >
  <br>
  <a href="index.jsp" >HOME</a>&nbsp;&nbsp;
  <%if(session.getAttribute("uid")!=null){ %>
  <a href="useracct.jsp">
  <%=session.getAttribute("uid")%></a>
  <%}
  else{%>
  <a href="login.jsp">
  LOGIN</a>
  <%}%>
  &nbsp;
  <a href="cart.jsp" >Cart</a>&nbsp;
</div><br><br>

<c:url value="detail_lap" var="lapurl">
<c:param name="prod_id" value="${param.item}"/>
</c:url>
<c:import  url="${lapurl}"/>


<center>

<section style="float:left;">
<img src="laptop/${requestScope.lapitem.getNAME()}_${requestScope.lapitem.getBRAND()}.jpg"   width="600px" height="500px"  >

</section>


<section style="float:right;width:800px;height:100vh;padding:0px">

<article style="text-align:left; ">
<button  style="postion:relative;" onclick="cartfunc()">
<font size="6">Add to CART</font>
</button>
&nbsp;&nbsp;
<button width="400px" value="BUY" onclick="buyfunc()">
<font size="6">BUY</font>
</button>&nbsp;
<br><br>
<article>
<font size=8>
<c:out  value="${requestScope.lapitem.getNAME()}"></c:out><br>
</font>
<font size=16>
<b>Rs 100000</b>
</font>
</article>
</article>
</section>
</center>

<script>
function cartfunc(){
	document.location.href="./add_cart?item_id="+${requestScope.lapitem.getId()}+"&type=11";
}
function buyfunc(){
	document.location.href="./add_order?item_id="+${requestScope.lapitem.getId()}+"&type=11";

}
</script>
</body>
</html>

