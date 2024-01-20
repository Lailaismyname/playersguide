import java.util.Scanner;
public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		PasswordValidator checkPassword = new PasswordValidator("");
		String password = "";
		while(true){
			System.out.println("Enter password"); 
			password = sc.nextLine();
			checkPassword = new PasswordValidator(password);
			System.out.println("password valid: " + checkPassword.isPasswordValid());
		}
	}
}