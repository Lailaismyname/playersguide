import java.util.Scanner;
public class Main {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		System.out.println("1. Get Elite Arrow \n2. Get Beginner Arrow \n3. Get Marksman Arrow \n4. Make your own Arrow");
		int choice = Integer.parseInt(sc.nextLine());
		Arrow arrow = createBeginnerArrow();
		if(choice == 1){
			arrow = createEliteArrow();
		}else if(choice == 2){	
			arrow = createBeginnerArrow();
		}else if(choice == 3){
			arrow = createMarksmanArrow();
		}else if(choice ==  4){
			arrow = createCustomArrow(sc);
		}else{
			System.out.println("Invalid choice");
		}
		System.out.println(arrow.getCost());
}
public static Arrow createEliteArrow(){
		Arrow eliteArrow = new Arrow("STEEL","PLASTIC",95);
		return eliteArrow;
	}
	public static Arrow createBeginnerArrow(){
		Arrow beginnersArrow = new Arrow("WOOD","GOOSE_FEATHERS",75);
		return beginnersArrow;
	}
	public static Arrow createMarksmanArrow(){
		Arrow marksmanArrow = new Arrow("STEEL","GOOSE_FEATHERS",65);
		return marksmanArrow;
	}
	public static Arrow createCustomArrow(Scanner sc){
			System.out.println("Do you want a steel, wood or obsidian arrowhead?");
			String arrowhead = sc.nextLine().toUpperCase();
			
			System.out.println("Do you want a plastic, duck feather or goose feather fletcher?");
			String fletcher = sc.nextLine().toUpperCase();
			
			System.out.println("How long do you want your shaft to be?");
			double shaftLength = Double.parseDouble(sc.nextLine());
		
			Arrow customArrow = new Arrow(arrowhead, fletcher, shaftLength);

		return customArrow;
	}
}