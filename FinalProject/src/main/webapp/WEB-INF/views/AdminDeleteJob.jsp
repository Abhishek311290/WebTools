<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>

     <script type="text/javascript">
        $(document).ready(function() {
            $('#callReject').click(function ()
            {
            //	alert("Hi");
                $.ajax({
                    type: "post",
                    url: "updateJobs", //this is my servlet
                    data: "jobid=" +$('#callReject').val(),
                    success: function(msg){
                    	alert("job Deleted Please Refresh the page");
                    	location.reload(forceGet);
                    	//window.location.reload(true);
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
<table class="table table-striped" id="tclean">
  <thead>
    <tr>
    <th> Job ID </th>
      <th>Job title</th>
      <th>Organization</th>
      <th>Action</th>
      <th></th>
    </tr>
  </thead>
  <tbody>
   <c:forEach items="${jobs}"  var="job">
    <tr>
      <td>${job.jobID}</td>
      <td>${job.jobTitle}</td>
      <td>${job.organisation}</td>
      <td>
      
      <button type="button" class="btn btn-danger" name="Action" value="${job.jobID}" id="callReject">Delete</button></td>
    </tr>
      </c:forEach>
  </tbody>
</table>
<input type="hidden" name="userName" value="${userDetails}">
<!-- </form> -->
</body>
</html>