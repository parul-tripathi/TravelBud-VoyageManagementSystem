<%@page import="com.arnav.verma.packages.Package"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
    width: 2100px;
    height: 84px;
}
.op
{
    width: 2100px;
    height: 75px;
}
.op2
{
    width: 2100px;
    height: 40px;
}
.bt
{
    background-color: rgba(17, 145, 219, 0.219);
    width: 2100px;
    height: 55px;
}
.box2
{
    background-color: rgba(17, 145, 219, 0.219);
    width: 2100px;
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
 	Package fl = (Package)session.getAttribute("bookedpackage");
 String passengername = (String)session.getAttribute("name");;
 String PNR = (String)session.getAttribute("pnr");
 //int rooms = (Integer)session.getAttribute("rooms");
%>
<table class="center">
<tr><th>Package Name</th><th>City</th><th>Price</th><th>Hotel</th><th>Duration</th><th>Name</th><th>PNR</th></tr>
	<tr>
                <td><%=fl.getName()%></td>
                <td><%=fl.getCity()%></td>
                <td><%=fl.getPrice()%></td>
                <td><%=fl.getHotel()%></td>
                <td><%=fl.getDuration()%></td>
                
                <td><%=passengername%></td>
   
                <td><%=PNR%></td>
                
            </tr>
            </table>

    <div >
	<form action="MAIN_PAGE/index.jsp">
	<input type="submit" value="Home" name="my" style="font-size:15px;">
	</form>
    </div>
    <div >
	<form action="Booedpackageserv">
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