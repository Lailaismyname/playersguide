import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		int[] array = { 4, 51, -7, 13, -99, 15, -8, 45, 90 };
		int currentSmallest = Integer.MAX_VALUE; // Start higher than anything in the array.
		for (int item : array){
			if (item < currentSmallest)
			currentSmallest = item;
		}
		System.out.println(currentSmallest);

		int total = 0;
		for (int item: array)
			total += item;
			double average = (double)total / array.length;
		
		System.out.println(average);
	}
}

// als ik de brackets toevoeg dan is average out of scope. Dus zijn het de brackets die dan de scope bepalen?