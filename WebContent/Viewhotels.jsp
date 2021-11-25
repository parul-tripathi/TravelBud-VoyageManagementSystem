<%@page import="com.arnav.verma.hotels.Hotel"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hotel Bookings</title>
<style>
    input[type=submit]
    {
        background-color: rgba(24, 155, 207, 0.664);
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
    background-color: rgba(22, 86, 206, 0.493);
    width: 2100px;
    height: 55px;
}
.box2{
    background-color: rgba(22, 86, 206, 0.493));
    width: 2100px;
    height: 235px;
}
body{
  background-image: url('hoe1.jpg');
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
	<h1 style="text-align:center;color:white">Hotels Available</h1>
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
<form action="Confirmhotelserv" >
	<table class="center" style="text-align:center;color:white">
			<tr><th>Hotel Name</th><th>Area</th><th>Rating</th><th>Price</th></tr>
			<c:forEach items="${Ht}" var="Hotel">
			<tr><td><input type="radio"  value="${Hotel.name}" name="name"/>${Hotel.name}</td>
			<td><input type="hidden" name="price"/>${Hotel.area}, 
			<input type="hidden" name="source"/>${Hotel.city}</td>
			<td><input type="hidden" name="desti"/>${Hotel.rating}</td>
			<td><input type="hidden" name="id"/>${Hotel.price}</td></tr>  
			</c:forEach>
	</table>
			<input type="submit" value="Book" name="bookthis"/>
</form>
<form action="Bookedhotelserv">
                <input type="submit" value="My Bookings" style="text-align:center;color:white">
            </form>
</div>
</body>
</html>
