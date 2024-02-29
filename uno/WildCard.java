class WildCard extends Card{
	String action;
	String color = "none";
	
	public WildCard(String action){
		this.action = action;
	}
	
	@Override
	public String toString(){
		return action;
	}
	
	@Override
	public boolean isActionCard(){
		return true;
	}
	
	@Override
	public boolean isWildCard(){
		return true;
	}
}