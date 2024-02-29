class ActionCard extends Card{
	String action;
	String color;
	
	public ActionCard(String action,String color){
		super();
		this.color = color;
		this.action = action;
	}
	
	@Override
	public String toString(){
		return color + " " + action;
	}
	
	@Override
	public boolean isActionCard(){
		return true;
	}
	// Waarom word deze niet inherited? niet vergeten uit te zoeken!
	public String getColor(){
		return color;
	}
}