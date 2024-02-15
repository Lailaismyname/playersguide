package fountainOfObjects;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class WorldMap{
	String[][] worldMap;
	String[][] adjacentRoomsMap;
	int gridSize;
	int fountainRow;
	int fountainColumn;
	
	int pitRow;
	int pitColumn;
	int amaroktRow;
	int amaroktColumn;
	int maelstromRow;
	int maelstromColumn;
		
	
	public WorldMap(int gridSize){
		this.gridSize = gridSize;
		// create the world
		worldMap = new String[gridSize][gridSize];
		for(int row = 0; row < gridSize; row++){
			for(int column = 0; column < gridSize; column++){
				worldMap[row][column] = "";
			}
		}
		// set the adjacent rooms
		adjacentRoomsMap = new String[gridSize][gridSize];
		for(int row = 0; row < gridSize; row++){
			for(int column = 0; column < gridSize; column++){
				adjacentRoomsMap[row][column] = "";
			}
		}
	}

	
	public String getRoomInfo(int row, int column, boolean isFountainActivated){	
		final String activeFountain = "You hear the rushing waters from the Fountain of objects.";
		final String inactiveFountain = "You hear water dripping in this room. The fountain is here!";
		final String entrance = "You see light coming from the temple entrance, but you must first activate the fountain. Be carefull weary traveler darkness awaits you!";
		final String exit = "The fountain has been reactivated and you have survived this ordeal and escaped with your life still intact. You are now a winner!";
		final String pit = "You fell into a pit with sharp spikes, you see the light and slowly fall into darkness.";
		final String adjacentOfPit = "You sense an eerie draft, there is a pit in a nearby room.";
		final String maelstrom = "You got sweeped up by maelstroms wind and relocated.";
		final String adjacentOfMaelstrom = "You can hear growling and groaning from a neighbouring room.";  
		final String amaroks = "You died, oh well...";
		final String adjacentOfAmaroks = "You can smell the rotten stench of an amarok in a nearby room.";
		
		String finalRoomInfo = "";
		// getting the text for the rooms
		switch (worldMap[row][column]) {
			case "entry":
				finalRoomInfo = isFountainActivated ? exit : entrance;
				break;
			case "fountain":
				finalRoomInfo = isFountainActivated ? activeFountain : inactiveFountain;
				break;
			case "pit":
				finalRoomInfo = pit;
				break;
			case "maelstrom":
				finalRoomInfo = maelstrom;
				break;
			case "amaroks":
				finalRoomInfo = amaroks;
				break;
			default:
				break;
		}
		// getting the text for the adjacent rooms
			switch (adjacentRoomsMap[row][column]){
				case "adjacentOfPit":
					finalRoomInfo += " " + adjacentOfPit;
					break;
				case "adjacentOfMaelstrom":
					finalRoomInfo += "" + adjacentOfMaelstrom;
					break;
				case "adjacentOfAmaroks":
					finalRoomInfo += " " + adjacentOfAmaroks;
					break;
				default:
					break;
			}
		return finalRoomInfo;
	}
	
	
	public void setRooms(){
		// set the entrance
		worldMap[0][0] = "entry";
		// set the other rooms
		int row = -1;
		int column = -1;
		ArrayList<String> rooms = new ArrayList<>(List.of("fountain","pit","amarokt","maelstrom"));
		// set the rooms
		for(String room : rooms){
			do{
				row = getRandomRoomNumber(gridSize - 1);
				column = getRandomRoomNumber(gridSize - 1);
			}while(isRoomEmpty(row,column));
			worldMap[row][column] = room;
			switch(room){
				case "fountain": 
					fountainRow = row;
					fountainColumn = column;
					break;
				case "pit": 
					pitRow = row;
					pitColumn = column;
					break;
				case "amarokt": 
					amaroktRow = row;
					amaroktColumn = column;
					break;
				case "maelstrom": 
					maelstromRow = row;
					maelstromColumn = column;
					break;
				default:
					break;
			}
		}
		// set pits
		setAdjacentRooms(pitRow, pitColumn, "adjacentOfPit");		
		// print worldMap for debugging
		for(int i = 0; i < gridSize; i++){
			for(int j = 0; j < gridSize; j++){
				System.out.print(worldMap[i][j] + " - ");
			}
			System.out.println();
		}	
	}
	
	
	public boolean isRoomEmpty(int row, int column){
		return !worldMap[row][column].equals("");
	}
	
	public void assignRoom(String roomItem, int row,int column){
		worldMap[row][column] = roomItem;
	}
	
	
	public void setAdjacentRooms(int row, int col, String nameOfAdjacentRoom){
		int[][] rowsAndColumns = {
			// deze klopt niet want pit word niet op juiste plek geprint
			{row - 1, col - 1}, // deze is goed
			{row, col - 1}, // deze is goed
			{row + 1, col - 1}, // deze is goed
			{row - 1, col},
			{row + 1, col},
			{row - 1, col + 1},
			{row, col + 1},
			{row + 1, col + 1}
						
		};
		for(int i = 0; i < 8; i++){
			if(rowsAndColumns[i][0] > 0 || rowsAndColumns[i][1] < 8){
				adjacentRoomsMap[rowsAndColumns[i][0] ] [rowsAndColumns[i][1] ] = nameOfAdjacentRoom;
			}
		}	
		// debugging	
		System.out.println("row: " + row + " col: " + col);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		for(int i = 0; i < gridSize; i++){
			for(int j = 0; j < gridSize; j++){
				System.out.print(adjacentRoomsMap[i][j] + " - ");
			}
			System.out.println();
		}
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
	}
	
	private int getRandomRoomNumber(int max){
		Random random = new Random();
		return random.nextInt(1,max);
	}
	
	
	public int getFountainRoomRow(){
		return fountainRow;
	}
	public int getFountainRoomColumn(){
		return fountainColumn;
	}
	
}
