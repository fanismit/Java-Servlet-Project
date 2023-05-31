<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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

    .form-group {
        display: flex;
        align-items: center;
        margin-bottom: 10px;
    }

    .form-label {
        flex:0 0 20px;
        font-weight: bold;
    }

    .form-input {
        flex: 1;
        padding: 5px;
        border: 1px solid #ddd;
        border-radius: 4px;
        box-sizing: border-box;
    }

    .form-input-small {
        flex: 0 0 100px;
        margin-right: 15px;
    }

    .btn-submit {
        display: block;
        width: 100%;
        padding: 4px 15px 4px 15px;
        font-size: 12px;
        font-weight: bold;
        text-align: center;
        color: #ffffff;
        background-color: #e50914;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        transition: background-color 0.3s;
    }

    .btn-submit:hover {
        background-color: #b2070e;
    }

</style>
</head>
<body>
    <div class="container">
        <h1>List of Movies</h1>
        <div class="movie-list">
            <div class="movie">
                <div class="movie-image">
                    <img src="movie1.jpg" alt="Movie 1">
                </div>
                <div class="movie-details">
                    <div class="movie-title">Movie 1</div>
                    <div class="movie-category">Category: Action</div>
                    <div class="form-group">
                        <div class="form-label">Cinema:</div>
                        <input type="text" class="form-input-small" name="box1" value="">
                        <div class="form-label">Date:</div>
                        <input type="text" class="form-input-small" name="box2" value="">
                        <div class="form-label">Time:</div>
                        <input type="text" class="form-input-small" name="box3" value="">
                        <div class="form-label">Room:</div>
                        <input type="text" class="form-input-small" name="box4" value="">
                        <input type="submit" class="btn-submit" value="Assign">
                    </div>
                </div>
            </div>
            <div class="movie">
                <div class="movie-image">
                    <img src="movie2.jpg" alt="Movie 2">
                </div>
                <div class="movie-details">
                    <div class="movie-title">Movie 2</div>
                    <div class="movie-category">Category: Drama</div>
                    <div class="form-group">
                        <div class="form-label">Cinema:</div>
                        <input type="text" class="form-input-small" name="box1" value="">
                        <div class="form-label">Date:</div>
                        <input type="text" class="form-input-small" name="box2" value="">
                        <div class="form-label">Time:</div>
                        <input type="text" class="form-input-small" name="box3" value="">
                        <div class="form-label">Room:</div>
                        <input type="text" class="form-input-small" name="box4" value="">
                        <input type="submit" class="btn-submit" value="Assign">
                    </div>
                </div>
            </div>
            <!-- Add more here-->
        </div>
    </div>

</body>
</html>
