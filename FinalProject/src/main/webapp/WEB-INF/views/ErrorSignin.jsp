<%-- 
    Document   : moviejsp
    Created on : Feb 9, 2017, 10:15:17 PM
    Author     : Praneeth
--%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
          <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
        <link rel="stylesheet" 
        href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        
         <script type="text/javascript">
            function validate()
            {    
            	
                var a = document.getElementById("lUserName");
                var b = document.getElementById("lPassword");
                var valid = true;
                if(a.value.length<=0 || b.value.length<=0)
                    {
                        alert("Please enter User Name & Password to Login ");
                        valid = false;
                    }
                return valid;
            };

        </script>
    </head>
    <body>
   
        <h1>Welcome To The Online Resume Analyzer</h1>

        Please make your selection below
		<form:form method="POST" action="action" commandName="Credentials"  >
       <div class="form-group">
      <label for="usr">Name:</label>
      <input type="text" class="form-control" id="lUserName" name="lUserName" path="lUserName">
    	</div>
    	<div class="form-group">
      <label for="pwd">Password:</label>
      <input type="password" class="form-control" id="lPassword" name="lPassword" path="lPassword">
   		 </div>
		 <p> Invalid Login Credentials</p>
        <input type="submit" name="Action" value="Login" onclick="validate()" />
        <input type="submit" name="Action" value="Signup" />
</form:form>
    </body>
</html>
