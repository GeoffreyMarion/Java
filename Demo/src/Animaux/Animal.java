package Animaux;

abstract class Animal {
	protected String Nom;

	public Animal(String nom) {
		Nom = nom;
	}
	
	abstract public void crier();

	public String getNom() {
		return Nom;
	}
}

