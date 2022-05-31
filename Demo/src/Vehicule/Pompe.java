package Vehicule;

public class Pompe {
	private String typeCarburant;
	private int contenance;
	private int contenu;
	
	
	
	public Pompe(String typeCarburant, int contenance, int contenu) {
		super();
		this.typeCarburant = typeCarburant;
		this.contenance = contenance;
		this.contenu = contenu;
	}
	public String getTypeCarburant() {
		return typeCarburant;
	}
	public void setTypeCarburant(String typeCarburant) {
		this.typeCarburant = typeCarburant;
	}
	public int getContenance() {
		return contenance;
	}
	public void setContenance(int contenance) {
		this.contenance = contenance;
	}
	public int getContenu() {
		return contenu;
	}
	public void setContenu(int contenu) {
		this.contenu = contenu;
	}
	
	
}
