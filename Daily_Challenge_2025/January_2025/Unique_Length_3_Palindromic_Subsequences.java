import java.util.HashMap;
import java.util.HashSet;

public class Unique_Length_3_Palindromic_Subsequences {
    public int countPalindromicSubsequence(String s) {
        // find unique chars
        HashMap<Character, Integer> firstOcc = new HashMap<>();
        HashMap<Character, Integer> lastOcc = new HashMap<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (!firstOcc.containsKey(ch)) {
                firstOcc.put(ch, i);
            }
            lastOcc.put(ch, i);
        }

        int count = 0;
        for (char ch : firstOcc.keySet()) {
            int first = firstOcc.get(ch);
            int last = lastOcc.get(ch);
            if (first == last) {
                continue;
            }
            HashSet<Character> set1 = new HashSet<>();
            for (int i = first + 1; i < last; i++) {
                set1.add(s.charAt(i));
            }
            count += set1.size();
        }
        return count;
    }

    public static void main(String[] args) {
        Unique_Length_3_Palindromic_Subsequences sol = new Unique_Length_3_Palindromic_Subsequences();
        System.out.println(sol.countPalindromicSubsequence("aabca"));

        System.out.println(sol.countPalindromicSubsequence("adc"));

        System.out.println(sol.countPalindromicSubsequence("bbcbaba"));
    }
}

/*
 * 1930. Unique Length-3 Palindromic Subsequences Solved Medium Topics Companies
 * Hint Given a string s, return the number of unique palindromes of length
 * three that are a subsequence of s.
 * 
 * Note that even if there are multiple ways to obtain the same subsequence, it
 * is still only counted once.
 * 
 * A palindrome is a string that reads the same forwards and backwards.
 * 
 * A subsequence of a string is a new string generated from the original string
 * with some characters (can be none) deleted without changing the relative
 * order of the remaining characters.
 * 
 * For example, "ace" is a subsequence of "abcde".
 * 
 * 
 * Example 1:
 * 
 * Input: s = "aabca" Output: 3 Explanation: The 3 palindromic subsequences of
 * length 3 are: - "aba" (subsequence of "aabca") - "aaa" (subsequence of
 * "aabca") - "aca" (subsequence of "aabca") Example 2:
 * 
 * Input: s = "adc" Output: 0 Explanation: There are no palindromic subsequences
 * of length 3 in "adc". Example 3:
 * 
 * Input: s = "bbcbaba" Output: 4 Explanation: The 4 palindromic subsequences of
 * length 3 are: - "bbb" (subsequence of "bbcbaba") - "bcb" (subsequence of
 * "bbcbaba") - "bab" (subsequence of "bbcbaba") - "aba" (subsequence of
 * "bbcbaba")
 * 
 * 
 * Constraints:
 * 
 * 3 <= s.length <= 105 s consists of only lowercase English letters.
 */