<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
          <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
        <link rel="stylesheet" 
        href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<title></title>
</head>
<body>
<form class="form-horizontal" action='canditateAction' method="POST" commandName ="Login">
<nav class="navbar navbar-default navbar-static-top">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand">
				Welcome Candidate ${user.fullName}
			</a>
		</div>
	

			<ul class="nav navbar-nav navbar-right">
				<li><a href="/FinalProject" class="f90-logout-button">Logout</a></li>
				<li><input type="hidden" name="userName" value="${user.userName}"></li>

				</ul>
			</div>
	</nav>
	<div class="container-fluid main-container">
		<div class="col-md-2 sidebar">
			<ul class="nav nav-pills nav-stacked">
				<li class="active">Home</li>
				<br>
				<li><input type="submit" class="btn btn-success" name="Action" value="View Jobs"></li>
				<br>
				<li><input type="submit" class="btn btn-success" name="Action" value="My Applications Status"></li>

			</ul>
		</div>

<div class="container">
  <h2>Candidate Profile Info</h2>
    <div class="form-group">
      <label class="control-label col-sm-2" for="fullName">Name:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="fullName" name="fullName" value ="${user.fullName}" placeholder="Enter Full Name"  disabled >
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="major">Major:</label>
      <div class="col-sm-10">          
        <input type="text" class="form-control" id="major" name="major" value ="${user.major}" placeholder="Enter Major Here" disabled>
      </div>
    </div>
    
    <div class="form-group">
      <label class="control-label col-sm-2" for="skills">Skills:</label>
      <div class="col-sm-10">          
        <input type="text" class="form-control" id="skills"  name="skills" value ="${user.skills}"  placeholder="Enter skills separated by comma" disabled>
      </div>
    </div>
    
<!--      <div class="form-group"> -->
<!--       <label class="control-label col-sm-2" for="Resume">Resume:</label> -->
<!--       <div class="col-sm-10">           -->
<!--         <input type="file" class="form-control" id="skills" placeholder="Paste Your resume Here"> -->
<!--       </div> -->
<!--     </div> -->

	<div class="form-group">
      <label class="control-label col-sm-2" for="email">Email:</label>
      <div class="col-sm-10">          
        <input type="email" class="form-control" id="email" name="email" value ="${user.email}"  disabled>
      </div>
    </div>
    
     <div class="form-group">
      <label class="control-label col-sm-2" for="userName">User Name:</label>
      <div class="col-sm-10">          
        <input type="text" class="form-control" id="userName" name="userName" value ="${user.userName}"disabled>
      </div>
    </div>
    
    
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-default" name="Action" value="Save Profile" disabled>Save profile</button>
      </div>
    </div>

</div>


		<footer class="pull-left footer">
			<p class="col-md-12">
				<hr class="divider">
				Copyright &COPY; 2017 
			</p>
		</footer>
	</div>
	</form>
</body>
</html>