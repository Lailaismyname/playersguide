import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		// get input values from user
		System.out.println("How many provinces do you have?");
		int provinces = Integer.parseInt(scanner.nextLine());
		System.out.println("How many duchies do you have?");
		int duchies = Integer.parseInt(scanner.nextLine());
		System.out.println("How many estates do you have?");
		int estates = Integer.parseInt(scanner.nextLine());
		
		// calculate total score
		int total = (provinces * 6) + (duchies * 3) + estates;
		// output total score
		System.out.println("Total score: " + total);
	}
}