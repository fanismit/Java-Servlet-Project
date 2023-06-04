<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
    <title>Add New Movie</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        .container {
            max-width: 400px;
            margin: 50px auto;
            padding: 20px;
            background-color: #ffffff;
            border-radius: 5px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        h1 {
            text-align: center;
        }

        label {
            display: block;
            margin-bottom: 8px;
            font-weight: bold;
        }

        input[type="text"],
        textarea {
            width: 100%;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 4px;
            box-sizing: border-box;
            resize: vertical;
        }

        .form-group {
            margin-bottom: 20px;
        }

        .form-group:last-child {
            margin-bottom: 0;
        }

        .btn-submit {
            display: block;
            width: 100%;
            padding: 10px;
            font-size: 16px;
            font-weight: bold;
            text-align: center;
            color: #ffffff;
            background-color: #e50914;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        .btn-submit:hover {
            background-color: #b2070e;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Add New Movie</h1>
        <form action="addMovie" method="POST">
            <div class="form-group">
                <label for="title">Title</label>
                <input type="text" id="title" name="title" required>
            </div>
             <div class="form-group">
                <label for="category">Category</label>
                <input type="text" id="category" name="category" required>
            </div>
            <div class="form-group">
                <label for="director">Director</label>
                <input type="text" id="director" name="director" required>
            </div>
            <div class="form-group">
                <label for="description">Description</label>
                <textarea id="description" name="description" rows="4" required></textarea>
            </div>
            <div class="form-group">
                <label for="image-url">Image URL</label>
                <input type="text" id="image-url" name="image-url" required>
            </div>
            <div class="form-group">
                <label for="movie-od">Movie Id</label>
                <input type="text" id="movieId" name="movieId" required>
            </div>
            <div class="form-group">
                <input type="submit" class="btn-submit" value="Add Movie">
            </div>
        </form>
    </div>
</body>
</html>
