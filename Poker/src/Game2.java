import java.util.Scanner;
import java.awt.*;
import javax.swing.*;

public class Game2 {
	Deck deck = new Deck();
	Scanner scanner = new Scanner(System.in);	
	Card[] cards = deck.returnCards();
	int playerSum, cardNum;
	
	public void startgame2() {
		do {
		deck.fillDeck();
		deck.shuffle();
			
			
			int j;
			cardNum = 2;
			boolean GameOver = false;
			for (j = 0; j<cardNum; j++) {
			System.out.print(cards[j].getRank() + 1 + " Suit(" + (cards[j].getSuit() + 1 + ")	"));
			}
			playerSum = getSum(playerSum, cards[0].getRank() + 1);
			playerSum = getSum(playerSum, cards[1].getRank() + 1);

			System.out.print("\nSum: " + playerSum +"\n");
			do {			
			System.out.print("get one more card or not?!(Y or N)\n");
			char choose = scanner.next().charAt(0);
			
			switch (choose) {
			case 'Y':
			case 'y':
				cardNum = cardNum+1;	
				for (j = 0; j<cardNum; j++) {
					System.out.print(cards[j].getRank() + 1 + " Suit(" + (cards[j].getSuit() + 1 + ")	"));
				}
				playerSum = getSum(playerSum, cards[cardNum-1].getRank() + 1);
				System.out.print("\nSum: " + playerSum + "\n");
				if (playerSum > 21) {
					System.out.print("Your card is too big\n");
					GameOver = true;
				}
				break;
			case 'N':
			case 'n':
				break;
			}
			if (GameOver != true) {
				System.out.printf("exit please input 0 ,others to continue\n");
			}
			if (GameOver == true || scanner.next().charAt(0) == '0') {
				break;
			}

		} while (true);
		
		Finish(playerSum);
		System.out.print("Start a new game?\n1: Yes\n2: No\n");
		char ch = scanner.next().charAt(0);
		if (ch == '2')
			break;
		} while (true);
		System.out.printf("bye\n");
	}
	
	public static int getSum(int Sum, int Card) {
				
		if ((Card == 11) || (Card == 12) || (Card == 13)) {
			Sum = Sum + 10;
		} else {					
			Sum = Sum + Card;
		}
		return Sum;
	}
	
	public static void Finish(int playerSum) {
		if (playerSum > 21) {
			System.out.print("You Lose\n");
		} else {
			System.out.print("You Win\n");
		}
	}

}