<%@page import="java.util.*"%>
<%@page import="paraballo.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Mobile</title>
<style>
.nav a{
text-decoration:none;
}

</style>
</head>
<body>
<div class="nav" style="color:white; background-color:lightseagreen; text-align: right;height:60px;width:100%;position:fixed;top:0;left:0;" >
  <br>
  <a href="index.jsp" >HOME</a>&nbsp;
<%if(session.getAttribute("logout")!="y"&&session.getAttribute("uid")!=null){ 
  %>
  <a href="useracct.jsp" ><%=session.getAttribute("uid")%></a>&nbsp;
  <%}
  else{%>
  <a href="login.jsp">LOGIN</a>&nbsp; 
   <a href="signup.jsp" >SIGN UP</a>&nbsp;
  <% }%>
  
  <a href="cart.jsp" >Cart</a>&nbsp;
</div><br><br>

<br>
<br>
<br>

<%
ArrayList<mob> list=(ArrayList<mob> )request.getAttribute("moblist");
for(mob it:list){
	String path="laptop/"+it.getNAME()+"_"+it.getBRAND()+".jpg";
	int id=it.getId();
%>
<article style="" >
<section style="float:left;">
<a href="detail.jsp?item=<%=id%> " style="text-decoration:none;padding-left:400px;" >
 <img src=<%=path %> width="90px" height="100px" />
</a>
</section>
<aside style="float:right;padding-right:800px">
<font size="5">
<b><%=it.getNAME() %></b><br>
<b>Rs <%=it.getId() %></b><br>
</font>
</aside>
</article>
<br>
<br>
<br>
<br>
<br>
<br>


<% 	
}
%>



</body>
</html>