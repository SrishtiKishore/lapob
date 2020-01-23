<%@page import="java.util.*"%>
<%@page import="paraballo.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>lap</title>
<style>
.nav a{
text-decoration:none;

}

</style>
</head>
<body >
<div class="nav" style="color:white; background-color:lightseagreen; text-align: right;height:60px;width:100%;position:fixed;top:0;left:0;" >
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

<center>
<br>
<br>
<br>
<%
ArrayList<lap> list2=(ArrayList<lap> )request.getAttribute("laptoplist");
for(lap it:list2){
	String path="laptop/"+it.getNAME()+"_"+it.getBRAND()+".jpg";
%>
<font size="5">
Name  :<b><%=it.getNAME() %>&nbsp;</b>
OS  :<b><%=it.getOS() %>&nbsp;</b>

<a href="detail_lap.jsp?item=<%=it.getId()%> " style="text-decoration:none;" >

 <img src=<%=path %> width="80px" height="90px" alt=" " />

</a>
</font>
<br><br>
<% 	
}
%>
</center>

</body>
</html>