import java.util.Scanner;

public class Manticore {
private int manticoreHealth = 10;
private int cityHealth = 15;


public void play(){
    // main function
    int station = setStation();
    // tell player 2 its his/her turn
    System.out.println("Player 2 it is your turn.");
    // run gameloop
    runGameLoop(this.cityHealth, this.manticoreHealth, station);
}
public static void runGameLoop(int cityHealth, int manticoreHealth, int station){
    // define neccesary variables
    int damage = 0;
    int round = 1;
    // do stuff player 2 is suposed to do
    while (cityHealth >= 0 && manticoreHealth >= 0){
        if(round % 3 == 0 && round % 5 == 0){
            //it's a multiple of 3 and 5
            damage = 10;
        }else if(round % 3 == 0 || round % 5 == 0){
            damage = 3;
        }
        //print info
        System.out.println("STATUS: Round: " + round + " City: " +cityHealth + "/15 Manticore: " + manticoreHealth + "/10");
        System.out.println("The cannon is expected to deal " + damage +  " damage this round.");
        // get desired target
        System.out.println("Enter desired cannon range: ");
        Scanner sc = new Scanner(System.in);
        int range = 0;
        // check if range is a number
        try{
             range = sc.nextInt();
        }catch (Exception err){
            System.out.println("Must be a number");
        }
        // check if range is between 0 and 100
        while (range < 0 || range > 100){
            System.out.println("range must be between 0 and 100");
            range = sc.nextInt();
        }
        cityHealth = cityHealth - 1;
        if (range > station){
            System.out.println("That round OVERSHOT the target.");
        }else if (range < station){
            System.out.println("That round OVERSHOT the target.");
        }else{
            System.out.println("That round was a DIRECT HIT!");
            manticoreHealth = manticoreHealth - damage;
        }
        if(manticoreHealth <= 0){
            System.out.println("health of manticore below zero");
        }
        else if(cityHealth <=0){
            System.out.println("city health below 0");
        }
        round++;
    }
}
    public static int setStation(){
        // set scanner
        Scanner sc = new Scanner(System.in);
        // ask user
        System.out.println("Player 1, how far away from the city do you want to station the Manticore?");
        int distance = 0;
        while (distance <= 0 || distance > 100) {
            System.out.print("Pick a number between 0 and 100: ");
            try {
                distance = sc.nextInt();
            } catch (Exception err) {
                System.out.println("This is not a number");
            }
        }
        for(int i =0; i < 50; i++){
            System.out.println();
        }
        return distance;
    }
}
