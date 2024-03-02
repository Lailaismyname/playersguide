package challenge57.util;
import java.util.Random;

public class RandomUtils{
	private static Random random = new Random();
	
	
	public static int getDouble(int max){
		return random.nextInt(0,max);
	}
	
	
	public static int getDouble(int min, int max){
		return random.nextInt(min,max);
	}
	
	
	public static String nextString(String... txt){
		int max = (txt.length - 1);
		return txt[RandomUtils.getDouble(max)];
	}
	
	/*
	public static boolean coinFlip(){
		int nr = RandomUtils.getDouble(10);
		return nr % 2 == 0 ? true : false; 
	}
	*/
	
	public static boolean coinFlip(){
		return coinFlip(0.5);
	}
	
	
	public static boolean coinFlip(double percentage){
		return random.nextDouble() < percentage;
	}
}

/* 
* i would think that it would be better to make a derived AdvancedRandom class
* otherwise you run the risk of adding more and more and making a cluttered mess
*/