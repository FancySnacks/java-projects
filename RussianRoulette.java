import java.util.Random;
import java.util.Scanner;


public class RussianRoulette 
{
	
	
		//---variables---

	
		static Scanner scanner = new Scanner(System.in);
		static String player_input;
		static int possible_results = 6;
		static boolean GameInProgress = false;
		static int player_id = 0;
	
			
			
		//---functions---
	
		
		//reset variables
		public static void GameStart()
		{
			GameInProgress = true;
			player_id = 0;
			DecideResult(possible_results, player_id);
		}
		
		//roll a random number and check the result
		public static void DecideResult(int results, int player_id)
		{
			if (player_id == 0)
			{
				System.out.println("---Rolling---");
			}
			else
			{
				System.out.println("---PC is rolling---");
			}
			
			//delay the result to build tension
			try 
			{
			    Thread.sleep(1500);
			} 
			catch(InterruptedException e) 
			{
			    System.out.println("fail");
			}
			
			boolean safe = true;
			Random random = new Random();
			int result = random.nextInt(results);
			
			if (result == 1)
			{
				safe = false;
			}
			else
			{
				safe = true;
			}
			
			ResultMessage(safe, player_id);
		}
		
		//inform the player about the result
		//shows different message based on whether it's the player or PC pulling the trigger
		// 0 = player
		// 1 = PC
		public static void ResultMessage(boolean safe, int player_id)
		{
			if (safe == true)
			{
				//on safe roll
				//continue playing on safe roll, until somebody loses
				switch(player_id) 
				{
				case 0: System.out.println("You're safe"); NextTurn();
				break;
				
				case 1: System.out.println("Opponent is safe"); NextTurn();
				break;
				
				default: System.out.println("Safe"); NextTurn();
				}
				
			}
			else
			{
				//on losing roll
				switch(player_id) 
				{
				case 0: System.out.println("You've lost"); GameEnd();
				break;
				
				case 1: System.out.println("Opponent lost"); GameEnd();
				break;
				
				default: System.out.println("Lost"); GameEnd();
				}
			}
		}
		
		//next player takes turn
		public static void NextTurn()
		{
			switch(player_id)
			{
			case 0: player_id++;
			break;
			
			case 1: player_id = 0;
			break;
			}
			
			DecideResult(possible_results, player_id);
		}
		
		//end the game
		public static void GameEnd()
		{
			//end the game
			GameInProgress = false;
			System.out.println("Game End!");
			Restart();
		}
		
		//ask player if he wants to play again
		public static void Restart()
		{
			//keep asking player if he wants to play again until he types in 
			while (!player_input.contains("Y") || !player_input.contains("y") || !player_input.contains("N") || !player_input.contains("n"))
			{
				System.out.println("");
				System.out.println("Do you want to play again?");
				System.out.println("'Y' = Yes | 'N' = No\"");
				player_input = scanner.nextLine();
			
				if (player_input.contains("Y") || player_input.contains("y"))
				{
					GameStart();
					break;
				}
				else
				{
					System.out.println("Goodbye");
					break;
				}
			}
			
		}
	
		
		
		//---main---
		
		
	public static void main(String[] args)
	{
		
		
		
		
		//---core gameplay---
		
		System.out.println("Would you like to play Russian Roulette?");
		System.out.println("Type 'Q' or 'q' to quit / Type anything else to play");
		player_input = scanner.nextLine();
		
		
		if (player_input.contains("q") || player_input.contains("Q"))
		{
			System.out.println("Goodbye");
			GameInProgress = false;
			scanner.close();
		}
		else
		{
			GameStart();
		}
		
	}
}
