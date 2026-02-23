/**
 * MAIN CLASS
 *
 * Coordinates the game flow:
 * 1. Initialize game
 * 2. Accept user guesses
 * 3. Validate guesses
 * 4. Stop when game ends
 *
 * @author Suhas T G
 * @version 2.0
 */

import java.util.*;
public class GuessingApp{
    public static void main(String[] args){

        System.out.println("Welcome to the Guessing App");
        GameConfig config = new GameConfig();
        config.showRules();

        //UC2 part
        Scanner scanner = new Scanner(System.in);
        int attempts = 0;

        //Game loops unit the user reaches maximum attempts
        while (attempts < config.getMaxAttempts()){
            System.out.println("Enter your guess:");
            int guess = scanner.nextInt();
            attempts++;

            String result = GuessValidator.validateGuess(guess, config.getTargetNumber());
            System.out.println(result);

            //Stop the loop if the guess is correct
            if ("CORRECT".equals(result)){
                break;
            }
        }
    }
}