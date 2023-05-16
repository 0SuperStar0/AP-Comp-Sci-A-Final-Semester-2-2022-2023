import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;

public class TTT {

	private JFrame frame;
	
	private String startGame = "X";
	
	//if winner = 1, game has been won by X. Else if winner = 2, game has been won by O. Else if winner = 3, board is full
	int winner = 0;
	//keeps track of turns
	int turn;
	
	//Strings to keep track of what symbol is in what grid spot
	String b1 = "N";
	String b2 = "N";
	String b3 = "N";
	String b4 = "N";
	String b5 = "N";
	String b6 = "N";
	String b7 = "N";
	String b8 = "N";
	String b9 = "N";
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TTT window = new TTT();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TTT() {
		initialize();
	}
	
	/**
	 * Method to swap between X and O
	 */
	private void choosePlayer() {
		if( startGame.equalsIgnoreCase("X"))
			startGame = "O";
		else
			startGame = "X";
	}
	
	/**
	 * Method to check if someone has won
	 */
	public void WonGame()
	{
		
		//All possible X wins
		if( b1 == "X" && b2 == "X" && b3 =="X") {
			winner = 1;
			System.out.print("X Win Condition 1");
		}
		else if( b4 == "X" && b5 == "X" && b6 =="X") {
			winner = 1;
			System.out.print("X Win Condition 2");
		}
		else if( b7 == "X" && b8 == "X" && b9 =="X") {
			winner = 1;
			System.out.print("X Win Condition 3");
		}
		else if( b1 == "X" && b4 == "X" && b7 =="X") {
			winner = 1;
			System.out.print("X Win Condition 4");
		}
		else if( b2 == "X" && b5 == "X" && b8 =="X") {
			winner = 1;
			System.out.print("X Win Condition 5");
		}
		else if( b3 == "X" && b6 == "X" && b9 =="X") {
			winner = 1;
			System.out.print("X Win Condition 6");
		}
		else if( b1 == "X" && b5 == "X" && b9 =="X") {
			winner = 1;
			System.out.print("X Win Condition 7");
		}
		else if( b3 == "X" && b5 == "X" && b7 =="X") {
			winner = 1;
			System.out.print("X Win Condition 8");
		}
		
		//All possible O wins
		else if( b1 == "O" && b2 == "O" && b3 =="O") {
			winner = 2;
			System.out.print("O Win Condition 1");
		}
		else if( b4 == "O" && b5 == "O" && b6 =="O") {
			winner = 2;
			System.out.print("O Win Condition 2");
		}
		else if( b7 == "O" && b8 == "O" && b9 =="O") {
			winner = 2;
			System.out.print("O Win Condition 3");
		}
		else if( b1 == "O" && b4 == "O" && b7 =="O") {
			winner = 2;
			System.out.print("O Win Condition 4");
		}
		else if( b2 == "O" && b5 == "O" && b8 =="O") {
			winner = 2;
			System.out.print("O Win Condition 5");
		}
		else if( b3 == "O" && b6 == "O" && b9 =="O") {
			winner = 2;
			System.out.print("O Win Condition 6");
		}
		else if( b1 == "O" && b5 == "O" && b9 =="O") {
			winner = 2;
			System.out.print("O Win Condition 7");
		}
		else if( b3 == "O" && b5 == "O" && b7 =="o") {
			winner = 2;
			System.out.print("X Win Condition 8");
		}
		
		//If board is full, no one wins and winner value is 3
		else if (turn >= 9) {
			winner = 3;
			System.out.print("Board Full");
		}
		if( winner > 0)
			displayWinner();
	}
	
	//Displays the Winner based on the winner variable being 1 for X or 2 for O
	public void displayWinner() {
		if ( winner == 1)
			JOptionPane.showMessageDialog( frame, "Player X Wins!", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
		else if ( winner == 2)
			JOptionPane.showMessageDialog( frame, "Player O Wins!", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
		else if ( winner == 3)
			JOptionPane.showMessageDialog( frame, "No player won. Board is full", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
	}

	//outputs value of a grid spot into console. This is for debugging.
	public void val( int a, String b ) {
		String c ="B" + a + " now is " +b + "\n";
		System.out.printf(c);
	}

	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//settings for the window
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(3, 3, 0, 0));
		
		
		//all JPanels and their buttons.
		/**
		 * The Buttons work like this
		 * 
		 * 1. Check if there is an X or O
		 * 		if an X or O is there, then it doesn't allow a move and tells the player
		 * 2. if there isn't an X or O, it places the X or O, swaps symbols for next turn and then places the symbol on the b string variable
		 * 		then checks if the player won the game.
		 */
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JButton B1 = new JButton("");
		B1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a) {
				if ( B1.getText() == "X" || B1.getText() == "O") {
					JOptionPane.showMessageDialog( frame, "Symbol already there.", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
					System.out.print("B1 already has a value\n");
				}
				else if (winner == 1 || winner == 2) {
					JOptionPane.showMessageDialog( frame, "Game has already been won.", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
					System.out.print("Game has been won." + "\n");
				}
				else {
					B1.setText(startGame);
					if( startGame.equalsIgnoreCase("X")) {
						B1.setForeground(Color.RED);
						b1 = "X";
						val(1,b1);
					}
					else {
						B1.setForeground(Color.BLUE);
						b1 = "O";
						val(1,b1);
					}
					choosePlayer();
					WonGame();
					turn++;
				}
			}
		});
		B1.setFont(new Font("Arial Black", Font.BOLD, 99));
		panel_1.add(B1, BorderLayout.CENTER);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JButton B2 = new JButton("");
		B2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a) {
				if ( B2.getText() == "X" || B2.getText() == "O") {
					JOptionPane.showMessageDialog( frame, "Symbol already there.", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
					System.out.print("B2 already has a value" + "\n");
				}
				else if (winner == 1 || winner == 2) {
					JOptionPane.showMessageDialog( frame, "Game has already been won.", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
					System.out.print("Game has been won." + "\n");
				}
				else {
					B2.setText(startGame);
					if( startGame.equalsIgnoreCase("X")) {
						B2.setForeground(Color.RED);
						b2 = "X";
						val(2,b2);
					}
					else {
						B2.setForeground(Color.BLUE);
						b2 = "O";
						val(2,b2);
					}
					choosePlayer();
					WonGame();
					turn++;
				}
			}
		});
		B2.setFont(new Font("Arial Black", Font.BOLD, 99));
		panel_2.add(B2, BorderLayout.CENTER);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JButton B3 = new JButton("");
		B3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a) {
				if ( B3.getText() == "X" || B3.getText() == "O") {
					JOptionPane.showMessageDialog( frame, "Symbol already there.", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
					System.out.print("B3 already has a value" + "\n");
				}
				else if (winner == 1 || winner == 2) {
					JOptionPane.showMessageDialog( frame, "Game has already been won.", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
					System.out.print("Game has been won." + "\n");
				}
				else {
					B3.setText(startGame);
					if( startGame.equalsIgnoreCase("X")) {
						B3.setForeground(Color.RED);
						b3 = "X";
						val(3,b3);
					}
					else {
						B3.setForeground(Color.BLUE);
						b3 = "O";
						val(3,b3);
					}
					choosePlayer();
					WonGame();
					turn++;
				}
			}
		});
		B3.setFont(new Font("Arial Black", Font.BOLD, 99));
		panel_3.add(B3, BorderLayout.CENTER);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JButton B4 = new JButton("");
		B4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a) {
				if ( B4.getText() == "X" || B4.getText() == "O") {
					JOptionPane.showMessageDialog( frame, "Symbol already there.", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
					System.out.print("B4 already has a value" + "\n");
				}
				else if (winner == 1 || winner == 2) {
					JOptionPane.showMessageDialog( frame, "Game has already been won.", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
					System.out.print("Game has been won." + "\n");
				}
				else {
					B4.setText(startGame);
					if( startGame.equalsIgnoreCase("X")) {
						B4.setForeground(Color.RED);
						b4 = "X";
						val(4,b4);
					}
					else {
						B4.setForeground(Color.BLUE);
						b4 = "O";
						val(4,b4);
					}
					choosePlayer();
					WonGame();
					turn++;
				}
			}
		});
		B4.setFont(new Font("Arial Black", Font.BOLD, 99));
		panel_4.add(B4, BorderLayout.CENTER);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.add(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JButton B5 = new JButton("");
		B5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a) {
				if ( B5.getText() == "X" || B5.getText() == "O") {
					JOptionPane.showMessageDialog( frame, "Symbol already there.", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
					System.out.print("B5 already has a value" + "\n");
				}
				else if (winner == 1 || winner == 2) {
					JOptionPane.showMessageDialog( frame, "Game has already been won.", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
					System.out.print("Game has been won." + "\n");
				}
				else {
					B5.setText(startGame);
					if( startGame.equalsIgnoreCase("X")) {
						B5.setForeground(Color.RED);
						b5 = "X";
						val(5,b5);
					}
					else {
						B5.setForeground(Color.BLUE);
						b5 = "O";
						val(5,b5);
					}
					choosePlayer();
					WonGame();
					turn++;
				}
			}
		});
		B5.setFont(new Font("Arial Black", Font.BOLD, 99));
		panel_5.add(B5, BorderLayout.CENTER);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.add(panel_6);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		JButton B6 = new JButton("");
		B6.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a) {
				if ( B6.getText() == "X" || B6.getText() == "O") {
					JOptionPane.showMessageDialog( frame, "Symbol already there.", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
					System.out.print("B6 already has a value" + "\n");
				}
				else if (winner == 1 || winner == 2) {
					JOptionPane.showMessageDialog( frame, "Game has already been won.", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
					System.out.print("Game has been won." + "\n");
				}
				else {
					B6.setText(startGame);
					if( startGame.equalsIgnoreCase("X")) {
						B6.setForeground(Color.RED);
						b6 = "X";
						val(6,b6);
					}
					else {
						B6.setForeground(Color.BLUE);
						b6 = "O";
						val(6,b6);
					}
					choosePlayer();
					WonGame();
					turn++;
				}
			}
		});
		B6.setFont(new Font("Arial Black", Font.BOLD, 99));
		panel_6.add(B6, BorderLayout.CENTER);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.add(panel_7);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		JButton B7 = new JButton("");
		B7.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a) {
				if ( B7.getText() == "X" || B7.getText() == "O") {
					JOptionPane.showMessageDialog( frame, "Symbol already there.", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
					System.out.print("B7 already has a value" + "\n");
				}
				else if (winner == 1 || winner == 2) {
					JOptionPane.showMessageDialog( frame, "Game has already been won.", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
					System.out.print("Game has been won." + "\n");
				}
				else {
				B7.setText(startGame);
				if( startGame.equalsIgnoreCase("X")) {
					B7.setForeground(Color.RED);
					b7 = "X";
					val(7,b7);
				}
				else {
					B7.setForeground(Color.BLUE);
					b7 = "O";
					val(7,b7);
				}
				choosePlayer();
				WonGame();
				turn++;
				}
			}
		});
		B7.setFont(new Font("Arial Black", Font.BOLD, 99));
		panel_7.add(B7, BorderLayout.CENTER);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.add(panel_8);
		panel_8.setLayout(new BorderLayout(0, 0));
		
		JButton B8 = new JButton("");
		B8.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a) {
				if ( B8.getText() == "X" || B8.getText() == "O") {
					JOptionPane.showMessageDialog( frame, "Symbol already there.", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
					System.out.print("B8 already has a value" + "\n");
				}
				else if (winner == 1 || winner == 2) {
					JOptionPane.showMessageDialog( frame, "Game has already been won.", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
					System.out.print("Game has been won." + "\n");
				}
				else {
					B8.setText(startGame);
					if( startGame.equalsIgnoreCase("X")) {
						B8.setForeground(Color.RED);
						b8 = "X";
						val(8,b8);
					}
					else {
						B8.setForeground(Color.BLUE);
						b8 = "O";
						val(8,b8);
					}
					choosePlayer();
					WonGame();
					turn++;
				}
			}
		});
		B8.setFont(new Font("Arial Black", Font.BOLD, 99));
		panel_8.add(B8, BorderLayout.CENTER);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.add(panel_9);
		panel_9.setLayout(new BorderLayout(0, 0));
		
		JButton B9 = new JButton("");
		B9.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a) {
				if ( B9.getText() == "X" || B9.getText() == "O") {
					JOptionPane.showMessageDialog( frame, "Symbol already there.", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
					System.out.print("B9 already has a value" + "\n");
				}
				else if (winner == 1 || winner == 2) {
					JOptionPane.showMessageDialog( frame, "Game has already been won.", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
					System.out.print("Game has been won." + "\n");
				}
				else {
					B9.setText(startGame);
					if( startGame.equalsIgnoreCase("X")) {
						B9.setForeground(Color.RED);
						b9 = "X";
						val(9,b9);
					}
					else {
						B9.setForeground(Color.BLUE);
						b9 = "O";
						val(9,b9);
					}
					choosePlayer();
					WonGame();
					turn++;
				}
			}
		});
		B9.setFont(new Font("Arial Black", Font.BOLD, 99));
		panel_9.add(B9, BorderLayout.CENTER);
	}

}
