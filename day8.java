import java.util.*;
import java.util.Arrays;
public class ReverseWords {
    public static String reverseWords(String s) {
        // Trim spaces and split by one or more spaces (regex: "\\s+")
        String[] words = s.trim().split("\\s+");
        
        // Reverse the array of words
        Collections.reverse(Arrays.asList(words));
        
        // Join words with a single space
        return String.join(" ", words);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string:");
        String s = sc.nextLine();

        String result = reverseWords(s);
        System.out.println("Output: \"" + result + "\"");
        sc.close();
    }
}
