import java.util.Arrays;
public class Number_of_Ways_to_Form_a_Target_String_Given_a_Dictionary {
    public int numWays(String[] words, String target) {
        int wordLen = words[0].length();
        int targetLen = target.length();
        int charFreq[][] = new int[wordLen][26];

        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                int charIndex = word.charAt(i) - 'a';
                charFreq[i][charIndex]++;
            }
        }
        long dp[][] = new long[wordLen + 1][targetLen + 1];
        for (int i = 0; i < wordLen + 1; i++) {
            Arrays.fill(dp[i], -1);
        }
        return (int) (recur(0, 0, charFreq, target, words, dp));
    }

    long recur(int wordIndex, int targetIndex, int charFreq[][], String target, String words[], long dp[][]) {
        // base case
        if (targetIndex == target.length()) {
            dp[wordIndex][targetIndex] = 1;
            return 1;
        }
        if (wordIndex == words[0].length()) {
            dp[wordIndex][targetIndex] = 0;
            return 0;
        }

        if ((target.length() - targetIndex) > (words[0].length() - wordIndex)) {
            dp[wordIndex][targetIndex] = 0;
            return 0;
        }

        if (dp[wordIndex][targetIndex] != -1) {
            return dp[wordIndex][targetIndex];
        }

        int curIndex = target.charAt(targetIndex) - 'a';
        int freq = charFreq[wordIndex][curIndex];

        long pick = freq * recur(wordIndex + 1, targetIndex + 1, charFreq, target, words, dp);
        long noPick = recur(wordIndex + 1, targetIndex, charFreq, target, words, dp);
        long res = (pick + noPick) % 1000000007;
        dp[wordIndex][targetIndex] = res;
        return res;
    }
    public static void main(String[] args) {
        Number_of_Ways_to_Form_a_Target_String_Given_a_Dictionary solution = new Number_of_Ways_to_Form_a_Target_String_Given_a_Dictionary();
        String[] words = {"acca","bbbb","caca"};
        String target = "aba";
        int result = solution.numWays(words, target);
        System.out.println(result);

        words = new String[] {"abba","baab"};
        target = "bab";
        result = solution.numWays(words, target);
        System.out.println(result);
    }
}

/*1639. Number of Ways to Form a Target String Given a Dictionary
Solved
Hard
Topics
Companies
Hint
You are given a list of strings of the same length words and a string target.

Your task is to form target using the given words under the following rules:

target should be formed from left to right.
To form the ith character (0-indexed) of target, you can choose the kth character of the jth string in words if target[i] = words[j][k].
Once you use the kth character of the jth string of words, you can no longer use the xth character of any string in words where x <= k. In other words, all characters to the left of or at index k become unusuable for every string.
Repeat the process until you form the string target.
Notice that you can use multiple characters from the same string in words provided the conditions above are met.

Return the number of ways to form target from words. Since the answer may be too large, return it modulo 109 + 7.

 

Example 1:

Input: words = ["acca","bbbb","caca"], target = "aba"
Output: 6
Explanation: There are 6 ways to form target.
"aba" -> index 0 ("acca"), index 1 ("bbbb"), index 3 ("caca")
"aba" -> index 0 ("acca"), index 2 ("bbbb"), index 3 ("caca")
"aba" -> index 0 ("acca"), index 1 ("bbbb"), index 3 ("acca")
"aba" -> index 0 ("acca"), index 2 ("bbbb"), index 3 ("acca")
"aba" -> index 1 ("caca"), index 2 ("bbbb"), index 3 ("acca")
"aba" -> index 1 ("caca"), index 2 ("bbbb"), index 3 ("caca")
Example 2:

Input: words = ["abba","baab"], target = "bab"
Output: 4
Explanation: There are 4 ways to form target.
"bab" -> index 0 ("baab"), index 1 ("baab"), index 2 ("abba")
"bab" -> index 0 ("baab"), index 1 ("baab"), index 3 ("baab")
"bab" -> index 0 ("baab"), index 2 ("baab"), index 3 ("baab")
"bab" -> index 1 ("abba"), index 2 ("baab"), index 3 ("baab")
 

Constraints:

1 <= words.length <= 1000
1 <= words[i].length <= 1000
All strings in words have the same length.
1 <= target.length <= 1000
words[i] and target contain only lowercase English letters. */