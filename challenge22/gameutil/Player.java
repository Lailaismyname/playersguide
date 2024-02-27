package challenge22.gameutil;
import java.util.Random;
import java.util.Scanner;

class Player{
	Random random;
	boolean isComputer;
	Scanner sc = new Scanner(System.in);
	int chosenLocation;
	
	public Player(boolean isComputer){
		isComputer = isComputer;
		Random random = new Random();
		chosenLocation = random.nextInt(1,100);
	}
	
	public Player(){
		System.out.println("nr: ");
		chosenLocation = Integer.parseInt(sc.nextLine());
	}
}