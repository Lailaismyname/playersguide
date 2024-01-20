public class Color{
	// variabelen
	private int red;
	private int green;
	private int blue;
	// define 8 private static fields for commonly used colors
	private int[] whiteColor = {255,255,255};
	private int[] blackColor = {0,0,0};
	private int[] redColor = {255,0,0};
	private int[] blueColor = {0,0,255};
	private int[] greenColor = {0,255,0};
	private int[] yellowColor = {255,255,0};
	private int[] purpleColor = {128,0,128};
	private int[] orangeColor = {255,165,0};
	// constructors
	public Color(String colorName){
		int[] colors = getColor(colorName);
		this.red = colors[0];
		this.green = colors[1];
		this.blue = colors[2];
	}
	public Color(int red,int green, int blue){
		this.red = red;
		this.green = green;
		this.blue = blue;
	}
	//methods
	public String toString(){
		return "(" + red + "," + green + "," + blue + ")";
	}
	private int[] getColor(String colorName){
		switch(colorName.toLowerCase()){
			case "white":
				return whiteColor;
			case "black":
				return blackColor;
			case "red":
				return redColor;
			case "blue":
				return blueColor;
			case "green":
				return greenColor;
			case "yellow":
				return yellowColor;
			case "purple":
				return purpleColor;
			case "orange":
				return orangeColor;
			default:
				throw new IllegalArgumentException("Invalid Color");
		}
	}
	//setters
}