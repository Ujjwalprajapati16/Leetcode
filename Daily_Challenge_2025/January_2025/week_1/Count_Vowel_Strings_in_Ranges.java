import java.util.Arrays;
import java.util.HashSet;

public class Count_Vowel_Strings_in_Ranges {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int prefixSum[] = new int[n];
        prefixSum[0] = isVowel(words[0]);
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + isVowel(words[i]);
        }
        int m = queries.length;
        int ans[] = new int[m];
        for (int i = 0; i < m; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            int res = prefixSum[r];
            if (l != 0) {
                res -= prefixSum[l - 1];
            }
            ans[i] = res;
        }
        return ans;
    }

    public int isVowel(String word) {
        HashSet<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        char first = word.charAt(0);
        char last = word.charAt(word.length() - 1);
        if (set.contains(first) && set.contains(last)) {
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        Count_Vowel_Strings_in_Ranges obj = new Count_Vowel_Strings_in_Ranges();
        String words[] = { "aba", "bcb", "ece", "aa", "e" };
        int queries[][] = { { 0, 2 }, { 1, 4 }, { 1, 1 } };
        int ans[] = obj.vowelStrings(words, queries);
        for (int i : ans) {
            System.out.print(i + " ");
        }
        System.out.println();

        String words1[] = { "a", "e", "i" };
        int queries1[][] = { { 0, 2 }, { 0, 1 }, { 2, 2 } };
        int ans1[] = obj.vowelStrings(words1, queries1);
        for (int i : ans1) {
            System.out.print(i + " ");
        }
    }
}

/*
 * 2559. Count Vowel Strings in Ranges Solved Medium Topics Companies Hint You
 * are given a 0-indexed array of strings words and a 2D array of integers
 * queries.
 * 
 * Each query queries[i] = [li, ri] asks us to find the number of strings
 * present in the range li to ri (both inclusive) of words that start and end
 * with a vowel.
 * 
 * Return an array ans of size queries.length, where ans[i] is the answer to the
 * ith query.
 * 
 * Note that the vowel letters are 'a', 'e', 'i', 'o', and 'u'.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: words = ["aba","bcb","ece","aa","e"], queries = [[0,2],[1,4],[1,1]]
 * Output: [2,3,0] Explanation: The strings starting and ending with a vowel are
 * "aba", "ece", "aa" and "e". The answer to the query [0,2] is 2 (strings "aba"
 * and "ece"). to query [1,4] is 3 (strings "ece", "aa", "e"). to query [1,1] is
 * 0. We return [2,3,0]. Example 2:
 * 
 * Input: words = ["a","e","i"], queries = [[0,2],[0,1],[2,2]] Output: [3,2,1]
 * Explanation: Every string satisfies the conditions, so we return [3,2,1].
 * 
 * 
 * Constraints:
 * 
 * 1 <= words.length <= 105 1 <= words[i].length <= 40 words[i] consists only of
 * lowercase English letters. sum(words[i].length) <= 3 * 105 1 <=
 * queries.length <= 105 0 <= li <= ri < words.length
 */