package gameutil;
import java.util.Random;
import java.util.ArrayList;

class Map{
	private int size;
	public Room[][] map;		// of mischien private?
	
	public Map(int size){
		this.size = size;
		map = new Room[size][size];
	}
	
	public void setMap(){
		// set Entrance
		map[0][0] = new Room("Entry", "You see light coming from the cavern entrance.");
		// create rooms
		Fountain fountain = new Fountain();
		Room pit = new Room("pit","You feel a draft. There is a pit in a nearby room.");
		Room amarok = new Room("amarok","You can smell the rotten stench of an amarok in a nearby room.");
		Room maelstrom = new Room("maelstrom","You hear the growling and groaning of a maelstrom nearby.");
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
		for(Room room : listOfRooms){
			int row;
			int col;
			do {
				row = getRandomRoomNumber(size);
				col = getRandomRoomNumber(size);
			}while (map[row][col] !=  null);
			map[row][col] = room;
		}
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
	
}