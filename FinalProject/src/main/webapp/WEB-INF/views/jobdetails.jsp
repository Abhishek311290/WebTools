<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<form:form class="form-horizontal" commandName="appDetails" action="applyforJob" method="post" enctype="multipart/form-data">
<div class="container">
  <h2>Job Details</h2>
  
    <div class="form-group">
      <label class="control-label col-sm-2" for="jobTitle">Job Title:</label>
      <div class="col-sm-10">
        <form:input type="text" path="jobTitle" class="form-control" id="jobTitle" name="jobTitle" value="${job.jobTitle}" disabled="true"/>
      </div>
    </div>
     <div class="form-group">
      <label class="control-label col-sm-2" for="organisation">Organization</label>
      <div class="col-sm-10">
        <form:input type="text" path="organisation" class="form-control" id="organisation" name="organisation" value="${job.organisation}" disabled="true" />
      </div>
    </div>
    
      <label class="control-label col-sm-2" for="skills">Skills Required</label>
      <div class="col-sm-10">
        <form:input type="text" path="skills" class="form-control" id="skills" name="skills" value="${job.skills}" disabled="true"/>
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="jobDesc">Job Desc:</label>
      <form:input class="form-control" path="jobDesc" rows="5" id="jobDesc" name="jobDesc" value="${job.jobDesc}" disabled="true"/>
    </div>
    
      <label class="control-label col-sm-2" for="fullName">Applicant name</label>
      <div class="col-sm-10">
        <form:input type="text" class="form-control" path="fullName" id="fullName" name="fullName" value="${userDetails.fullName}" disabled="true"/>
      </div>
    
     <label class="control-label col-sm-2" for="email">Applicant email</label>
      <div class="col-sm-10">
      <form:input type="text" class="form-control" path ="email" id="email" name="email" value="${userDetails.email}" disabled="true"/>
      </div>
      
       <label class="control-label col-sm-2" for="resumeComment">Resume Analyzer Analysis for this Job</label>
      <div class="col-sm-10">
        <form:input type="text" class="form-control" path="resumeAnalyzerComment" id="resumeAnalyzerComment" name="resumeAnalyzerComment" value="${resumeComment}" disabled="true"/>
      </div>
      
         <div class="form-group"> 
      <label class="control-label col-sm-2" for="resumeFile">Resume:</label> 
     <div class="col-sm-10">      
         <input type="file" class="form-control" id="resumeFile" name="resumeFile" placeholder="Paste Your resume Here"> 
      </div> 
    </div> 
    	 <form:input type="hidden" class="form-control" path="status" id="status" name="status" value="Submitted" />
        <form:input type="hidden" class="form-control" path="userName" id="userName" name="userName" value="${userDetails.userName}" />
        
        <form:input type="hidden" class="form-control"  path="postedBy" id="postedBy" name="postedBy" value="${job.postedBy}" />
        
        
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-success" name="Action" value="Apply">Apply</button>
      </div>
    </div>
    </div>
 </form:form>


</body>
</html>