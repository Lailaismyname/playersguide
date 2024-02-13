/* TODO 
* rooms adjacent van pit en amarokt plaatsen
* game stoppen als speler in de pit valt
*/
package fountainOfObjects;
import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class FountainOfObjects{	
	private final int gridSize;
	WorldMap worldMap;
	PlayerLocation playersCurrentLocation;
	
	int fountainRow;
	int fountainColumn;
	public FountainOfObjects(){
		gridSize = getGameSize();
		worldMap = new WorldMap(gridSize);
		worldMap.setRooms();
		playersCurrentLocation = new PlayerLocation(0,0,gridSize);
	}
	// color pallete 2: 70's vibe
	final String ANSI_BROWN = new TerminalColor(129,52,5).toString(); 
	final String ANSI_SYRACUSE = new TerminalColor(212,81,19).toString();
	final String ANSI_CARROT = new TerminalColor(249,160,63).toString();
	final String ANSI_PEACHYELLOW = new TerminalColor(248,221,164).toString();
	final String ANSI_TEAGREEN = new TerminalColor(221,249,193).toString();
	// reset color
	final String ANSI_RESET = TerminalColor.getResetColor();
	
	Scanner sc = new Scanner(System.in);
	boolean isGameFinished = false;
	boolean isFountainActivated = false;
	
	
	int invalidMoveCounter = 0;
	
	
	
	
	// games main function
	public void play(){		
		AsciiArt temple = new AsciiArt();
		temple.printGameTitle(ANSI_TEAGREEN, ANSI_RESET);
		DadJoke dadJoke = new DadJoke();
		do{
			System.out.println(ANSI_BROWN + "You are in the room at " + playersCurrentLocation.toString() + ANSI_RESET);
			giveHint();
			if(!movePlayer(getNextPlayerMove())){
				System.out.println(ANSI_TEAGREEN + "You bang your head against the wall, there doesnt seem to be a door there!" + ANSI_RESET);
				invalidMoveCounter++;
				if(invalidMoveCounter > 2){
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
			String[] commandList = nextPlayerMove.split(" ");				
				ArrayList<String> validCommands = new ArrayList<>(List.of("north", "south", "west", "east", "activate", "deactivate", "fountain"));
					String selectedCommand = "";
					for(String command : commandList){
						if(validCommands.contains(command)){
							selectedCommand += command;
						}
					}
					
					switch(selectedCommand){
						case "north":
						case "west":
						case "south":
						case "east":
						case "activatefountain":
						case "deactivatefountain":
							isSelectionValid = true;
							nextPlayerMove = selectedCommand;
							break;
						default:
							isSelectionValid = false;
					}
			if(!isSelectionValid){
				System.out.println(ANSI_CARROT + "Invalid option, try again" + ANSI_RESET);
			}
		}while(!isSelectionValid);
		return nextPlayerMove;
	}
	
	
	// method to display hint to player
	private void giveHint(){
		String hint = worldMap.getRoomInfo(playersCurrentLocation.getRow(), playersCurrentLocation.getColumn(), isFountainActivated);
		if(!hint.equals("")){
			System.out.println(ANSI_SYRACUSE + hint + ANSI_RESET);
		}
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
				case "activatefountain":
					isFountainActivated = true;
					break;
				case "deactivatefountain":
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
	
	
	private int getGameSize(){
		Scanner sc = new Scanner(System.in);
		System.out.println(ANSI_PEACHYELLOW + "Would you like to play a small, medium or large game?" + ANSI_RESET);
		ArrayList<String> options = new ArrayList<>(List.of("small","medium","large"));
		String gameSize = "";
		do{
			gameSize = sc.nextLine();
		}while(!options.contains(gameSize));
		switch (gameSize){
			case "small":
				return 4;
			case "medium":
				return 6;
			case "large":
				return 8;
			default:
				return 4;
		}
	}
		
}
