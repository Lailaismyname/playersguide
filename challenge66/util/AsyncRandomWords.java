package challenge66.util;
import java.util.concurrent.Callable;
import java.util.List;
import java.util.Random;
import java.util.Arrays;

public class AsyncRandomWords implements Callable<Integer>{
		Integer wordLength;
		String word;
		public AsyncRandomWords(String word){
			this.word = word;
			wordLength = word.length();
		}
	
		@Override
		public Integer call() throws Exception{
			// generate nr of characters
			Random random = new Random();
			String generatedWord = "";
			int tryCounter = 0;
			do{
				// clear out the word
				generatedWord = "";
				for(int i = 0; i < wordLength; i++){
					// fill the generated word
					generatedWord += (char) ('a' + random.nextInt(26));
				}
				tryCounter++;
			}while(!generatedWord.equalsIgnoreCase(word));
			return tryCounter;
		}
}
