import java.util.Random;
import java.util.Scanner;

/**
 * Word Scramble Game "Word Scramble Wizard".
 * The player must guess the original word from a scrambled version.
 */
public class Main {
    public static void main(String[] args) {

        // Scanner for user input
        Scanner scanner = new Scanner(System.in);
        // Random number generator
        Random random = new Random();

        // Predefined list of magic words
        String[] wordList = {"magic", "wizard", "spell", "potion", "alchemy",
                "sorcery", "wand", "dragon", "cauldron", "broomstick"};

        int playerScore = 0; // Player's score
        boolean keepPlaying = true; // Flag to control the game loop

        System.out.println("Welcome to Word Scramble Wizard!");
        System.out.println("Unscramble the magic words to score points!");

        // Main game loop
        while (keepPlaying) {
            // Selects a random word from the list
            String word = wordList[random.nextInt(wordList.length)];
            // Scrambles the chosen word
            String scrambleWord = scrambleWord(word, random);

            System.out.println("Scrambled Word: " + scrambleWord);

            boolean wordGuess = false; // Flag to check if the player guessed correctly
            int attempts = 3; // Number of allowed attempts

            // Loop for player's attempts
            while (attempts > 0 && !wordGuess) {
                System.out.println("Your Guess: ");
                String playerGuess = scanner.nextLine();

                // Checks if the player's guess is correct
                if (playerGuess.equalsIgnoreCase(word)) {
                    System.out.println("Correct! You've unscrambled the word.");
                    playerScore++; // Increments the player's score
                    wordGuess = true; // Marks that the word was guessed correctly
                } else {
                    attempts--; // Reduces the number of attempts
                    System.out.println("Wrong! Attempts remaining: " + attempts);
                }
            }

            // If the player does not guess the word
            if (!wordGuess) {
                System.out.println("The correct word is: " + word);
            }

            System.out.println("Your current score: " + playerScore);
            System.out.println("Do you want to play again? (yes/no): ");

            // Asks the player if they want to continue playing
            String response = scanner.nextLine();
            keepPlaying = response.equalsIgnoreCase("yes");
        }

        // Final game message
        System.out.println("Thank you for playing! Your final score is: " + playerScore);
        scanner.close(); // Closes the scanner
    }

    /**
     * Scrambles the characters of a word randomly.
     * @param word The word to be scrambled.
     * @param random Random number generator.
     * @return The scrambled word.
     */
    public static String scrambleWord(String word, Random random) {
        char[] letters = word.toCharArray(); // Converts the word into a character array

        // Shuffles the characters by swapping random positions
        for (int i = 0; i < letters.length; i++) {
            int j = random.nextInt(letters.length);
            char temp = letters[i];
            letters[i] = letters[j];
            letters[j] = temp;
        }

        return new String(letters); // Returns the scrambled word
    }
}
