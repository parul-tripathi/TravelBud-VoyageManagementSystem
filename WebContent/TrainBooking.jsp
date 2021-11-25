<%@page import="com.arnav.verma.trains.Train"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Train Bookings</title>
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
  background-image: url('train.jpeg');
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
        <h1 style="text-align:center;color:white">Trains Available</h1>
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
<form action="Confirmtrainserv" >
	<table class="center" style="text-align:center;color:white">
			<tr><th>Train Name</th><th>Price</th><th>From</th><th>Destination</th><th>Train ID</th><th>Time</th><th>Duration</th></tr>
			<c:forEach items="${Tr}" var="Train">
			<tr><td><input type="radio"  value="${Train.name}" name="name"/>${Train.name}</td>
			<td><input type="hidden" name="price"/>${Train.price}</td>
			<td><input type="hidden" name="source"/>${Train.source}</td>
			<td><input type="hidden" name="desti"/>${Train.destination}</td>
			<td><input type="hidden" name="id"/>${Train.trainid}</td>
			<td><input type="hidden" name="time"/>${Train.time}</td>
			<td><input type="hidden" name="duration"/>${Train.duration}</td></tr> 
			</c:forEach>
	</table>
			<input type="submit" value="Book" name="bookthis" style="text-align:center;color:white"/>
            
</form>
	<form action="Bookedtrainserv">
                <input type="submit" value="My Bookings" style="text-align:center;color:white">
            </form>
	
		
	</div>
</body>
</html>





