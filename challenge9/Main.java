import java.util.Scanner;
public class Main{
	public static void main(String args[]){
		System.out.println("How many eggs did you collect today? ");
			Scanner scanner = new Scanner(System.in);
			int input = scanner.nextInt();
			double duckbearEggs =  (double)input % 4;
			double sisterEggs = input / 4;
			System.out.println("Each sister gets " + (int)sisterEggs + " eggs and the duckbear gets " +(int)duckbearEggs  + "  eggs.");
	}
}
 //If there are 6 eggs, the duckbear gets 2 and the sisters get 1. If there are 7 eggs the duckbear gets 3 eegs and the sisters get 1
