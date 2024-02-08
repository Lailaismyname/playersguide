class ColoredItem<T>{
	final String ANSI_RESET = "\u001B[0m";
	final String ANSI_RED = "\u001B[31m";
	final String ANSI_GREEN = "\u001B[32m";
	final String ANSI_YELLOW = "\u001B[33m";
	final String ANSI_BLUE = "\u001B[34m";
	final String ANSI_PURPLE = "\u001B[35m";
	final String ANSI_CYAN = "\u001B[36m";

	private T item;
	String color;
	
	public ColoredItem(T item, String color){
		this.item = item;
		this.color = color;
	}
	
	void display(){
		String requiredColor = "black";
		String outputColor = "\u001B[0m";
		switch (color){
			case "red":
				outputColor = ANSI_RED;
				break;
			case "green":
				outputColor = ANSI_GREEN;
				break;
			case "yellow":
				outputColor = ANSI_YELLOW;
				break;
			case "blue":
				outputColor = ANSI_BLUE;
				break;
			case "purple":
				outputColor = ANSI_PURPLE;
				break;
			case "cyan":
				outputColor = ANSI_CYAN;
				break;
			default:
				outputColor = ANSI_RESET;
		}
		
		System.out.println(outputColor + item.toString() + ANSI_RESET);
	}
	
}