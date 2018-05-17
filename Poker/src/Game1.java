import java.util.Scanner;
import java.awt.*;
import javax.swing.*;

public class Game1 {

	public void startgame1() {

		Scanner scanner = new Scanner(System.in);
		Deck deck = new Deck();
		Card[] cards = deck.returnCards();

		do {
			deck.fillDeck();
			deck.shuffle();
			for (int i = 0; i <= 1; i++) {

				System.out.print(cards[i].getRank() + 1 + " Suit(" + (cards[i].getSuit() + 1 + ")       "));

			}
			
			System.out.printf("\nshot or not?!(Y or N)\n");
			char shot = scanner.next().charAt(0);
			switch (shot) {
			case 'Y':
			case 'y':
				shot(cards[0].getRank() + 1, cards[1].getRank() + 1, cards[2].getRank() + 1);
				break;
			case 'N':
			case 'n':
				break;
			}
			System.out.printf("exit please input 0 ,others to draw\n");

		} while (scanner.next().charAt(0) != '0');
		System.out.printf("bye\n");
	}

	public static void shot(int first, int second, int num) {

		if (num > first && num < second) {
			System.out.printf("%d is inside %d and %d\n", num, first, second);
		} else if (num < first && num > second) {
			System.out.printf("%d is inside %d and %d\n", num, second, first);
		} else if (num == first || num == second) {
			System.out.printf("%d is hited %d and %d\n", num, first, second);
		} else {
			System.out.printf("%d is outside %d and %d\n", num, first, second);
		}
	}

}