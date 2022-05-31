package Heritage;

public class Personne {
	protected String nom;
	protected String prenom;
	protected String email;
	protected int tel;
	protected double salaire;
	
	
	
	public Personne(String nom, String prenom, String email, int tel, double salaire) {
		
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.tel = tel;
		this.salaire = salaire;
	}

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getTel() {
		return tel;
	}
	public void setTel(int tel) {
		this.tel = tel;
	}
	public double getSalaire() {
		return salaire;
	}
	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}
	
	public double CalculSalaire() {
		return salaire;
	}
	@Override
	public String toString() {
		return "\n \t NOM : " +nom+ "\n \t PRENOM: " +prenom+ "\n \t Salaire: "+ salaire; 
	}
}