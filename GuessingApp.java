/**
 * MAIN CLASS
 * Use Case 5: Game Result Storage
 * This class coordinates the complete game flow
 * and persists the final result after completion.
 *
 * Responsibilities:
 * - Initialize game configuration
 * - Accept and validate user guesses
 * - Generate hints when applicable
 * - Store game result at the end
 *
 * @author Suhas T G
 * @version 5.0
 */

import java.util.Scanner;

public class GuessingApp{
    public static void main(String[] args) throws InvalidInputException{

        Scanner scanner = new Scanner(System.in);

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
    }
}