import java.util.ArrayList;
import java.util.Scanner;

public class Uno{
	Scanner sc = new Scanner(System.in);
	Deck deck = new Deck(true); 
	DiscardPile discardPile = new DiscardPile(); 
	Card topOfDiscardPile = discardPile.getCardFromDeck(0);
	ArrayList<Player> players = new ArrayList<Player>();
	int playerAmount = 2;
	public void play(){
		playerAmount = getAmountOfPlayers();
		setPlayers(playerAmount);
		dealCards();
		discardPile.addCardToDeck(deck.getCardFromDeck());
		System.out.println(topOfDiscardPile);
		
		// main game loop
		playRound();
	}
	
	
	public void setPlayers(int amount){
		String name = "";
		for(int i = 0; i < amount; i++){
			System.out.print("Player " + (i+1) + " enter your name:");
			name = sc.nextLine();
			players.add(new Player(name));
		}
	}
	
	
	public int getAmountOfPlayers(){
		int amount = -1;
		System.out.print("How many players?");
		amount = Integer.parseInt(sc.nextLine());
		return amount;
	}
	
	
	public void dealCards(){
		for(Player player: players){
			for(int i = 0; i < 7; i++){
				Card card = deck.getCardFromDeck();
				player.addCardToHand(card);
			}
		}
	}
	
	
	public void playRound(){
		for(Player player: players){
			handlePlayerTurn(player);
		}
	}
	
	
	public void handlePlayerTurn(Player player){ 
		System.out.println(player + " it's your turn, which card do you want to play?");
		for(Card card: player.hand){
			System.out.print("|" + card + "|");
		}
		System.out.println();
		String playerCard = "";
		do{
			playerCard = sc.nextLine();
			if(!handContainsCard(player,playerCard)){
				System.out.println("You do not have that card in your deck");
			}
		}while (!handContainsCard(player,playerCard));
		// check if that card is playable
		// add that card to discard pile
		discardPile.addCardToDeck(getCard(player,playerCard));
		// remove that card from the player hand
		player.removeCardFromHand(getCard(player,playerCard));
		// check if it is an action card
		// it is an action card handle the action
		
	}
	
	public boolean handContainsCard(Player player, String selectedCard){
		for(Card card: player.hand){
			if(card.toString().equalsIgnoreCase(selectedCard)){
				return true;
			}
		}
		return false;
	}
	
	public Card getCard(Player player, String cardName){
		return player.hand.get(cardname);
		for(Card card : player.hand){
			if(card.toString().equalsIgnoreCase(selectedCard)){
				return card;
			}else {
				throw new ObjectNotFoundException;
			}
		}
	}
}
