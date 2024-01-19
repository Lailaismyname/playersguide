import java.util.Scanner;
import java.awt.*;

public class Main{	
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_GREEN = "\u001B[32m";
	
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		//ask user for target row and column
		System.out.println(ANSI_PURPLE + "Target row: " + ANSI_GREEN);
		int targetRow = Integer.parseInt(sc.nextLine());
		System.out.println(ANSI_PURPLE + "Target column: " + ANSI_GREEN);
		int targetColumn = Integer.parseInt(sc.nextLine());
		System.out.print(ANSI_RESET);
		
		// set deploy positions
		int[][] deploys = {
			{targetColumn -1, targetRow},
			{targetColumn, targetRow -1 },
			{targetColumn + 1, targetRow},
			{targetColumn, targetRow + 1}
		};
		
		for(int i = 0; i < 4; i++){
			System.out.println( "(" + deploys[i][0] + "," + deploys[i][1] + ")");
		}
		
		Toolkit.getDefaultToolkit().beep();
	}
}