<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>VTC:Conducteurs</title>
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
					<th scope="col">Prenom</th>
					<th scope="col">Nom</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${tableau}" var="conducteur">
					<tr>
						<td>${conducteur.id_c}</td>
						<td>${conducteur.nom}</td>
						<td>${conducteur.prenom}</td>
						<td><a style="color: #000000;" href="conducteur?id=${conducteur.id_c}&action=modif"><i class="fa-solid fa-pen-to-square"></i></a>
						<a style="color: #000000;" href=# data-bs-toggle="modal" data-bs-target="#vtc_${conducteur.id_c}"><i class="fa-solid fa-trash-can"></i></a></td>
					</tr>
					<div class="modal fade" id="vtc_${conducteur.id_c}" tabindex="-1"
						aria-labelledby="exampleModalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title" id="exampleModalLabel">Suppression
										de conducteur</h5>
									<button type="button" class="btn-close" data-bs-dismiss="modal"
										aria-label="Close"></button>
								</div>
								<div class="modal-body">Voulez vous supprimer
									${conducteur.nom } - ${conducteur.prenom } ?</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-secondary"
										data-bs-dismiss="modal">Annuler</button>
									<a href="conducteur?id=${conducteur.id_c}&action=suppr">
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
		<c:if test="${ajout}">
			<div class="msg">
				<div class="alert alert-success" role="alert">Ajout d'un
					nouveau conducteur !!</div>
			</div>
		</c:if>
		<script type="text/javascript">
			setTimeout(function(){document.querySelector(".msg").innerHTML=""},5000)
		</script>
		
		<form method="post">
			<div class="mb-3">
				<label for="InputNom" class="form-label">Nom du conducteur</label> 
				<input type="text" class="form-control"
					id="InputNom" name="nom" value="${conducteur.nom}">
			</div>
			<div class="mb-3">
				<label for="InputPrenom" class="form-label">Prenom du conducteur</label>
				<input type="text" class="form-control"
					id="InputPrenom" name="prenom" value="${conducteur.prenom}">
			</div>
			<button type="submit" class="btn btn-dark">Ajouter conducteur</button>
		</form>
	</div>
</body>
</html>