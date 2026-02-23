public class ValidationService {
    public static int validateInput(String input) throws InvalidInputException{
        // Check for out of range numbers
        try{
            int value = Integer.parseInt(input);
            if (value < 1 || value > 100){
                throw new InvalidInputException("Number mush be between 1 and 100");
            }
            return value;

        }catch (NumberFormatException e){
            throw new InvalidInputException("Invalid input. Please enter numbers only");
        }

    }
}
