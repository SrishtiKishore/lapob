
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="paraballo.*,java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<title>Orders</title>
<style >
.nav a{
text-decoration:none;
}

#nav1 a{
  text-decoration:none;
  position: absolute;
  left: -80px;
  transition: 0.3s;
  padding: 15px;
  width: 100px;
  font-size: 20px;
  color: white;
  background-color:lightseagreen;
  border-radius: 0 5px 5px 0;
  
}

#nav1 a:hover {
  left: 0;
}
#home {
  top: 100px;
}

#order {
  top: 200px;
}

#cart {
  top: 300px;
}

</style>
</head>
<body>
 
<div class="nav" style="color:white; background-color:#F778A1; text-align: right;height:60px;position:fixed;width:100%;top:0;left:0;" >
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
  &nbsp;&nbsp;
</div>

<section style="float:left;">
<div id="nav1" class="nav1" style="background-color:lightseagreen;">
<br><br>
<a href="useracct.jsp" id="home"><b>HOME</b></a><br><br>
<a href="order.jsp" id="order"><b>YOUR ORDERS</b></a><br><br><br><br>
<a href="cart.jsp" id="cart"><b>CART</b></a><br><br>

</div>
</section>

<c:import var="data" url="/get_ord"/>
<section style="float:right;">
<font size="6"><br><br>
<c:forEach   items="${requestScope.order_item}" var="item">

<c:if test="${item.getType()==11 }">
<c:url value="order_disp" var="ord_url">

<c:param name="type" value="${item.getType()}"/>
<c:param name="id" value="${item.getpid()}"/>

</c:url>

<c:import  url="${ord_url}"/>
<section style="float:left;padding-left:200px">
<a href="detail_lap.jsp?item=${requestScope.display_item.getId()}" style="text-decoration:none;" >
<img src="laptop/${requestScope.display_item.getNAME()}_${requestScope.display_item.getBRAND()}.jpg"   width="90px" height="80px"/>
</a>&nbsp;
</section>
<section style="float:right;padding-right:700px">
<b><c:out value="${requestScope.display_item.getNAME()} " />&nbsp;</b>
<br>OS <c:out value="${requestScope.display_item.getOS()} " />&nbsp;
</section>
</c:if>

<c:if test="${item.getType()==12 }">
<c:url value="order_disp" var="ord_url">

<c:param name="type" value="${item.getType()}"/>
<c:param name="id" value="${item.getpid()}"/>

</c:url>
<c:import  url="${ord_url}"/>
<section style="float:left;padding-left:200px">
<a href="detail.jsp?item=${requestScope.display_item.getId()}" style="text-decoration:none;" >
<img src="laptop/${requestScope.display_item.getNAME()}_${requestScope.display_item.getBRAND()}.jpg"    width="90px" height="80px"/>
</a>&nbsp;
</section>
<section style="float:right;padding-right:700px">
<c:out value="${requestScope.display_item.getNAME() } "/>&nbsp;
<br><b>Rs <c:out value="${requestScope.display_item.getPrice() } "/>&nbsp;
</b>
</section>
</c:if>
<br>
<br>
<br>
<br>
<br>
</c:forEach>
</font>
</section>
</body>
</html>

