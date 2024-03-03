package challenge61;
import challenge61.util.Sieve;
import java.util.Scanner;


class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a predicate: ");
		int predicate = -1;
		do{
			try{
				predicate = Integer.parseInt(sc.nextLine());
			}catch (IllegalArgumentException err){
				System.out.println("Not a Number.");
			}
		} while(predicate < 1 || predicate > 3);
		Sieve sieve = new Sieve(predicate);
		while(true){
			try{
				int number = Integer.parseInt(sc.nextLine());
				System.out.println(sieve.isGood(number));
			} catch(NumberFormatException err){
				System.out.println("Not a number.");
			};
		}
	}
}