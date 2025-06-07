import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Lexicographically_Minimum_String_After_Removing_Stars {
    public String clearStars(String s) {
        List<Deque<Integer>> stacks = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            stacks.add(new ArrayDeque<>());
        }

        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (curr != '*') {
                stacks.get(curr - 'a').add(i);
                continue;
            }

            for (int j = 0; j < 26; j++) {
                if (!stacks.get(j).isEmpty()) {
                    int charIndex = stacks.get(j).pollLast();
                    chars[charIndex] = '*';
                    break;
                }
            }
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (chars[i] != '*') {
                res.append(s.charAt(i));
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        Lexicographically_Minimum_String_After_Removing_Stars solution = new Lexicographically_Minimum_String_After_Removing_Stars();
        System.out.println(solution.clearStars("aaba*")); // Output: "aab"
        System.out.println(solution.clearStars("abc")); // Output: "abc"
        System.out.println(solution.clearStars("ab*c*d*e")); // Output: "de"
    }
}

/*
 * 3170. Lexicographically Minimum String After Removing Stars Solved Medium
 * Topics premium lock icon Companies You are given a string s. It may contain
 * any number of '*' characters. Your task is to remove all '*' characters.
 * 
 * While there is a '*', do the following operation:
 * 
 * Delete the leftmost '*' and the smallest non-'*' character to its left. If
 * there are several smallest characters, you can delete any of them. Return the
 * lexicographically smallest resulting string after removing all '*'
 * characters.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "aaba*"
 * 
 * Output: "aab"
 * 
 * Explanation:
 * 
 * We should delete one of the 'a' characters with '*'. If we choose s[3], s
 * becomes the lexicographically smallest.
 * 
 * Example 2:
 * 
 * Input: s = "abc"
 * 
 * Output: "abc"
 * 
 * Explanation:
 * 
 * There is no '*' in the string.
 * 
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 105 s consists only of lowercase English letters and '*'.
 * The input is generated such that it is possible to delete all '*' characters.
 */