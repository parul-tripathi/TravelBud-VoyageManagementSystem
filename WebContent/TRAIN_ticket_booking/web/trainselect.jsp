<%@page import="com.arnav.verma.trains.Train"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
  <head>
    <title>VOYAGE MANAGEMENT SYSTEM: TRAIN BOOKING</title>
    <link rel="stylesheet" href="css/style.css" />
    <link
      href="//fonts.googleapis.com/css?family=Open+Sans:400,300italic,300,400italic,600,600italic,700,700italic,800,800italic"
      rel="stylesheet"
      type="text/css"
    />
    <link
      href="//fonts.googleapis.com/css?family=Montserrat:400,700"
      rel="stylesheet"
      type="text/css"
    />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta
      name="keywords"
      content="Flight Ticket Booking  Widget Responsive, Login Form Web Template, Flat Pricing Tables, Flat Drop-Downs, Sign-Up Web Templates, Flat Web Templates, Login Sign-up Responsive Web Template, Smartphone Compatible Web Template, Free Web Designs for Nokia, Samsung, LG, Sony Ericsson, Motorola Web Design"
    />
    <script type="application/x-javascript">
      addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); }
    </script>
  </head>
  <body>
    <h1>Train Booking</h1>
    <div class="main-agileinfo">
      <div class="sap_tabs">
        <div id="horizontalTab">
          <ul class="resp-tabs-list">
            <li class="resp-tab-item"><span>Book Your Ticket</span></li>
          </ul>
          <div class="clearfix"></div>
          <div class="resp-tabs-container">
            <div class="tab-1 resp-tab-content oneway">
              <form action="../../TrainServ">
                <div class="from">
                  <h3>From</h3>
                  <select name="fromcity" id="fromcity">
						<option value="null" selected disabled>From City</option>
						
						<c:forEach items ="${trlist}" var="Train">
							<option value="${Train.source}">${Train.source}</option>
						</c:forEach>
					</select>
                </div>
                <div class="to">
                  <h3>Destination</h3>
                  <select name="tocity" id="tocity">
						<option value="null" selected disabled>To City</option>
						
						<c:forEach items ="${trlist}" var="Train">
							<option value="${Train.destination}">${Train.destination}</option>
						</c:forEach>
					</select>
                </div>
                <div class="clear"></div>
                <div class="date">
                  <div class="depart">
                    <h3>Departure Date</h3>
                    <input
                      class="date"
                      id="datepicker2"
                      name="date"
                      type="text"
                      value="mm/dd/yyyy"
                      onfocus="this.value = '';"
                      onblur="if (this.value == '') {this.value = 'mm/dd/yyyy';}"
                      required=""
                    />
                    <span class="checkbox1">
                      <label class="checkbox"
                        ><input type="checkbox" name="" checked="" /><i> </i
                        >Flexible with date</label
                      >
                    </span>
                  </div>
                </div>

                <div class="clear"></div>
                <div class="numofppl">
                  <div class="adults">
                    <h3>Adult:(12+ yrs)</h3>
                    <div class="quantity">
                      <div class="quantity-select">
                        <div class="entry value-minus">&nbsp;</div>
                        <div class="entry value"><span>1</span></div>
                        <div class="entry value-plus active">&nbsp;</div>
                      </div>
                    </div>
                  </div>
                  <div class="clear"></div>
                </div>
                <div class="clear"></div>
                <input type="submit" value="Search Trains" name="filter"/>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="footer-w3l">
      <p class="agileinfo">VOYAGE MANAGEMENT SYSTEM<br />VIT,VELLORE</p>
    </div>
    <!--script for portfolio-->
    <script src="js/jquery.min.js"></script>
    <script src="js/easyResponsiveTabs.js" type="text/javascript"></script>
    <script type="text/javascript">
      $(document).ready(function () {
        $("#horizontalTab").easyResponsiveTabs({
          type: "default", //Types: default, vertical, accordion
          width: "auto", //auto or any width like 600px
          fit: true, // 100% fit in a container
        });
      });
    </script>
    <!--//script for portfolio-->
    <!-- Calendar -->
    <link rel="stylesheet" href="css/jquery-ui.css" />
    <script src="js/jquery-ui.js"></script>
    <script>
      $(function () {
        $("#datepicker,#datepicker1,#datepicker2,#datepicker3").datepicker();
      });
    </script>
    <!-- //Calendar -->
    <!--quantity-->
    <script>
      $(".value-plus").on("click", function () {
        var divUpd = $(this).parent().find(".value"),
          newVal = parseInt(divUpd.text(), 10) + 1;
        divUpd.text(newVal);
      });

      $(".value-minus").on("click", function () {
        var divUpd = $(this).parent().find(".value"),
          newVal = parseInt(divUpd.text(), 10) - 1;
        if (newVal >= 1) divUpd.text(newVal);
      });
    </script>
    <!--//quantity-->
    <!--load more-->
    <script>
      $(document).ready(function () {
        size_li = $("#myList li").size();
        x = 1;
        $("#myList li:lt(" + x + ")").show();
        $("#loadMore").click(function () {
          x = x + 1 <= size_li ? x + 1 : size_li;
          $("#myList li:lt(" + x + ")").show();
        });
        $("#showLess").click(function () {
          x = x - 1 < 0 ? 1 : x - 1;
          $("#myList li")
            .not(":lt(" + x + ")")
            .hide();
        });
      });
    </script>
    <!-- //load-more -->
  </body>
</html>
