package challenge58.util;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class Game{
	Scanner sc = new Scanner(System.in);
	Random random = new Random();
	int min = 0;
	int max = 9;
	ArrayList<Integer> guessed = new ArrayList<Integer>();
	int round = 0;
	boolean isGameOver = false;
	int nr;
	
	public Game(){
		nr = getRandomNr(9);
	}
	
	
	public void play(){
		do{
			playRound();
		} while(!isGameOver);
	}
	
	public void playRound(){
		String player = round % 2 == 0 ?  "Player 1" :  "Player 2";
		System.out.print(player + " it is your turn guess a ");
		int playerNr = getNumberInput(min,max);
		if(!isGuessed(playerNr)){
			addToGuessed(playerNr);
			round++;
		}else{
			System.out.println("This number has already been guessed, try again:");
		};
		if(isWinningNr(playerNr)){
			printWinMsg(player);
			isGameOver = true;
		}
	}
	
	public void printWinMsg(String playername){
		System.out.println("Congrats " + playername + " you win!");
	}
	
	public boolean isWinningNr(int guessedNr){
		return guessedNr == nr;
	}
	public boolean isGuessed(int guess){
		return guessed.contains(guess);
	}
	
	public void addToGuessed(int guess){
		guessed.add(guess);
	}
	
	
	public int getRandomNr(int max){
		return random.nextInt(0,max);
	}
	
	
	public int getNumberInput(int min, int max){
		int nr = (min - 1);
		do{
			System.out.print("number: ");
			try{
				nr = Integer.parseInt(sc.nextLine());
			}catch(IllegalArgumentException err){
				System.out.println("Not a Number");
			}
		}while(nr < min || nr > max);
		return nr;
	}
}

/*
You could write this program without exceptions, but the requirements
demanded an exception for learning purposes. If you didn’t have that requirement, would you have
used an exception? Why or why not?
I would have used logic because thats what i was told, but also because there is no need for an exception if you are going to reprompt anyway. 
*/