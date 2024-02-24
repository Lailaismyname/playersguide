package gameutil;

class Room{
	private String name;
	private String description;
	
	public Room(String name, String description){
		this.name = name;
		this.description = description;
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
	
	@Override
	public String toString(){
		// return "Name:" + name + " Description: " + description;
		return name;
	}
}