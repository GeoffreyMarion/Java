package Polymorph;

public class Carre extends Forme{
	private double Cote;
	
	public Carre(double cote) {
		this.Cote=cote;
	}

	@Override
	protected double perimetre() {
		return Cote*4;
	}

	@Override
	protected double surface() {
		return Cote*Cote;
	}

	@Override
	public String toString() {
		return "Carre de Cote=" + Cote;
	}

}
