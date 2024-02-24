package gameutil;

class Room{
	private String name;
	private String description;
	private String adjacentTxt;
	
	public Room(String name, String description, String adjacentTxt){
		this.name = name;
		this.description = description;
		this.adjacentTxt = adjacentTxt;
	}
	public Room(String name, String description){
		this.name = name;
		this.description = description;
		this.adjacentTxt= "";
	}
	
	public Room(String name){
		this.name = name;
		this.description = "";
	}
	
	public Room(){
		this.name = "Empty";
	}
	
	
	public String getName() {
		return name;
	}
	
	
	public String getDescription() {
		return description;
	}
	
	
	public String getAdjacentTxt() {
		return adjacentTxt;
	}
	
	
	@Override
	public String toString(){
		return "Name:" + name + " Description: " + description;
	}
}