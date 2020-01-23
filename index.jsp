<html>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>MYHUB</title>
    <style>
            body{
              background-image: url("wall.jpg");
              text-align: center;
            }
            .nav a{
            text-decoration:none;
            top:0;
            left:0;}
     </style>     
  </head>
  <body>
  
  <font size="4">
  <div class="nav" style="color:white; background-color:black ; text-align: right;height:70px;width:100%;position:fixed;top:0;left:0;" >
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
  
  <a href="contact.jsp" >CONTACT</a>&nbsp;
</div>
</font><br><br>

<br><br><br>
 <section style="float:left">
 

 </section>
  <font size="4">

 <section > 
 <form action=".\search_servlet" method="post"> <b>Search </b><br>
 <input type="text" name="search"  ><br><br>
 <input type="submit" name="submit"></form>
 </section>  
 
 <footer style="color:white; background-color:black; position:right;top:0;left:0;">
 <a href="admin.jsp">admin</a>
 </footer>
 
  </font>
 
 </body>
</html>