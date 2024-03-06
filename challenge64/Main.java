package challenge64;
import challenge64.util.TwoLenses;

class Main{
	public static void main(String[] args){
		int[] arr = {1, 9, 2, 8, 3, 7, 4, 6, 5};
		TwoLenses tl = new TwoLenses();
		System.out.println(tl.alterArray(arr));
		System.out.println(tl.alterArrayWithLambda(arr));
	}
}