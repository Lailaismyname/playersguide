class ActionCard extends Card{
	String action;
	
	public ActionCard(String action){
		this.action = action;
	}
	
	@Override
	public String toString(){
		return action;
	}
}