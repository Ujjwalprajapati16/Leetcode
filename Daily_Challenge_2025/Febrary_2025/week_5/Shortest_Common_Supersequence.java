public class Shortest_Common_Supersequence {
    public String shortestCommonSupersequence(String str1, String str2) {
        int[][] dp = longestCommonSubsequence(str1, str2);
        int i = str1.length(), j = str2.length();
        StringBuilder sb = new StringBuilder();
        
        // Build the supersequence backwards.
        while(i > 0 && j > 0) {
            if(str1.charAt(i-1) == str2.charAt(j-1)) {
                // Same char in both strings: add it and move diagonally.
                sb.append(str1.charAt(i-1));
                i--;
                j--;
            } else if(dp[i-1][j] > dp[i][j-1]) {
                // Prefer a char from str1.
                sb.append(str1.charAt(i-1));
                i--;
            } else {
                // Otherwise, prefer a char from str2.
                sb.append(str2.charAt(j-1));
                j--;
            }
        }
        
        // If there are remaining characters in str1, add them.
        while(i > 0) {
            sb.append(str1.charAt(i-1));
            i--;
        }
        // If there are remaining characters in str2, add them.
        while(j > 0) {
            sb.append(str2.charAt(j-1));
            j--;
        }
        
        // The supersequence is built backwards so reverse it.
        return sb.reverse().toString();
    }
    
    // Helper method to compute the longest common subsequence (LCS) DP table.
    private int[][] longestCommonSubsequence(String s, String t) {
        int n = s.length(), m = t.length();
        int[][] dp = new int[n+1][m+1];
        
        // Build the DP table: dp[i][j] is the length of LCS of s[0...i-1] and t[0...j-1].
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(s.charAt(i-1) == t.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp;
    }

    public static void main(String[] args) {
        Shortest_Common_Supersequence obj = new Shortest_Common_Supersequence();
        String str1 = "abac";
        String str2 = "cab";
        System.out.println(obj.shortestCommonSupersequence(str1, str2));

        String str3 = "aaaaaaaa";
        String str4 = "aaaaaaaa";
        System.out.println(obj.shortestCommonSupersequence(str3, str4));
    }
}

/*1092. Shortest Common Supersequence 
Solved
Hard
Topics
Companies
Hint
Given two strings str1 and str2, return the shortest string that has both str1 and str2 as subsequences. If there are multiple valid strings, return any of them.

A string s is a subsequence of string t if deleting some number of characters from t (possibly 0) results in the string s.

 

Example 1:

Input: str1 = "abac", str2 = "cab"
Output: "cabac"
Explanation: 
str1 = "abac" is a subsequence of "cabac" because we can delete the first "c".
str2 = "cab" is a subsequence of "cabac" because we can delete the last "ac".
The answer provided is the shortest such string that satisfies these properties.
Example 2:

Input: str1 = "aaaaaaaa", str2 = "aaaaaaaa"
Output: "aaaaaaaa"
 

Constraints:

1 <= str1.length, str2.length <= 1000
str1 and str2 consist of lowercase English letters. */