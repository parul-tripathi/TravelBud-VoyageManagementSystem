<%@page import="com.arnav.verma.hotels.Hotel"%>
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
<h1 style="text-align:center;">Hotel Details</h1>
	
	
	 <%
	 	Hotel ht = (Hotel)session.getAttribute("bookedhotel");
     %>
     <h3 style="text-align:center;"><%=ht.getName()%></h3>
     Full Address: <%=ht.getAddress()%>
            
     	
	
	<div style="text-align:center;">
	<form action="Confirmhotelserv" >
			<input type="submit" value="Book" name="bookthis"/>
</form>
	</div>
	
</body>
</html>