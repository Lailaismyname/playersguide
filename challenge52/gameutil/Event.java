package challenge52.gameutil;

class Event{
	final private String name;
	final private String description;
	
	
	public Event(String name, String description){
		this.name = name;
		this.description = description;
	}
	
	public String getName() {
		return name;
	}
	
	
	public String getDescription() {
		return description;
	}
}