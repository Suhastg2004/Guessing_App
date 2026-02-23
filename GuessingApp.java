/**
 * MAIN CLASS
 * Error handling and validation
 * @author Suhas T G
 * @version 4.0
 */

import java.util.Scanner;

public class GuessingApp{
    public static void main(String[] args) throws InvalidInputException{

        System.out.println("Welcome to the Guessing App");
        GameConfig config = new GameConfig();
        config.showRules();

        //UC2 part
        Scanner scanner = new Scanner(System.in);
        int attempts = 0;

        //Count the hints
        int hintsUsed = 0;

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
                break;
            }
        }
    }
}