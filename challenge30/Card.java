public class Card{
	// variables
	private String color;
	private String rank;
	// constructors
	public Card(String color, String rank){
		this.color = color;
		this.rank = rank;
	}
	// methods
	public boolean isNumberCard(){
		try{
			Integer.parseInt(this.rank);
			return true;
		}catch(NumberFormatException e){
			return false;
		}
	}
	public String toString(){
		return "The " + color + " " + rank;
	}
	// setters
}
