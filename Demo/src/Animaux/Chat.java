package Animaux;

public class Chat extends Animal{
private int NiveauIndependance;
	
	public Chat(String nom) {
		super(nom);
	}

	@Override
	public void crier() {
		System.out.println("Miaou");
	}

}
