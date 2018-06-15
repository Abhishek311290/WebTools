<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
          <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
        <link rel="stylesheet" 
        href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<title></title>
</head>
<body>
<form action="CandidateResponse" method="post" >
<div class="alert alert-success">
Online Portal Career Opportunity.
</div>
<table class="table table-striped">
  <thead>
    <tr>
    <th> Application ID </th>
      <th>Job Title</th>
      <th>Organization</th>
      <th>Status</th>
      <th></th>
    </tr>
  </thead>
  <tbody>
   <c:forEach items="${appdetails}"  var="app">
    <tr>
      <td>${app.applicationID}</td>
      <td>${app.jobTitle}</td>
       <td>${app.organisation}</td>
      <td>${app.status}</td>
    </tr>
      </c:forEach>
  </tbody>
</table>
<input type="hidden" name="userName" value="${userDetails}">
</form>
</body>
</html>