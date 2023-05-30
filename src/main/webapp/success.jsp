<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>YES</title>
  <style>
    body {
    	font-family: Arial, sans-serif;
    	margin: 0;
    	padding: 0;
    }
    
    header {
    	background-color: #333;
    	color: #fff;
    	padding: 10px 0px 10px 50px;
    	text-align: left;
    }
    
    nav {
    	background-color: #f4f4f4;
    	padding: 10px 0px 10px 50px;
    }
    
    nav ul {
    	list-style-type: none;
    	margin: 0;
    	padding: 0;
    }
    
    nav ul li {
    	display: inline-block;
    	margin-right: 10px;
    }
    
    nav ul li a {
	    color: #333;
	    text-decoration: none;
	    padding: 5px;
	}
    
    section {
    	height:100%;
    	background: linear-gradient(0deg, rgba(0, 0, 0, 0.6), rgba(0, 0, 0, 0.6)), url("images/wp10615910.jpg");
    	background-size:cover;
    	height:84vh;
    }
    section h1{
    	color: #fff;
    	padding-top:80px;
    	margin: 0px;
    	text-align: center;
    	font-size: 50px;
    	
    }
    section p{
    	color: #fff;
    	padding-top:20px;
    	text-align: center;
    	font-size: 20px;
    	width: 460px;
    	margin: 0 auto;
    	line-height: 28px;
    	
    }
    .dropdown {
 		position: relative;
  		display: inline-block;
	}

	.dropdown-content {
		display: none;
		position: absolute;
		background-color: #f9f9f9;
		min-width: 260px;
		box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
		z-index: 1;
	}

	.dropdown-content a {
  		color: black;
  		padding: 12px 16px;
  		text-decoration: none;
  		display: block;
	}

	.dropdown:hover .dropdown-content {
  		display: block;
	}
	
	.dropdown:hover svg{
		-webkit-transform: scaleY(-1);
  		transform: scaleY(-1);
  	}
	.flexbox{
		display: flex;
		flex-direction:row;
		align-items: center;
	}
  </style>
</head>
<body>
  <header>
    <h1>Κεντρικό Μενού</h1>
  </header>
  
  <nav>
    <ul>
      <li><a href="/Tickets-Java-Web-Project/">Αρχική</a></li>
      <li class="dropdown">
        <div class="flexbox"><a class="dropbtn">Σύνδεση</a><?xml version="1.0" encoding="iso-8859-1"?>
<svg fill="#000000" height="20px" width="10px" version="1.1" id="Layer_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" 
	 viewBox="0 0 330 330" xml:space="preserve">
<path id="XMLID_225_" d="M325.607,79.393c-5.857-5.857-15.355-5.858-21.213,0.001l-139.39,139.393L25.607,79.393
	c-5.857-5.857-15.355-5.858-21.213,0.001c-5.858,5.858-5.858,15.355,0,21.213l150.004,150c2.813,2.813,6.628,4.393,10.606,4.393
	s7.794-1.581,10.606-4.394l149.996-150C331.465,94.749,331.465,85.251,325.607,79.393z"/>
</svg></div>
        <div class="dropdown-content">
          <a href="#">Πελάτες</a>
          <a href="#">Διαχειριστές Περιεχομένου</a>
          <a href="#">Διαχειριστές Εφαρμογής</a>
        </div>
      </li>
    </ul>
  </nav>
  
  <section>
  <h1>Καλώς ήρθατε</h1>
  <p>Τα κατάφερα</p>
  
  </section>
</body>
</html>
