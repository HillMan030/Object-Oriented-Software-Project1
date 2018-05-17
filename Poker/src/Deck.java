
import java.util.Random;

public class Deck implements DeckInterface {

	private  Card[] deck = new Card[52];

	public void fillDeck() {
		int i = 0;
		for (int suit = 0; suit <= 3; suit++) {
			for (int rank = 0; rank <= 12; rank++) {
				deck[i] = new Card();
				deck[i].setRank(rank);
				deck[i].setSuit(suit);
				i++;
			}
		}
	}
	
	public void shuffle()// shuffle deck
	{
		Random r = new Random();
		for (int i = 0; i != 52; ++i) {
			int number1 = r.nextInt(52);
			int number2 = r.nextInt(52);

			Card temp = deck[number1];
			deck[number1] = deck[number2];
			deck[number2] = temp;
		}
	}

	public void printdeck() {

		for (int i = 0; i <= 51; i++) {
			System.out.printf("%d %d\n", deck[i].getRank() + 1, deck[i].getSuit() + 1);
		}
	}

	public Card[] returnCards()
	{
		return deck ;
	}
	
}
