package fountainOfObjects;
import java.util.Random;


class WorldMap{
	String[][] worldMap;
	int gridRows;
	int gridColumns;
	int fountainRow;
	int fountainColumn;
	
	
	public WorldMap(int gridSize){
		this.gridRows = gridSize;
		this.gridColumns = gridSize;
		// create the world
		worldMap = new String[gridRows][gridColumns];
		for(int row = 0; row < gridRows; row++){
			for(int column = 0; column < gridColumns; column++){
				worldMap[row][column] = "";
			}
		}
		// set the entrance
		worldMap[0][0] = "entry";
		// set the fountain room
		int row = getRandomRoomNumber(gridRows - 1);
		int column = getRandomRoomNumber(gridColumns - 1); 
		worldMap[row][column] = "fountain"; 
		// set the row and column of fountain for later reference
		this.fountainRow = row;
		this.fountainColumn = column;
	}

	
	
	public String getRoomInfo(int row, int column, boolean isFountainActivated){	
		String activeFountain = "You hear the rushing waters from the Fountain of objects";
		String inactiveFountain = "You hear water dripping in this room. The fountain is here!";
		String entrance = "You see light coming from the temple entrance, but you must first activate the fountain. Be carefull weary traveler darkness awaits you!";
		String exit = "The fountain has been reactivated and you have survived this ordeal and escaped with your life still intact. You are now a winner!";
			
		
		switch (worldMap[row][column]) {
			case "entry":
				return isFountainActivated ? exit : entrance;
			case "fountain":
				return isFountainActivated ? activeFountain : inactiveFountain;
			default:
				return "";
		}
	}
	
	
	private int getRandomRoomNumber(int max){
		Random random = new Random();
		return random.nextInt(1,max);
	}
	
	
	public int getFountainRoomRow(){
		return this.fountainRow;
	}
	public int getFountainRoomColumn(){
		return this.fountainColumn;
	}
	
}
