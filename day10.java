import java.util.*;
public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        // Take first string as initial prefix
        String prefix = strs[0];

        // Compare with remaining strings
        for (int i = 1; i < strs.length; i++) {
            // Keep trimming prefix until it matches
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);

                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of strings:");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        String[] strs = new String[n];
        System.out.println("Enter strings:");
        for (int i = 0; i < n; i++) {
            strs[i] = sc.nextLine();
        }

        String result = longestCommonPrefix(strs);
        System.out.println("Longest Common Prefix: \"" + result + "\"");
        sc.close();
    }
}
