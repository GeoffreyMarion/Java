package nope;

import java.util.*;

public class semaine {
	
	public static void main(String[] args) {
		ArrayList<String> semaine = new ArrayList<> (
		Arrays.asList("lundi", "mar", "mercredi", "jeudi", "vendredi", "samedi", "dimanc"));
		
		System.out.println(semaine);
		System.out.println(semaine.size());
		System.out.println(semaine.remove(semaine.size()-1));
		System.out.println(semaine);
	}
}