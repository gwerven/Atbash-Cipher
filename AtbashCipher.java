// File: AtbashCipher.java
// Author: Garrett Erven
// Purpose: The purpose of this program is to perform encryptions and decryptions using an Atbash Cipher.

import java.util.Scanner;

public class AtbashCipher
{
	public static void main(String[] args)
	{
		// Greet the user
		System.out.println("Welcome to the Atbash cipher!");
		
		// Setup the Scanner to receive user input
		Scanner keyboard = new Scanner(System.in);
		
		// Declare a variable to store the user's choice
		String decision = "";
		
		// Continue asking the user if they would like to encrypt or decrypt until they enter "Q"
		while(!decision.equals("Q"))
		{
			// Prompt the user for their choice
			System.out.println("Do you want to encrypt or decrypt data? Enter “E” to encrypt, “D” to decrypt or “Q” to quit:");
			decision = keyboard.nextLine();
			
			switch(decision)
			{
				case "E":
					// Prompt the user for the message they would like to encrypt
					String message = "";
					System.out.println("Enter message in plain-text:");
					message = keyboard.nextLine();
					// Generate and output the cipher text to the user
					System.out.println("Cipher Text is:");
					System.out.println(encrypt(message.toLowerCase()));
					break;
				case "D":
					// Prompt the user for the cipher text they would like to decrypt
					String ciphertext = "";
					System.out.println("Enter cipher-text:");
					ciphertext = keyboard.nextLine();
					// Generate and output the message to the user
					System.out.println("Message in plain-text is:");
					System.out.println(decrypt(ciphertext.toLowerCase()));
					break;
				case "Q": // Notify the user the program is terminating
					System.out.println("Exiting the Atbash cipher!");
					break;
				default: System.out.println("Incorrect Option");
					break;
			}
		}
	}
	
	// Generate and return the encrypted message
	public static String encrypt(String message)
	{
		String cipherText = "";
		
		// Declare and initialize some useful variables for later use
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		String backwardsAlphabet = "";
		for(int i = alphabet.length() - 1; i > -1; i--)
		{
			backwardsAlphabet += alphabet.charAt(i);
		}
		
		for(int i = 0; i < message.length(); i++)
		{
			// Ignore spaces
			if(message.charAt(i) == (char)32)
			{
				cipherText += " ";
			}
			else
			{
				for(int j = 0; j < alphabet.length(); j++)
				{
					if(message.charAt(i) == alphabet.charAt(j))
					{
						cipherText += backwardsAlphabet.charAt(j);
						break;
					}
				}
			}
		}
		
		return cipherText;
	}
	
	// Generate and return the decrypted cipher text
	public static String decrypt(String cipherText)
	{
		String message = "";
		
		// Declare and initialize some useful variables for later use
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		String backwardsAlphabet = "";
		for(int i = alphabet.length() - 1; i > -1; i--)
		{
			backwardsAlphabet += alphabet.charAt(i);
		}
		
		for(int i = 0; i < cipherText.length(); i++)
		{
			// Ignore spaces
			if(cipherText.charAt(i) == (char)32)
			{
				message += " ";
			}
			else
			{
				for(int j = 0; j < backwardsAlphabet.length(); j++)
				{
					if(cipherText.charAt(i) == backwardsAlphabet.charAt(j))
					{
						message += alphabet.charAt(j);
						break;
					}
				}
			}
		}
		
		return message;
	}
}