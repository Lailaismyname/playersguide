/* TODO/TONOTFORGET
- als een speler geen kaart heeft om te spelen dan moet hij een kaart van de draw pile pakken. 
*/

import java.util.ArrayList;
import java.util.Scanner;

public class Uno{
	Scanner sc = new Scanner(System.in);
	Deck deck = new Deck(true); 
	DiscardPile discardPile = new DiscardPile(); 
	Card topOfDiscardPile;
	ArrayList<Player> players = new ArrayList<Player>();
	int playerAmount = 2;
	int turnsPlayed = 0;
	
	public void play(){
		playerAmount = getAmountOfPlayers();
		setPlayers(playerAmount);
		dealCards();
		discardPile.addCardToDeck(deck.getCardFromDeck());
		topOfDiscardPile = discardPile.getCardFromDeck(turnsPlayed);		
		// main game loop
		playRound();
	}
	
	
	public void setPlayers(int amount){
		String name = "";
		for(int i = 0; i < amount; i++){
			System.out.print("Player " + ( i + 1 ) + " enter your name:");
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
	
	
	public void clearScreen(){
		for(int i = 0; i < 50; i++){
			System.out.println();
		}
	}
	
	public void playRound(){
		for(Player player: players){
			System.out.println("Top card of Discard pile: " + topOfDiscardPile);
			System.out.println("|" + player + " it's your turn, which card do you want to play?" + "|");
			printPlayersCards(player);
			handlePlayerTurn(player);
			clearScreen();
		}
	}
	
	public void printPlayersCards(Player player){
		System.out.println("	Your deck");
		for(Card card: player.hand){
			System.out.print("|" + card + "|");
		}
		System.out.println();
	}
	
	
	public void handlePlayerTurn(Player player){ 
		String playerMove;
		Card selectedCard;
		do{
			playerMove = getPlayerMove(player);
			selectedCard = getCard(player, playerMove);
			if(!isMoveLegal(selectedCard)){
				System.out.print("You can't play that card, try again: ");
			}
		}while (!isMoveLegal(selectedCard));
		updateDeckAndDiscardPile(player, selectedCard);
		handleActionCard(selectedCard);
		updateTopOfDiscardPile();
	}
	
	public String getPlayerMove(Player player){
		String selectedCard = "";
		do{
			selectedCard = sc.nextLine();
			if(!handContainsCard(player,selectedCard)){
				System.out.println("You do not have that card in your deck");
			}
		}while (!handContainsCard(player,selectedCard));
		return selectedCard;
	}
	
	public void updateDeckAndDiscardPile(Player player,Card card){
		discardPile.addCardToDeck(card);
		player.removeCardFromHand(card);
	}
	
	public void updateTopOfDiscardPile(){
		turnsPlayed++;
		topOfDiscardPile = discardPile.getCardFromDeck(turnsPlayed);
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
		for(Card card : player.hand){
			if(card.toString().equalsIgnoreCase(cardName)){
				return card;
			}
		}
		throw new NullPointerException("card not found");
	}
	
	public void handleActionCard(Card actionCard){
		
	}
	
	public boolean isMoveLegal(Card card){
		String color = topOfDiscardPile.getColor();
		if(card.isWildCard() || topOfDiscardPile.isWildCard()){
			return true;
		}else if(card.isActionCard() || topOfDiscardPile.isActionCard()){
			if(card.getColor().equalsIgnoreCase(color)){
				return true;
			}else{
				return false;
			}
		}else{
			if(card.getColor().equalsIgnoreCase(color)){
				return true;
			}else if(card.getNr() == topOfDiscardPile.getNr()){
				return true;
			}else{
				return false;
			}
		}
	}
}
