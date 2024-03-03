package challenge62.util;
import java.util.Scanner;
import challenge62.util.HandleFile;

public class LongGame{
	Scanner sc = new Scanner(System.in);
	HandleFile file = new HandleFile();
	String playerName;
	int playerScore;
	
	public LongGame(){
		playerScore = 0;
	}
	
	public void play(){
		getPlayerName();
		if(file.doesFileExist(playerName)){
			playerScore = file.getScoreFromFile(playerName);
			System.out.println(playerScore);
		}else{
			makeFile();
		}
		String str;
		int points;
		boolean endGame = false;
		do{
			str = getString();
			points = getPoints(str);
			updatePoints(points);
			printScore();
			if(hasEndingCommand(str)){
				file.writeToFile(playerName, playerScore);
			}
			endGame = hasEndingCommand(str);
		}while(!endGame);
	}
	
	private void makeFile(){
		do{
			if(verifyName()){
				String fileName = playerName;
				if(!file.doesFileExist(fileName)){
					file.makeFile(playerName);
				}
				break;
			}else{
				getPlayerName();
			}
		}while(true);
	}
	
	public boolean hasEndingCommand(String str){
		if(str.contains("IO")){
			return true;
		}else{
			return false;
		}
	}
	
	public String getString(){
		System.out.print("add characters: ");
		return sc.nextLine();
	}
	
	
	public int getPoints(String str){
		str = str.replace(" ","");
		return str.length();
	}
	
	public void updatePoints(int points){
		playerScore += points;
	}
	
	public void printScore(){
		System.out.println("Your points: " + playerScore);
	}
	
	private boolean verifyName(){
		System.out.println("You have chosen the name '" + playerName + "' do you want to save it? y/n");
		String save = null;
		do{
			if(save != null){
				System.out.println("Not a valid option, Do you want to save? y/n");
			}
			save = sc.nextLine();
			if(save.equalsIgnoreCase("y") || save.equalsIgnoreCase("yes") || save.equalsIgnoreCase("n") || save.equalsIgnoreCase("no")){
				break;
			}
		}while (true);
		if(save.equalsIgnoreCase("y") || save.equalsIgnoreCase("yes")){
			return true;
		}else if(save.equalsIgnoreCase("n") || save.equalsIgnoreCase("no")){
			return false;
		}else{
			throw new IllegalArgumentException("Not a valid option");
		}
	}

	private String getPlayerName(){
		System.out.println("Enter your name");
		playerName = sc.nextLine();
		return "test";
	}
}