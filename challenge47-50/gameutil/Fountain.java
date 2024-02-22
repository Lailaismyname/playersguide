package gameutil;

class Fountain extends Room{
	boolean isActivated = false;
	String name;
	String description = isActivated? "activated" : "deactivated";
	
	public Fountain(){
		super("fountain", "you hear water dripping");
	}
}