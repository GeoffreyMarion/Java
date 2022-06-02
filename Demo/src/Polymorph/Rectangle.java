package Polymorph;

public class Rectangle extends Forme{
	private double Longueur;
	private double Largeur;
	
	public Rectangle(double longueur,double largeur) {
		this.Longueur=longueur;
		this.Largeur=largeur;
	}

	@Override
	protected double perimetre() {
		return (Longueur+Largeur)*2;
	}

	@Override
	protected double surface() {
		return Longueur*Largeur;
	}

	@Override
	public String toString() {
		return "Rectangle de Longueur=" + Longueur + " et de Largeur=" + Largeur;
	}

}