<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div style="text-align:center;">
		<h1>Login Page</h1>
		<form action="MyLoginServlet" method="get">
			<input type="text" placeholder="Enter your username" name="username"/><br>
			<input type="password" placeholder="Enter your password" name="pass"/><br>
			<input type="submit" value="login" name="login"/>
			<input type="reset" value="Reset"/>
		</form>
	</div>

</body>
</html>