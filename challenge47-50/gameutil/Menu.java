package gameutil;
import java.util.Scanner;

class Menu{
	Scanner sc = new Scanner(System.in);
	
	// method to ask the user what size of game they want to have
	public int getGameSize(){
		System.out.println("Would you like to play a small, medium or large game?");
		String size = "";
		do {
			size = sc.nextLine();
			if (size.equalsIgnoreCase("small")){
				return 4;
			} else if (size.equalsIgnoreCase("medium")){
				return 6;
			}else if (size.equalsIgnoreCase("large")){
				return 8;
			}
		}while (true);
	}
	
	// method that prints out an introductory text
	public void printIntroTxt(){
		System.out.println("""
		You enter the Cavern of Objects, a maze of rooms filled with dangerous pits in search of the Fountain of Objects.
		Light is visible only in the entrance, and no other light is seen anywhere in the caverns.
		You must navigate the Caverns with your other senses.
		Find the Fountain of Objects, activate it, and return to the entrance.Look out for pits. 
		You will feel a breeze if a pit is in an adjacent room. If you enter a room with a pit, you will die
		Maelstroms are violent forces of sentient wind. Entering a room with one could transport you to any other location in the caverns. 
		You will be able to hear their growling and groaning in nearby rooms.
		Amaroks roam the caverns. Encountering one is certain death, but you can smell their rotten stench in nearby rooms.
		You carry with you a bow and a quiver of arrows. 
		You can use them to shoot monsters in the caverns but be warned: you have a limited supply
		""");
	}
	
	// method that explains how the game works
	public void getHelp(){
		
	}
	
}