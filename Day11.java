import java.util.*;
import java.util.Arrays;
public class PermutationsUnique {
    public static List<String> permuteUnique(String s) {
        List<String> result = new ArrayList<>();
        char[] chars = s.toCharArray();
        Arrays.sort(chars); // sort to handle duplicates
        boolean[] used = new boolean[chars.length];
        backtrack(chars, used, new StringBuilder(), result);
        return result;
    }

    private static void backtrack(char[] chars, boolean[] used, StringBuilder path, List<String> result) {
        if (path.length() == chars.length) {
            result.add(path.toString());
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            // Skip already used
            if (used[i]) continue;

            // Skip duplicates (if same char as previous and previous not used)
            if (i > 0 && chars[i] == chars[i - 1] && !used[i - 1]) continue;

            // Choose
            used[i] = true;
            path.append(chars[i]);

            backtrack(chars, used, path, result);

            // Undo choice
            path.deleteCharAt(path.length() - 1);
            used[i] = false;
        }
    }

    // Test
    public static void main(String[] args) {
        System.out.println(permuteUnique("abc"));
        System.out.println(permuteUnique("aab"));
        System.out.println(permuteUnique("aaa"));
        System.out.println(permuteUnique("a"));
        System.out.println(permuteUnique("abcd").size()); // should be 24
    }
}
