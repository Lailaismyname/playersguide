import java.util.Scanner;
public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		// ask user to set up password
		String passCode = "a";
		String verifyPasscode = "b";
		while(!passCode.equals(verifyPasscode)){
			System.out.println("Enter the passcode you want to use");
			passCode = sc.nextLine();
			System.out.println("verify passode");
			verifyPasscode = sc.nextLine();
		}
		// create new door 
		Door door = new Door(passCode);
		// allow user transitions
		String wantsToContinue = "y";
		while(wantsToContinue.equals("y") || wantsToContinue.equals("Y")){
			doorOptions(sc, door);
			System.out.println("Do you want to continue? y/n");
			wantsToContinue = sc.nextLine();
		}
		
	}
	static void doorOptions(Scanner sc,Door door){
		System.out.println("1. Open door \n2. Close door \n3. Lock door \n4. unlock door \n5. Change passcode \n6. Get door status");
		int choice =  Integer.parseInt(sc.nextLine());
		
		switch(choice){
			case 1:
				door.openDoor();
				break;
			case 2:
				door.closeDoor();
				break;
			case 3:
				door.lockDoor();
				break;
			case 4:
				door.unlockDoor();
				break;
			case 5:
				System.out.println("What is your current passcode?");
				String currentPasscode = sc.nextLine();
				door.changePasscode(currentPasscode);
				break;
			case 6:
				System.out.println(door.getDoorStatus());
				break;
			default:
				System.out.println("Invalid option");
		}
	}
}