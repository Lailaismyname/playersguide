package challenge57;
import challenge57.util.RandomUtils;

class Main{
	public static void main(String[] args){
		//RandomUtils.getDouble(0,5);
		//RandomUtils.getDouble(0,10);
		//System.out.println(RandomUtils.nextString("a b c", "d e f", "g"));
		System.out.println(RandomUtils.coinFlip());
		System.out.println(RandomUtils.coinFlip(0.1));
	}
}