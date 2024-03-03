package challenge61.util;
import java.util.function.Predicate;

public class Sieve{
	Predicate<Integer> predicate;
	
	public Sieve(int option){
		switch (option) {
			case 1:
				predicate = (number) -> number % 2 == 0;
				break;
			case 2: 
				predicate = (number) -> number > 0;
				break;
			case 3:
				predicate = (number) -> number % 10 == 0;
				break;
			default:
				System.out.println("Not a valid option");
				break;
			
		}
	}
	
	public boolean isGood(int number){
		return predicate.test(number);
	}
}

/* 
Was not aware that predicate is a class, might wanna add that info to playersguide page. 
Answer this question: Does this change make the program shorter or longer?
shorter
Answer this question: Does this change make the program easier to read or harder?
bad readability imo.
*/