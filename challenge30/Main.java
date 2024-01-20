/* 
Ik weet niet hoe ik deze opdracht moet oplossen, het lijkt erop dat de kaarten in de deck naar dezelfde kaart verwijzen
Maar volgens mij maak ik een nieuw object aan voor elke kaart. 
*/
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
				System.out.println("counter = " + counter + " rank: " + rank.toString() + " color: " + color);	//debug statements
				deck[counter++] = new Card(color.toString(),rank.toString());
				System.out.println("The card: " + deck[counter-1].toString());	//debug statements
			}
		}
		deck[0] = new Card("red", "three");	//debug statements
		deck[1] = new Card("blue", "five");	//debug statements
		System.out.println("-------------------------------------");
		for(Card card : deck){
			System.out.println(card.toString());	//debug statements
		}
	}
}

/*Answer this question: Why do you think we used a color enumeration here but made a color class
in the previous challenge?
My guess is that the class is suposed to be used for the actual appearance of the card, and this one for the descriptive part of the card
*/