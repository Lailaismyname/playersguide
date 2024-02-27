class DiscardPile extends Deck{
	
	
	public void addCardToDeck(Card card){
		deck.add(card);
	}
	
	public Card getCardFromDeck(int cardToGet){
		Card card = deck.get(cardToGet);
		return card;
	}
}