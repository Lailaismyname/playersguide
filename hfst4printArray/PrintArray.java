import java.util.Scanner;

class PrintArray{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int num_items = -1;
		do{
			System.out.print("Provide array size: ");
			num_items = Integer.parseInt(sc.nextLine());
		}while(num_items <= 0);
		int[] arrayItems = new int[num_items];
		for(int i = 0; i < num_items; i++){
			System.out.print("Provide item to add to array: ");
			arrayItems[i] = Integer.parseInt(sc.nextLine());
		}
		System.out.println("All done here is your array: ");
		for(int item : arrayItems){
			System.out.println("*".repeat(item) + item);
		}
	}
}