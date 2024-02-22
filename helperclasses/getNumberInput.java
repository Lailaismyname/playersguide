package helperclasses;
import java.util.Scanner;
/**
* verifies if user input is a number and returns that number
* @param min			min range of number
* @param max  			max range of number
* @param isPositive		if an input can be positive or not
* @return				the number input of user
*/

public class getNumberInput{
	Scanner sc = new Scanner(System.in);
	
	public int getNr(int min, int max){
		int number = (min - 1);
		do {
			System.out.print("Number: ");
			number = Integer.parseInt(sc.nextLine());
		}while (number < min || number > max);
		return number;
	}
	
	
	public int getNr(int min, int max, String msg){
		int number = (min - 1);
		do {
			System.out.print(msg);
			number = Integer.parseInt(sc.nextLine());
		}while (number < min || number > max);
		return number;
	}
	
	
	public int getNr(boolean isPositive){
		int number;
		do {
			System.out.print("Number: ");
			number = Integer.parseInt(sc.nextLine());
			
			if(isPositive && number > 0){
				break;
			} else if(!isPositive && number < 0){
				break;
			}
		}while (true);
		return number;
	}
	
	
	public int getNr(boolean isPositive, String msg){
		int number;
		do {
			System.out.print(msg);
			number = Integer.parseInt(sc.nextLine());
			
			if(isPositive && number > 0){
				break;
			} else if(!isPositive && number < 0){
				break;
			}
		}while (true);
		return number;
	}
}