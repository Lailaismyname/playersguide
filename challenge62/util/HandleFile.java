package challenge62.util;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class HandleFile{
	public String formatFileName(String filename){
		filename = filename.replace(" ","_");
		filename = "challenge62/txtFiles/" + filename + ".txt";
		return filename;
	}
	
	public void makeFile(String filename){
		filename = formatFileName(filename);
		System.out.println(filename);
		try{
			File file = new File(filename);
			if(file.createNewFile()){
				System.out.println("File created");
			}else{
				System.out.println("File already exists");
			}
		}catch(IOException err){
			System.out.println("An error occurred.");
			err.printStackTrace();
		}
	}
	
	public boolean doesFileExist(String filename){
		filename = filename.replace(" ","_");
		filename = "challenge62/txtFiles/" + filename + ".txt";
		File file = new File(filename);
		if(file.exists()){
			return true;
		}else{
			return false;
		}
	}
	
	public void writeToFile(String playerName, int points){
		String fileName = formatFileName(playerName);
		try{
			FileWriter writer = new FileWriter(fileName);
			writer.write("Score: " + points);
			writer.close();
			System.out.println("Successfully wrote to the file.");
		}catch(IOException err){
			System.out.println("An error occurred");
			err.printStackTrace();
		}
	}
	
	public int getScoreFromFile(String playerName){
		String fileName = formatFileName(playerName);
		try{
			File file = new File(fileName);
			Scanner sc = new Scanner(file);
			String txt = sc.nextLine();
			txt = txt.replace("Score: ","");
			return Integer.parseInt(txt);
		}catch(IOException err){
			System.out.println("An error occurred");
			err.printStackTrace();
			return -1;
		}
	}
	
}