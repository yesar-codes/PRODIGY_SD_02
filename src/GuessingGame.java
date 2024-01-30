import java.util.Random;
import java.util.Scanner;
import java.util.random.RandomGenerator;

public final class GuessingGame {
    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 1000;
    private static final String WELCOME_MESSAGE = "Welcome to the Guessing Game!";
    private static final String SELECTED_NUMBER_MESSAGE = "I have selected a number between %d and %d. " +
            "Try to guess it.%n";
    private static final String ENTER_GUESS_MESSAGE = "Enter your guess: ";
    private static final String TOO_LOW_MESSAGE = "Too low! Try again.";
    private static final String TOO_HIGH_MESSAGE = "Too high! Try again.";
    private static final String CONGRATULATIONS_MESSAGE = "Congratulations! You guessed the number in %d attempts.%n";
    private static final String UTILIITY_CLASS_ERROR = "Utility class cannot be instantiated.";
    private GuessingGame() {
        System.out.println(UTILIITY_CLASS_ERROR);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RandomGenerator random = new Random();

        int randomNumber = generateRandomNumber(random);

        int attempts = 0;
        int userGuess;

        System.out.println(WELCOME_MESSAGE);
        System.out.printf(SELECTED_NUMBER_MESSAGE, LOWER_BOUND, UPPER_BOUND);

        do {
            userGuess = getUserGuess(scanner);
            attempts++;
            provideFeedback(userGuess, randomNumber, attempts);

        } while (userGuess != randomNumber);

        scanner.close();
    }

    private static int generateRandomNumber(RandomGenerator random) {
        return random.nextInt(UPPER_BOUND - LOWER_BOUND + 1) + LOWER_BOUND;
    }

    private static int getUserGuess(Scanner scanner) {
        System.out.print(ENTER_GUESS_MESSAGE);
        return scanner.nextInt();
    }

    private static void provideFeedback(int userGuess, int randomNumber, int attempts) {
        if (userGuess < randomNumber) {
            System.out.println(TOO_LOW_MESSAGE);
        } else if (userGuess > randomNumber) {
            System.out.println(TOO_HIGH_MESSAGE);
        } else {
            System.out.printf(CONGRATULATIONS_MESSAGE, attempts);
        }
    }
}


