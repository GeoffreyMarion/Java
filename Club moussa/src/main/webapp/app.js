var regexnom = /^[a-zA-Z\-]$/;
var regexdate = /^(0?[1-9]|[12][0-9]|3[01])[\/\-](0?[1-9]|1[012])[\/\-]\d{4}$/;
var regexemail= /^[\w-\.]+@(([\w-]))+[\.]+([\w-]){2,4}$/;
var regexphone= /^(((\+33\s)|0)[1-9]\s([0-9][0-9]\s){4})$/;
const nom=document.querySelector("#inputNom");
const prenom=document.querySelector("#inputPrenom");
const date=document.querySelector("#inputDate");
const civ = document.querySelector("input[name=civilite]:checked");
const email=document.querySelector("#inputEmail");
const tel=document.querySelector("#inputTelephone");
const mdp=document.querySelector("#inputMdp");
const mdp2=document.querySelector("#inputMdpC");
const lang=document.querySelector("select[name=langages]:checked");
var val= true;

document.querySelector("form").onsubmit = function(){
	 verif();
}

function verif() {
	val=true;
	if (nom.value.length == 0) {
		alert("Nom est vide");
		nom.focus();
		nom.style.backgroundColor = "red";
		val=false;
	}

	if (!regexnom.test(nom).value) {
		alert("Entrez nom valide!");
		nom.focus();
		nom.style.backgroundColor = "red";
		val=false;;
	}
	
	if (prenom.value.length == 0) {
		alert("Prenom est vide");
		prenom.focus();
		prenom.style.backgroundColor = "red";
		val=false;
	}
	if (!regexnom.test(prenom).value) {
		alert("Entrez prenom valide!");
		nom.focus();
		nom.style.backgroundColor = "red";
		val=false;
	}
	if (date.value.length == 0) {
		alert("Date est vide");
		date.focus();
		date.style.backgroundColor = "red";
		val=false;
	}
	if (!regexdate.test(date).value) {
		alert("Entrez une date valide!");
		date.focus();
		date.style.backgroundColor = "red";
		val=false;
	}
	if (email.value.length == 0) {
		alert("Email est vide");
		email.focus();
		email.style.backgroundColor = "red";
		val=false;
	}
	if (!regexemail.test(email).value) {
		alert("Entrez un mail valide!");
		email.focus();
		email.style.backgroundColor = "red";
		val=false;
	}
	if (tel.value.length == 0) {
		alert("Email est vide");
		tel.focus();
		tel.style.backgroundColor = "red";
		val=false;
	}
	if (!regexphone.test(tel).value) {
		alert("Entrez un numéro valide!");
		tel.focus();
		tel.style.backgroundColor = "red";
		val=false;
	}
	if (mdp.value.length == 0) {
		alert("Mot de passe est vide");
		mdp.focus();
		mdp.style.backgroundColor = "red";
		val=false;
	}
	if (mdp2.value.length == 0) {
		alert("Mot de passe est vide");
		mdp2.focus();
		mdp2.style.backgroundColor = "red";
		val=false;
	}
	if (mdp.value != mdp2.value) {
		alert("Mot de pass différents");
		mdp.focus();
		mdp.style.backgroundColor = "red";
		mdp2.style.backgroundColor = "red";
		val=false;
	}
	if (lang.value.length == 0) {
		alert("Pas de langues selectionnées");
		lang.focus();
		lang.style.backgroundColor = "red";
		val=false;
	}
	alert(val);
	if(val=true){return true;}
	else{return false;}
}
