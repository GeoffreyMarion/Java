package gestionperso;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Arme{
	Random rf = new Random();
	private int maxf=5;
	private int minf=1;
	int pow= rf.nextInt(maxf-minf+1) + minf;
	int pow2= rf.nextInt(maxf-minf+1) + minf;
	int pow3= rf.nextInt(maxf-minf+1) + minf;
	private TypeArme typea=giveArme();
	private int vio;
	private int pre;
	private int dex;
	
	public ArrayList<Arme> armes = new ArrayList<Arme>();
	
	public static TypeArme giveArme() {
	Random rarm = new Random();
	TypeArme arm= TypeArme.values()[rarm.nextInt(TypeArme.values().length)];
	return arm;
	}
	
	public Arme() {
		stat_arme();
		armes.add(this);
	}
	
	public void setTypea(TypeArme typea) {
		this.typea = typea;
	}
	public TypeArme getTypea() {
		return typea;
	}
	public int getVio() {
		return vio;
	}
	public int getPre() {
		return pre;
	}
	public int getDex() {
		return dex;
	}
	public void stat_arme() {
		switch(typea){
		case pistolet:
			vio=2+pow;
			pre=3+pow2;
			dex=1+pow3;
			break;
		case épée:
			vio=2+pow;
			pre=2+pow2;
			dex=2+pow3;
			break;
		case masse:
			vio=3+pow;
			pre=1+pow2;
			dex=2+pow3;
			break;
		case couteau:
			vio=1+pow;
			pre=2+pow2;
			dex=3+pow3;
			break;
		case désarmé:
			vio=1+pow;
			pre=1+pow2;
			dex=1+pow3;
			break;
		}
	}

	@Override
	public String toString() {
		if (this.typea==TypeArme.désarmé) {
			return "Arme="+ typea;
		}
		else {return "Arme="+ typea + " | Violence= " + vio+ " | Précision= " + pre+ " | Dextérité= " + dex;}
	}

}
