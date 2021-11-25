<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 style="text-align:center;">Add Booking Details</h1>
	<div style="text-align:center;">
		<form action="BookingDone.jsp" method="get">
			<select name="flightid" id="flightid">
				<option value="null" selected disabled>Select Flight</option>
				
				<c:forEach items ="${list}" var="Train">
					<option value="${Flight.flightid}">${Flight.flightid}</option>
				</c:forEach>
			</select><br>
			<input type="number" placeholder="No. of Persons" name="num"/><br>
			<select name="Class" id="Class">
				<option value="null" selected disabled>Select Class</option>
				<option value="Bussiness">Bussiness</option>
		  		<option value="Economy">Economy</option>
			</select><br>
			
			<input type="submit" value="Book"/>
		</form>
	</div>
</body>
</body>
</html>