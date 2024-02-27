package challenge52.gameutil;
import java.util.Random;
import java.util.ArrayList;
import helperclasses.TerminalColor;

class Map{
	TerminalColor teaRose = new TerminalColor(239,199,194);
	private int size;
	public Room[][] map;
	Fountain fountain;
	Room pit;
	Room amarok;
	Room maelstrom;
	Arrow arrow;
	
	
	public Map(int size){
		arrow = new Arrow(5);
		this.size = size;
		map = new Room[size][size];
		
		// set Entrance
		map[0][0] = new Room("Entry", "You see light coming from the cavern entrance.");
		// create rooms
		fountain = new Fountain();
		pit = new Room("pit","You fell into a pit and died.","You feel a draft. There is a pit in a nearby room.");
		amarok = new Room("amarok","Amarok kills you.","You can smell the rotten stench of an amarok in a nearby room.");
		maelstrom = new Room("maelstrom","You got swept up by a maelstrom wind.","You hear the growling and groaning of a maelstrom nearby.");
	}
	
	public void setMap(){
		// array to fill the map with quantity of rooms according to map size
		ArrayList<Room> listOfRooms = new ArrayList<>();
		// add rooms to array based on game size
		listOfRooms.add(fountain);
		listOfRooms.add(pit);
		listOfRooms.add(amarok);
		if (size > 4){
			listOfRooms.add(pit);
			listOfRooms.add(amarok);
			listOfRooms.add(amarok);
			listOfRooms.add(maelstrom);
		}
		if (size > 	6){
			listOfRooms.add(pit);
			listOfRooms.add(amarok);
			listOfRooms.add(maelstrom);
			listOfRooms.add(maelstrom);
		}
		// add the rooms to the map
		listOfRooms.forEach(room ->{
			int row;
			int col;
			do {
				row = getRandomRoomNumber(size);
				col = getRandomRoomNumber(size);
			}while (map[row][col] !=  null);
			map[row][col] = room;
		});
	}
	
	
	public void moveMaelstrom(int row, int col){
		// overwrite current room as null 
		map[row][col] = null;
		// look for a room with null and overwrite it with maelstrom
		int newRow = (row + 1) < 0 ? size + (row + 1) : (row + 1);
		int newCol = (col - 1) >= size ? size - (col - 1) : (col - 1);
		if(map[newRow][newCol] == null){
			map[newRow][newCol] = maelstrom;
		} else{
			// if spot is taken move to random spot
			do{
				newRow = getRandomRoomNumber(size);
				newCol = getRandomRoomNumber(size);
			}while (map[newRow][newCol] != null);
			map[newRow][newCol] = maelstrom;
		}
	}
	
	
	public void shootMonster(int row, int col, String playerCommand){
		int newRow = row;
		int newCol = col;
		
		if (playerCommand.equalsIgnoreCase("shootNorth")){
			newRow = (row - 1);
		}else if (playerCommand.equalsIgnoreCase("shootSouth")){
			newRow = (row + 1);
		}else if (playerCommand.equalsIgnoreCase("shootWest")){
			newCol = (col - 1);
		}else if (playerCommand.equalsIgnoreCase("shootEast")){
			newCol = (col + 1);
		}
		if (newRow < 0 || newRow > size || newCol < 0 || newCol > size ){
			if (arrow.getQuantity() != 0 || map[newRow][newCol] == null){
				arrow.useArrow();
				System.out.println(teaRose + "You didn't hit anything, you have " + arrow.getQuantity() + " arrows left");
			} else{
				System.out.println(teaRose + "You are out of Arrows");
			}
		}else if (map[newRow][newCol] != null){
			// remove the arrow from quantity
			arrow.useArrow();
			// check if there is a monster there
			if(map[newRow][newCol] == amarok || map[newRow][newCol] == amarok){
				String monster = map[newRow][newCol] == maelstrom ? "maelstrom" : "amarok";
				// remove the monster
				map[newRow][newCol] = null;
				System.out.println(teaRose + "You killed the " + monster + ",you have " + arrow.getQuantity() + " arrows left");
			}
		}
	}

	
	public String getAdjacentRooms(int row, int col){
		String hint = "";
		if ((row + 1) < size && map[row+1][col] != null){
			hint += map[row+1][col].getAdjacentTxt();
		}else if ((row - 1) > 0 && map[row-1][col] != null){
			hint += map[row-1][col].getAdjacentTxt();
		}else if ((col + 1) < size  && map[row][col+1] != null){
			hint += map[row][col+1].getAdjacentTxt();
		}else if ((col -1) > 0 && map[row][col-1] != null){
			hint += map[row][col-1].getAdjacentTxt();
		}
		return hint;
	}


	private int getRandomRoomNumber(int max){
		Random random = new Random();
		return random.nextInt(1,max);
	}
	
	
	public String getRoomName(int row, int col){
		return map[row][col] == null ? "empty": map[row][col].getName();
	}
	
	
	public String getRoomDescription(int row, int col){
		return map[row][col] == null ? "none": map[row][col].getDescription();
	}
	
	
	public void activateFountain(){
		fountain.activateFountain();
	}

	
	public void deActivateFountain(){
		fountain.deActivateFountain();
	}
	
	
	public boolean isFountainActivated(){
		return fountain.getFountainStatus();
	}
	
}