/* TODO 
* help functie toevoegen, en arrow functionaliteit maken
* 
*/
package fountainOfObjects;
import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class FountainOfObjects{	
	private final int gridSize;
	WorldMap worldMap;
	Location playersCurrentLocation;
	
	int fountainRow;
	int fountainColumn;
	public FountainOfObjects(){
		gridSize = getGameSize();
		worldMap = new WorldMap(gridSize);
		worldMap.setRooms();
		playersCurrentLocation = new Location(0,0,gridSize);
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
	
	// games main function
	public void play(){	
		// print worldMap for debugging
		for(int i = 0; i < gridSize; i++){
			for(int j = 0; j < gridSize; j++){
				System.out.print("|");
				System.out.print(worldMap.worldMap[i][j]);
				System.out.print("|");
			}
			System.out.println("----------------------------------------------------");
		}
		// einde debug statements
		
		AsciiArt titleScreen = new AsciiArt();
		titleScreen.printGameTitle(ANSI_TEAGREEN, ANSI_RESET);
		do{
			System.out.println(ANSI_BROWN + "You are in the room at " + playersCurrentLocation.toString() + ANSI_RESET);
			giveHint();
			if(!movePlayer(getNextPlayerMove())){
				System.out.println(ANSI_TEAGREEN + "You bang your head against the wall, there doesnt seem to be a door there!" + ANSI_RESET);
			}
			if(worldMap.isEvent(playersCurrentLocation.getRow(),playersCurrentLocation.getColumn()).equals("pit") || worldMap.isEvent(playersCurrentLocation.getRow(),playersCurrentLocation.getColumn()).equals("amarokt")){
				System.out.println(ANSI_TEAGREEN + "You died, GAME OVER!" + ANSI_RESET);
				System.exit(0);
			}else if(worldMap.isEvent(playersCurrentLocation.getRow(),playersCurrentLocation.getColumn()).equals("maelstrom")){
				worldMap.relocateMaelstrom(playersCurrentLocation.getRow(),playersCurrentLocation.getColumn());
				relocatePlayer();
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
			String command = nextPlayerMove.replace(" ","");				
				ArrayList<String> validCommands = new ArrayList<>(List.of("movenorth", "movesouth", "movewest", "moveeast", "activate", "deactivate", "fountain", "shootnorth","shooteast","shootwest","shootsouth"));
					
					switch(command){
						case "movenorth":
						case "movewest":
						case "movesouth":
						case "moveeast":
						case "activatefountain":
						case "deactivatefountain":
						case "help":
						case "shootnorth":
						case "shootwest":
						case "shooteast":
						case "shootsouth":
							isSelectionValid = true;
							nextPlayerMove = command;
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
	
	private void relocatePlayer(){
		// move is out of bounds then go to outer
		if(playersCurrentLocation.getRow() - 1 < 0){
			playersCurrentLocation.setRow(0);
		}else{
			playersCurrentLocation.setRow(playersCurrentLocation.getRow() - 1);
		}
		if(playersCurrentLocation.getColumn() + 2 > (gridSize - 1)|| playersCurrentLocation.getColumn() + 1 > (gridSize - 1)){
			playersCurrentLocation.setColumn(gridSize -1);
		}else{
			playersCurrentLocation.setColumn(playersCurrentLocation.getColumn() - 1);
		}
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
		int row = playersCurrentLocation.getRow();
		int col = playersCurrentLocation.getColumn();
		try{
			switch (move){
				case "movenorth":
					playersCurrentLocation.setRow(row - 1);
					break;
				case "movesouth":
					playersCurrentLocation.setRow(row + 1);
					break;
				case "moveewest":
					playersCurrentLocation.setColumn(col - 1);
					break;
				case "moveeast":
					playersCurrentLocation.setColumn(col + 1);
					break;
				case "activatefountain":
					isFountainActivated = true;
					break;
				case "deactivatefountain":
					isFountainActivated = false;
					break;
				case "help":
					printHelpMenu();
					break;
				case "shootnorth":
					worldMap.shootArrow("north",row,col);
					break;
				case "shooteast":
					worldMap.shootArrow("east",row,col);
					break;
				case "shootwest":
					worldMap.shootArrow("west",row,col);
					break;
				case "shootsouth":
					worldMap.shootArrow("south",row,col);
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
	
	private void printHelpMenu(){
		System.out.println("To move in a direction by type north, south, east or west");
		System.out.println("To shoot an Arrow type shoot and add a direction ");
		System.out.println("To activate the fountain type 'Activate fountain'.");
		System.out.println("To Deactivate the fountain type 'Deactivate fountain'.");		
	}
	
	private void printIntroductoryText(){
		System.out.println("PRINT INTRODUCTORY TEXT HERE, FORGET ME NOT!!");
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
