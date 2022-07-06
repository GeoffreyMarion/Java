<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>about</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
</head>
<body>
<br>
<div class= container>
	<div class="row col-8" style=" border-color: #849460; border-style:solid;
border-width: 2px; padding: 10px;">
		<div class="row col-8">
			<div class="col-6">
				<b>Civilité:</b> ${civilite} ${prenom} ${nom}
			</div>
			<div class="col-6">
				<b>né/e le:</b> ${date}
			</div>
		</div>
		<div class="row col-8">
			<div class="col-6">
				<b>Email:</b> ${email}
			</div>
			<div class="col-6">
				<b>Telephone:</b> ${telephone}
			</div>
		</div>
		<div class="row col-8">
			<div class="col-12">
				<b>Langages:</b> ${langages}
			</div>
		</div>
	</div>
</div>
</body>
</html>