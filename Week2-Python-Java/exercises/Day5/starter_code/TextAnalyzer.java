import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Week 2 Exercise — String analysis (implement TODO methods).
 *
 * Compile: javac TextAnalyzer.java
 * Run:     java TextAnalyzer
 */
public class TextAnalyzer {

    /**
     * Counts the amount of words in a txt file
     * @param text the text string
     * @return the total amount of words in the string
     */
    public static int wordCount(String text) {
        int wordCount = 0;
        if(text.isBlank()){
            return wordCount;
        }

        String [] words  = text.split("\\s+");
        wordCount = words.length;

        return wordCount;
    }
 
    /**
     * Checks if a string is a palindrome
     * @param token string to check if it is a palindrome
     * @return true if it is a palindrome, false otherwise
     */
    public static boolean isPalindrome(String token) {
        String cleanToken = token.trim().toLowerCase();
        boolean isPalindrome = true;
        for(int i = 0; i < cleanToken.length()/2; i++){
            if(cleanToken.charAt(i) != cleanToken.charAt(cleanToken.length() - i - 1)){
                isPalindrome = false;
                break;
            }
        }
        return isPalindrome;
    }

    /**
     * Count the occurrences of a pattern in a string
     * @param haystack the string where the pattern might be found
     * @param needle the pattern to be counter in the string
     * @return number of occurrences of the pattern
     */
    public static int countOccurrences(String haystack, String needle) {
        String [] words  = haystack.split(needle);
        int occurrences = words.length - 1;

        return occurrences;
    }

    public static void main(String[] args) throws IOException {
        Path p = Path.of("sample.txt");
        String body = Files.readString(p);
        System.out.println("words=" + wordCount(body));
        System.out.println("palindrome(Radar)=" + isPalindrome("Radar"));
        System.out.println("occurrences of 'QA'=" + countOccurrences(body, "QA"));
    }
}