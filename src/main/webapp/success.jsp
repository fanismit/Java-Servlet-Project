<!DOCTYPE html>
<html>
<head>
    <title>Message Page</title>
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-color: #f2f2f2;
            font-family: Arial, sans-serif;
        }
        
        .center{
        	display: flex;
			justify-content: center;
		}
		
        .container {
            width: 600px;
            padding: 50px;
            margin: auto;
            background-color: #ffffff;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            border-radius: 5px;
        }
        
        h1 {
            text-align: center;
            color: #333333;
            font-size: 28px;
            margin-bottom: 20px;
        }
        
        p {
            text-align: center;
            color: #666666;
            font-size: 18px;
            margin-bottom: 30px;
        }
        
        .btn {
            display: inline-block;
            padding: 12px 24px;
            background-color: #4CAF50;
            color: #ffffff;
            text-decoration: none;
            font-size: 16px;
            border-radius: 4px;
            transition: background-color 0.3s;
        }
        
        .btn:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>${message_title}</h1>
        <p>${message_body}</p>
        <div class="center">
        	<a href="ContentAdmin/Actions/CreateMovie.jsp" class="btn">Go Back</a>
        </div>
    </div>
</body>
</html>
