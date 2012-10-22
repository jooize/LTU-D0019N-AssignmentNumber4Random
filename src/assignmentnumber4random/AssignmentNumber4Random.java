package assignmentnumber4random;

public class AssignmentNumber4Random
{
	public static void main(String[] args)
	{
		boolean loop = true;
		int menuItemSelected;
		GuessTheRandomNumber game = new GuessTheRandomNumber();

		while(loop)
		{
			menuItemSelected = game.showMainMenu();

			switch(menuItemSelected)
			{
				case 1: game.playGame(); break;
				case 2: game.showStatistics(); break;
				case 3: loop = false;
			}
		}
	}
}
