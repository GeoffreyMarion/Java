package nope;

import java.util.*;

public class Palindrome {

	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	String mot=sc.next();
	StringBuilder inversion =new StringBuilder(mot);
	if (mot.equals(inversion.reverse().toString())) {
		System.out.println("pal");
	}
	else {
		System.out.println("pas pal");
	}
	}
}
