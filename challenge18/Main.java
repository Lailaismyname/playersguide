import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int[] numbers = new int[5];
		System.out.println("Enter 5 numbers");
		for(int i = 0; i < 5; i++){
				numbers[i] = Integer.parseInt(sc.nextLine());
		}
		int[] numbersCopy = new int[5];
		for(int i = 0; i < 5; i++){
			numbersCopy[i] = numbers[i]; 
		}
		System.out.println("Original array");
		for(int nr: numbers){
			System.out.print(nr + " ");
		}
		System.out.println("\nCopied array");
		for(int nr: numbersCopy){
			System.out.print(nr + " ");
		}
	}
}