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
    height: 350px;
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
    <div class="box1">
        <div class="op">
            <p>
        
            </p>   
        </div>
    <h1 style="text-align:center;font-size: 40px;">Your Booking is Done</h1>
    </div>
    <div class="bt">
        <p>
    
        </p>   
    </div>
<div class="box2" style="text-align:center;">
        <div class="op2">
            <p>
        
            </p>   
        </div>
<div style="text-align:center;">

 <%
 	Flight fl = (Flight)session.getAttribute("bookedflight");
 String passengername = (String)session.getAttribute("name");;
 String classs = (String)session.getAttribute("class");;
 String date = (String)session.getAttribute("date");
 String PNR = (String)session.getAttribute("pnr");
%>
<table class="center" style="font-size:20px;">
<tr><th>Flight Name</th><th>Price</th><th>From</th><th>Destination</th><th>Flight ID</th><th>Time</th><th>Duration</th><th>Name</th><th>Date</th><th>Class</th><th>PNR</th></tr>
	<tr>
                <td><%=fl.getName()%></td>
                <td><%=fl.getPrice()%></td>
                <td><%=fl.getSource()%></td>
                <td><%=fl.getDestination()%></td>
                <td><%=fl.getFlightid()%></td>
                <td><%=fl.getTime()%></td>
                <td><%=fl.getDuration()%></td>
                <td><%=passengername%></td>
                <td><%=date%></td>
                <td><%=classs%></td>
                <td><%=PNR%></td>
                
            </tr>
            </table>

    <div >
	<form action="MAIN_PAGE/index.jsp">
	<input type="submit" value="Home" name="my" style="font-size:15px;">
	</form>
    </div>
    <div >
	<form action="BookedFlightserv">
	<input type="submit" value="My Bookings" name="my" style="font-size:15px;">
	</form>
    </div>
    <div >
	<form action="Explorecityserv" >
	<input type="submit" value="Explore" name="my" style="font-size:15px;">
	</form>
    </div>
</div>
</div>
</body>
</html>