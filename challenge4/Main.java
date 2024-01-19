import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Bread is ready. \nWho is the bread for?");
		String person = scanner.nextLine();
		System.out.println("Noted :" + person + " got bread.");
	}
}