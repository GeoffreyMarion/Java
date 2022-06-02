package Polymorph;

import java.util.ArrayList;

public class MainForm {

	public static void main(String[] args) {
		Forme carre = new Carre(5);
		Forme cercle = new Cercle(10);
		Forme rect = new Rectangle(5, 10);
		ArrayList<Forme> formes = new ArrayList<>();
		formes.add(rect);
		formes.add(cercle);
		formes.add(carre);
		System.out.println("Le périmétre: ");
		for (Forme forme : formes) {
		System.out.println("\t "+forme.toString()+" est de "+forme.perimetre());
		}
		System.out.println("La surface: ");
		for (Forme forme : formes) {
		System.out.println("\t "+forme.toString()+" est de "+forme.surface());
		}

	}

}
