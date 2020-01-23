<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="paraballo.*,java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<title>Cart</title>
<style>
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
<section>
<div class="nav" style="color:white; background-color:#F778A1; text-align: right;height:60px;width:100%;position:fixed;top:0;left:0;" >
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
  &nbsp;
</div>
</section>
<c:import var="data" url="/cart"/>
<section style="float:left;">
<br>
<div id="nav1" class="navbar" >

<a href="useracct.jsp" id="home"><b>HOME</b></a><br><br>
<a href="order.jsp" id="order"><b>YOUR ORDERS</b></a><br><br><br><br>
<a href="cart.jsp" id="cart"><b>CART</b></a><br><br>

</div>

</section>

<section style="float:right;">
<font size="6">
<br><br>
<c:forEach   items="${requestScope.cart_item}" var="item">

<c:if test="${item.getType()==11 }">
<c:url value="cart_disp" var="carturl">

<c:param name="type" value="${item.getType()}"/>
<c:param name="id" value="${item.getId()}"/>

</c:url>

<c:import  url="${carturl}"/>
<section style="float:left;padding-left:200px;">
<a href="detail_lap.jsp?item=${requestScope.obj.getId()}" style="text-decoration:none;" >
<img src="laptop/${requestScope.obj.getNAME()}_${requestScope.obj.getBRAND()}.jpg"   width="80px" height="80px"/>
</a>&nbsp;&nbsp;
</section>
<section style="float:right;padding-right:700px;">
<b><c:out value="${requestScope.obj.getNAME()} " />&nbsp;</b>
<c:out value="${requestScope.obj.getOS()} " />&nbsp;<br>
<b>Rs<c:out value="1000 " />&nbsp;</b><br>
</section>
</c:if>

<c:if test="${item.getType()==12 }">
<c:url value="cart_disp" var="carturl">

<c:param name="type" value="${item.getType()}"/>
<c:param name="id" value="${item.getId()}"/>

</c:url>
<c:import  url="${carturl}"/>
<section style="float:left;padding-left:200px;">
<a href="detail.jsp?item=${requestScope.obj.getId()}" style="text-decoration:none;" >
<img src="laptop/${requestScope.obj.getNAME()}_${requestScope.obj.getBRAND()}.jpg"    width="90px" height="80px"/>
</a>&nbsp;
</section>
<section style="float:right;padding-right:700px;">
<c:out value="${requestScope.obj.getNAME() } "/>&nbsp;<br>
<b>Rs <c:out value="${requestScope.obj.getPrice() } "/> only &nbsp;
</b><br>
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