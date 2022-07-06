<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
</head>
<body>
<br>
<div class= container>
<form class="row g-3 col-8" method="post" action="<% request.getContextPath(); %> membre">
  <div class="col-md-6">
    <label for="inputPrenom" class="form-label">Prenom</label>
    <input type="text" class="form-control" id="inputPrenom" name="prenom">
  </div>
  <div class="col-md-6">
    <label for="inputNom" class="form-label">Nom</label>
    <input type="text" class="form-control" id="inputNom" name="nom">
  </div>
  <div class="col-md-6">
    <label for="inputDate" class="form-label">Date de naissance</label>
    <input type="date" class="form-control" id="inputDate" name="date">
  </div>
  <div class="col-md-6">
    <fieldset class="col-md-12">
    <label for="input" class="form-label">Votre civilité</label>
    <div class="col-md-6">
      <input type="radio" id="homme" name="civilite" value="M."
             checked>
      <label for="homme">Homme</label>
    </div>
    <div class="col-md-6">
      <input type="radio" id="femme" name="civilite" value="Mme.">
      <label for="femme">Femme</label>
    </div>
</fieldset>
  </div>
   <div class="col-6">
    <label for="inputEmail" class="form-label">Email</label>
    <input type="email" class="form-control" id="inputEmail" placeholder="" name="email">
  </div>
  <div class="col-6">
    <label for="inputTelephone" class="form-label">Téléphone</label>
    <input type="tel" class="form-control" id="inputTelephone" placeholder="" name="telephone">
  </div>
  <div class="col-6">
    <label for="inputMdp" class="form-label">Mot de passe</label>
    <input type="password" class="form-control" id="inputMdp" name="mdp">
  </div>
  <div class="col-6">
    <label for="inputMdp" class="form-label">Confirmation</label>
    <input type="password" class="form-control" id="inputMdpC" name="mdpc">
  </div>
  <div class="col-6">
<label class="col-12" for="langages">Vos langages:</label>
<select class="col-12" name="langages" id="langages" multiple>
  <option value="html">HTML</option>
  <option value="css">CSS</option>
  <option value="js">JS</option>
    <option value="jqery">Jqery</option>
  <option value="java">JAVA</option>
</select>
</div>
  
  <div class="col-12">
    <button type="submit" class="btn btn-dark">Sign in</button>
  </div>
</form>
</div>
<script src="app.js"></script>
</body>
</html>