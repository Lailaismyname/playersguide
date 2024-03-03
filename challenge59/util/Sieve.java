package challenge59.util;

public class Sieve{
	int predicate;
	
	public Sieve(int predicate){
		this.predicate = predicate;
	}
	
	public boolean isGood(int number){
		if(predicate == 1){
			return isEven(number);
		}else if(predicate == 2){
			return isPositive(number);
		}else if(predicate == 3){
			return isMultipleOfTen(number);
		}else{
			System.out.println("not an option");
			return false;
		}
	}
	
	private boolean isEven(int number){
		return number % 2 == 0;
	}
	
	private boolean isPositive(int number){
		return number > 0;
	}
	
	private boolean isMultipleOfTen(int number){
		return number % 10 == 0;
	}
}


/*
Answer this question: Describe how you could have also solved this problem with inheritance and
polymorphism. Which solution seems more straightforward to you, and why?

inherit the class Sieve based on which type you are checking for, and then overload the methods
so SieveEvenNumber extends Sieve
*/