/* Name: Shelley Chen
 * Date: March 11, 2022
 * Course Code: ICS4U0-A
 * Assignment: Linked List Assignment
 * Program Description: This program prompts the user for text input and checks if what the users types in
 * is a palindrome or not. A check button is used to submit text, a reset button clears the input fields 
 * and output messages, and the quit button exits the program. 
 */

// doubly linked list storing the characters
public class CharactersLinkedList {
	
	public CharacterNode head = null; // linked list contains two data fields: head and tail pointers
	public CharacterNode tail = null;
	
	// character node class
	static class CharacterNode {
		
		// data fields for character nodes
		char data; // character stored in the node
		CharacterNode next; // next pointer
		CharacterNode prev; // previous pointer
		
		// constructor for character nodes
		public CharacterNode (char d) 
		{
			data = d;
			next = null; // when a new character is constructed, default its pointers to null
			prev = null;
		}
		 
		// gets the character in the node 
		public char getData ()
		{ 
			return data; 
		}
		
		// sets the character in the node
		public void setData (char d)
		{
			data = d;
		}
		
		// gets the previous node
		public CharacterNode getPreviousNode ()
		{
			return prev;
		}
		
		// sets the previous node
		public void setPreviousCharNode (CharacterNode charNode)
		{
			prev = charNode;
		}
		
		// gets the next node
		public CharacterNode getNextNode ()
		{
			return next;
		}
		
		// sets the next node
		public void setNextCharNode (CharacterNode charNode)
		{
			next = charNode;
		}
	 }
	
	// constructor for linked list
	public CharactersLinkedList (String text)
	{
		// loop through all the characters in the text
		for (int i = 0; i < text.length(); i++) 
		{
			addCharacterNode(text.charAt(i)); // call method to add a character to the linked list
		}
	}
		
	// method to add a new character to the linked list
	public void addCharacterNode (char character)
	{ 
		CharacterNode newCharNode = new CharacterNode(character); // construct a new character
		
		// if list is empty (if head points to nothing)
		if (head == null) 
		{
			// make head and tail point to new character 
			head = newCharNode; 
			tail = newCharNode;
		}
	
		// insert character at the tail (end of doubly linked list)
		else 
		{
			newCharNode.setPreviousCharNode(tail);// make new node's prev pointer point to current end
			tail.setNextCharNode(newCharNode); // make current tail's next pointer point to the new node
			tail = newCharNode; // shift tail to point to the new node
		}
	}
	
}
