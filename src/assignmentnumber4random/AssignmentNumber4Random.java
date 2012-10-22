package assignmentnumber4random;
import java.util.Random;
import java.util.Scanner;

public class AssignmentNumber4Random
{
	public static int showMainMenu()
	{
		int choices = 3; // Number of menu items
		int choice = 0; // Selected menu item
		Scanner input = new Scanner(System.in);

		// Loop until user inputs valid menu item number
		while(!(choice >= 1 && choice <= choices))
		{
			System.out.println("1. New game");
			System.out.println("2. Statistics");
			System.out.println("3. End");
			System.out.println("\nSelect your choice by entering corresponding number.");

			try
			{
				choice = input.nextInt(); // Get users choice
			
				// Print error if choice is not within range
				if(!(choice >= 1 && choice <= choices))
					System.out.println("You must enter one of the options in the list.");
			}
			catch(java.util.InputMismatchException e)
			{
				System.out.println("You must enter a number only.");
				input.next();
			}
		}

		return choice;
	}

	public static void playGame()
	{
		Random randomGenerator = new Random();
		Scanner input = new Scanner(System.in);
		int randomNumber, userNumber = 0;

		randomNumber = randomGenerator.nextInt(100); // Generates 0-99
		randomNumber++; // Make it 1-100

		System.out.println("A random number has been generated in the range 1-100.");
		//System.out.println("Number: " + randomNumber);

		while(!(userNumber == randomNumber))
		{
			System.out.print("Enter your guess: ");
			try
			{
				userNumber = input.nextInt();

				if(randomNumber > userNumber)
					System.out.println("Higher.");
				if(randomNumber < userNumber)
					System.out.println("Lower.");
				if(randomNumber == userNumber)
					System.out.println("Correct!");
			}
			catch(java.util.InputMismatchException e)
			{
				System.out.println("You must enter a number only.");
				input.next();
			}
		}
	}

	public static void showStatistics()
	{
	}

	public static void main(String[] args)
	{
		boolean loop = true;
		int choice;

		while(loop)
		{
			choice = showMainMenu();

			switch(choice)
			{
				case 1: playGame(); break;
				case 2: showStatistics(); break;
				case 3: loop = false;
			}
		}
	}
}
