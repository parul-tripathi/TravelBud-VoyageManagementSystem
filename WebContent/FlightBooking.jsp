<%@page import="com.arnav.verma.Flight"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<link href="C:\Users\Aniket Mishra\Desktop\Untitled\fli.css" rel="stylesheet" type="text/css">
<meta charset="ISO-8859-1">
<title>Flight Bookings</title>
<style>
    input[type=submit]
    {
        background-color: rgba(5, 53, 17, 0.664);
    }
.box1{
    width: 2100px;
    height: 75px;
}
.op{
    width: 2100px;
    height: 75px;
}
.op2{
    width: 2100px;
    height: 40px;
}
.bt{
    background-color: rgba(5, 44, 15, 0.493);
    width: 2100px;
    height: 55px;
}
.box2{
    background-color: rgba(8, 100, 31, 0.308);
    width: 2100px;
    height: 235px;
}
body{
  background-image: url('254408.jpg');
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
    <h1 style="text-align:center;color:white">Flights Available</h1>
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
<form action="Confirmbookingserv" >
    <table class="center">
        <tr><th>Flight Name</th><th>Price</th><th>From</th><th>Destination</th><th>Flight ID</th><th>Time</th><th>Duration</th></tr>
        <c:forEach items="${Fl}" var="Flight">
            <tr><td><input type="radio"  value="${Flight.name}" name="name" style="text-align:center;color:white"/>${Flight.name}</td>
                <td><input type="hidden" name="price" style="text-align:center;color:white"/>${Flight.price}</td>
                <td><input type="hidden" name="source" style="text-align:center;color:white"/>${Flight.source}</td>
                <td><input type="hidden" name="desti" style="text-align:center;color:white"/>${Flight.destination}</td>
                <td><input type="hidden" name="id" style="text-align:center;color:white"/>${Flight.flightid}</td>
                <td><input type="hidden" name="time" style="text-align:center;color:white"/>${Flight.time}</td>
                <td><input type="hidden" name="duration" style="text-align:center;color:white"/>${Flight.duration}</td></tr> 
			</c:forEach>
	</table>
			<input type="submit" value="Book" name="bookthis" style="text-align:center;color:white"/>
            </form>
            <form action="BookedFlightserv">
	            <input type="submit" value="My Bookings" style="text-align:center;color:white">
	        </form>

	
	
	
	
</div>
</body>
</html>