package fountainOfObjects;
import java.util.Random;
import java.util.ArrayList;
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
		
		adjacentRoomsMap = new String[gridSize][gridSize];
		for(int row = 0; row < gridSize; row++){
			for(int column = 0; column < gridSize; column++){
				worldMap[row][column] = "";
			}
		}
	}

	
	public String getRoomInfo(int row, int column, boolean isFountainActivated){	
		String activeFountain = "You hear the rushing waters from the Fountain of objects";
		String inactiveFountain = "You hear water dripping in this room. The fountain is here!";
		String entrance = "You see light coming from the temple entrance, but you must first activate the fountain. Be carefull weary traveler darkness awaits you!";
		String exit = "The fountain has been reactivated and you have survived this ordeal and escaped with your life still intact. You are now a winner!";
		String pit = "You fell into a pit with sharp spikes, you see the light and slowly fall into darkness";
		String adjacentOfPit = "You sense an eerie draft, there is a pit in a nearby room";
		
		switch (worldMap[row][column]) {
			case "entry":
				return isFountainActivated ? exit : entrance;
			case "fountain":
				return isFountainActivated ? activeFountain : inactiveFountain;
			case "pit":
				return pit;
			case "adjacentOfpit":
				return adjacentOfPit;
			default:
				return "";
		}
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
					fountainRow = row;
					fountainColumn = column;
					break;
				case "amarokt": 
					fountainRow = row;
					fountainColumn = column;
					break;
				case "maelstrom": 
					fountainRow = row;
					fountainColumn = column;
					break;
				default:
					break;
			}
		// TODO set the rooms adjacent rooms. Deze moeten apart want ze kunnen overlappen met de andere rooms zoals fountain e.d.
			// dan ook de gethint method aanpassen dat ie dus 2 hints ophaalt. 
		ArrayList<String> adjacentRooms = new ArrayList<>(List.of("pit","amarokt","maelstrom"));
		
		
		}
		
		// print worldMap for debugging
		for(int i = 0; i < gridSize; i++){
			for(int j = 0; j < gridSize; j++){
				System.out.print(worldMap[i][j] + " - ");
			}
			System.out.println();
		}	
	}
	
	
	public boolean isRoomEmpty(int row, int column){
		if(worldMap[row][column].equals("")){
			return false;
		}else{
			return true;
		}
	}
	
	public void assignRoom(String roomItem, int row,int column){
		worldMap[row][column] = roomItem;
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
