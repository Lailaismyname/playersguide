import java.util.Scanner;
public class Main {
	public static void main(String args[]){
			Scanner sc = new Scanner(System.in);
			
			System.out.println("What type of arrowhead do you want?");
			String arrowhead = sc.nextLine().toUpperCase();
			
			System.out.println("What type of fletcher do you want?");
			String fletcher = sc.nextLine().toUpperCase();
			
			System.out.println("How long do you want your shaft to be?");
			double shaftLength = Double.parseDouble(sc.nextLine());
		
			Arrow arrow = new Arrow(arrowhead, fletcher, shaftLength);
			System.out.println(arrow.getCost());
			}	
}
