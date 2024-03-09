package challenge66;
import challenge66.util.AsyncRandomWords;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutionException;
import java.util.Scanner;


class Main{
	public static void main(String[] args){
		long startTime = System.currentTimeMillis();
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter word: ");
		String word = sc.nextLine();
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
			System.exit(0);
	}
}