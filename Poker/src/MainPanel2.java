import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;

class MainPane2 extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	static int id = 0;
	private JButton get_card1 = new JButton("getcard1");
	private JButton get_card2 = new JButton("getcard2");
	private JButton get_card3 = new JButton("getcard3");
	private JButton get_card4 = new JButton("getcard4");
	private JButton get_card5 = new JButton("getcard5");
	private JButton shuffle = new JButton("shuffle");
	private JButton end_game = new JButton("end game");
	private JLabel end = new JLabel("");
	private JLabel card1 = new JLabel("");
	private JLabel card2 = new JLabel("");
	private JLabel card3 = new JLabel("");
	private JLabel card4 = new JLabel("");
	private JLabel card5 = new JLabel("");
	private JLabel comcard1 = new JLabel("");
	private JLabel comcard2 = new JLabel("");
	private JLabel comcard3 = new JLabel("");
	private JLabel comcard4 = new JLabel("");
	private JLabel comcard5 = new JLabel("");
	private JLabel cSum = new JLabel("");
	private JLabel pSum = new JLabel("");
	private JLabel Sys = new JLabel("");
	private JLabel cCard = new JLabel("");
	private JLabel pCard = new JLabel("");
	private JLabel win = new JLabel("");
	int playerSum = 0, comSum = 0, comCard = 0, playerCard = 0, stCard;
	boolean check[] = {false, false, false, false, false};


	Container cp = this.getContentPane();
	Scanner scanner = new Scanner(System.in);
	Deck deck = new Deck();
	Card[] cards = deck.returnCards();


	public MainPane2() {

		get_card1.addActionListener(this);
		get_card2.addActionListener(this);
		get_card3.addActionListener(this);
		get_card4.addActionListener(this);
		get_card5.addActionListener(this);
		end_game.addActionListener(this);
		shuffle.addActionListener(this);
	    cp.setLayout(null);

		add(end).setBounds(300, 100, 150, 100);
		add(card1).setBounds(100, 100, 150, 100);
		add(card2).setBounds(200, 100, 150, 100);
		add(card3).setBounds(300, 100, 150, 100);
		add(card4).setBounds(400, 100, 150, 100);
		add(card5).setBounds(500, 100, 150, 100);
		add(comcard1).setBounds(100, 300, 150, 100);
		add(comcard2).setBounds(200, 300, 150, 100);
		add(comcard3).setBounds(300, 300, 150, 100);
		add(comcard4).setBounds(400, 300, 150, 100);
		add(comcard5).setBounds(500, 300, 150, 100);
		add(pCard).setBounds(300, 50, 450, 100);
		add(cCard).setBounds(300, 250, 450, 100);
		add(cSum).setBounds(200, 375, 450, 100);
		add(pSum).setBounds(400, 375, 450, 100);
		add(Sys).setBounds(300, 400, 450, 100);
		add(win).setBounds(300, 425, 450, 100);
		add(get_card1).setBounds(100, 525, 100, 40);
		add(get_card2).setBounds(200, 525, 100, 40);
	    add(get_card3).setBounds(300, 525, 100, 40);
		add(get_card4).setBounds(400, 525, 100, 40);
		add(get_card5).setBounds(500, 525, 100, 40);
		add(end_game).setBounds(200, 600, 100, 40);
		add(shuffle).setBounds(400, 600, 100, 40);
		this.setIconImage(this.getToolkit().getImage("poker.jpg"));
		this.setTitle("Game2");
		this.setSize(700, 800);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		deck.fillDeck();
		deck.shuffle();
		card1.setIcon(new ImageIcon("pic\\0.jpg"));
		card2.setIcon(new ImageIcon("pic\\0.jpg"));
		card3.setIcon(new ImageIcon("pic\\0.jpg"));
		card4.setIcon(new ImageIcon("pic\\0.jpg"));
		card5.setIcon(new ImageIcon("pic\\0.jpg"));
		comcard1.setIcon(new ImageIcon("pic\\0.jpg"));
		comcard2.setIcon(new ImageIcon("pic\\0.jpg"));
		comcard3.setIcon(new ImageIcon("pic\\0.jpg"));
		comcard4.setIcon(new ImageIcon("pic\\0.jpg"));
		comcard5.setIcon(new ImageIcon("pic\\0.jpg"));
		

	}

	public void actionPerformed(ActionEvent arg0) {
		
		pCard.setText("Your Card");
		cCard.setText("Computer Card");
		
		if (arg0.getActionCommand() == "getcard1") {
			if (check[0] == true) {
				String str = new String();
				str = "You cant get this card again";
				Sys.setText(str);
			}else {
			Sys.setText("");
			String str = new String();
			str = Integer.toString(cards[0].getRank() + 1 + 13 * cards[0].getSuit());
			card1.setIcon(new ImageIcon("pic\\"+ str + ".png"));
			playerCard++;
			playerSum = getSum(playerSum, cards[0].getRank() + 1);
			if (comSum < 17) {
			String str2 = new String();
			str2 = Integer.toString(cards[1].getRank() + 1 + 13 * cards[1].getSuit());
			if (comCard != 0) {
				comcard1.setIcon(new ImageIcon("pic\\"+ str2 + ".png"));
				//cSum.setText("Computer get: " + comSum );
			} else if (comCard == 0){
				stCard = 1;
			}
			comSum = getSum(comSum, cards[1].getRank() + 1);
			comCard++;
			}
			pSum.setText("You get: " + playerSum );
			//cSum.setText("Computer get: " + comSum );
			if (playerSum >= 21 || comSum >= 21) {
				String str3 = new String();
				str3 = Finish(playerSum, comSum);
				String str2 = new String();
				str2 = Integer.toString(cards[stCard].getRank() + 1 + 13 * cards[stCard].getSuit());
				comcard1.setIcon(new ImageIcon("pic\\"+ str2 + ".png"));
				cSum.setText("Computer get: " + comSum);
			    win.setText("\n"+str3);
			}
			check[0] = true;
			}
		} else if (arg0.getActionCommand() == "getcard2") {
			if (check[1] == true) {
				String str = new String();
				str = "You cant get this card again";
				Sys.setText(str);
			}else {
			Sys.setText("");
			String str = new String();
			str = Integer.toString(cards[2].getRank() + 1 + 13 * cards[2].getSuit());
			card2.setIcon(new ImageIcon("pic\\" + str + ".png"));
			playerCard++;
			playerSum = getSum(playerSum, cards[2].getRank() + 1);
			if (comSum < 17) {
				String str2 = new String();
				str2 = Integer.toString(cards[3].getRank() + 1 + 13 * cards[3].getSuit());
				if (comCard != 0) {
					comcard2.setIcon(new ImageIcon("pic\\"+ str2 + ".png"));
					//cSum.setText("Computer get: " + comSum );
				}else if (comCard == 0){
					stCard = 3;
				}
				comSum = getSum(comSum, cards[3].getRank() + 1);
				comCard++;
			}
			pSum.setText("You get: " + playerSum );
			//cSum.setText("Computer get: " + comSum );
			if (playerSum >= 21 || comSum >= 21) {
				String str3 = new String();
				str3 = Finish(playerSum, comSum);
				String str2 = new String();
				str2 = Integer.toString(cards[stCard].getRank() + 1 + 13 * cards[stCard].getSuit());
				switch (stCard) {
					case 1:
						comcard1.setIcon(new ImageIcon("pic\\"+ str2 + ".png"));
					break;
					case 3:
						comcard2.setIcon(new ImageIcon("pic\\"+ str2 + ".png"));
					break;
					case 5:
						comcard3.setIcon(new ImageIcon("pic\\"+ str2 + ".png"));
					break;
					case 7:
						comcard4.setIcon(new ImageIcon("pic\\"+ str2 + ".png"));
					break;
					case 9:
						comcard5.setIcon(new ImageIcon("pic\\"+ str2 + ".png"));
					break;
				}
				cSum.setText("Computer get: " + comSum);
			    win.setText("\n"+str3);
			}
			check[1] = true;
			}
		} else if (arg0.getActionCommand() == "getcard3") {
			if (check[2] == true) {
				String str = new String();
				str = "You cant get this card again";
				Sys.setText(str);
			}else {
			Sys.setText("");
			String str = new String();
			str = Integer.toString(cards[4].getRank() + 1 + 13 * cards[4].getSuit());
			card3.setIcon(new ImageIcon("pic\\" + str + ".png"));
			playerCard++;
			playerSum = getSum(playerSum, cards[4].getRank() + 1);
			if (comSum < 17) {
				String str2 = new String();
				str2 = Integer.toString(cards[5].getRank() + 1 + 13 * cards[5].getSuit());
				if (comCard != 0) {
					comcard3.setIcon(new ImageIcon("pic\\"+ str2 + ".png"));
					//cSum.setText("Computer get: " + comSum );
				}else if (comCard == 0){
					stCard = 5;
				}
				comSum = getSum(comSum, cards[5].getRank() + 1);
				comCard++;
			}
			pSum.setText("You get: " + playerSum );
			if (playerSum >= 21 || comSum >= 21) {
				String str3 = new String();
				str3 = Finish(playerSum, comSum);
				String str2 = new String();
				str2 = Integer.toString(cards[stCard].getRank() + 1 + 13 * cards[stCard].getSuit());
				switch (stCard) {
				case 1:
					comcard1.setIcon(new ImageIcon("pic\\"+ str2 + ".png"));
				break;
				case 3:
					comcard2.setIcon(new ImageIcon("pic\\"+ str2 + ".png"));
				break;
				case 5:
					comcard3.setIcon(new ImageIcon("pic\\"+ str2 + ".png"));
				break;
				case 7:
					comcard4.setIcon(new ImageIcon("pic\\"+ str2 + ".png"));
				break;
				case 9:
					comcard5.setIcon(new ImageIcon("pic\\"+ str2 + ".png"));
				break;
			}
				cSum.setText("Computer get: " + comSum);
			    win.setText("\n"+str3);
			}
			check[2] = true;
			}
		} else if (arg0.getActionCommand() == "getcard4") {
			if (check[3] == true) {
				String str = new String();
				str = "You cant get this card again";
				Sys.setText(str);
			}else {
			Sys.setText("");
			String str = new String();
			str = Integer.toString(cards[6].getRank() + 1 + 13 * cards[6].getSuit());
			card4.setIcon(new ImageIcon("pic\\" + str + ".png"));
			playerCard++;
			playerSum = getSum(playerSum, cards[6].getRank() + 1);
			if (comSum < 17) {
				String str2 = new String();
				str2 = Integer.toString(cards[7].getRank() + 1 + 13 * cards[7].getSuit());
				if (comCard != 0) {
					comcard4.setIcon(new ImageIcon("pic\\"+ str2 + ".png"));
					//cSum.setText("Computer get: " + comSum );
				}else if (comCard == 0){
					stCard = 7;
				}
				comSum = getSum(comSum, cards[7].getRank() + 1);
				comCard++;
			}
			pSum.setText("You get: " + playerSum );
			if (playerSum >= 21 || comSum >= 21) {
				String str3 = new String();
				str3 = Finish(playerSum, comSum);
				String str2 = new String();
				str2 = Integer.toString(cards[stCard].getRank() + 1 + 13 * cards[stCard].getSuit());
				switch (stCard) {
				case 1:
					comcard1.setIcon(new ImageIcon("pic\\"+ str2 + ".png"));
				break;
				case 3:
					comcard2.setIcon(new ImageIcon("pic\\"+ str2 + ".png"));
				break;
				case 5:
					comcard3.setIcon(new ImageIcon("pic\\"+ str2 + ".png"));
				break;
				case 7:
					comcard4.setIcon(new ImageIcon("pic\\"+ str2 + ".png"));
				break;
				case 9:
					comcard5.setIcon(new ImageIcon("pic\\"+ str2 + ".png"));
				break;
			}
				cSum.setText("Computer get: " + comSum);
			    win.setText("\n"+str3);
			}
			check[3] = true;
			}
		} else if (arg0.getActionCommand() == "getcard5") {
			if (check[4] == true) {
				String str = new String();
				str = "You cant get this card again";
				Sys.setText(str);
			}else {
			Sys.setText("");
			String str1 = new String();
			str1 = Integer.toString(cards[8].getRank() + 1 + 13 * cards[8].getSuit());
			card5.setIcon(new ImageIcon("pic\\" + str1 + ".png"));
			playerCard++;
			playerSum = getSum(playerSum, cards[8].getRank() + 1);
			if (comSum < 17) {
				String str2 = new String();
				str2 = Integer.toString(cards[9].getRank() + 1 + 13 * cards[9].getSuit());
				if (comCard != 0) {
					comcard5.setIcon(new ImageIcon("pic\\"+ str2 + ".png"));
					//cSum.setText("Computer get: " + comSum );
				}else if (comCard == 0){
					stCard = 9;
				}
				comSum = getSum(comSum, cards[9].getRank() + 1);
				comCard++;
			}
			pSum.setText("You get: " + playerSum );
			//cSum.setText("Computer get: " + comSum );
			if (playerSum >= 21 || comSum >= 21) {
				String str3 = new String();
				str3 = Finish(playerSum, comSum);
				String str2 = new String();
				str2 = Integer.toString(cards[stCard].getRank() + 1 + 13 * cards[stCard].getSuit());
				switch (stCard) {
				case 1:
					comcard1.setIcon(new ImageIcon("pic\\"+ str2 + ".png"));
				break;
				case 3:
					comcard2.setIcon(new ImageIcon("pic\\"+ str2 + ".png"));
				break;
				case 5:
					comcard3.setIcon(new ImageIcon("pic\\"+ str2 + ".png"));
				break;
				case 7:
					comcard4.setIcon(new ImageIcon("pic\\"+ str2 + ".png"));
				break;
				case 9:
					comcard5.setIcon(new ImageIcon("pic\\"+ str2 + ".png"));
				break;
				}
				cSum.setText("Computer get: " + comSum);
			    win.setText("\n"+str3);
			}
			check[4] = true;
			}
		}  else if (arg0.getActionCommand() == "end game") {
			String str = new String();

			if (playerCard <= 1) {
				if (stCard == 1) {
					str = Integer.toString(cards[3].getRank() + 1 + 13 * cards[3].getSuit());
					comcard2.setIcon(new ImageIcon("pic\\"+ str + ".png"));
					comSum = getSum(comSum, cards[3].getRank() + 1);
				} else if (comCard >= 1){
					str = Integer.toString(cards[1].getRank() + 1 + 13 * cards[3].getSuit());
					comcard1.setIcon(new ImageIcon("pic\\"+ str + ".png"));
					comSum = getSum(comSum, cards[1].getRank() + 1);
				}
			}
			String str1 = new String();
			str1 = Finish(playerSum, comSum);
			String str3 = new String();
			str3 = Integer.toString(cards[stCard].getRank() + 1 + 13 * cards[stCard].getSuit());
			switch (stCard) {
			case 1:
				comcard1.setIcon(new ImageIcon("pic\\"+ str3 + ".png"));
			break;
			case 3:
				comcard2.setIcon(new ImageIcon("pic\\"+ str3 + ".png"));
			break;
			case 5:
				comcard3.setIcon(new ImageIcon("pic\\"+ str3 + ".png"));
			break;
			case 7:
				comcard4.setIcon(new ImageIcon("pic\\"+ str3 + ".png"));
			break;
			case 9:
				comcard5.setIcon(new ImageIcon("pic\\"+ str3 + ".png"));
			break;
			}
			cSum.setText("Computer get: " + comSum);
			pSum.setText("  Sum: " + playerSum );
			win.setText(str1);

			
		}else if (arg0.getActionCommand() == "shuffle") {
			playerSum = 0;
			comSum = 0;
			comCard = 0;
			playerCard = 0;
			for (int i = 0; i<5; i++) {
			check[i] = false;
			}
			deck.shuffle();
			Sys.setText("");
			card1.setIcon(new ImageIcon("pic\\0.jpg"));
			card2.setIcon(new ImageIcon("pic\\0.jpg"));
			card3.setIcon(new ImageIcon("pic\\0.jpg"));
			card4.setIcon(new ImageIcon("pic\\0.jpg"));
			card5.setIcon(new ImageIcon("pic\\0.jpg"));
			comcard1.setIcon(new ImageIcon("pic\\0.jpg"));
			comcard2.setIcon(new ImageIcon("pic\\0.jpg"));
			comcard3.setIcon(new ImageIcon("pic\\0.jpg"));
			comcard4.setIcon(new ImageIcon("pic\\0.jpg"));
			comcard5.setIcon(new ImageIcon("pic\\0.jpg"));
			win.setText(" ");
			cSum.setText(" ");
			pSum.setText("  You get: " + playerSum );

		}

	}
	
	public static int getSum(int Sum, int Card) {
		
		if ((Card == 11) || (Card == 12) || (Card == 13)) {
			Sum = Sum + 10;
		} else {					
			Sum = Sum + Card;
		}
		return Sum;
	}
	
	public static String Finish(int playerSum, int cSum) {
		
		if (playerSum > 21) {
			return "You Lose"; 
		}else if (cSum > 21){
			return "You Win";
		}else if (playerSum > cSum){
			return "You Win";
		}else if (playerSum < cSum){
			return "You Lose";
		}else if (playerSum == cSum) {
			return "You Lose";
		}
		else {
			return null;
		}	
		}
	}

