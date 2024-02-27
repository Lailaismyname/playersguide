package challenge22.gameutil;
import helperclasses.TerminalColor; 

import java.util.Scanner;
import java.util.Random;
import java.util.HashMap;

public class Manticore{
	String yellow = new TerminalColor(230,175,46).toString();
	String red = new TerminalColor(231,29,54).toString();
	String brown = new TerminalColor(67,62,14).toString();
	String reset_color = TerminalColor.ANSI_RESET;
	Scanner sc = new Scanner(System.in);
	int manticoreLocation;
	int round = 0;
	Combatant city;
	Combatant manticore;
		
	
	public Manticore(){
		Random random = new Random();
		manticoreLocation = random.nextInt(1,100);
		city = new Combatant(15);
		manticore = new Combatant(10);
	}
	
	
	
	public void play(){
		// System.out.println("Manticore Location: " + manticoreLocation);
		do{
			handlePlayerTurn();
			if (manticore.getHealth() <= 0){
				System.out.println("The Manticore has been destroyed! The city of Consolas has been saved!");
				break;
			}else if(city.getHealth() <= 0){
				System.out.println("The Manticore destroyed the city of consolas!");
			}
		}while (true);
	}
	
	
	public void printStatus(){
		System.out.println("STATUS: Round: " + round + " City: " + city.toString() + " Manticore: " + manticore.toString());
	}
	
	
	public void handlePlayerTurn(){
		round++;
		System.out.println("----");
		System.out.println("Player 2, it is your turn.");
		printStatus();
		int range = getDesiredRange();
		printExpectedDamage(range);
		printHitInfo(range);
		if(isTargetHit(range)){
			manticore.takeOfDamage(getExpectedDamage());
		}
		city.takeOfDamage(1);
	}
	
	public int getExpectedDamage(){
		if (round % 3 == 0 && round % 5 == 0){
			return 10;
		}else if (round % 5 == 0){
			return 3;
		}else {
			return 1;
		}
	}
	
	public void printExpectedDamage(int range){
		String color = "";
		if (getExpectedDamage() == 10){
			color = yellow;
		}else if (getExpectedDamage() == 3){
			color = red;
		}else {
			color = brown;
		}
		
		System.out.println(color + "The cannon is expected to deal " + getExpectedDamage() + " damage this round." + reset_color);
	}
	
	public int getDesiredRange(){
		int range = -1;
		do{
			System.out.print("Enter the desired range: ");
			range = Integer.parseInt(sc.nextLine());
			if (range > 0 && range < 100){
				break;
			}
		}while (true);
		return range;
	}
	
	
	public void printHitInfo(int range){
		System.out.print("That round ");
		if (range < manticoreLocation){
			System.out.println("FELL SHORT of the target");
		}else if (range > manticoreLocation){
			System.out.println("OVERSHOT the target");
		}else {
			System.out.println("was a DIRECT HIT");
		}
	}
	
	
	public boolean isTargetHit(int range){
		return range == manticoreLocation;
	}	
}