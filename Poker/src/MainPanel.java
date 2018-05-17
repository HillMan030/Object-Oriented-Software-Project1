
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;

class MainPane1 extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	static int id = 0; // just for setting location
	private JButton go = new JButton("go");
	private JButton notgo = new JButton("notgo");
	private JButton get_card1 = new JButton("getcard1");
	private JButton get_card2 = new JButton("getcard2");
	private JButton shuffle = new JButton("shuffle");
	private JLabel ans = new JLabel("");
	private JLabel card1 = new JLabel("");
	private JLabel card2 = new JLabel("");

	Container cp = this.getContentPane();
	Scanner scanner = new Scanner(System.in);
	Deck deck = new Deck();
	Card[] cards = deck.returnCards();


	public MainPane1() {

		go.addActionListener(this);
		notgo.addActionListener(this);
		get_card1.addActionListener(this);
		get_card2.addActionListener(this);
		shuffle.addActionListener(this);
		//getContentPane().setLayout();
		// ans.setVerticalTextPosition(SwingConstants.BOTTOM);
		// go.setBounds(400,300,100,40);
		// ans.setBounds(500, 500, 500, 500);
		//cp.add(go,BorderLayout.EAST);
	    cp.setLayout(null);  //取消預設之 BorderLayout

		add(ans).setBounds(300, 100, 150, 100);
		add(card1).setBounds(100, 100, 150, 100);
		add(card2).setBounds(500, 100, 150, 100);
		add(get_card1).setBounds(100, 300, 100, 40);
		add(get_card2).setBounds(200, 300, 100, 40);
	    add(go).setBounds(300, 300, 100, 40);
		add(notgo).setBounds(400, 300, 100, 40);
		add(shuffle).setBounds(500, 300, 100, 40);
		this.setIconImage(this.getToolkit().getImage("poker.jpg"));
		this.setTitle("Game1");
		this.setSize(700, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		deck.fillDeck();
		deck.shuffle();
		card1.setIcon(new ImageIcon("pic\\0.jpg"));
		card2.setIcon(new ImageIcon("pic\\0.jpg"));
		ans.setIcon(new ImageIcon("pic\\0.jpg"));

	}

	public void actionPerformed(ActionEvent arg0) {

		if (arg0.getActionCommand() == "go") {
			shot(cards[0].getRank() + 1, cards[1].getRank() + 1, cards[2].getRank() + 1, cards[2].getSuit());
			// ans.setText("標籤 1");
		} else if (arg0.getActionCommand() == "notgo") {
			//System.out.println("Ended");
			card1.setText("");
			card2.setText("");
			ans.setText("");
			card1.setIcon(new ImageIcon("pic\\0.jpg"));
			card2.setIcon(new ImageIcon("pic\\0.jpg"));
			ans.setIcon(new ImageIcon("pic\\0.jpg"));

		} else if (arg0.getActionCommand() == "getcard1") {
			String str = new String();
			str = Integer.toString(cards[0].getRank() + 1 + 13 * cards[0].getSuit());
			card1.setText(cards[0].getRank() + " with suit " + cards[0].getSuit() + 1);
			card1.setIcon(new ImageIcon("pic\\" + str + ".png"));
		} else if (arg0.getActionCommand() == "getcard2") {
			String str = new String();
			str = Integer.toString(cards[1].getRank() + 1 + 13 * cards[1].getSuit());
			card2.setText(cards[1].getRank() + " with suit " + cards[1].getSuit() + 1);
			card2.setIcon(new ImageIcon("pic\\" + str + ".png"));
		} else if (arg0.getActionCommand() == "shuffle") {
			deck.shuffle();
			card1.setText("");
			card2.setText("");
			ans.setText("");
			card1.setIcon(new ImageIcon("pic\\0.jpg"));
			card2.setIcon(new ImageIcon("pic\\0.jpg"));
			ans.setIcon(new ImageIcon("pic\\0.jpg"));
		}

	}

	public void shot(int first, int second, int num, int num2) {

		if (num > first && num < second) {
			String str = new String();
			str = Integer.toString(num + 13 * num2);
			ans.setText(num + " is inside");
			ans.setIcon(new ImageIcon("pic\\" + str + ".png"));

		} else if (num < first || num > second) {
			String str = new String();
			str = Integer.toString(num + 13 * num2);
			ans.setText(num + "is outside");
			ans.setIcon(new ImageIcon("pic\\" + str + ".png"));
		} else if (num == first || num == second) {
			String str = new String();
			str = Integer.toString(num + 13 * num2);
			ans.setText(num + "is hitted");
			ans.setIcon(new ImageIcon("pic\\" + str + ".png"));

		}
	}
}
