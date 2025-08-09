import java.util.*;

public class Hangman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String wordToGuess = WordBank.getRandomWord().toLowerCase();
        Set<Character> guessedLetters = new HashSet<>();
        int attempts = 6;

        System.out.println("🎮 Welcome to Hangman!");

        while (attempts > 0) {
            // Display word state
            boolean allGuessed = true;
            System.out.print("\nWord: ");
            for (char c : wordToGuess.toCharArray()) {
                if (guessedLetters.contains(c)) {
                    System.out.print(c + " ");
                } else {
                    System.out.print("_ ");
                    allGuessed = false;
                }
            }

            if (allGuessed) {
                System.out.println("\n✅ You guessed it right! The word was: " + wordToGuess);
                break;
            }

            // Take input
            System.out.print("\nGuess a letter: ");
            String input = scanner.nextLine().toLowerCase();

            if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
                System.out.println("❗ Invalid input. Please enter a single letter.");
                continue;
            }

            char guess = input.charAt(0);
            if (guessedLetters.contains(guess)) {
                System.out.println("⚠️ You already guessed that letter!");
                continue;
            }

            guessedLetters.add(guess);

            if (wordToGuess.contains(String.valueOf(guess))) {
                System.out.println("✅ Correct!");
            } else {
                attempts--;
                System.out.println("❌ Wrong! Attempts left: " + attempts);
            }
        }

        if (attempts == 0) {
            System.out.println("\n💀 Game Over! The word was: " + wordToGuess);
        }

        scanner.close();
    }
}
