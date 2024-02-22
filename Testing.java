import helperclasses.getNumberInput;
import helperclasses.TerminalColor;


class Testing{
	public static void main(String[] args){
		getNumberInput getNr = new getNumberInput();
		System.out.print("range 10 to 20");
		getNr.getNr(10,20);
		System.out.print("range -10 to 20");
		getNr.getNr(-10,10);
		System.out.print("positive number");
		getNr.getNr(true);
		System.out.print("negative number");
		getNr.getNr(false);		
		System.out.print("custom message");
		getNr.getNr(true,"WoopWoop: ");		
	}
}