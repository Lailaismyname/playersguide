package challenge64.util;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class TwoLenses{
	public List<Integer> alterArray(int[] arr){
		Arrays.sort(arr);
		List<Integer> newArr = new ArrayList<Integer>();
		for(int nr : arr){
			if(nr % 2 == 0){
				newArr.add(nr * 2);
			}
		}
		return newArr;
	}
	
	public List<Integer> alterArrayWithLambda(int[] arr){
		Arrays.sort(arr);
		List<Integer> newArr = new ArrayList<Integer>();
		Arrays.stream(arr).forEach(nr -> {
			if(nr % 2 == 0){
				newArr.add(nr * 2);
			}
		});
		return newArr;
	}
}

/*
Answer this question: Compare the size and understandability of these approaches. Does any
stand out as being particularly good or particularly bad?
Not sure if im doing it correctly, i dont think one is better then the other. 
Answer this question: Of the two approaches, which is your personal favorite, and why?
i prefer readability, so in general that would be an approach without the lambda expression. 
From what i understand is that you will find lambda expressions more in situations where you are working with GUI's
where you can pass a lambda on an event. 
*/