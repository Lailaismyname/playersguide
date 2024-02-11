package fountainOfObjects;
import java.lang.Math;


class WorldMap{
	String[][] worldMap;
	int gridRows;
	int gridColumns;
	int fountainRow;
	int fountainColumn;
	
	
	public WorldMap(int gridRows, int gridColumns){
		// substracting one, because count starts at 0
		this.gridRows = gridRows;
		this.gridColumns = gridColumns;
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
			// random fountain room location
		int row = getRandomRoomNumber(1, gridRows);
		int column = getRandomRoomNumber(1, gridColumns); 
			// ff vaste locatie om te testen nog
		//int row = 0;
		//int column = 2; 
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
	
	
	private int getRandomRoomNumber(int min, int max){
		int range = max - min + 1;
		return (int)(Math.random() * range) + min;
	}
	
	
	public int getFountainRoomRow(){
		return this.fountainRow;
	}
	public int getFountainRoomColumn(){
		return this.fountainColumn;
	}
	
}
