import java.util.ArrayList;
import java.util.*;

class Deck{
	ArrayList<Card> deck = new ArrayList<Card>();
	
	public Deck(){}
	
	public Deck(boolean isNewDeck){
		if(isNewDeck){
			createDeck();
			shuffleDeck();
		}
	}
	
	public void createDeck(){
			addColoredCards("Blue");
			addColoredCards("Green");
			addColoredCards("Red");
			addColoredCards("Yellow");
			addActionCards(8, "Draw two");
			addActionCards(8, "Reverse");
			addActionCards(8, "Skip");
			addWildCards(4, "Wild");
			addWildCards(4, "Wild draw four");
	}
	
	
	public void addColoredCards(String color){
		deck.add(new Card(color, 0));
		for(int i = 0; i <= 1; i++){
				for(int card = 1; card <= 9; card++){
					deck.add(new Card(color,card));
				}
			}
	}
	
	
	public void addActionCards(int amount, String action){
		String color = "Blue";
		for(int i = 0; i < amount; i++){
			if(i > 1 && i < 4){
				color = "Red"; 
			}else if(i > 3 && i < 6){
				color = "Green";
			}else{
				color = "Yellow";
			}
			deck.add(new ActionCard(action, color));
		}
	}
	
	public void addWildCards(int amount, String action){
		for(int i = 0; i < amount; i++){
			deck.add(new WildCard(action));
		}
	}
	
	public void shuffleDeck(){
		Collections.shuffle(deck);
	}
	
	public Card getCardFromDeck(){
		int cardToGet = 0;
		Card card = deck.get(cardToGet);
		removeCardFromDeck(cardToGet);
		return card;
	}
	
	public void removeCardFromDeck(int cardToBeRemoved){
		deck.remove(cardToBeRemoved);
	}
	
	public void printDeck(){
		for(Card card:deck){
			System.out.println(card.toString());
		}
	}
	
	
	public ArrayList<Card> getDeck(){
		return deck;
	}
}