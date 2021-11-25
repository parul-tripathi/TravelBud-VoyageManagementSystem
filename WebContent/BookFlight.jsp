<%@page import="com.arnav.verma.Flight"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 style="text-align:center;">Add Booking Details</h1>
	<div style="text-align:center;">
		<form action="Confirmbookingserv" method="get">
			<input type="text" placeholder="Name" name="name"/><br>
			<input type="text" placeholder="Mobile No." name="mob"/><br>
			<input type="text" placeholder="No. of Persons" name="num"/><br>
			<select name="Gen" id="Gen">
				<option value="null" selected disabled>Select Gender</option>
				<option value="Bussiness">Male</option>
		  		<option value="Economy">Female</option>
			</select><br>
			<select name="Class" id="Class">
				<option value="null" selected disabled>Select Class</option>
				<option value="Bussiness">Bussiness</option>
		  		<option value="Economy">Economy</option>
			</select><br>
			
			<input type="submit" value="Book" name="details"/>
		</form>
	</div>
</body>
</html>