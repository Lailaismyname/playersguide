import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String[] availableItems = {"1.Rope", "2.Torches", "3.Climbing Equipment", "4.Clean water", "5.Machete", "6.Canoe", "7.Food Supplies"};
		
		for(String item : availableItems){
			System.out.println(item);
		}
	
		System.out.print("What item do you want to see the price of? ");
		int selectedItem = Integer.parseInt(sc.nextLine());
		int gold;
		switch(selectedItem){
			case 1:
				gold = 10;
				break;
			case 2:
				gold = 15;
				break;	
			case 3:
				gold = 25;
				break;	
			case 4:
				gold = 1;
				break;	
			case 5:
				gold = 20;
				break;
			case 6:
				gold = 200;
				break;	
			case 7:
				gold = 1;
				break;	
			default:
				gold = 0;
				break;
		}
		
		if(gold > 0){
			System.out.println(availableItems[selectedItem] + " costs " + gold + " gold.");
		}else{
			System.out.println("Not a valid choice");
		}
	}
}