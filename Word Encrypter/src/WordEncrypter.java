import java.util.Scanner;
import javax.swing.JOptionPane;
import java.lang.Character;

public class WordEncrypter {
	public static Scanner sc = new Scanner(System.in);
	public static int shift;
	private static int option;
	private String newWord; 

	/*public static void main(String[] args){

		Object[] options = {"Encrypt a word",
				"Decrypt a word",
		"Exit"};
		do{
			option = JOptionPane.showOptionDialog(null, "Select an option:", "Top Secret Word Encrypter / Decrypter",
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE,
					null,
					options,
					options[2]);
			if (option ==  JOptionPane.YES_OPTION || option == JOptionPane.NO_OPTION){
				
				
				if (option == 0){
					JOptionPane.showMessageDialog(null, "Your encoded word is: " + EncryptDecrypt(), "Top Secret Word Encrypter",
							JOptionPane.QUESTION_MESSAGE);
				}

				if (option == 1){
					JOptionPane.showMessageDialog(null, "Your decoded word is: " + EncryptDecrypt(), "Top Secret Word Decrypter",
							JOptionPane.QUESTION_MESSAGE);
				}
			}

		} while (option != JOptionPane.CANCEL_OPTION);
	}

	public static boolean valid(String s){
		for (int i = 0; i < s.length(); i++)
			if (s.charAt(i) < 97 || s.charAt(i) > 122){
				JOptionPane.showMessageDialog(null, "Incorrect input. Please try again.");
				return false;
			}
		return true;
	}

	public static String EncryptDecrypt(){
		String word = "";
		String key = "";
		String newWord = "";
		do {
			if (option == 0){
				word = JOptionPane.showInputDialog(null, "Enter an unencrypted word.", "Top Secret Word Encrypter",
						JOptionPane.QUESTION_MESSAGE);
			}
			else if (option == 1){
				word = JOptionPane.showInputDialog(null, "Enter an encrypted word.", "Top Secret Word Decrypter",
						JOptionPane.QUESTION_MESSAGE);
			}
		} while (!valid(word));
		do {
			if (option == 0){
				key = JOptionPane.showInputDialog(null, "Enter an encryption key.", "Top Secret Word Encrypter",
						JOptionPane.QUESTION_MESSAGE);
			}

			else if (option == 1){
				key = JOptionPane.showInputDialog(null, "Enter the decryption key.", "Top Secret Word Decrypter",
						JOptionPane.QUESTION_MESSAGE);
			}

		} while (!valid(key));

		shift = 0; 
	    for (int x = 0; x < key.length(); x++) 
	      shift += key.charAt(x) - 96; //uses ASCII values
	    shift = shift % 26;
		
		char [] y = word.toCharArray(); // create a char array made of the characters in the string
	    if (option == 0) // shifting n backwards is the same as shifting 26 - n forwards 
	      shift = 26 - shift;
	    for (int x = 0; x < y.length; x++) {//go through every element in char array, and increment it shift times
	      for (int a = 0; a < shift; a++)
	        if (y[x] == 'z') //if a character comes to z, place it to 'a' instead of to the next ASCII character; otherwise, increment it once
	        y[x] = 'a';
	      else 
	        y[x]++;
	    }
		newWord = new String(y);
		return newWord;

	}
	*/

}