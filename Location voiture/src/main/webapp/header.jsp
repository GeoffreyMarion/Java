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
	
<c:url value="conducteur" var="conducteur" ></c:url>
<c:url value="vehicule" var="vehicule" ></c:url>
<c:url value="association" var="association" ></c:url>
	<body>
		<header class="p-3 bg-dark text-white">
		      <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
		        <a href="conducteur" class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
		          <img class="bi me-2" width="50" height="50" role="img" aria-label="Bootstrap" alt="logo" src="logo.jpg" style="border: solid 2px; border-radius: 25px;">
		        </a>
		
		        <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
		          <li><a href="${conducteur}" class="nav-link px-2 text-white">Conducteur</a></li>
		          <li><a href="${vehicule}" class="nav-link px-2 text-white">Vehicule</a></li>
		          <li><a href="${association}" class="nav-link px-2 text-white">Association</a></li>
		        </ul>
		    </div>
		  </header>
		  <br>
	</body>
</html>