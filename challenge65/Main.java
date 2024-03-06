package challenge65;
import challenge65.util.RecentNumbers;
import java.util.Scanner;

class Main{
	public static void main(String[] args){
		RecentNumbers secondThread = new RecentNumbers();
		secondThread.start();
		secondThread.setName("secondThread");
		// the default thread heeft een priority van 5. 10 is hoogste en 1 laagste
		secondThread.setPriority(1); 
		do{
			int[] numbers = secondThread.getNumbers();
			if(hasEnterBeenPressed()){
				System.out.println(numbers[0] + " " + numbers[1]); // debug
				if(numbers[0] == numbers[1]){
					System.out.println("The numbers are the same!");
					System.exit(0);
				}
			};
		}while(true);
	}
	
	public static boolean hasEnterBeenPressed(){
		Scanner sc = new Scanner(System.in);
		String key = sc.nextLine();
		do{
			if(key.equals("")){
				return true;
			}else{
				return false;
			}
		}while(true);
	}
}
