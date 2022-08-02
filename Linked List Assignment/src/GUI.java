/* Name: Shelley Chen
 * Date: March 11, 2022
 * Course Code: ICS4U0-A
 * Assignment: Linked List Assignment
 * Program Description: This program prompts the user for text input and checks if what the users types in
 * is a palindrome or not. A check button is used to submit text, a reset button clears the input fields 
 * and output messages, and the quit button exits the program. 
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.lang.*;


import java.lang.*;
import javax.swing.SwingConstants;

public class GUI extends JFrame {

	private JPanel contentPane;
	private JTextField wordTextField;
	static String userText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);		
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel titleLabel = new JLabel("Palindrome Checker");
		titleLabel.setBounds(163, 21, 125, 16);
		contentPane.add(titleLabel);
		
		JLabel promptLabel = new JLabel("Enter text:");
		promptLabel.setBounds(37, 59, 82, 16);
		contentPane.add(promptLabel);
		
		wordTextField = new JTextField();
		wordTextField.setBounds(113, 54, 296, 26);
		contentPane.add(wordTextField);
		wordTextField.setColumns(10);
		
		JLabel outputLabel = new JLabel("");
		outputLabel.setHorizontalAlignment(SwingConstants.CENTER);
		outputLabel.setBounds(88, 162, 278, 16);
		contentPane.add(outputLabel);
		
		JButton checkButton = new JButton("Check");
		checkButton.setBounds(86, 100, 117, 29);
		contentPane.add(checkButton);
		
		JButton resetButton = new JButton("Reset");
		resetButton.setBounds(232, 100, 117, 29);
		contentPane.add(resetButton);
		
		JButton quitButton = new JButton("Quit");
		quitButton.setBounds(160, 206, 117, 29);
		contentPane.add(quitButton);

		
		checkButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				checkButton.setEnabled(false);
				outputLabel.setVisible(true);
				wordTextField.setEditable(false);
				userText = wordTextField.getText(); // get text from text field
				String filteredUserText = filterText(userText); // call method to filter text, assign to variable
				CharactersLinkedList charList = new CharactersLinkedList(filteredUserText); // instantiate new characters linked list
				
				// call method to check if word is a palindrome
				if (isPalindrome(charList)) outputLabel.setText("Input IS a palindrome"); // set text of output label accordingly
				else outputLabel.setText("Input IS NOT a palindrome");
			}
		});
		
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				
				wordTextField.setText("");
				outputLabel.setText("");
				outputLabel.setVisible(false);
				checkButton.setEnabled(true);
				wordTextField.setEditable(true);
			}
		});
		
		quitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
		});
	
	} // GUI
	
	// method sanitize the text from the user by removing punctuation, spaces, and changing cases
	public static String filterText (String rawText)
	{
		String filteredText = ""; 
		
		// loop through letters in the text that user submits
		for (int i = 0; i < rawText.length(); i++)
		{
			// if current character is a letter or digit
		    if (Character.isLetterOrDigit(rawText.charAt(i)))
			{
		    	filteredText += Character.toLowerCase(rawText.charAt(i)); // convert to lower case, add current character to string				
			}
		}
		return filteredText; // return sanitized text
	}
	
	// method to check if input is a palindrome
	public static boolean isPalindrome (CharactersLinkedList charLinkedList)
	{
		// assumption: if string is empty, it is a palindrome
		if (charLinkedList.head == null) return true;

		// continue to traverse through the list as long as we have not reached the middle
		while ((charLinkedList.head != charLinkedList.tail) && (charLinkedList.head.prev != charLinkedList.tail))
		{
			// if head and tail do not point to the same character
			if (charLinkedList.head.getData() != charLinkedList.tail.getData()) return false;
			
			// traverse through list
			charLinkedList.head = charLinkedList.head.next;
			charLinkedList.tail = charLinkedList.tail.prev;
		}
		return true; 
	}
	
}
