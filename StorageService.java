/**
 * Use Case 5: Game Result Storage
 *
 * This class is responsible for persisting
 * the final game result after the game ends.
 * Results are stored in a file so that
 * game history is not lost after exit.
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class StorageService {
    /*
     * Saves the final outcome of the game.
     * Each record contains:
      - Player name
      - Number of attempts used
      - Win or loss result
     */
    public static void saveResult(String player, int attempts,boolean win) {
        // Writer is closed automatically after operations complete
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("game_results_stg.txt", true))){
            writer.write("Player: " + player + " Attempts: " + attempts + " Result: " + (win ? "WIN" : "LOSE"));
            writer.newLine();

        } catch (IOException e){
            System.out.println("Unable to save game result.");
        }
    }
}