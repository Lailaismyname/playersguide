import java.util.Scanner;
import java.util.ArrayList;

public class PackFunctionality{
	Arrow arrow = new Arrow();
	Bow bow = new Bow();
	Rope rope = new Rope();
	Water water = new Water();
	Food food = new Food();
	Sword sword = new Sword();
	Scanner sc = new Scanner(System.in);
	Pack pack = new Pack();
	// methods
	public void start(){
		// get pack settings and make pack
		makePack();
		showPackMenu();
	}
	
	public void makePack(){
		System.out.println("What max volume do you want your pack to have?");
		double volume = 0;
		double weight = 0;
		while(volume == 0){
			try{
				volume = Double.parseDouble(sc.nextLine());
			}catch(NumberFormatException err){
				System.out.println("Invalid option, What max volume do you want your pack to have?");
			}
		}
		System.out.println("What max weight do you want your pack to have?");
		while(weight == 0){
			try{
				weight = Double.parseDouble(sc.nextLine());
			}catch(NumberFormatException err){
				System.out.println("Invalid option, What max weight do you want your pack to have?");
			}
		}
		pack = new Pack(weight,volume);
	}
	
	
	public void showPackMenu(){
		System.out.println("-------------------------------------------");
		System.out.println("What do you want to do?");
		System.out.println("1. Add Items to pack");
		System.out.println("2. Show pack content");
		System.out.println("3. Show pack volume");
		System.out.println("4. Show pack weight");
		System.out.println("5. Show amount of items in pack");
		System.out.println("6. Show pack limits");
		System.out.println("7. Exit");
		System.out.println("-------------------------------------------");
		int selectedOption = -1;
		while(selectedOption < 0 || selectedOption > 7){
			try{
				selectedOption = Integer.parseInt(sc.nextLine());
			}catch(NumberFormatException err){
				System.out.println("Not a valid option");
			}
		}
		if(selectedOption == 1){
				addItemToPack();
		}else if(selectedOption == 2){
			showPackContent();
		}else if(selectedOption == 3){
			showPackVolume();
		}else if(selectedOption == 4){
			showPackWeight();
		}else if(selectedOption == 5){
			System.out.println(pack.items.size());
		}else if(selectedOption == 6){
			showPackLimits();
		}else if(selectedOption == 7){
			// exit 0 = succesful exit, 1 = unsuccesful exit, -1 unsuccesful with exception
			System.out.println("Have a nice day");
			System.exit(0);
		}
	}
	
	
	public void showPackContent(){
		for (InventoryItem item : pack.items){
			System.out.println(item.getName());
		}
		if(pack.items.size() == 0){
			System.out.println("Your pack is empty");
		}
		showPackMenu();
	}
	
	
	public void showPackVolume(){
		//TODO schrijf code om pack volume te laten zien
		System.out.println("Current volume: " + pack.getCurrentVolume());
		showPackMenu();
	}
	
	
	public void showPackWeight(){
		System.out.println("Current weight: " + pack.getCurrentWeight());
		showPackMenu();
	}
	
	
	public void showPackLimits(){
		System.out.println("Max Weight: " + pack.getMaxWeight() + "\nMax Volume: " + pack.getMaxVolume());
	}
	
	
	public void addItemToPack(){
		String[] items = {"arrow","bow","rope","water","food","sword"};
		int counter = 1;
		System.out.println("What item do you want to add to the pack?");
		for(String item : items){
			System.out.println(counter + ". " + item);
			counter++;
		}
		int selectedItem = -1;
		String itemAdded = "";
		while(selectedItem < 1 || selectedItem > 6){
			System.out.println("What would you like to add to your pack?");
			try{
				selectedItem = Integer.parseInt(sc.nextLine());
			}catch(NumberFormatException err){
				System.out.println("Not a valid option");
			}
		}
		String msg = " added to inventory.";
		switch(selectedItem){
			case 1:
				if(pack.addInventoryItem(arrow)){
					System.out.println(arrow.toString() + " added to pack");
				}
				break;
			case 2:
				if(pack.addInventoryItem(bow)){
					System.out.println(bow.toString() + " added to pack");
				}
				break;
			case 3:
				if(pack.addInventoryItem(rope)){
					System.out.println(rope.toString() + " added to pack");
				}
				break;
			case 4:
				if(pack.addInventoryItem(water)){
					System.out.println(water.toString() + " added to pack");
				}
				break;
			case 5:
				if(pack.addInventoryItem(food)){
					System.out.println(food.toString() + " added to pack");
				}
				break;
			case 6:
				if(pack.addInventoryItem(sword)){
					System.out.println(sword.toString() + " added to pack");
				}
				break;
			default:
				System.out.println("not a valid option");
				break;
		}
		System.out.println("1. add another item");
		System.out.println("2. Back to menu");
		int selectedOption = -1;
		while(selectedOption < 1 || selectedOption > 2){
			try{
				selectedOption = Integer.parseInt(sc.nextLine());
			}catch(NumberFormatException err){
				System.out.println("Not a valid option");
			}
		}
		if(selectedOption == 1){
			addItemToPack();
		}else if(selectedOption == 2){
			showPackMenu();
		}
	}
}