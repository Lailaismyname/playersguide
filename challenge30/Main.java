public class Main{
	//enums
	enum CardColor{
		RED,
		GREEN,
		BLUE,
		YELLOW;
	}
	enum CardRanks{
		DOLLAR,
		PERCENT,
		CIRCUMFLEX,
		AMPERSAND,
		TEN,
		NINE,
		EIGHT,
		SEVEN,
		SIX,
		FIVE,
		FOUR,
		THREE,
		TWO,
		ONE;
	}
	//main method
	public static void main(String[] args){
		Card[] deck = new Card[56];
		int counter = 0;
		
		for(CardColor color: CardColor.values()){
			for(CardRanks rank : CardRanks.values()){
				deck[counter++] = new Card(color.toString(),rank.toString());
				System.out.println("The card: " + deck[counter-1].toString());	//debug statements
			}
		}
	}
}

/*Answer this question: Why do you think we used a color enumeration here but made a color class
in the previous challenge?
My guess is that the class is suposed to be used for the actual appearance of the card, and this one for the descriptive part of the card
*/
