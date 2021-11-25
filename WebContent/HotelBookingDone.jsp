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
<style>
input[type=submit]
{
    background-color: rgba(19, 16, 219, 0.288);
    width: 120px;
    height: 25px;
}
.box1
{
    width: 2050px;
    height: 84px;
}
.op
{
    width: 2050px;
    height: 75px;
}
.op2
{
    width: 2050px;
    height: 40px;
}
.bt
{
    background-color: rgba(17, 145, 219, 0.219);
    width: 2050px;
    height: 55px;
}
.box2
{
    background-color: rgba(17, 145, 219, 0.219);
    width: 2050px;
    height: 265px;
}
body
{
  background-image: url('254361.jpg');
  background-repeat: no-repeat;
  background-attachment: fixed;  
  background-size: cover;
}
table {
        border-collapse: separate;
        border-spacing: 0 15px;
      }
      th,
      td {
        width: 100px;
        text-align: center;
        padding: 5px;
      }
      
table.center {
  margin-left: auto; 
  margin-right: auto;
}
</style>
</head>
<body>
<h1 style="text-align:center;">Your Hotel has been Booked</h1>
<div style="text-align:center;">

<%
 	Hotel fl = (Hotel)session.getAttribute("bookedhotel");
 String passengername = (String)session.getAttribute("name");;
 String chin = (String)session.getAttribute("chin");;
 String chout = (String)session.getAttribute("chout");
 String PNR = (String)session.getAttribute("pnr");
 int rooms = (Integer)session.getAttribute("rooms");
%>
<table class="center">
<tr><th>Hotel Name</th><th>City</th><th>Price</th><th>Rooms</th><th>Name</th><th>Check In Date</th><th>Check Out Date</th><th>PNR</th></tr>
	<tr>
                <td><%=fl.getName()%></td>
                <td><%=fl.getCity()%></td>
                <td><%=fl.getPrice()%></td>
                <td><%=rooms%></td>
                <td><%=passengername%></td>
                <td><%=chin%></td>
                <td><%=chout%></td>
                <td><%=PNR%></td>
                
            </tr>
            </table>
	<form action="MAIN_PAGE/index.jsp">
	<input type="submit" value="Home" name="my">
	</form>
	<form action="Bookedhotelserv">
	<input type="submit" value="My Bookings" name="my">
	</form>
	<form action="Explorecityserv">
	<input type="submit" value="Explore" name="my">
	</form>
</div>
</body>
</html>