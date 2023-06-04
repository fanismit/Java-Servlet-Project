<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Home</title>
  <meta charset="UTF-8">
  <style>
    body {
    	font-family: Arial, sans-serif;
    	margin: 0;
    	padding: 0;
    }
    
    section {
    	height:100%;
    	background: linear-gradient(0deg, rgba(0, 0, 0, 0.6), rgba(0, 0, 0, 0.6)), url("Images/wp10615910.jpg");
    	background-size:cover;
    	height:100vh;
    }
    section h1{
    	color: #fff;
    	padding-top:80px;
    	margin: 0px;
    	text-align: center;
    	font-size: 50px;
    	
    }
    section > p{
    	color: #fff;
    	padding-top:20px;
    	text-align: center;
    	font-size: 20px;
    	width: 460px;
    	margin: 0 auto;
    	line-height: 28px;
    	
    }

	.flexbox{
		display: flex;
		flex-direction:row;
		align-items: center;
	}
    .container {
      width: 350px;
      margin: 0 auto;
      padding: 40px 20px;
      background-color: #fff;
      border-radius: 5px;
      box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
	  margin-top:30px;
	  opacity: 0.95;
	  
    }

    h2 {
      text-align: center;
      margin-bottom: 20px;
    }

    .form-group {
      margin-bottom: 20px;
    }

    label {
      display: block;
      margin-bottom: 5px;
    }

    input[type="text"],
    input[type="password"] {
      width: 330px;
      padding: 10px;
      border-radius: 3px;
      border: 1px solid #ccc;
	  
    }

    input[type="submit"] {
      width: 100%;
      padding: 10px;
      background-color: #e50914;
      border: none;
      color: #fff;
      font-weight: bold;
      cursor: pointer;
    }

    input[type="submit"]:hover {
      background-color: #b2070e;
    }
    form p{
    color: #e50914;
    }
  </style>
</head>
<body>

  <section>
  <h1>Welcome</h1>
  <p>Please log in to continue.</p>
   <div class="container">
    <h2>Login</h2>
    <form action="login" method="post">
      <div class="form-group">
        <label for="username">Username</label>
        <input type="text" id="username" name="username" required placeholder="Please enter your username">
      </div>
      <div class="form-group">
        <label for="password">Password</label>
        <input type="password" id="password" name="password" required placeholder="Please enter your password">
      </div>
      <p>The login details you entered are incorrect. Please try again.</p>
      <input type="submit" value="Login">
    </form>
  </div>
  </section>
</body>
</html>