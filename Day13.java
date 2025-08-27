import java.util.*;

public class LongestPalindromeSubstring {
    
    private static String expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right); 
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        
        String longest = "";
        
        for (int i = 0; i < s.length(); i++) {
            
            String odd = expandAroundCenter(s, i, i);
            
            String even = expandAroundCenter(s, i, i + 1);
            
            String current = odd.length() > even.length() ? odd : even;
            
            if (current.length() > longest.length()) {
                longest = current;
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string: ");
        String s = sc.nextLine();

        String result = longestPalindrome(s);
        System.out.println("Longest Palindromic Substring: " + result);

        sc.close();
    }
}
