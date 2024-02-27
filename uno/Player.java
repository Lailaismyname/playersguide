import java.util.ArrayList;

class Player{
	String name;
	ArrayList<Card> hand = new ArrayList<Card>();
	
	public Player(String name){
		this.name = name;
	}
	
	public void addCardToHand(Card card){
		hand.add(card);
	}
	
	public void removeCardFromHand(Card card){
		hand.remove(card);
	}
	
	
	@Override
	public String toString(){
		return this.name;
	}
}