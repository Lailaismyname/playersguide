import java.util.Scanner;

public class SimulasTest {
    /*
    The box can be in three states:
if the box is in the OPEN state, you can close it, and it becomes CLOSED
if the box is in the CLOSED state, you can open it, and it becomes OPEN
if the box is in the CLOSED state, you can lock it, and it becomes LOCKED
if the box is in the LOCKED state, you can unlock it, and it becomes CLOSED
     */
    enum chestState{
        OPEN,
        CLOSED,
        LOCKED
    }
    public static void getChestState(){
        // chest is locked by default.
        var chest = chestState.OPEN;
        // ask user what state the chest must be in?
        System.out.println("What state do you want the chest to be in?");
        Scanner sc = new Scanner(System.in);
        String userChoice = sc.nextLine().toLowerCase();
        while(true){
            while(!userChoice.equals("locked") && !userChoice.equals("open") && !userChoice.equals("closed")){
                System.out.print("Choice: ");
                userChoice = sc.nextLine().toLowerCase();
            }
            switch(userChoice){
                case "locked":
                    if(chest == chestState.OPEN){
                        System.out.print("You must close the chest before you can lock it. ");
                    } else{
                        chest = chestState.LOCKED;
                    }
                    break;
                case "open":
                    chest = chestState.OPEN;
                    break;
                case "closed":
                    chest = chestState.CLOSED;
                    break;
                default:
                    System.out.println("Not a valid option");
            }
            //reset user choice
            userChoice = "";
            // log chest state
            System.out.println("The chest is currently " + chest);
        }
    }
}
