<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>VTC:Vehicule</title>
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
					<th scope="col">Marque</th>
					<th scope="col">Modele</th>
					<th scope="col">Couleur</th>
					<th scope="col">Immatriculation</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${tableau}" var="vehicule">
					<tr>
						<td>${vehicule.id_v}</td>
						<td>${vehicule.marque}</td>
						<td>${vehicule.modele}</td>
						<td>${vehicule.couleur}</td>
						<td>${vehicule.immatriculation}</td>
						<td><a style="color: #000000;" href="vehicule?id=${vehicule.id_v}&action=modif"><i class="fa-solid fa-pen-to-square"></i></a>
						<a style="color: #000000;" href=# data-bs-toggle="modal" data-bs-target="#vtc_${vehicule.id_v}"><i class="fa-solid fa-trash-can"></i></a></td>
					</tr>
					<div class="modal fade" id="vtc_${vehicule.id_v}" tabindex="-1"
						aria-labelledby="exampleModalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title" id="exampleModalLabel">Suppression
										de vehicule</h5>
									<button type="button" class="btn-close" data-bs-dismiss="modal"
										aria-label="Close"></button>
								</div>
								<div class="modal-body">Voulez vous supprimer
									${vehicule.marque } - ${vehicule.modele } ?</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-secondary"
										data-bs-dismiss="modal">Annuler</button>
									<a href="vehicule?id=${vehicule.id_v}&action=suppr">
										<button type="button" class="btn btn-danger">Confirmer</button>
									</a>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</tbody>
		</table>
		<br>
		<form method="post">
			<div class="mb-3">
				<label for="InputMarque" class="form-label">Marque du vehicule</label> 
				<input type="text" class="form-control"
					id="InputMarque" aria-describedby="marqueHelp" name="marque">
			</div>
			<div class="mb-3">
				<label for="InputModele" class="form-label">Modele du vehicule</label>
				<input type="text" class="form-control"
					id="InputModele" name="modele">
			</div>
			<div class="mb-3">
				<label for="InputCouleur" class="form-label">Couleur du vehicule</label>
				<input type="text" class="form-control"
					id="InputCouleur" name="couleur">
			</div>
			<div class="mb-3">
				<label for="InputImmat" class="form-label">Immatriculation du vehicule</label>
				<input type="text" class="form-control"
					id="InputImmat" name="immatriculation">
			</div>
			<button type="submit" class="btn btn-dark">Ajouter vehicule</button>
		</form>
	</div>
</body>
</html>