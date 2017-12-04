import java.util.ArrayList;
import java.util.Random;
//TODO: please add new fields and methods to Deck class (35)
		//usedCard (5 points)
		//nUsed (5 points)
		//getOneCard (10 points)
		//shuffle (10 points)
		//constructor (5 points)
public class Deck {
	//新增private field ArrayList<Card> card
	private ArrayList<Card> card;
	//新增private field ArrayList<Card> usedcard
	private ArrayList<Card> usedCard;
	//新增一個private fieled nUsed
	private int nUsed = -1;
	public Deck(int nDeck) {
		card = new ArrayList<Card>();
		usedCard =new ArrayList<Card>();
		int i;
		int rank;
		for (i = 1; i <= nDeck; i++) 
		{
			for (Card.Suit suit : Card.Suit.values()) 
			{
				for (rank = 1; rank <= 13; rank++)
				{
					Card card = new Card(suit,rank);
					card.add(card);
				}
			}
		}
		shuffle();
	}
	//將所有的牌都印出
	public void printDeck() {
		for(Card a:card)
		{
			a.printCard();
		}
	}
	//如果nUsed牌用過一次就+1，當牌剛好用完52張就洗牌
	public Card getOneCard() {
		nUsed = nUsed + 1;
		if(nUsed == 52)
		{
			usedCard.clear();
			shuffle();
		}
		usedCard.add(card.get(nUsed));
		return card.get(nUsed);
	}
	public void shuffle() {
		ArrayList<Card> NewCard = new ArrayList<Card>();
		Random rnd = new Random();
		Card c;
		int i;
		for (i = 0; i <=nUsed; i++) 
		{
			card.add(usedCard.get(i));	
			do 
			{
				c = card.get(rnd.nextInt(52));
			} 
			while(NewCard.contains(c));
			NewCard.add(c);
		}
		card.clear();
		card = NewCard;
		nUsed = 0;
	}
	public ArrayList<Card> getAllCards() {
		return card;
	}
	public Card getOneCard(boolean l) {
		return null;
	}
}