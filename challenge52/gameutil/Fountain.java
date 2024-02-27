package challenge52.gameutil;

class Fountain extends Room{
	private boolean isActivated = false;
	String name;
	String description = "";
	
	public Fountain(){
		super("fountain");
	}
	
	
	public void activateFountain(){
		isActivated = true;
	}
	
	
	public void deActivateFountain(){
		isActivated = false;
	}
	
	
	public boolean getFountainStatus(){
		return this.isActivated;
	}
	
	
	@Override
	public String getDescription() {
		return description = isActivated? "You hear rushing water" : "You hear water dripping";
	}
}