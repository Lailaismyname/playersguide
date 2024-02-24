package gameutil;
import java.util.Scanner;

class PlayerCommand{
	Scanner sc = new Scanner(System.in);
	TerminalColor pink = new TerminalColor(219,127,142);
	TerminalColor teaRose = new TerminalColor(239,199,194);
	
	public String getPlayerMove(){
		String move = "";
		do {
			System.out.print(teaRose + "What would you like to do? " + pink);
			
			move = sc.nextLine();
			String[] commands = move.split(" ");
			if (move.contains("north") && commands.length == 2){
				if(move.contains("shoot")){
					move = "shootNorth";
				}else{
					move = "moveNorth";
				}
				break;
			}else if (move.contains("south") && commands.length == 2){
				if(move.contains("shoot")){
					move = "shootSouth";
				}else{
					move = "moveSouth";
				}
				break;
			}else if (move.contains("east") && commands.length == 2){
				if(move.contains("shoot")){
					move = "shootEast";
				}else{
					move = "moveEast";
				}
				break;
			} else if (move.contains("west") && commands.length == 2){
				if(move.contains("shoot")){
					move = "shootWest";
				}else{
					move = "moveWest";
				}
				break;
			} else if (move.contains("fountain")){
				if (move.contains("activate")){
					move = "activateFountain";
				}else if (move.contains("deactivate")){
					move = "deactivateFountain";
				}
				break;
			}
		}while(true);
		
		return move;
	}
}