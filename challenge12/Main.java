import java.util.Scanner;
public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter nr: ");
		int input = Integer.parseInt(sc.nextLine());
		if(input % 2 == 0){
			System.out.println("Tick");
		}else{
			System.out.println("Tock");
		}
	}
}