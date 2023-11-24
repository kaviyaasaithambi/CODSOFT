import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int lowerRange = 1;
        int upperRange = 100;
        int secretNumber;
        int attempts = 0;
        int maxAttempts = 7; // Limiting attempts per round
        boolean playAgain = true;
        int totalAttempts = 0;
        int rounds = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) {
            rounds++;
            secretNumber = random.nextInt(upperRange - lowerRange + 1) + lowerRange;
            attempts = 0;
            System.out.println("\nRound " + rounds + ":");
            System.out.println("Guess a number between " + lowerRange + " and " + upperRange);

            while (true) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess < secretNumber) {
                    System.out.println("Too low! Try a higher number.");
                } else if (userGuess > secretNumber) {
                    System.out.println("Too high! Try a lower number.");
                } else {
                    System.out.println("Congratulations! You guessed the correct number " + secretNumber +
                            " in " + attempts + " attempts.");
                    totalAttempts += attempts;
                    break;
                }

                if (attempts == maxAttempts) {
                    System.out.println("Oops! You've reached the maximum attempts. The number was " + secretNumber + ".");
                    break;
                }
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playChoice = scanner.next().toLowerCase();

            if (!playChoice.equals("yes")) {
                playAgain = false;
                System.out.println("Total rounds played: " + rounds);
                System.out.println("Total attempts: " + totalAttempts);
            }
        }

        scanner.close();
    }
}
