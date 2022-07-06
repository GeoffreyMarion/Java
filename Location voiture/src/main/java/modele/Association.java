package modele;

public class Association {
	private int id_a;
	private Conducteur conducteur;
	private Vehicule vehicule;
	
	public Association(int id_a, Conducteur conducteur, Vehicule vehicule) {
		this.id_a = id_a;
		this.conducteur = conducteur;
		this.vehicule = vehicule;
	}
	
	public Association(Conducteur conducteur, Vehicule vehicule) {
		this.conducteur = conducteur;
		this.vehicule = vehicule;
	}

	public int getId_a() {
		return id_a;
	}
	public void setId_a(int id) {
		this.id_a = id;
	}
	public Conducteur getConducteur() {
		return conducteur;
	}
	public void setConducteur(Conducteur conducteur) {
		this.conducteur = conducteur;
	}
	public Vehicule getVehicule() {
		return vehicule;
	}
	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}
	
	
}
