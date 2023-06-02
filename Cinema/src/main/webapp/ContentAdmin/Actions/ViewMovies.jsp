<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList" %>
    <%@page import="java.util.List" %>   
    <%@page import="Classes.Movies" %>
<!DOCTYPE html>
<html>
<head>
<title>List of Movies</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        margin: 0;
        padding: 0;
    }

    .container {
        max-width: 1300px;
        margin: 50px auto;
        padding: 20px;
        background-color: #ffffff;
        border-radius: 5px;
        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        box-sizing: border-box;
    }

    h1 {
        text-align: center;
    }

    .movie-list {
        display: flex;
        flex-wrap: wrap;
        justify-content: flex-start;
    }

    .movie {
        display: flex;
        align-items: flex-start;
        margin-bottom: 20px;
    }

    .movie-image {
        flex: 0 0 150px;
        margin-right: 20px;
    }

    .movie-image img {
        max-width: 100%;
        height: auto;
    }

    .movie-details {
        flex: 1;
        min-width: 200px;
    }

    .movie-title {
        font-size: 18px;
        font-weight: bold;
        margin-bottom: 5px;
    }

    .movie-category {
        margin-bottom: 5px;
        font-style: italic;
        color: #888888;
    }

    .info-group {
        display: flex;
        align-items: center;
        margin-bottom: 10px;
    }

    .info-label {
    	padding-right:30px;
        flex:0 0 20px;
        font-weight: bold;
    }

</style>
</head>
<body>
    <div class="container">
        <h1>Available Movies</h1>
        <div class="movie-list">
        	<%
        	List<Classes.Movies> movies = (List<Classes.Movies>) request.getAttribute("movies");
        	if(movies != null){
        		for(Classes.Movies movie: movies){
        	%>
            <div class="movie">
                <div class="movie-image">
                    <img src="movie1.jpg" alt="Movie 1">
                </div>
                <div class="movie-details">
                    <div class="movie-title">asdffff</div>
                    <div class="movie-category">asssssssssssddfff</div>
                        <div class="info-group">
                        <div class="info-label">Cinema:asddfff</div>
                        <div class="info-label">Room:wwee</div>
                        <div class="info-label">Date:sxdcc</div>
                        <div class="info-label">Time:cffvfvv</div>
                    </div>
                </div>
            </div>
            <% 
                }
            } else {
            %>
				<p> No movies found!</p>
            <% 
            }
            %>
        </div>
    </div>

</body>
</html>
