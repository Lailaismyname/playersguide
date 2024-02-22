package gameutil;

class TerminalColor{
	final static String ANSI_RESET = "\u001B[0m";
	String red;
	String green;
	String blue;
	
	
	TerminalColor(int red, int green, int blue){
		this.red = Integer.toString(red);
		this.green = Integer.toString(green);
		this.blue = Integer.toString(blue);
	}
	TerminalColor(){}
	
	@Override
	public String toString(){
		return "\u001B[38;2;" + red + ";" + green + ";" + blue + "m";
	}
	
	public static String getResetColor(){
		return ANSI_RESET;
	}
}