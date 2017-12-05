/* Mufeez Amjad
 * April 25th 2016
 * GuessingGame
 * Ms Karasinska
 * Data Dictionary
 *    sc is the scanner for user input
 *    max is the maximum number in the range
 *    min is the minimum number in the range
 *    maxTarget is the maximum number in the AI's guess range
 *    minTarget is the minimum number in the AI's guess range
 *    level is the user input of choice of level
 *    range is the range between the minimum and maximum
 *    maxGuesses is the number of guesses the user has
 *    number is the random number
 *    guess is the user or AI guess
 *    setRange is the user input for a custom range or not
 *    setGuesses is the user input for a custom number of guesses or not
 *    booleanGuesses stores if the user set the guesses
 *    startTime is the start of the timer when the user guesses
 *    endTime is the end of the timer when the user guesses correctly
 *    time is the time it took for the user to guess correctly
 *    timer is if the user asked to be timed
 *    ifTimer is the user input for a timer or not
 *    numGames is the number of games
 *    score is the number of wins
 *    
 * Program Description
 * 	  This program allows the computer to create a random number and the user to guess the number. There are various levels of the game:
 *			Level 1: A number is created between 1 and 100
 *			Level 2: The user sets the range for the random number
 *			Level 3: The user can choose to be limited to a number of guesses or be timed.
 *			Level 4: An AI guesses the number strategically, for a set number of games
 *			Level 5: You set the number for the computer to guess.
 */

import java.util.Scanner;

public class GuessingGame {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		int maximum = 100;
		int minimum = 1;
		int maxTarget = 0;
		int minTarget = 0;
		int level;
		int range;
		int maxGuesses = 1000;
		int number = 0;
		int guess;
		char setRange = ' ';
		char setGuesses = ' ';
		boolean guesses = false;
		long startTime = 0;
		long endTime = 0;
		long time = 0;
		boolean timer = false;
		char ifTimer;
		int numGames = 1;
		int score = 0;
		
		System.out.println("\n d888b  db    db d88888b .d8888. .d8888. d888888b d8b   db  d888b        d888b   .d8b.  .88b  d88. d88888b"); //ASCII Art
		System.out.println("88' Y8b 88    88 88'     88'  YP 88'  YP   `88'   888o  88 88' Y8b      88' Y8b d8' `8b 88'YbdP`88 88'     ");
		System.out.println("88      88    88 88ooooo `8bo.   `8bo.      88    88V8o 88 88           88      88ooo88 88  88  88 88ooooo ");
		System.out.println("88  ooo 88    88 88~~~~~   `Y8b.   `Y8b.    88    88 V8o88 88  ooo      88  ooo 88~~~88 88  88  88 88~~~~~ ");
		System.out.println("88. ~8~ 88b  d88 88.     db   8D db   8D   .88.   88  V888 88. ~8~      88. ~8~ 88   88 88  88  88 88.     ");
		System.out.println(" Y888P  ~Y8888P' Y88888P `8888Y' `8888Y' Y888888P VP   V8P  Y888P        Y888P  YP   YP YP  YP  YP Y88888P ");

		System.out.println("\nWelcome to the Guessing Game!"); //General Instructions
		System.out.println("How to Play:");
		System.out.println("\tThe computer will generate a random number.");
		System.out.println("\tYou have to guess the number.");
		System.out.println("\tIf you choose to have a limited number of guess, you win only if you guess the number before you run out of guesses.");

		System.out.println("\nThis version of the game has 5 levels."); //Level information
		
		System.out.println("\nLevel 1 - the computer creates the range for the number.");
		System.out.println("Level 2 - you create the range for the number.");
		System.out.println("Level 3 - you have a limited number of guesses and/or you are timed.");
		System.out.println("Level 4 - watch the computer strategically play, for a set number of games.");
		System.out.println("Level 5 - set a number for the computer to guess.");

		do { //user picks a level
			System.out.println("\nPick Level 1, 2, 3, 4 or 5"); //prompts user for input
			level = sc.nextInt(); //receives input
		} while (level != 1 && level != 2 && level != 3 && level != 4 && level !=5);

		if (level == 1)	System.out.println("\nThe computer will generate a random number between 1 and 100."); //Level 1

		else if (level == 2) { //Level 2
			do {
				System.out.println("Enter the maximum number in your range.");
				maximum = sc.nextInt();
				System.out.println("Enter the minimum number in your range.");
				minimum = sc.nextInt();
				System.out.println("\nThe computer will generate a random number between " + minimum + " and " + maximum + ".");
			} while (maximum < minimum); // maximum cannot be less than minimum
		}

		else if (level == 3 || level == 4) { //Level 3
			if (level == 4){
				do {
					System.out.println("\nHow many games do you want the AI to play?");
					numGames = sc.nextInt();
				} while (numGames <= 0);
			}
			
			do {
				System.out.println("\nDo you want to set your own range? (Y or N)");
				setRange = sc.next().charAt(0);
			} while (setRange != 'Y' && setRange != 'y' && setRange != 'N' && setRange != 'n');
			 
					switch (setRange){
					   case 'Y':
					   case 'y':
					    do {
					     System.out.println("Enter the maximum number in your range.");
					     maximum = sc.nextInt();
					     System.out.println("Enter the minimum number in your range.");
					     minimum = sc.nextInt();
					    } while(maximum < minimum);    
					   default:
						   System.out.println("\nThe computer will generate a random number between " + minimum + " and " + maximum + ".\n");
					    break;
					}
			
			do {
				System.out.println("\nDo you want to set the number of guesses allowed? (Y or N)");
				setGuesses = sc.next().charAt(0);
			} while (setGuesses != 'Y' && setGuesses != 'y' && setGuesses != 'N' && setGuesses != 'n');

					switch (setGuesses) {
					case 'Y':
					case 'y':
						do {
							System.out.println("Enter the maximum number of guesses.");
							maxGuesses = sc.nextInt();
							guesses = true; //used later on to print how many guesses user has left only if their is a max
						} while (maxGuesses <= 0);
					default:
						break;
					}
			
			do { //asks for a timer
				System.out.println("\nDo you want to use a timer? (Y or N)");
				ifTimer = sc.next().charAt(0);
			} while (ifTimer != 'Y' && ifTimer != 'y' && ifTimer != 'N' && ifTimer != 'n');
			    
					switch (ifTimer) {
					case 'Y':
					case 'y':
							timer = true; //used later on to start timer
					default:
						break;
					}
			    		
		}
		
		else if (level == 5){
			do {
				System.out.println("Enter a random number that is positive.");
				number = sc.nextInt();
			} while (number <= 0);
			
			if (number < 100 && number >= 0){
				maximum = 100;
				minimum = 0;
			}
			
			else if (number < 1000 && number > 100){
				maximum = 1000;
				minimum = 100;
			}
			
			else if (number < 1000000 && number > 1000){
				maximum = 1000000;
				minimum = 1000;
			}
			else if (number < 1000000000 && number > 1000000){
				maximum = 1000000000;
				minimum = 1000000;
			}
			
			do {
				System.out.println("\nDo you want to set the number of guesses allowed? (Y or N)");
				setGuesses = sc.next().charAt(0);
			} while (setGuesses != 'Y' && setGuesses != 'y' && setGuesses != 'N' && setGuesses != 'n');

					switch (setGuesses) {
					case 'Y':
					case 'y':
						do {
							System.out.println("Enter the maximum number of guesses.");
							maxGuesses = sc.nextInt();
							guesses = true; //used later on to print if how many guesses user has left
						} while (maxGuesses <= 0);
					default:
						break;
					}
			
		}
		
		range = maximum - minimum +1;
		minTarget = minimum;
		maxTarget = maximum;
		
		if (level != 5) number = (int) (range * Math.random()) + minimum;

		if (maxGuesses != 1000)System.out.println("\nYou have " + maxGuesses + " attempts to guess the number.");


		System.out.println("Good Luck!\n");
		
		
		if (timer){
			startTime = System.nanoTime();
			System.out.println("Timer has started.");
		}
		
		
		for (int games = 1; games <= numGames; games++){
			
			minTarget = minimum;
			maxTarget = maximum;
			
			range = maximum - minimum + 1;
			
			if (level == 5 && games > 1){
				System.out.println("\nEnter a new positive random number.");
				number = sc.nextInt();
			}
				
			if (games != 1){
				number = (int) (range * Math.random()) + minimum;
				if (numGames < 5){
					System.out.println("\nA new random number has been generated in the range.");
					System.out.println(level == 4 || level == 5 ? "The computer has "  + maxGuesses + " attempt(s) to guess the number." : "You have " + maxGuesses + " attempt(s) to guess the number.");
				}
				
			}	
				
				if (!guesses && level != 1 && level != 2){
					if (range <= 10){ //preset number of guesses if user does not enter their own
						maxGuesses = 4;
					}
					else if (range <= 500) {
						maxGuesses = 10;
					} else if (range <= 10000) {
						maxGuesses = 14;
					} else if (range <= 1000000) {
						maxGuesses = 20;
					} else if (range <= 400000000) {
						maxGuesses = 40;
					}
					guesses = true;					
				}
				if (numGames < 5 || level == 1 || level == 2 || level == 3 || level == 5){
					for (int i = 1; i <= maxGuesses; i++) {
							
							range = maxTarget - minTarget;
							
							System.out.println(level == 4 || level == 5 ? "Enter the guess" : "Enter your guess.");
	
							if (level == 4 || level == 5){
								guess = (range / 2) + minTarget;
								System.out.println(guess);
							}
							
							else {
								guess = sc.nextInt();
							}
							
							if (i >= maxGuesses && guess != number) {
								i = maxGuesses;
								System.out.println(level == 4 || level == 5 ? "The computer has exceeded the maximum number of guesses." : "You have exceeded the maximum number of guesses.");
								System.out.println("The number was: " + number);
							}
	
							else if (guess > number) {
								System.out.println(level == 4 || level == 5 ? "The computer's guess is too high." : "Your guess is too high.");
								maxTarget = guess;
	
							}
	
							else if (guess < number) {
								System.out.println(level == 4 || level == 5 ? "The computer's guess is too low." : "Your guess is too low.");
								minTarget = guess;
							}
	
							else if (guess == number) {
								System.out.println(level == 4 || level == 5 ? "The computer guessed correctly in " + i + " guesses." : "You guessed correctly in " + i + " guesses.");
								if (timer && numGames == 1){
									endTime=System.nanoTime();
									time = level == 4 ? (endTime - startTime)/1000 : (endTime - startTime)/1000000000; 
									System.out.println(level == 4 ? "It took " + time + " milliseconds to guess." : "It took " + time + " seconds to guess." );
								}
								i = maxGuesses;
								System.out.println("The number was " + number + ".");
								score++;
							}
	
							if (guesses && maxGuesses != i) {
								System.out.println(level == 4 || level == 5 ? "\nThe computer has " + (maxGuesses - i)	+ " guess(es) left." : "\nYou have " + (maxGuesses - i)	+ " guess(es) left.");
							}
							
						}
					}
				
				else {
					for (int i = 1; i <= maxGuesses; i++) {
						
						range = maxTarget - minTarget;
						
						guess = (range / 2) + minTarget;
												
						if (i >= maxGuesses && guess != number) i = maxGuesses;

						else if (guess > number) maxTarget = guess;

						else if (guess < number) minTarget = guess;

						else if (guess == number) {
							i = maxGuesses;
							score++;
						}
					}
				}
		}
		
		if (numGames > 1 || timer){
			if (level >= 4) System.out.println("The computer won " + (score) + " out of " + numGames + " games.");
			if (timer){
				endTime=System.nanoTime();
				if (level == 3){
					time = (endTime - startTime)/1000000000;
					System.out.println("It took " + time + " seconds to guess.");
				}
				else {time = (endTime - startTime)/1000000;
				System.out.println("It took " + time + " milliseconds to finish the games.");
				}
			}
		}
		
		sc.close();
	}
}
