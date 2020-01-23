<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LOGIN</title>
<style>body {
 background-image: url("login.jpg");
 text-align: center;
}
.nav a{
text-decoration:none;
}

</style>
<script type="text/javascript">
	window.history.forward();
	function noBack() { window.history.forward(); }
</script>
</head>
<body  onload="noBack();" 
	onpageshow="if (event.persisted) noBack();" onunload="">

    
    <form action="./login" method="post"  >
  <div class="container" >
    <h1>LOGIN</h1>
 
    <hr>

    <label for="email" class="center"><b>Email</b></label><br>
    <input type="text" placeholder="Enter Email" name="email" required class="center"><br>

    <label for="psw" class="center"><b>Password</b></label><br>
    <input type="password" placeholder="Enter Password" name="psw" required class="center"><br><br>

   
  </div>

    <div class="clearfix">
      
      <button type="submit" class="login"  class="center">Login</button>
    </div>
 
</form>

</body>
</html>