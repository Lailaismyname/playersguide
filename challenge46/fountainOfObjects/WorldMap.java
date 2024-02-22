package fountainOfObjects;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashMap;

class WorldMap{
	String[][] worldMap;
	int gridSize;
	int fountainRow;
	int fountainColumn;
	
	ArrayList<String> rooms;
	
	ArrayList<Location> pits = new ArrayList<Location>();
	ArrayList<Location> amarokts = new ArrayList<Location>();
	ArrayList<Location> maelstroms = new ArrayList<Location>();
		
	
	public WorldMap(int gridSize){
		this.gridSize = gridSize;
		// create the world
		worldMap = new String[gridSize][gridSize];
		for(int row = 0; row < gridSize; row++){
			for(int column = 0; column < gridSize; column++){
				worldMap[row][column] = "";
			}
		}
		if(gridSize == 4){
			rooms = new ArrayList<>(List.of("fountain","pit","amarokt"));
		}else if(gridSize == 6){
			rooms = new ArrayList<>(List.of("fountain","pit","pit","amarokt","amarokt","maelstrom"));
		}else if(gridSize == 8){
			rooms = new ArrayList<>(List.of("fountain","pit","pit","pit","amarokt","amarokt","amarokt","maelstrom","maelstrom"));
		}
	}

	
	public String getRoomInfo(int row, int column, boolean isFountainActivated){	
		final String activeFountain = "You hear the rushing waters from the Fountain of objects.";
		final String inactiveFountain = "You hear water dripping in this room. The fountain is here!";
		final String entrance = "You see light coming from the temple entrance.";
		final String exit = "The fountain has been reactivated!";
		final String adjacentOfPit = "You sense an eerie draft, there is a pit in a nearby room.";
		final String maelstrom = "You got sweeped up by maelstroms wind and relocated.";
		final String adjacentOfMaelstrom = "You can hear growling and groaning from a neighbouring room.";  
		final String adjacentOfAmaroks = "You can smell the rotten stench of an amarok in a nearby room.";
		
		String finalRoomInfo = "";
		String[] eventsInCurrentRoom = worldMap[row][column].split(",");
		
		for(String room: eventsInCurrentRoom){
			if(room.equals("entry")){
				finalRoomInfo += isFountainActivated ? exit : entrance;
			}
			if(room.equals("fountain")){
				finalRoomInfo += isFountainActivated ? activeFountain : inactiveFountain;
			}
			if(room.equals("adjacentOfPit")){
				finalRoomInfo += adjacentOfPit;
			}
			if(room.equals("adjacentOfMaelstrom")){
				finalRoomInfo += adjacentOfMaelstrom;
			}
			if(room.equals("adjacentOfAmaroks")){
				finalRoomInfo += adjacentOfAmaroks;
			}
		}
		return finalRoomInfo;
	}
	
	
	public void setRooms(){
		// set the entrance
		worldMap[0][0] = "entry";
		// set the other rooms
		int row = -1;
		int column = -1;
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
					worldMap[row][column] += ",pit";
					pits.add(new Location(row,column,gridSize));
					break;
				case "amarokt": 
					worldMap[row][column] += ",amarokt";
					amarokts.add(new Location(row,column,gridSize));
					break;
				case "maelstrom": 
					worldMap[row][column] += ",maelstrom";
					maelstroms.add(new Location(row,column,gridSize));
					break;
				default:
					break;
			}
		}
		// set pits
		setAdjacentRooms();		
	}
	
	
	public void shootArrow(String direction, int row, int col){
		switch(direction){
			case "north":
				row += 1;
				break;
			case "south":
				row -= 1;
				break;
			case "east":
				col += 1;
				break;
			case "west":
				col -= 1;
				break;
			default:
				System.out.println("You can't shoot that way");
		}
		
		// shoot the maelstrom or amarokt
		if(worldMap[row][col].contains("amarokt")){
			worldMap[row][col].replace("amarokt","");
		} else if(worldMap[row][col].contains("maelstrom")){
			worldMap[row][col].replace("maelstrom","");
		}	
		
		System.out.println(worldMap[row][col].contains("amarokt"));
	}
	
	
	public boolean isRoomEmpty(int row, int column){
		return !worldMap[row][column].equals("");
	}
	
	
	public void setAdjacentRooms(){
		pits.forEach(pit -> {
			asignRooms(pit.getRow(), pit.getColumn(), "adjacentOfPit");
		});
		amarokts.forEach(amarokt -> {
			asignRooms(amarokt.getRow(), amarokt.getColumn(), "adjacentOfAmarokt");
		});
		maelstroms.forEach(maelstrom -> {
			asignRooms(maelstrom.getRow(), maelstrom.getColumn(), "adjacentOfMaelstrom");	
		});
	}
	
	
	public void relocateMaelstrom(int row,int col){
			String[] events = worldMap[row][col].split(",");
			System.out.println("You get sweeped up by a maelstrom wind");
			for(String event : events){
				if (!event.equals("maelstrom")){
					worldMap[row][col] += event + ",";
				}
			}
			
			worldMap[getRandomRoomNumber(gridSize)][getRandomRoomNumber(gridSize)] += "maelstrom"; 
	}
	
	
	public void asignRooms(int row, int col, String nameOfAdjacentRoom){
		int[][] rowsAndColumns = {
			{row - 1, col - 1}, 
			{row, col - 1}, 
			{row + 1, col - 1}, 
			{row - 1, col},
			{row + 1, col},
			{row - 1, col + 1},
			{row, col + 1},
			{row + 1, col + 1}
						
		};
		for(int i = 0; i < 8; i++){
			if(rowsAndColumns[i][0] > 0 || rowsAndColumns[i][1] < 8){
				worldMap[rowsAndColumns[i][0] ] [rowsAndColumns[i][1] ] += "," +nameOfAdjacentRoom;
			}
		}			
	}
	
	
	public String isEvent(int row, int col){
		String[] events = worldMap[row][col].split(",");
		for(String event : events){
			if(event.equals("pit")){
				return "pit";
			}else if(event.equals("maelstrom")){
				return "maelstrom";
			}else if(event.equals("amarokt")){
				return "amarokt";
			}
		}
		return "";
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
