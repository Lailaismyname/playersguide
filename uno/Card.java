class Card{
	String color;
	int nr;
	
	public Card(){}
	
	
	public Card(String color, int nr){
		this.color = color;
		this.nr = nr;
	}
	
	@Override
	public String toString(){
		return  color + " " + nr;
	}
	
	public boolean isActionCard(){
		return false;
	}
	
	public boolean isWildCard(){
		return false;
	}
	
	public String getColor(){
		return color;
	}
	
	public int getNr(){
		return nr;
	}
}