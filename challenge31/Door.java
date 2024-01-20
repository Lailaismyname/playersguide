import java.util.Scanner;
public class Door{
	enum DoorState {
		OPEN,
		CLOSED,
		LOCKED, 
		UNLOCKED;
	}
	// variables
	private String passCode;
	public DoorState doorStatus = DoorState.CLOSED;
	// constructors
	public Door(String passCode){
		this.passCode = passCode;
	}
	// methods
	public void openDoor(){
		if(doorStatus == DoorState.CLOSED || doorStatus == DoorState.UNLOCKED){
			doorStatus = DoorState.OPEN;
			System.out.print("opening door, Status:");
			System.out.println(doorStatus);
		}else{
			System.out.println("Door must be closed and unlocked before it can be opened");
		}
	}
	public void closeDoor(){
		if(doorStatus == DoorState.OPEN){
			doorStatus = DoorState.CLOSED;
			System.out.print("CLOSING door, Status:");
			System.out.println(doorStatus);
		}else{
			System.out.println("Door must be open before it can be closed");
		}
	}
	public void lockDoor(){
		if(doorStatus == DoorState.CLOSED){
			doorStatus = DoorState.LOCKED;
			System.out.print("LOCKING door, Status:");
			System.out.println(doorStatus);
		}else{
			System.out.println("Door must be CLOSED before it can be LOCKED");
		}	
	}
	public void unlockDoor(){
		if(doorStatus == DoorState.LOCKED){
			doorStatus = DoorState.UNLOCKED;
			System.out.print("UNLOCKING door, Status:");
			System.out.println(doorStatus);
		}else{
			System.out.println("Door must be LOCKED before it can be UNLOCKED");
		}
	}
	public void changePasscode(String providedPasscode){
		Scanner sc = new Scanner(System.in);
		if(passCode.equals(providedPasscode)){
			System.out.println("Type your new pass code: ");
			String newPassCode = sc.nextLine();
			System.out.println("Type your pass code to verify");
			String verifyPassCode = sc.nextLine();
			
			while(!newPassCode.equals(verifyPassCode)){
				System.out.println("Passcodes don't match try again: ");
				System.out.println("Type your new pass code: ");
				newPassCode = sc.nextLine();
				System.out.println("Type your pass code to verify");
				verifyPassCode = sc.nextLine();
			}
			passCode = newPassCode;
		}else{
			System.out.println("That is not the correct passcode");
		}
	}
	public String getDoorStatus(){
		return doorStatus.toString();
	}
}