<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Content Admin Dashboard</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }

        .navbar {
            background-color: #333;
            overflow: hidden;
        }

        .navbar a {
            float: left;
            color: white;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }

        .navbar a:hover {
            background-color: #ddd;
            color: black;
        }

        .navbar a.active {
            background-color: #e50914;
            color: white;
        }

        .navbar .logout-btn {
            float: right;
        }

         .container {
        max-width: 900px;
        margin: 50px auto;
        padding: 20px;
        background-color: #ffffff;
        border-radius: 5px;
        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        box-sizing: border-box;
    }


        h1 {
            margin-top: 0;
        }

        p {
            margin-top: 0;
        }
  		.column {
  			display:flex;
  			justify-content:space-between;
  			flex-direction: row;
  		}

        label {
            display: ;
            color: #000;
            margin-bottom: 10px;
        }
		.user-info{
			display: flex;
			flex-direction: column;
		}
        input[type="text"],
        input[type="email"],
        input[type="password"] {
            width: 400px;
            padding: 10px;
            margin-bottom: 20px;
            border: none;
            background-color: #333;
            color: #fff;
            border-radius: 5px;
        }
    </style>
</head>
<body>
    <div class="navbar">
        <a class="active" href="/CinemaUnipi/ContentAdmin/content_admin_home.jsp">Profile</a>
        <a href="#">View Movies</a>
        <a href="Actions/AddMovie.jsp">Add Movie</a>
        <a href="#">Assign Room & Time</a>
        <a class="logout-btn" href="#">Logout</a>
    </div>

    <div class="container">
        <h1>Profile</h1>
        <div class="info">
        	 <form>
        		<div class="column">
        			<div class="user-info">
	        			<label for="username">Username:</label>
	        			<input type="text" id="username" value="${sessionScope.userDetails.get(0)}" readonly>
	        		</div>
	        		<div class="user-info">
	        			<label for="email">Email:</label>
	        			<input type="email" id="email" value="${sessionScope.userDetails.get(1)}" readonly>
	        		</div>
				</div>
        		<div class="column">
        			<div class="user-info">
		        		<label for="password">Password:</label>
		        		<input type="password" id="password" value="${sessionScope.userDetails.get(3)}" readonly>
	        		</div>
	        		<div class="user-info">
	        			<label for="role">Role:</label>
	        			<input type="text" id="role" value="${sessionScope.userDetails.get(2)}" readonly>
        			</div>
        		</div>
   			 </form>
        </div>
    </div>
</body>
</html>
