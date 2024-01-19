import java.util.Scanner;
public class Main{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.print("What is the base?  ");
		double base = scanner.nextInt();
		System.out.print("What is the height?  ");
		double height = scanner.nextInt();
		double area = (base * height) / 2;
		System.out.println(area);
		}
}