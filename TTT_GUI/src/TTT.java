import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.Font;

public class TTT {

	private JFrame frame;
	
	private String startGame = "X";
	
	//if winner = 1, game has been won by X. Else if winner = 2, game has been won by O.
	int winner = 0;
	
	private JLabel B1;
	private JLabel B2;
	private JLabel B3;
	private JLabel B4;
	private JLabel B5;
	private JLabel B6;
	private JLabel B7;
	private JLabel B8;
	private JLabel B9;
	

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
		String b1 = B1.getText();
		String b2 = B2.getText();
		String b3 = B3.getText();
		String b4 = B4.getText();
		String b5 = B5.getText();
		String b6 = B6.getText();
		String b7 = B7.getText();
		String b8 = B8.getText();
		String b9 = B9.getText();
		
		//All possible X wins
		if( b1 == "X" && b2 == "X" && b3 =="X")
			winner = 1;
		else if( b4 == "X" && b5 == "X" && b6 =="X")
			winner = 1;
		else if( b7 == "X" && b8 == "X" && b9 =="X")
			winner = 1;
		else if( b1 == "X" && b4 == "X" && b7 =="X")
			winner = 1;
		else if( b2 == "X" && b5 == "X" && b8 =="X")
			winner = 1;
		else if( b3 == "X" && b6 == "X" && b9 =="X")
			winner = 1;
		else if( b1 == "X" && b5 == "X" && b9 =="X")
			winner = 1;
		else if( b3 == "X" && b5 == "X" && b7 =="X")
			winner = 1;
		
		//All possible O wins
		else if( b1 == "O" && b2 == "O" && b3 =="O")
			winner = 1;
		else if( b4 == "O" && b5 == "O" && b6 =="O")
			winner = 1;
		else if( b7 == "O" && b8 == "O" && b9 =="O")
			winner = 1;
		else if( b1 == "O" && b4 == "O" && b7 =="O")
			winner = 1;
		else if( b2 == "O" && b5 == "O" && b8 =="O")
			winner = 1;
		else if( b3 == "O" && b6 == "O" && b9 =="O")
			winner = 1;
		else if( b1 == "O" && b5 == "O" && b9 =="O")
			winner = 1;
		else if( b3 == "O" && b5 == "O" && b7 =="O")
			winner = 1;
		
		displayWinner();
	}
	
	//Displays the Winner
	public void displayWinner() {
		if ( winner == 1)
			JOptionPane.showMessageDialog( frame, "Player X Wins!", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
		else if ( winner == 2)
			JOptionPane.showMessageDialog( frame, "Player O Wins!", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);


	}
	
	/**
	 * Does literally nothing
	 */

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(3, 3, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JButton B1 = new JButton("");
		B1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a) {
				if ( B1.getText() == "X" || B1.getText() == "O") {
					JOptionPane.showMessageDialog( frame, "Symbol already there.", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					B1.setText(startGame);
					if( startGame.equalsIgnoreCase("X"))
						B1.setForeground(Color.RED);
					else
						B1.setForeground(Color.BLUE);
					choosePlayer();
					WonGame();
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
				}
				else {
					B2.setText(startGame);
					if( startGame.equalsIgnoreCase("X"))
						B2.setForeground(Color.RED);
					else
						B2.setForeground(Color.BLUE);
					choosePlayer();
					WonGame();
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
				}
				else {
					B3.setText(startGame);
					if( startGame.equalsIgnoreCase("X"))
						B3.setForeground(Color.RED);
					else
						B3.setForeground(Color.BLUE);
					choosePlayer();
					WonGame();
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
				}
				else {
					B4.setText(startGame);
					if( startGame.equalsIgnoreCase("X"))
						B4.setForeground(Color.RED);
					else
						B4.setForeground(Color.BLUE);
					choosePlayer();
					WonGame();
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
				}
				else {
					B5.setText(startGame);
					if( startGame.equalsIgnoreCase("X"))
						B5.setForeground(Color.RED);
					else
						B5.setForeground(Color.BLUE);
					choosePlayer();
					WonGame();
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
				}
				else {
					B6.setText(startGame);
					if( startGame.equalsIgnoreCase("X"))
						B6.setForeground(Color.RED);
					else
						B6.setForeground(Color.BLUE);
					choosePlayer();
					WonGame();
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
				}
				else {
				B7.setText(startGame);
				if( startGame.equalsIgnoreCase("X"))
					B7.setForeground(Color.RED);
				else
					B7.setForeground(Color.BLUE);
				choosePlayer();
				WonGame();
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
				}
				else {
					B8.setText(startGame);
					if( startGame.equalsIgnoreCase("X"))
						B8.setForeground(Color.RED);
					else
						B8.setForeground(Color.BLUE);
					choosePlayer();
					WonGame();
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
				}
				else {
					B9.setText(startGame);
					if( startGame.equalsIgnoreCase("X"))
						B9.setForeground(Color.RED);
					else
						B9.setForeground(Color.BLUE);
					choosePlayer();
					WonGame();
				}
			}
		});
		B9.setFont(new Font("Arial Black", Font.BOLD, 99));
		panel_9.add(B9, BorderLayout.CENTER);
	}

}
