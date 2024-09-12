package p1;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class PatrickDuggan_40125560 {

	/**
	 * Game of rock, paper, scissors using user input (scanner) and a computer
	 * random choice
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		//initialise scanner
		Scanner scanner = new Scanner(System.in);

		// declare vars
		String userInput;
		String userAnswer = "";
		int userScore =0;
		int computerScore =0;
		int drawScore =0;
		
		
		// array to hold results
		String[] results = new String[5];

		// loop to iterate through rounds of the game
		for (int loop = 0; loop < results.length; loop++) {
			System.out.println("**********");
			System.out.println("ROUND " + (loop + 1));
			System.out.println("**********");
			System.out.println("Choose Rock, Paper or Scissors");

			userInput = scanner.nextLine(); // user choice
			

			// using an if else loop to check the users answer and save it
			if (userInput.equalsIgnoreCase("rock")) {
				userAnswer = "Rock";
			} else if (userInput.equalsIgnoreCase("paper")) {
				userAnswer = "Paper";
			} else if (userInput.equalsIgnoreCase("scissors")) {
				userAnswer = "Scissors";
			} else {
				System.out.println("Unrecognised choice, please try again");
				userInput = scanner.nextLine();
			}
			System.out.println("Player played: " + userAnswer); //confirming user choice

			// now we need the computers choice (randomly generated)
			// first import scanner class and declare vars
			Random random = new Random();
			String computerChoice = "";
			int randomNumber = 0;
			randomNumber = random.nextInt(3); //generates a random number 0,1 or 2
			if (randomNumber == 0) { //assigning 0,1 and 2 to the 3 options using an if else statement
				computerChoice = "Rock";
			} else if (randomNumber == 1) {
				computerChoice = "Paper";
			} else {
				computerChoice = "Scissors";
			}
			System.out.println("Computer played: " + computerChoice); //display computer choice

			//creating a new variable to store the result of the method call for the game result
			String gameResult = gameResultMethod(userAnswer,computerChoice);
			System.out.println("Result: "+gameResult); //displaying result
			results[loop]=gameResult; //adding the result of the round into the array to be accessed later
			


			}
			
		//used to test whether the array is working correctly
//			System.out.println(Arrays.toString(results));
			System.out.println("\nFinal Statistics:");
			
			//iterating through the array and checking the result of the rounds
			//then adding the win, loss and draw totals up
			for(int i=0; i<results.length; i++) {
				if (results[i]=="Player Wins") {
					userScore++;
				} else if (results[i]=="Computer Wins") {
					computerScore++;
				} else {
					drawScore++;
				}
			}
			
			//i tried to use maths methods to turn userScore into a % to 2d but I could not get the calculations to change userScore
			//so I have used a makeshift way which is still 100% accurate
			userScore=userScore*20;
			System.out.println("Win Percentage: "+userScore+".00%"); //printing win percentage
			computerScore=computerScore*20;
			System.out.println("Loss Percentage: "+computerScore+".00%"); //printing loss percentage
			drawScore=drawScore*20;
			System.out.println("Draw Percentage: "+drawScore+".00%"); //printing draw percentage

			System.out.println("\nThanks for playing"); //ending statement
			
			scanner.close();
		}
	
	
/**
 * method to check the users answer vs the computers answer and determine the result
 * @param userAnswer
 * @param computerChoice
 * @return gameResult
 */
	public static String gameResultMethod(String userAnswer, String computerChoice) {
		String gameResult = "";
		if (userAnswer == computerChoice) {
			gameResult = "Draw Game";
		} else if (userAnswer == "Rock" && computerChoice == "Scissors") {
			gameResult = "Player Wins";
		} else if (userAnswer == "Rock" && computerChoice == "Paper") {
			gameResult = "Computer Wins";
		} else if (userAnswer == "Paper" && computerChoice == "Rock") {
			gameResult = "Player Wins";
		} else if (userAnswer == "Paper" && computerChoice == "Scissors") {
			gameResult = "Computer Wins";
		} else if (userAnswer == "Scissors" && computerChoice == "Paper") {
			gameResult = "Player Wins";
		} else if (userAnswer == "Scissors" && computerChoice == "Rock") {
			gameResult = "Computer Wins";

		
	}
		return gameResult;
}
}
