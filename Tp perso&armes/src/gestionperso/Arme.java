package gestionperso;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Arme{
	
	private String noma;
	private TypeArme typea=giveArme();
	private int pow;
	Scanner scw = new Scanner(System.in);
	
	public ArrayList<Arme> armes = new ArrayList<Arme>();
	
	public static TypeArme giveArme() {
	Random rarm = new Random();
	TypeArme arm= TypeArme.values()[rarm.nextInt(TypeArme.values().length)];
	return arm;
	}
	
	public Arme(String nomar) {
		this.noma = nomar;
		switch(typea){
		case pistolet:
			pow=5;
			break;
		case épée:
			pow=4;
			break;
		case masse:
			pow=3;
			break;
		case couteau:
			pow=2;
			break;
		case désarmé:
			pow=1;
			this.noma="mains";
			break;
		}
		armes.add(this);
	}
	
	public String getNoma() {
		return noma;
	}
	public int getPow() {
		return pow;
	}
	
	public void printarme() {
		for (Arme arme : armes) {System.out.println("\t "+noma+" "+typea+" "+pow);}	
	}
	public Arme testarme() {
		String sarme = scw.nextLine();
		for (Arme arme : armes) if(arme.noma==sarme){System.out.println(arme.noma); return arme;}
		return null;	
	}


	@Override
	public String toString() {
		if (this.noma=="mains") {
			return "Arme \n\tNom_Arme= " + noma;
		}
		else {return "Arme \n\tNom_Arme= " + noma + ", Type_Arme= " + typea + ", Puissance= " + pow;}
	}

}
