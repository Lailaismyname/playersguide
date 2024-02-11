/* TODO 
* ENUMS gebruiken
* Rommel opruimen
* kijken of die if/else beter kunnen
* checken of movePlayer nog werkt met grotere grid.
*/

package fountainOfObjects;
import java.util.HashMap;
import java.util.Scanner;

public class FountainOfObjects{
	// color pallete 1: Bright 
	final String ANSI_EMINENCE = new TerminalColor(99,29,118).toString(); 
	final String ANSI_FLAX = new TerminalColor(243,222,138).toString();
	final String ANSI_CORALPINK = new TerminalColor(235,148,134).toString();
	final String ANSI_COOLGRAY = new TerminalColor(126,127,154).toString();
	final String ANSI_SEASALT = new TerminalColor(249,248,248).toString();
	
	// color pallete 2: 70's vibe
	final String ANSI_BROWN = new TerminalColor(129,52,5).toString(); 
	final String ANSI_SYRACUSE = new TerminalColor(212,81,19).toString();
	final String ANSI_CARROT = new TerminalColor(249,160,63).toString();
	final String ANSI_PEACHYELLOW = new TerminalColor(248,221,164).toString();
	final String ANSI_TEAGREEN = new TerminalColor(221,249,193).toString();
	// reset color
	final String ANSI_RESET = TerminalColor.getResetColor();
	
	Scanner sc = new Scanner(System.in);
	PlayerLocation playersCurrentLocation = new PlayerLocation(0,0);
	boolean isGameFinished = false;
	boolean isFountainActivated = false;
	
	WorldMap worldMap = new WorldMap(4,4);
	int invalidMoveCounter = 0;
	
	int fountainRow = worldMap.getFountainRoomRow();
	int fountainColumn = worldMap.getFountainRoomColumn();
	
	
	// games main function
	public void play(){		
		AsciiArt temple = new AsciiArt();
		temple.printTemple(ANSI_TEAGREEN, ANSI_RESET);
		DadJoke dadJoke = new DadJoke();
		do{
			System.out.println(ANSI_BROWN + "You are in the room at " + playersCurrentLocation.toString() + ANSI_RESET);
			giveHint();
			if(!movePlayer(getNextPlayerMove())){
				System.out.println(ANSI_TEAGREEN + "You bang your head against the wall, there doesnt seem to be a door there!" + ANSI_RESET);
				invalidMoveCounter++;
				if(invalidMoveCounter > 10){
					System.out.println(ANSI_TEAGREEN + dadJoke.getDadJoke() + ANSI_RESET);
				}
			}
		checkForWin();
		}while(!isGameFinished);
	}
	
	
	// method to ask player where they want to go
	private String getNextPlayerMove(){
		System.out.print(ANSI_CARROT + "What do you want to do? " + ANSI_RESET);
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
			} else if(nextPlayerMove.contains("activate") && nextPlayerMove.contains("fountain")){
				if(playersCurrentLocation.getRow() == fountainRow && playersCurrentLocation.getColumn() == fountainColumn){
					nextPlayerMove = "activateFountain";
					isSelectionValid = true;
				}else{
					System.out.println("You are not in the fountain room silly cat!");
					isSelectionValid = false;
				}
			}else if(nextPlayerMove.contains("deactivate") && nextPlayerMove.contains("fountain")){
				if(playersCurrentLocation.getRow() == fountainRow && 
				playersCurrentLocation.getColumn() == fountainColumn){
					nextPlayerMove = "activateFountain";
					isSelectionValid = true;
				}else{
					System.out.println("You are not in the fountain room silly cat!");
					isSelectionValid = false;
				}
			} else{
				isSelectionValid = false;
			}
		}while(!isSelectionValid);
		return nextPlayerMove;
	}
	
	
	// method to display hint to player
	private void giveHint(){
		System.out.println(ANSI_SYRACUSE + worldMap.getRoomInfo(playersCurrentLocation.getRow(), playersCurrentLocation.getColumn(), isFountainActivated) + ANSI_RESET);
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
				case "activateFountain":
					isFountainActivated = true;
					break;
				case "deactivateFountain":
					isFountainActivated = false;
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
	
	
	private void checkForWin(){
		if(playersCurrentLocation.getRow() == 0 && playersCurrentLocation.getColumn() == 0 && isFountainActivated){
			System.out.println(ANSI_SYRACUSE + "You have activated the fountain and succesfully found your way back through the darkness." + ANSI_RESET);
			isGameFinished = true;
		}
	}
		
}