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
            background-color: #4CAF50;
            color: white;
        }

        .navbar .logout-btn {
            float: right;
        }

        .container {
            padding: 20px;
        }

        h1 {
            margin-top: 0;
        }

        p {
            margin-top: 0;
        }
    </style>
</head>
<body>
    <div class="navbar">
        <a class="active" href="#">Profile</a>
        <a href="#">View Movies</a>
        <a href="Actions/AddMovie.jsp">Add Movie</a>
        <a href="#">Assign Room & Time</a>
        <a class="logout-btn" href="#">Logout</a>
    </div>

    <div class="container">
        <h1>Welcome, Content Admin</h1>
        <p>This is your profile page. You can manage movies and assign rooms and times.</p>
    </div>
</body>
</html>
