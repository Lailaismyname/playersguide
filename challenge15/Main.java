import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		System.out.println("What is your name? ");
		String name = sc.nextLine().toLowerCase();
		String[] availableItems = {"1.Rope", "2.Torches", "3.Climbing Equipment", "4.Clean water", "5.Machete", "6.Canoe", "7.Food Supplies"};
		
		for(String item : availableItems){
			System.out.println(item);
		}
	
		System.out.print("What item do you want to see the price of? ");
		int selectedItem = Integer.parseInt(sc.nextLine());
		System.out.println();
		int price;
		switch(selectedItem){
			case 1:
				price = 10;
				break;
			case 2:
				price = 15;
				break;	
			case 3:
				price = 25;
				break;	
			case 4:
				price = 1;
				break;	
			case 5:
				price = 20;
				break;
			case 6:
				price = 200;
				break;	
			case 7:
				price = 1;
				break;	
			default:
				price = 0;
				break;
		}
		
		if(price > 0){
			if(name.equals("laila")){
				price = price / 2;
			}
			System.out.println(availableItems[selectedItem].substring(2) + " costs " + price + " gold.");
		}else{
			System.out.println("Not a valid choice");
		}
	}
}