import java.util.Random;
import javax.swing.JOptionPane;
import java.util.Scanner;


public class magic8ball 
{
	
	//---variables---
	
	public static Scanner scanner = new Scanner("System.in");
	public static Random random_int = new Random();
	public static String question = "";
	
	//holds all possible answers
	public static String[] answers = {
										//positive answers
										"It is certain",
										"Definitely",
										"Without a doubt",
										"Most likely",
										"Everything points to yes",
										"Yes",
										//neutral answers
										"Ask again later",
										"Cannot predict",
										"The future is unclear",
										"Maybe yes, maybe no",
										"It depends",
										//negative answers
										"Don't count on it",
										"My sources say no",
										"Don't think so",
										"Very doubtful",
										"The stars are not in position"
									};
	
	
	//---functions---
	
	//allow the player to enter their question
	public static void Prompt()
	{
		JOptionPane.showInputDialog(null, "What would you ask the magic 8 ball?");
		question = scanner.nextLine();
		RandomizeAnswer();
	}
	
	//get random answer
	public static void RandomizeAnswer()
	{
		int answer_id = random_int.nextInt(0, answers.length);
		GiveAnswer(answer_id);
	}
	
	//show answer to the user
	public static void GiveAnswer(int answer_id)
	{
		JOptionPane.showMessageDialog(null, answers[answer_id]);
		scanner.close();
	}
	
	
	//---main---
	
	public static void main(String[] args)
	{
		Prompt();
	}
}