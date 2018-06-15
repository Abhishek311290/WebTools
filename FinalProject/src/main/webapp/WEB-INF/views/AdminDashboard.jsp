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
<form class="form-horizontal" action='adminAction' method="POST" commandName ="Login">
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
				Welcome Admin ${userName}
			</a>
		</div>
	

			<ul class="nav navbar-nav navbar-right"> 
				<li><a href="/FinalProject" class="f90-logout-button">Logout</a></li>
				<li><input type="hidden" name="userName" value="${userName}"></li>

				</ul>
			</div>
	</nav>
	<div class="container-fluid main-container">
		<div class="col-md-2 sidebar">
			<ul class="nav nav-pills nav-stacked">
				<li class="active">Home</li>
				<br>
				<li><input type="submit" class="btn btn-danger" name="Action" value="Delete Job"></li>

			</ul>
		</div>




		<footer class="pull-left footer">
			<p class="col-md-12">
				<hr class="divider">
				Copyright &COPY; 2017 
<!-- 				<a href="http://www.pingpong-labs.com">Gravitano</a> -->
			</p>
		</footer>
	</div>
	</form>
</body>
</html>