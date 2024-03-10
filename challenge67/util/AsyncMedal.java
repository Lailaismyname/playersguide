package challenge67.util;

import java.util.Scanner;
import java.util.Random;
import java.util.concurrent.Callable;

public class AsyncMedal implements Callable<Integer>{
	Integer wordLength;
	String word;
	
	public AsyncMedal(){
		getWord();
	}
	
	@Override
	public Integer call() throws Exception{
		return generateSameWord();
	}
	
	public int generateSameWord(){
		long startTime = System.currentTimeMillis();
		Random random = new Random();
		String generatedWord = "";
		int tryCounter = 0;
		do{
			generatedWord = "";
			for(int i = 0; i < wordLength; i++){
				generatedWord += (char) ('a' + random.nextInt(26));
			}
			tryCounter++;
		}while(!generatedWord.equalsIgnoreCase(word));
			long endTime = System.currentTimeMillis();
			long timeDifference = endTime - startTime;
			System.out.println("Thread " + Thread.currentThread().getId() + " completed. Word was '" + word + "'. Time taken: " + timeDifference + " ms");
			return tryCounter;
	}
	
	private String getWord(){
		System.out.print("Word: ");
		Scanner sc = new Scanner(System.in);
		String word = sc.nextLine();
		this.word = word;
		this.wordLength = word.length();
		return word;
	}
}