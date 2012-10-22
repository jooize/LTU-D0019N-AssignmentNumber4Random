package assignmentnumber4random;
import java.util.Random;
import java.util.Scanner;

public class GuessTheRandomNumber
{
	private int gamesPlayed;
	private int totalGuesses;

	public static int showMainMenu()
	{
		Scanner input = new Scanner(System.in);
		int choice = 0; // Selected menu item
		int choices = 3; // Number of menu items

		System.out.println();
		System.out.println("1. New game");
		System.out.println("2. Statistics");
		System.out.println("3. End");
		System.out.println();

		// Loop until user inputs valid menu item number
		while(!(choice >= 1 && choice <= choices))
		{
			System.out.println("Select your choice by entering corresponding number.");

			try
			{
				choice = input.nextInt(); // Get users choice
			
				// Print error if choice is not within range
				if(!(choice >= 1 && choice <= choices))
					System.out.println("You must enter one of the options in the list.");
			}
			catch(java.util.InputMismatchException e)
			{
				System.out.println("You must enter an integer only.");
				input.next();
			}
		}

		System.out.println();
		return choice;
	}

	public void playGame()
	{
		Random randomGenerator = new Random();
		Scanner input = new Scanner(System.in);
		int randomNumber, userNumber = 0, guesses = 0;

		randomNumber = randomGenerator.nextInt(100); // Generates 0-99
		randomNumber++; // Make it 1-100

		System.out.println("A random number has been generated in the range 1-100.");
		//System.out.println("Number: " + randomNumber);

		// Loop until correct guess
		while(!(userNumber == randomNumber))
		{
			System.out.print("Enter your guess: ");
			try
			{
				userNumber = input.nextInt(); // Get players guess
				guesses++; // Add one guess to statistics

				if(randomNumber > userNumber)
					System.out.println("Higher.");
				if(randomNumber < userNumber)
					System.out.println("Lower.");
				if(randomNumber == userNumber)
				{
					System.out.println("Correct!");
					this.totalGuesses += guesses; // Add all guesses to total in statistics
					this.gamesPlayed++; // Add one game played to statistics
				}
			}
			catch(java.util.InputMismatchException e)
			{
				System.out.println("You must enter an integer only.");
				input.next();
			}
		}
	}

	public void showStatistics()
	{
		System.out.println("Games played: " + this.gamesPlayed);
		System.out.println("Total guesses: " + this.totalGuesses);
	}
}

