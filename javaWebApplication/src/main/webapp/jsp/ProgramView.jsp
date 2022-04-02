<%@page import="javawebapplication.utility.ServletUtility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ProgramRegistration</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
 <script>
 $( function() {
      $( "#datepicker" ).datepicker({
          dateFormat : 'mm/dd/yy',
          changeMonth: true,
        changeYear: true
      });
    } );
  </script>
</head>
<body>
<%@ include file="Header.jsp"%>
  <main class="login-form">
  <div class="cotainer">
    <div class="row justify-content-center">
      <div class="col-md-8">
        <div class="card">
          <div class="card-header">
            Program Registration
            
          </div>
          
          <div class="card-body">
          
          <h3 style="color: green;"> <%=ServletUtility.getSuccessMessage(request)%></h3>
          <h3 style="color: red;"><%=ServletUtility.getErrorMessage(request)%></h3>
          
            <form action="<%=JWAView.ProgramCTL %>" method="post">
              
              <div class="form-group row">
                <label for="email_address" 
                  class="col-md-4 col-form-label text-md-right">Activity<font color="red"></font></label>
                <div class="col-md-6">
                  <input type="text"   class="form-control" placeholder="Enter Activity"
                    name="activity" value="" >
                    <font  color="red"></font>
                </div>
              </div>
              
              <div class="form-group row">
                <label for="email_address" 
                  class="col-md-4 col-form-label text-md-right">Location<font color="red"></font></label>
                <div class="col-md-6">
                  <input type="text"   class="form-control" placeholder="Enter Location"
                    name="name" value="" >
                    <font  color="red"></font>
                </div>
              </div>
              
              <div class="form-group row">
                <label for="email_address" 
                  class="col-md-4 col-form-label text-md-right">Day<font color="red"></font></label>
                <div class="col-md-6">
                  <input type="text" id="email_address"  class="form-control" placeholder="Enter Day"
                    name="day" value="" >
                    <font  color="red"></font>
                </div>
              </div>
              
              <div class="form-group row">
                <label for="email_address" 
                  class="col-md-4 col-form-label text-md-right">Capacity<font color="red"></font></label>
                <div class="col-md-6">
                  <input type="text" id="capacity"  class="form-control" placeholder="Enter Capacity"
                    name="capacity" value="" >
                    <font  color="red"></font>
                </div>
              </div>
              
              <div class="form-group row">
                <label for="email_address" 
                  class="col-md-4 col-form-label text-md-right">Start-Date<font color="red"></font></label>
                <div class="col-md-6">
                  <input type="text"  id="datepicker" class="form-control" placeholder="Enter Start-Date"
                    name="start-date" value="" >
                    <font  color="red"></font>
                </div>
              </div>
              
               <div class="form-group row">
                <label for="email_address" 
                  class="col-md-4 col-form-label text-md-right">End-Date<font color="red"></font></label>
                <div class="col-md-6">
                  <input type="text"  id="datepicker" class="form-control" placeholder="Enter End-Date"
                    name="end-date" value="" >
                    <font  color="red"></font>
                </div>
              </div>
              
              <div class="form-group row">
                <label for="email_address" 
                  class="col-md-4 col-form-label text-md-right">Start-Time<font color="red"></font></label>
                <div class="col-md-6">
                  <input type="text" id="email_address"  class="form-control" placeholder="Enter the Start-Time"
                    name="start-time" value="" >
                    <font  color="red"></font>
                </div>
              </div>
              
              <div class="form-group row">
                <label for="email_address" 
                  class="col-md-4 col-form-label text-md-right">End-Time<font color="red"></font></label>
                <div class="col-md-6">
                  <input type="text" id="email_address"  class="form-control" placeholder="Enter the End-Time"
                    name="end-time" value="" >
                    <font  color="red"></font>
                </div>
              </div>
              
              <div class="form-group row">
                <label for="email_address" 
                  class="col-md-4 col-form-label text-md-right">Member-Price<font color="red"></font></label>
                <div class="col-md-6">
                  <input type="text" id="email_address"  class="form-control" placeholder="Enter the Member-Price"
                    name="member-price" value="" >
                    <font  color="red"></font>
                </div>
              </div>
              
              <div class="form-group row">
                <label for="email_address" 
                  class="col-md-4 col-form-label text-md-right">Non-Member-Price<font color="red"></font></label>
                <div class="col-md-6">
                  <input type="text" id="email_address"  class="form-control" placeholder="Enter the Non-Member-Price"
                    name="non-member-price" value="" >
                    <font  color="red"></font>
                </div>
              </div>
              
              <div class="form-group row">
                <label for="email_address" 
                  class="col-md-4 col-form-label text-md-right">PreRequirement<font color="red"></font></label>
                <div class="col-md-6">
                  <input type="text" id="email_address"  class="form-control" placeholder="Enter the PreRequirements"
                    name="prereq" value="" >
                    <font  color="red"></font>
                </div>
              </div>
              <div class="col-md-6 offset-md-4">
                <input type="submit" class="btn btn-primary" name="operation" value="Register">
                
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
  </main>
  <div style="margin-top: 120px">
    <%@ include file="Footer.jsp"%>
  </div>
</body>
</html>