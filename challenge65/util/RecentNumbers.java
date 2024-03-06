package challenge65.util;
import java.util.Random;
import java.util.Scanner;

public class RecentNumbers extends Thread{
	private final Scanner sc = new Scanner(System.in);
	private int[] numbers = new int[2];

	@Override
	public void run(){
		int i = 1;
		do{
			try{
				Thread.sleep(1000);
			} catch(InterruptedException err){
				System.out.println(err);
			}
			int index = ( i % 2 ) == 0 ? 0 : 1;
			numbers[index] = getRandomNumber();
			System.out.println(numbers[index]);
			i++;
		}while(true);
	}
	
	private int getRandomNumber(){
		Random random = new Random();
		return random.nextInt(0,9);
	}
	
	public int[] getNumbers(){
		return numbers;
	}
	
}