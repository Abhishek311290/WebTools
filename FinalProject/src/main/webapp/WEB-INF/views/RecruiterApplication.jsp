<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>
 <script type="text/javascript">
        $(document).ready(function() {
            $('#call').click(function ()
            {
            	var status="Accept";
            //	alert("Hi");
                $.ajax({
                    type: "post",
                    url: "updateUser", //this is my servlet
                    data: "appid=" +$('#call').val()+"&Status="+status,
                    success: function(msg){      
                         alert("Value Updated to Accept")
                    }
                });
            });

        });
    </script>
    
   <script type="text/javascript">
        $(document).ready(function() {
            $('#callReject').click(function ()
            {
            	var status="Reject";
            //	alert("Hi");
                $.ajax({
                    type: "post",
                    url: "updateUser", //this is my servlet
                    data: "appid=" +$('#callReject').val()+"&Status="+status,
                    success: function(msg){      
                         alert("Value Updated to Reject")
                    }
                });
            });

        });
    </script>
    
    <script type="text/javascript">
        $(document).ready(function() {
            $('#callView').click(function ()
            {
            	//var status="Reject";
            //	alert("Hi");
                $.ajax({
                    type: "post",
                    url: "viewResume", //this is my servlet
                    data: "appid=" +$('#callView').val(),
                    success: function(msg){      
                        //
                    }
                });
            });

        });
    </script>  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
          <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
        <link rel="stylesheet" 
        href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<title></title>
</head>
<body>
<div class="alert alert-success">
Online Portal Career Opportunity.
</div>
<table class="table table-striped">
  <thead>
    <tr>
    <th> Application ID </th>
      <th>Applican't Name</th>
      <th>Applican't Resume Analyzer Status</th>
      <th>Action</th>
      <th>Resume</th>
      <th></th>
    </tr>
  </thead>
  <tbody>
   <c:forEach items="${appdetails}"  var="app">
    <tr>
      <td>${app.applicationID}</td>
      <td>${app.fullName}</td>
      <td>${app.resumeAnalyzerComment}</td>
      <td><button type="button" class="btn btn-success" name="Action" value="${app.applicationID}" id="call">Accept</button>
      
      <button type="button" class="btn btn-danger" name="Action" value="${app.applicationID}" id="callReject">Reject</button></td>
      <td><button type="button" class="btn btn-success" name="Action" value="${app.applicationID}" id="callView">View</button></td>
    </tr>
      </c:forEach>
  </tbody>
</table>
<input type="hidden" name="userName" value="${userDetails}">
<!-- </form> -->
</body>
</html>