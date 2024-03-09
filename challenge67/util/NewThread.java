package challenge67.util;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutionException;
import java.util.Scanner;

public class NewThread extends Thread{
	
	@Override
	public void run(){
		makeNewRandomWord();
	}
	
	public void makeNewRandomWord(){
		String word = getWord();
		makeRandomWordObject(word);
	}
	
	private String getWord(){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter word: ");
		String word = sc.nextLine();
		return word;
	}
	
	private static void makeRandomWordObject(String word){
		long startTime = System.currentTimeMillis();
		AsyncRandomWords callableSubClass = new AsyncRandomWords(word);
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		Future<Integer> futureObject = executorService.submit(callableSubClass);
		try {
			Integer tryCounter = futureObject.get();
			System.out.println("Try Counter: " + tryCounter);
		} catch(InterruptedException e){
			System.out.println(e);
		}catch(ExecutionException e){
			System.out.println(e);
		}
		long endTime = System.currentTimeMillis();
		long timeDifference = endTime - startTime;
		System.out.println("Time taken: " + timeDifference + " ms");
	}
}