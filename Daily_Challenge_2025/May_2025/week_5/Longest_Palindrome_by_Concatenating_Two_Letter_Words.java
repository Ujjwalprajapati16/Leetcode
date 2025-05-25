import java.util.HashMap;
import java.util.Map;

public class Longest_Palindrome_by_Concatenating_Two_Letter_Words {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        int length = 0;

        for (String word : words) {
            String reverse = new StringBuilder(word).reverse().toString();
            if (map.getOrDefault(reverse, 0) > 0) {
                length += 4;
                map.put(reverse, map.get(reverse) - 1);
            } else {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        for (String key : map.keySet()) {
            if (key.charAt(0) == key.charAt(1) && map.get(key) > 0) {
                length += 2;
                break;
            }
        }

        return length;
    }

    public static void main(String[] args) {
        Longest_Palindrome_by_Concatenating_Two_Letter_Words solution = new Longest_Palindrome_by_Concatenating_Two_Letter_Words();

        // Example test cases
        String[] words1 = { "lc", "cl", "gg" };
        System.out.println(solution.longestPalindrome(words1)); // Output: 6

        String[] words2 = { "ab", "ty", "yt", "lc", "cl", "ab" };
        System.out.println(solution.longestPalindrome(words2)); // Output: 8

        String[] words3 = { "cc", "ll", "xx" };
        System.out.println(solution.longestPalindrome(words3)); // Output: 2
    }
}

/*
 * 2131. Longest Palindrome by Concatenating Two Letter Words Solved Medium
 * Topics Companies Hint You are given an array of strings words. Each element
 * of words consists of two lowercase English letters.
 * 
 * Create the longest possible palindrome by selecting some elements from words
 * and concatenating them in any order. Each element can be selected at most
 * once.
 * 
 * Return the length of the longest palindrome that you can create. If it is
 * impossible to create any palindrome, return 0.
 * 
 * A palindrome is a string that reads the same forward and backward.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: words = ["lc","cl","gg"] Output: 6 Explanation: One longest palindrome
 * is "lc" + "gg" + "cl" = "lcggcl", of length 6. Note that "clgglc" is another
 * longest palindrome that can be created. Example 2:
 * 
 * Input: words = ["ab","ty","yt","lc","cl","ab"] Output: 8 Explanation: One
 * longest palindrome is "ty" + "lc" + "cl" + "yt" = "tylcclyt", of length 8.
 * Note that "lcyttycl" is another longest palindrome that can be created.
 * Example 3:
 * 
 * Input: words = ["cc","ll","xx"] Output: 2 Explanation: One longest palindrome
 * is "cc", of length 2. Note that "ll" is another longest palindrome that can
 * be created, and so is "xx".
 * 
 * 
 * Constraints:
 * 
 * 1 <= words.length <= 105 words[i].length == 2 words[i] consists of lowercase
 * English letters.
 */