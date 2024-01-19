import java.util.Scanner;
public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		//user 1
		int pilotNr = -1;
		while(pilotNr < 0 || pilotNr > 100){
			System.out.println("User 1, Pick a number between 0 and 100");
			try{
				pilotNr = Integer.parseInt(sc.nextLine());
			}catch (NumberFormatException e){
				System.out.println("That is not a valid number");
			}
		}
		
		// clear the screen
		for(int i=0; i < 50; i++){
			System.out.println();
		}
		
		//user 2
		int hunterNr = -1;
		while(hunterNr != pilotNr){
			System.out.println("User 2, what is your guess?");
			try{
				hunterNr = Integer.parseInt(sc.nextLine());
			}catch(NumberFormatException e){
				System.out.println("That is not a valid number");
			}
			if (hunterNr > pilotNr){
				System.out.println("Too high, try again");
			}else if(hunterNr < pilotNr){
				System.out.println("Too low, try again");
			}
			else{
				System.out.println("You guessed the number!");
			}
		}
	}
}