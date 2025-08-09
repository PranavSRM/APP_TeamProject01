import java.util.Random;

public class WordBank {
    private static final String[] WORDS = {
        "java", "hangman", "developer", "keyboard", "computer", "syntax", "object","programming","system"
    };

    public static String getRandomWord() {
        Random rand = new Random();
        return WORDS[rand.nextInt(WORDS.length)];
    }
}
