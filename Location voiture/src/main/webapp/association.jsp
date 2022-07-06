<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>VTC:Associaton</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css"
	integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
<c:import url="header.jsp"></c:import>
	<div class="container">
		<table class="table">
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">Conducteur</th>
					<th scope="col">Vehicule</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${tableau_a}" var="association">
					<tr>
						<td>${association.id_a}</td>
						<td>${association.conducteur.prenom}
							${association.conducteur.nom} <br>${association.conducteur.id_c}</td>
						<td>${association.vehicule.marque}
							${association.vehicule.modele} <br>${association.vehicule.id_v}</td>
						<td><a style="color: #000000;"
							href="association?id_a=${association.id_a}&action=modif"><i
								class="fa-solid fa-pen-to-square"></i></a> <a
							style="color: #000000;"
							href="association?id_a=${association.id_a}&action=suppr"><i
								class="fa-solid fa-trash-can"></i></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<form method="post">
		<div class="input-group mb-3">
			<div class="input-group-prepend">
				<label class="input-group-text" for="inputGroupSelect01">Conducteur</label>
			</div>
			<select class="custom-select" id="inputGroupSelect01" name="id_c">
				<option selected>Choose...</option>
				<c:forEach items="${tableau_c}" var="conducteur">
				<option value="${conducteur.id_c}"<c:out value="${conducteur.id_c}"></c:out>>${conducteur.prenom} ${conducteur.nom}</option>
				</c:forEach>
			</select>
		</div>
		<br>
		<div class="input-group mb-3">
			<div class="input-group-prepend">
				<label class="input-group-text" for="inputGroupSelect02">Vehicule</label>
			</div>
			<select class="custom-select" id="inputGroupSelect02" name="id_v">
				<option selected>Choose...</option>
				<c:forEach items="${tableau_v}" var="vehicule">
				<option value="${vehicule.id_v}"<c:out value="${vehicule.id_v}"></c:out>>${vehicule.marque} ${vehicule.modele}</option>
				</c:forEach>
			</select>
		</div>
		</form>
		<br>
		<button type="submit" class="btn btn-dark">Ajouter association</button>
	</div>
</body>
</html>