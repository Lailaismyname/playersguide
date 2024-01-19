import java.util.Scanner;
public class Main{
	public static void main(String[] args){
		System.out.println("What kind of thing are we talking about?");
		Scanner scanner = new Scanner(System.in);
		String a = scanner.nextLine(); //LETOP IS GEEN NEXTLINE
		System.out.println("How would you describe it? Big? Azure? Tattered?");
		String b = scanner.nextLine();
		String c = " of doom 3000!";
		System.out.println("The " + b + " " + a + c);
	}
}

/* aside from comments you make sure to name everything as descriptive as possible */