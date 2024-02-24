package gameutil;
import java.util.Random;
import java.util.ArrayList;

class Map{
	private int size;
	public Room[][] map;
	Fountain fountain;
	Room pit;
	Room amarok;
	Room maelstrom;
	
	public Map(int size){
		this.size = size;
		map = new Room[size][size];
		
		// set Entrance
		map[0][0] = new Room("Entry", "You see light coming from the cavern entrance.");
		// create rooms
		fountain = new Fountain();
		pit = new Room("pit","You fell into a pit and died.");
		amarok = new Room("amarok","Amarok kills you.");
		maelstrom = new Room("maelstrom","You got swept up by a maelstrom wind.");
	}
	
	public void setMap(){
		/* text for nearby rooms": 
			"You feel a draft. There is a pit in a nearby room."
			"You can smell the rotten stench of an amarok in a nearby room."
			"You hear the growling and groaning of a maelstrom nearby."
		*/
		
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
		// DEBUG STATEMENT
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				System.out.print("|");
				System.out.print(map[i][j]);
				System.out.print("|");
			}
			System.out.println("\n");
		}
		// END DEBUG STATEMENT
	}
	
	
	public void moveMaelstrom(int row, int col){
		// overwrite current room as null 
		// look for a room with null and overwrite it with maelstrom
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