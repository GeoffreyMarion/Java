package FOAD;

public class Ville {
private String nom;
private int departement;

@Override
public String toString() {
	return "Ville [nom=" + nom + ", departement=" + departement + "]";
}

public Ville() {
	this.nom = "Paris";
	this.departement = 75000;
}

public Ville(String nom, int departement) {
	this.nom = nom;
	this.departement = departement;
}


}
