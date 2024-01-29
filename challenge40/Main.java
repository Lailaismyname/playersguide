import java.util.Scanner;
import java.util.ArrayList;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("On: on  Off: off  Up: W  Down:S  Left: A  Right: D");
		System.out.print("Move:");
		String move1 = sc.nextLine().toLowerCase();
		System.out.print("Move:");
		String move2 = sc.nextLine().toLowerCase();
		System.out.print("Move:");
		String move3 = sc.nextLine().toLowerCase();
		String[] moves = {move1,move2,move3};
		
		RobotCommand w = new NorthCommand();
		RobotCommand s = new SouthCommand();
		RobotCommand a = new WestCommand();
		RobotCommand d = new EastCommand();
		RobotCommand on = new OnCommand();
		RobotCommand off = new OffCommand();
		
		ArrayList<RobotCommand> commands = new ArrayList<>();
		for(String move : moves){
			switch (move){
				case "w":
					commands.add(w);
					break;
				case "s":
					commands.add(s);
					break;
				case "a":
					commands.add(a);
					break;
				case "d":
					commands.add(d);
					break;
				case "on":
					commands.add(on);
					break;
				case "off":
					commands.add(off);
					break;
			} 
		}
		
		Robot robot = new Robot(commands);
		robot.run();
		
	}
}

/* Antwoord op de vraag:
ik zie niet echt het verschil op het moment, 
wellicht heb ik een beter antwoord na wat meer oefeningen met beide. 
*/