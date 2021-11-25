<%@page import="com.arnav.verma.Flight"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <meta charset="ISO-8859-1" />
    <title>VOYAGE MANAGEMENT SYSTEM: FLIGHT(Cancel Bookings)</title>
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
              background-image: url('canf.jpg');
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
        <p></p>
      </div>
      <h1 style="text-align: center; color: white">Your Bookings</h1>
    </div>
    <div class="bt">
      <p></p>
    </div>
    <div class="box2" style="text-align: center; color: white">
      <div class="op2">
        <p>Please select your bookings that you want to Cancel</p>
      </div>
      <form action="Cancelserv">
        <table class="center" style="text-align: center; color: white">
          <tr>
          <th>PNR</th>
            <th>Flight Name</th>
            <th>Price</th>
            <th>From</th>
            <th>Destination</th>
            <th>Flight ID</th>
            <th>Time</th>
            <th>Duration</th>
            <th>Name</th>
            <th>Date</th>
            <th>Class</th>
            
          </tr>
          <c:forEach items="${FLB}" var="Flight" varStatus="status">
            <tr>
            <td>
                <input type="radio" value="${pnr[status.index]}" name="PNR" />${pnr[status.index]}
              </td>
              <td>
                <input
                  type="hidden"
                  value="${Flight.name}"
                  name="name"
                />${Flight.name}
              </td>
              <td><input type="hidden" name="price" />${Flight.price}</td>
              <td><input type="hidden" name="source" />${Flight.source}</td>
              <td><input type="hidden" name="desti" />${Flight.destination}</td>
              <td><input type="hidden" name="id" />${Flight.flightid}</td>
              <td><input type="hidden" name="time" />${Flight.time}</td>
              <td><input type="hidden" name="duration" />${Flight.duration}</td>
              <td>
                <input type="hidden" name="price" />${names[status.index]}
              </td>
              <td>
                <input type="hidden" name="price" />${dates[status.index]}
              </td>
              <td><input type="hidden" name="price" />${clas[status.index]}</td>
              
            </tr>
          </c:forEach>
        </table>
        <input type="submit" value="Cancel" name="cancelflight" />
      </form>
      <form action="MAIN_PAGE/index.jsp">
        <input type="submit" value="Home" />
      </form>
      <div id="paypal-button"></div>
<script src="https://www.paypalobjects.com/api/checkout.js"></script>
<script>
paypal.Button.render({
// Configure environment
env: 'sandbox',
client: {
sandbox: 'demo_sandbox_client_id',
production: 'demo_production_client_id'
},
// Customize button (optional)
locale: 'en_US',
style: {
size: 'small',
color: 'gold',
shape: 'pill',
},
// Set up a payment
payment: function (data, actions) {
return actions.payment.create({
transactions: [{
amount: {
total: '0.01',
currency: 'USD'
}
}]
});
},
// Execute the payment
onAuthorize: function (data, actions) {
return actions.payment.execute()
.then(function () {
// Show a confirmation message to the buyer
window.alert('Thank you for your purchase!');
});
}
}, '#paypal-button');
</script>
    </div>
    
  </body>
</html>