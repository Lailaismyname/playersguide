import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter x value: ");
		int x = Integer.parseInt(sc.nextLine());
		System.out.print("Enter y value: ");
		int y = Integer.parseInt(sc.nextLine());
		
		String xDirection = x > 0 ? "east" : "west";
		String yDirection = y > 0 ? "North" : "South";
		
		System.out.println("The enemy is to the " + yDirection + xDirection);		
	}
}