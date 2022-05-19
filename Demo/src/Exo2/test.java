package Exo2;

import java.util.ArrayList;

public class test {

	public static void main(String[] args) {
		

		Specialite Cours1 = new Specialite("JAVA/JEE");
		Specialite Cours2 = new Specialite("HTML/CSS");
		Specialite Cours3 = new Specialite("Gestion de projet");
		Specialite Cours4 = new Specialite("JS");
		Specialite Cours5 = new Specialite("PHP");
		ArrayList<Specialite> spe = new ArrayList<>();
		spe.add(Cours1);
		spe.add(Cours2);
		spe.add(Cours3);
		spe.add(Cours4);
		spe.add(Cours5);
		
		//System.out.println(spe);
		
		enseignant enseignant1 = new enseignant(Cours1,"Moussaka");
		enseignant enseignant2 = new enseignant(Cours1,"Moussi-Moussa");
		enseignant enseignant3 = new enseignant(Cours5,"Moussaillon");
		enseignant enseignant4 = new enseignant(Cours4,"Moussarobaz");
		ArrayList<enseignant> ens = new ArrayList<>();
		ens.add(enseignant1);
		ens.add(enseignant2);
		ens.add(enseignant3);
		ens.add(enseignant4);
		
		//System.out.println(ens);
		
		for (Specialite specialite : spe) {
			String print="";
			Boolean proff=false;
			for (enseignant enseignant : ens) {
				if(enseignant.getSpecialite()==specialite) {
					print+= enseignant +",";
					proff=true;
					}
				}
			if(proff==false){
				print= " Pas de proff";
				}
			System.out.println(specialite+":"+print);
			}
	}
}
