public class Main{
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	
	public static void main(String[] args){
		for(int i = 1; i <= 100; i++){
			if(i % 3 == 0 && i % 5 == 0){
					System.out.println(ANSI_BLUE + 1 + ": Fire and Electric" + ANSI_RESET);
			}else if(i % 3 == 0){
				System.out.println(ANSI_RED + i + ": Fire" + ANSI_RESET);
			}else if(i % 5 == 0){
				System.out.println(ANSI_YELLOW +i + ": Electric" + ANSI_RESET);
			}else{
				System.out.println(i + ": Normal");
			}
		}
	}
}