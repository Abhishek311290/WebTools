<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  	  <script type="text/javascript">
            function validate()
            {    
            	
                var a = document.getElementById("userName");
                var b = document.getElementById("email");
                var c = document.getElementById("password");
                
                var valid = true;
                if(a.value.length<=0 || b.value.length<=0 || c.value.length<=0)
                    {
                        alert("Please enter all the Registration details ");
                        valid = false;
                    }
                return valid;
            };

        </script>
<title>Registration</title>
</head>
<body>
<form class="form-horizontal" action='adduser' method="POST" commandName ="Login" onsubmit="return validate()">
  <fieldset>
    <div id="legend">
      <legend class="">Register</legend>
    </div>
    <div class="control-group">
      <!-- Username -->
      <label class="control-label"  for="userName">Username</label>
      <div class="controls">
        <input type="text" id="userName" name="userName" placeholder="" class="input-xlarge" path="userName">
        <p class="help-block">Username can contain any letters or numbers, without spaces</p>
      </div>
    </div>
 
    <div class="control-group">
      <!-- E-mail -->
      <label class="control-label" for="email">E-mail</label>
      <div class="controls">
        <input type="text" id="email" name="email" placeholder="" class="input-xlarge" path="email">
        <p class="help-block">Please provide your E-mail</p>
      </div>
    </div>
 
    <div class="control-group">
      <!-- Password-->
      <label class="control-label" for="password">Password</label>
      <div class="controls">
        <input type="password" id="password" name="password" placeholder="" class="input-xlarge" path="password">
        <p class="help-block">Password should be at least 4 characters</p>
      </div>
    </div>
   
    
    <select name="Role" path="role">
    <option value="SysAdmin">SysAdmin</option>
    <option value="Recruiter">Recruiter</option>
    <option value="JobCandidate">JobCandidate</option>
  </select>
  <br><br>

    <div class="control-group">
      <!-- Button -->
      <div class="controls">
        <button class="btn btn-success">Register</button>
      </div>
    </div>
    
  </fieldset>
</form>
    </body>
</html>