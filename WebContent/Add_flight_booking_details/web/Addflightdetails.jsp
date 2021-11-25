<!DOCTYPE html>
<html lang="en">
  <head>
    <title>VOYAGE MANAGEMENT SYSTEM: ADD FLIGHT TICKET BOOKING DETAILS</title>
    <!-- for-mobile-apps -->
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta
      name="keywords"
      content="Auditions Registration Form Widget Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design"
    />
    <script type="application/x-javascript">
      addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
      	function hideURLbar(){ window.scrollTo(0,1); }
    </script>
    <!-- //for-mobile-apps -->
    <!-- //custom-theme -->
    <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
    <!-- js -->
    <script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
    <!-- //js -->
    <!-- font-awesome-icons -->
    <!-- //font-awesome-icons -->
    <link
      href="//fonts.googleapis.com/css?family=Anton&amp;subset=latin-ext,vietnamese"
      rel="stylesheet"
    />
  </head>
  <body>
    <!-- banner -->
    <div class="center-container">
      <div class="banner-dott">
        <div class="main">
          <h1 class="w3layouts_head">ADD FLIGHT TICKET BOOKING DETAILS</h1>
          <div class="w3layouts_main_grid">
            <form action="../../Confirmbookingserv"  class="w3_form_post">
              <div class="w3_agileits_main_grid w3l_main_grid">
                <span class="agileits_grid">
                  <label>First Name </label>
                  <input
                    type="text"
                    name="name"
                    placeholder="First Name"
                    required=""
                  />
                </span>
              </div>
              <div class="w3_agileits_main_grid w3l_main_grid">
                <span class="agileits_grid">
                  <label>Last Name </label>
                  <input
                    type="text"
                    name="lname"
                    placeholder="Last Name"
                    required=""
                  />
                </span>
              </div>
              <div class="w3_agileits_main_grid w3l_main_grid">
                <span class="agileits_grid">
                  <label>Your Email </label>
                  <input
                    type="text"
                    name="Task"
                    placeholder="email"
                    required=""
                  />
                </span>
              </div>
              <div class="w3_agileits_main_grid w3l_main_grid">
                <span class="agileits_grid">
                  <label>Phone Number </label>
                  <input
                    type="text"
                    name="mob"
                    placeholder="Phone Number"
                    required=""
                  />
                </span>
              </div>
              <div class="w3_agileits_main_grid w3l_main_grid">
                <span class="agileits_grid">
                  <label>Select Gender </label>
                  <select name="country">
                    <option value="none" selected="" disabled="">
                      Select Gender
                    </option>
                    <option value="Ph">Male</option>
                    <option value="Po">Female</option>
                    <option value="So">Other</option>
                  </select>
                </span>
              </div>

              <div class="w3_agileits_main_grid w3l_main_grid">
                <span class="agileits_grid">
                  <label>Select Class </label>
                  <select name="Class" id="Class">
                    <option value="none" selected="" disabled="">
                      Select Class
                    </option>
                    <option value="First Class">First Class</option>
                    <option value="Business Class">Business Class</option>
                    <option value="Premium Economy Class">Premium Economy Class</option>
                    <option value="Economy Class">Economy Class</option>
                  </select>
                </span>
              </div>

              <div class="w3_main_grid">
                <div class="w3_main_grid_right">
                  <input type="submit" value="Submit" name="details"/>
                </div>
              </div>
            </form>
          </div>
          <!-- Calendar -->
          <link rel="stylesheet" href="css/jquery-ui.css" />
          <script src="js/jquery-ui.js"></script>
          <script>
            $(function () {
              $("#datepicker").datepicker();
            });
          </script>
          <!-- //Calendar -->
          <div class="w3layouts_copy_right">
            <div class="container">
              <p>TRAVEL BUD<br />VIT,VELLORE</p>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- //footer -->
  </body>
</html>
