<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="paraballo.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mobile</title>
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

<div class="nav" style="color:white; background-color:lightseagreen; text-align: right;height:60px;">
  <br>
  <a href="index.jsp" >HOME</a>&nbsp;
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

<c:url value="detail_mob" var="moburl">
<c:param name="prod_id" value="${param.item}"/>
</c:url>
<c:import  url="${moburl}"/>

<center>

<section style="float:left;">
<img src="laptop/${requestScope.mobitem.getNAME()}_${requestScope.mobitem.getBRAND()}.jpg"  width="600px" height="500px"  >
</section>

<section style="float:right;width:800px;height:100vh;padding:0px">

<article style="text-align:left; ">
<button   onclick="myfunc()">
<font size="6">Add to CART</font>
</button>
&nbsp;
<button width="400px" value="BUY" onclick="buyfunc()" color="pink">
<font size="6">BUY</font>
</button>&nbsp;
<article>
<font size=8>
<c:out value="${requestScope.mobitem.getNAME() } "/><br>
</font>
<font size=16>
<b>Rs <c:out value="${requestScope.mobitem.getPrice() }"/></b>
</font>
</article>
</article>
</section>
</center>
<script>
function myfunc(){
	window.location="./add_cart?item_id="+${requestScope.mobitem.getId() }+"&type=12";
}
function buyfunc(){
	document.location.href="./add_order?item_id="+${requestScope.mobitem.getId() }+"&type=12";
 getRequestDispatcher()
}
</script>
</body>
</html>

