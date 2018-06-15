<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
          <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
        <link rel="stylesheet" 
        href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
           <script type="text/javascript">
            function validate()
            {    
            	
                var a = document.getElementById("jobTitle");
                var b = document.getElementById("organisation");
                var c = document.getElementById("skills");
                var d=document.getElementById("jobDesc");
                var valid = true;
                if(a.value.length<=0 || b.value.length<=0 ||c.value.length<=0 || d.value.length<=0 )
                    {
                        alert("Please enter Values in all field");
                        valid = false;
                    }
                return valid;
            };

        </script>
<title></title>

</head>
<body>
<form action="createJob" method="POST" commandName="JobDetails" onsubmit="return validate();">

	<div class="form-group"> 
		<label class="control-label " for="name">Job Title</label>
		<input class="form-control" id="jobTitle" name="jobTitle" path="jobTitle" type="text"/>
	</div>
	
	<div class="form-group"> 
		<label class="control-label requiredField" for="organisation">Organization name<span class="asteriskField">*</span></label>
		<input class="form-control" id="organisation" name="organisation" type="text"/>
	</div>
	
	<div class="form-group"> 
		<label class="control-label " for="skills">Skills</label>
		<input class="form-control" id="skills" name="skills" type="text"/>
	</div>
	
	<div class="form-group">
		<label class="control-label " for="jobDesc">Job Description</label>
		<textarea class="form-control" cols="40" id="jobDesc" name="jobDesc" rows="10"></textarea>
	</div>
	
		<div class="form-group">
		<label class="control-label " for="postedBy">Posted By</label>
		<input class="form-control" id="postedBy" name="postedBy" type="text" value="${postedBy}" readonly/>
	</div>
	
	<div class="form-group">
		<button class="btn btn-primary " name="submit" type="submit">Submit</button>
	</div>
	
</form>								
			
</body>
</html>