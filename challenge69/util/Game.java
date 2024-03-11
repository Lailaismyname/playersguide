package challenge69.util;
import java.util.List;
import java.util.ArrayList;

public class Game{
	List<Character> party = new ArrayList<Character>();

	
	public Game(){
		party.add(new Character("Skeleton","Nothing"));
		party.add(new Character("Skeleton","Nothing"));
	}
	
	
	public void play(){
		do{
			party.forEach(character ->{
				System.out.println("It is " +character.getName() + "'s turn...");
				System.out.println(character.getName() + " did " + character.getAction());
				System.out.println();
				try{
					Thread.sleep(500);
				}catch(InterruptedException e){
					System.out.println(e.getCause());
				}
			});
		}while(true);
	}	
}