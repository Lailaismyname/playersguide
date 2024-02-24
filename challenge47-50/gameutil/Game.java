package gameutil;
// import helperclasses.TerminalColor; 			// ff uitvogelen hoe die classpath werkt

public class Game{
	// colors 
	TerminalColor teaRose = new TerminalColor(239,199,194);
	TerminalColor pink = new TerminalColor(219,127,142);
	TerminalColor ashGrey = new TerminalColor(191,211,193);
	TerminalColor CambridgeBlue = new TerminalColor(104,166,145);
	TerminalColor eggPlant = new TerminalColor(105,79,93);
	String ANSI_RESET = TerminalColor.ANSI_RESET;
	// name this
	Menu menu = new Menu();
	int size;
	Map worldmap;
	String roomInfo = "";
	Coordinate playerLocation;
	PlayerCommand command = new PlayerCommand();
	String selectedMove = "";
	boolean isGameOver = false;
	boolean isPlayerInFountainRoom = false;
	
	// intialise with a terminal color
	{
		System.out.print(teaRose);
	}
	
	public Game(){
		size = menu.getGameSize();
		playerLocation = new Coordinate(0,0,size);
		worldmap = new Map(size);
		worldmap.setMap();
	}
	
	
	public void play(){
		setUpGame();
		do{
			System.out.println(eggPlant + "You are currently at Row: " + playerLocation.getRow() + " Column: " + playerLocation.getColumn() + teaRose);
			String hint = worldmap.getAdjacentRooms(playerLocation.getRow(),playerLocation.getColumn());
			if(!hint.equalsIgnoreCase("")){
				System.out.println(ashGrey + hint + teaRose);
			}
			// check if move is within valid, if it is then move player
			do {
				selectedMove = command.getPlayerMove();
			}while (!isMoveValid(selectedMove));
			movePlayer(playerLocation.getRow(), playerLocation.getColumn(), selectedMove);
			roomInfo = worldmap.getRoomDescription(playerLocation.getRow(),playerLocation.getColumn());
			if(roomInfo.length() > 5){
				System.out.println(CambridgeBlue + roomInfo + teaRose);
			}
			if (isEvent()){
				handleEvent();
			}
		}while (!isGameOver);
		
	}
	
	public void setUpGame(){
		menu.printIntroTxt();
	}
	
	
	public boolean isEvent(){
		String room = worldmap.getRoomName(playerLocation.getRow(),playerLocation.getColumn());
		if(room.equalsIgnoreCase("entry") || room.equalsIgnoreCase("amarok") ||
		room.equalsIgnoreCase("pit") || room.equalsIgnoreCase("maelstrom") || 
		room.equalsIgnoreCase("fountain")){ 
			return true;
		}else {
			return false;
		}
	}
	
	public void handleEvent(){
		String room = worldmap.getRoomName(playerLocation.getRow(),playerLocation.getColumn());
		if(room.equalsIgnoreCase("entry") && worldmap.isFountainActivated()){
			System.out.println(ashGrey + "You win!" + teaRose); 
			isGameOver = true;
		}else if (room.equalsIgnoreCase("amarok") || room.equalsIgnoreCase("pit")){
			//isGameOver = true;
		}else if (room.equalsIgnoreCase("maelstrom")){
			isPlayerInFountainRoom = false;
			// move player according to rules and within bounds
			// maelstrom moves 1 space south and 2 spaces west
			worldmap.moveMaelstrom(playerLocation.getRow(), playerLocation.getColumn());
			// player moves 1 space north and 2 spaces east
			int newRow = (playerLocation.getRow() - 1) < 0 ? size - (playerLocation.getRow() - 1) : (playerLocation.getRow() - 1);
			int newCol = (playerLocation.getColumn() + 1) >= size ? size - (playerLocation.getColumn() + 1) : (playerLocation.getColumn() + 1);
			playerLocation.setRow(newRow);
			playerLocation.setColumn(newCol);
		}else if (room.equalsIgnoreCase("fountain")){
			isPlayerInFountainRoom = true;
		} else{
			isPlayerInFountainRoom = false;
		}
	}
	
	
	public boolean isMoveValid(String playerCommand){
		if (playerCommand.equalsIgnoreCase("moveNorth")){
			return (playerLocation.getRow() - 1) >= 0 && (playerLocation.getRow() - 1) < size;
		}else if (playerCommand.equalsIgnoreCase("moveSouth")){
			return (playerLocation.getRow() + 1) <=  size && (playerLocation.getRow() + 1) < size;
		}else if (playerCommand.equalsIgnoreCase("moveEast")){
			return (playerLocation.getColumn() + 1) <=  size && (playerLocation.getColumn() + 1) < size;
		}else if (playerCommand.equalsIgnoreCase("moveWest")){
			return (playerLocation.getColumn() - 1) >= 0 && (playerLocation.getColumn() - 1) < size;
		}else if (playerCommand.equalsIgnoreCase("activateFountain") || playerCommand.equalsIgnoreCase("deActivateFountain")){
			return true;
		}else if(playerCommand.equalsIgnoreCase("help")){
			return true;
		}else if (playerCommand.equalsIgnoreCase("shootNorth") || playerCommand.equalsIgnoreCase("shootSouth") ||
			playerCommand.equalsIgnoreCase("shootEast") || playerCommand.equalsIgnoreCase("shootWest")){
			return true;
		}else {
			return false;
		}
	}
	
	
	public void movePlayer(int row, int col, String playerCommand){
		if (playerCommand.equalsIgnoreCase("moveNorth")){
			playerLocation.setRow( (row - 1) );
		}else if (playerCommand.equalsIgnoreCase("moveSouth")){
			playerLocation.setRow( (row + 1) );
		}else if (playerCommand.equalsIgnoreCase("moveEast")){
			playerLocation.setColumn( (col + 1) );
		}else if (playerCommand.equalsIgnoreCase("moveWest")){
			playerLocation.setColumn( (col - 1) );
		} else if (playerCommand.equalsIgnoreCase("activateFountain") && isPlayerInFountainRoom){
			worldmap.activateFountain();
		}else if (playerCommand.equalsIgnoreCase("deActivateFountain") && isPlayerInFountainRoom){
			worldmap.deActivateFountain();
		}else if(playerCommand.equalsIgnoreCase("help")){
			menu.getHelp();
		}else if (playerCommand.equalsIgnoreCase("shootNorth") || playerCommand.equalsIgnoreCase("shootSouth") ||
			playerCommand.equalsIgnoreCase("shootEast") || playerCommand.equalsIgnoreCase("shootWest")){
			worldmap.shootMonster(playerLocation.getRow(), playerLocation.getColumn(), playerCommand);
		}
	}
	
	
}