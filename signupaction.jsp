<%@page import="paraballo.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <jsp:useBean id="u" scope="request" class="paraballo.user_table"></jsp:useBean>  
  <jsp:setProperty name="u" property="*"  />  
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
SendEmail se=new SendEmail();
 
String s=request.getParameter("emailid");
boolean flag=se.sendmail(s);
if(flag==true){
u.setEmail(request.getParameter("emailid"));
u.setName(request.getParameter("name"));
u.setPassword(request.getParameter("pswd"));
u.setMobile(request.getParameter("mobno"));

user_save.register(u);

}
else
	out.println("Your email id not valid");
%>
</body>
</html>