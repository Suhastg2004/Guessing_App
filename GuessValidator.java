/*
 * Use Case 2: User Guess Submission
 *
 * This class is responsible for comparing
 * the user's guess with the target number.
 *
 * It does NOT handle input or output.
 */
class GuessValidator {
    //Compares guess with target and returns the comparison resutls
    public static String validateGuess(int guess, int target){
        // System.out.println(guess + " " + target);
        if (guess == target){
            return "CORRECT";
        }
        else if (guess < target){
            return "LOW";
        }
        // Executes When guess > target
        return "HIGH";
    }
}