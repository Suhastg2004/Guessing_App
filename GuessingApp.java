/**
 * MAIN CLASS
 * Use Case 6: Game Restart & Exit
 *
 * This class coordinates the complete game lifecycle,
 * allowing the player to replay or exit gracefully.

 * Responsibilities:
 * - Start a new game session
 * - Execute the guessing flow
 * - Persist game results
 * - Restart or exit based on user choice
 *
 * @author Suhas T G
 * @version 6.0
 */

import java.util.Scanner;

public class GuessingApp{
    public static void main(String[] args) throws InvalidInputException{

        Scanner scanner = new Scanner(System.in);
        //Stores user choice 
        boolean restart = false;

        System.out.println("Welcome to the Guessing App");
        
        //Take player name to store the result
        System.out.println("Enter Player Name: ");
        String player = scanner.nextLine();

        GameConfig config = new GameConfig();
        config.showRules();

        int attempts = 0;

        //Count the hints
        int hintsUsed = 0;
        boolean win = false; 

        // Outer loop controls whether a new game session should restart 

        do{
            //Game loops unit the user reaches maximum attempts
            while (attempts < config.getMaxAttempts()){
                System.out.println("Enter your guess:");
                int guess = ValidationService.validateInput(scanner.nextLine());
                attempts++;

                String result = GuessValidator.validateGuess(guess, config.getTargetNumber());

                //Give hint if the guess is incorrect and you have some hints left 
                if (!"CORRECT".equals(result) && hintsUsed < config.getMaxHints()) {
                    hintsUsed++;
                    System.out.println("Hint: " + HintService.generateHint(config.getTargetNumber(), hintsUsed));
                }
                
                System.out.println(result);

                //Stop the loop if the guess is correct 
                if ("CORRECT".equals(result)) {
                    System.out.println("You guessed in " + attempts + " attempts");
                    win = true;
                    break;
                }
            }
            //Final game result is stored after the loop complete
            //Store it in the text file 
            StorageService.saveResult(player, attempts, win);

            //Update the restart variable with users choice
            restart = GameController.restartGame(scanner);

        } while (restart);
    }
}