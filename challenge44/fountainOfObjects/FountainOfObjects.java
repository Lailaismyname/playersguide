package fountainOfObjects;
import java.util.HashMap;
import java.util.Scanner;

public class FountainOfObjects{
	// variables
	Scanner sc = new Scanner(System.in);
	String[][] rooms = { 
		{"Entrance/Exit","","Fountain Room",""}, 
		{"","","",""}, 
		{"","","",""}, 
		{"","","",""}, 
	};
	PlayerLocation playersCurrentLocation = new PlayerLocation(0,0);
	boolean isGameFinished = false;
	int headBangs = 0;
	
	
	// games main function
	public void play(){		
		do{
			System.out.println("You are in the room at " + playersCurrentLocation.toString());
			if(movePlayer(getNextPlayerMove())){
				giveHint();
			} else{
				System.out.println("You bang your head against the wall, there doesnt seem to be a door there!");
				headBangs++;
				if(headBangs > 10){
					// kijken of hier icanhazdadjoke api grapjes kan toevoegen.
					System.out.println("Where do sheep go to get their hair cut? The baa-baa shop.");
				}
			}
		}while(!isGameFinished);
	}
	
	
	// method to ask player where they want to go
	private String getNextPlayerMove(){
		System.out.print("What do you want to do? ");
		boolean isSelectionValid =  false;
		String nextPlayerMove = "";
		do{
			nextPlayerMove = sc.nextLine().toLowerCase();
			if (nextPlayerMove.contains("north")){
				nextPlayerMove = "north";
				isSelectionValid = true;
			}else if (nextPlayerMove.contains("south")){
				nextPlayerMove = "south";
				isSelectionValid = true;
			}else if (nextPlayerMove.contains("east")){
				nextPlayerMove = "east";
				isSelectionValid = true;
			}else if (nextPlayerMove.contains("west")){
				nextPlayerMove = "west";
				isSelectionValid = true;
			} else {
				isSelectionValid = false;
			}
		}while(!isSelectionValid);
		return nextPlayerMove;
	}
	
	// method to display hint to player
	private void giveHint(){
		System.out.println(rooms[playersCurrentLocation.getRow()][playersCurrentLocation.getColumn()]);
	}
	// method to move the player, returns true if move is made and false if not possible
	private boolean movePlayer(String move){
		try{
			switch (move){
				case "north":
					playersCurrentLocation.setRow(playersCurrentLocation.getRow() - 1);
					break;
				case "south":
					playersCurrentLocation.setRow(playersCurrentLocation.getRow() + 1);
					break;
				case "west":
					playersCurrentLocation.setColumn(playersCurrentLocation.getColumn() - 1);
					break;
				case "east":
					playersCurrentLocation.setColumn(playersCurrentLocation.getColumn() + 1);
					break;
				default: 
					System.out.println("Oops something went wrong");
					return false;
			}
			return true;
		}catch(IllegalArgumentException err){
			return false;
		}
	}
		
}

/* TODO
* de hints voor de fountain room fixen
* logica voor als game gewonnen is. Volgens mij gewoon bool van passedFountainRoom? en dan als ie terug is naar entrance dat checke
* /