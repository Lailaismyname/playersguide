import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		askForNumber("Give number", 1, 10);
	}
	public static int askForNumber(String text, int min, int max){
		Scanner sc = new Scanner(System.in);
		int nr = -200000000;
		while(nr < min || nr > max ){	
			System.out.println(text);
			try{
				nr = Integer.parseInt(sc.nextLine());
			}catch(NumberFormatException e){
				System.out.println("Invalid input");
			}
		}
		return nr;
	}
}