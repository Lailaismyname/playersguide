package challenge67;

import challenge67.util.AsyncMedal;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class Main{
	public static void main(String[] args){
		ExecutorService executor = Executors.newFixedThreadPool(2);
		AsyncMedal threadOne = new AsyncMedal();
		AsyncMedal threadTwo = new AsyncMedal();
		Future<Integer> resultThreadOne = executor.submit(threadOne);
		Future<Integer> resultThreadTwo = executor.submit(threadTwo);
		executor.shutdown();
	}
}