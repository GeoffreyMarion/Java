<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
		<title>header</title>
	</head>
<c:url value="index" var="index" ></c:url>
<c:url value="about" var="about" ></c:url>
<c:url value="contact" var="contact" ></c:url>
	<body>
		<header class="p-3 bg-dark text-white">
		      <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
		        <a href="index" class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
		          <img class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap" alt="logo" src="logo.png">
		        </a>
		
		        <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
		          <li><a href="${index}" class="nav-link px-2 text-secondary">Index</a></li>
		          <li><a href="${about}" class="nav-link px-2 text-white">About</a></li>
		          <li><a href="${contact}" class="nav-link px-2 text-white">Contact</a></li>
		        </ul>
		    </div>
		  </header>
	</body>
</html>