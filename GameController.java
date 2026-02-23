//This calas decides whether teh game should restart or exit
//based on the user choice
import java.util.Scanner;

public class GameController {
    public static boolean restartGame(Scanner scanner){
        System.out.println("Do you want to play again? (yes/no) :");
        return scanner.nextLine().equalsIgnoreCase("yes");
    }
}
