package nope;

public class Année {
	
	public static void main(String[] args) {
		int year=2000;
		if((year%4==0 && year%100!=0)||(year%400==0)){
			System.out.println("L'année "+ year +
					" est bissextile");
		}
		else {
			System.out.println("L'année "+ year +
					" est non bissextile");
		}
		
	}
	
}