import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Longest_Subsequence_Repeated_k_Times {
    public String longestSubsequenceRepeatedK(String s, int k) {
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        List<Character> candidate = new ArrayList<>();
        for (int i = 25; i >= 0; i--) {
            if (freq[i] >= k) {
                candidate.add((char) ('a' + i));
            }
        }

        Queue<String> q = new LinkedList<>();
        for (char ch : candidate) {
            q.add(String.valueOf(ch));
        }

        String ans = "";
        while (!q.isEmpty()) {
            String curr = q.poll();
            if (curr.length() > ans.length()) {
                ans = curr;
            }

            for (char ch : candidate) {
                String next = curr + ch;
                if (isKRepeatedSubsequence(s, next, k)) {
                    q.add(next);
                }
            }
        }

        return ans;
    }

    private boolean isKRepeatedSubsequence(String s, String t, int k) {
        int pos = 0, matched = 0;
        int m = t.length();

        for (char ch : s.toCharArray()) {
            if (ch == t.charAt(pos)) {
                pos++;
                if (pos == m) {
                    pos = 0;
                    matched++;
                    if (matched == k) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Longest_Subsequence_Repeated_k_Times obj = new Longest_Subsequence_Repeated_k_Times();
        String s = "letsleetcode";
        int k = 2;
        System.out.println(obj.longestSubsequenceRepeatedK(s, k)); // Output: "let"

        s = "bb";
        k = 2;
        System.out.println(obj.longestSubsequenceRepeatedK(s, k)); // Output: "b"
    }
}

/*
 * 2014. Longest Subsequence Repeated k Times Solved Hard Topics premium lock
 * icon Companies Hint You are given a string s of length n, and an integer k.
 * You are tasked to find the longest subsequence repeated k times in string s.
 * 
 * A subsequence is a string that can be derived from another string by deleting
 * some or no characters without changing the order of the remaining characters.
 * 
 * A subsequence seq is repeated k times in the string s if seq * k is a
 * subsequence of s, where seq * k represents a string constructed by
 * concatenating seq k times.
 * 
 * For example, "bba" is repeated 2 times in the string "bababcba", because the
 * string "bbabba", constructed by concatenating "bba" 2 times, is a subsequence
 * of the string "bababcba". Return the longest subsequence repeated k times in
 * string s. If multiple such subsequences are found, return the
 * lexicographically largest one. If there is no such subsequence, return an
 * empty string.
 * 
 * 
 * 
 * Example 1:
 * 
 * example 1 Input: s = "letsleetcode", k = 2 Output: "let" Explanation: There
 * are two longest subsequences repeated 2 times: "let" and "ete". "let" is the
 * lexicographically largest one. Example 2:
 * 
 * Input: s = "bb", k = 2 Output: "b" Explanation: The longest subsequence
 * repeated 2 times is "b". Example 3:
 * 
 * Input: s = "ab", k = 2 Output: "" Explanation: There is no subsequence
 * repeated 2 times. Empty string is returned.
 * 
 * 
 * Constraints:
 * 
 * n == s.length 2 <= n, k <= 2000 2 <= n < k * 8 s consists of lowercase
 * English letters.
 */