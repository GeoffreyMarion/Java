package Animaux;

public class Chien extends Animal{
	private int NiveauFidelite;
	
	public Chien(String nom) {
		super(nom);
	}

	@Override
	public void crier() {
		System.out.println("Waff");
		
	}

}
