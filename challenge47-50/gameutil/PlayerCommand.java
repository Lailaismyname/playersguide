package gameutil;
import java.util.Scanner;

class PlayerCommand{
	Scanner sc = new Scanner(System.in);
	
	public String getPlayerMove(){
		System.out.print("What would you like to do? ");
		String move = "";
		do {
			move = sc.nextLine();
			String[] commands = move.split(" ");
			if (move.contains("north") && commands.length == 2){
				if(move.contains("shoot")){
					move = "shootNorth";
				}else{
					move = "moveNorth";
				}
				break;
			}else if (move.contains("south")){
				if(move.contains("shoot")){
					move = "shootSouth";
				}else{
					move = "moveSouth";
				}
				break;
			}else if (move.contains("east")){
				if(move.contains("shoot")){
					move = "shootEast";
				}else{
					move = "moveEast";
				}
				break;
			} else if (move.contains("west")){
				if(move.contains("shoot")){
					move = "shootWest";
				}else{
					move = "moveWest";
				}
				break;
			}
		}while(true);
		
		return move; 		// moet uiteindelijk de naam van de move returnen
	}
}