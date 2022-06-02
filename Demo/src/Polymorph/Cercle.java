package Polymorph;

public class Cercle extends Forme{
	private double Rayon;
	private double Pi=Math.PI;
	
	public Cercle(double rayon) {
		this.Rayon=rayon;
	}

	@Override
	protected double perimetre() {
		return Pi*Rayon*2;
	}

	@Override
	protected double surface() {
		return Pi*Rayon*Rayon;
	}

	@Override
	public String toString() {
		return "Cercle de Rayon=" + Rayon;
	}

}
