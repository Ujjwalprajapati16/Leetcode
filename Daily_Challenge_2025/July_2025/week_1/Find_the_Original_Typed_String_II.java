import java.util.ArrayList;

public class Find_the_Original_Typed_String_II {
    static int MOD = (int) 1e9 + 7;

    public int possibleStringCount(String word, int k) {
        if (word.length() == 0) {
            return 0;
        }

        ArrayList<Integer> groups = new ArrayList<>();
        int count = 1;
        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i) == word.charAt(i - 1)) {
                count++;
            } else {
                groups.add(count);
                count = 1;
            }
        }

        groups.add(count);
        long total = 1;
        for (int num : groups) {
            total = (total * num) % MOD;
        }

        if (k <= groups.size()) {
            return (int) total;
        }

        int[] dp = new int[k];
        dp[0] = 1;

        for (int freq : groups) {
            int[] tempDp = new int[k];
            long sum = 0;

            for (int i = 0; i < k; i++) {
                if (i > 0) {
                    sum = (sum + dp[i - 1]) % MOD;
                }

                if (i > freq) {
                    sum = (sum - dp[i - freq - 1] + MOD) % MOD;
                }

                tempDp[i] = (int) sum;
            }

            dp = tempDp;
        }

        long invalidCount = 0;
        for (int i = groups.size(); i < k; i++) {
            invalidCount = (invalidCount + dp[i]) % MOD;
        }

        return (int) ((total - invalidCount + MOD) % MOD);
    }

    public static void main(String[] args) {
        Find_the_Original_Typed_String_II solution = new Find_the_Original_Typed_String_II();
        System.out.println(solution.possibleStringCount("aabbccdd", 7)); // Output: 5
        System.out.println(solution.possibleStringCount("aabbccdd", 8)); // Output: 1
        System.out.println(solution.possibleStringCount("aaabbb", 3)); // Output: 8
    }
}

/*
 * 3333. Find the Original Typed String II Solved Hard Topics premium lock icon
 * Companies Hint Alice is attempting to type a specific string on her computer.
 * However, she tends to be clumsy and may press a key for too long, resulting
 * in a character being typed multiple times.
 * 
 * You are given a string word, which represents the final output displayed on
 * Alice's screen. You are also given a positive integer k.
 * 
 * Return the total number of possible original strings that Alice might have
 * intended to type, if she was trying to type a string of size at least k.
 * 
 * Since the answer may be very large, return it modulo 109 + 7.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: word = "aabbccdd", k = 7
 * 
 * Output: 5
 * 
 * Explanation:
 * 
 * The possible strings are: "aabbccdd", "aabbccd", "aabbcdd", "aabccdd", and
 * "abbccdd".
 * 
 * Example 2:
 * 
 * Input: word = "aabbccdd", k = 8
 * 
 * Output: 1
 * 
 * Explanation:
 * 
 * The only possible string is "aabbccdd".
 * 
 * Example 3:
 * 
 * Input: word = "aaabbb", k = 3
 * 
 * Output: 8
 * 
 * 
 * 
 * Constraints:
 * 
 * 1 <= word.length <= 5 * 105 word consists only of lowercase English letters.
 * 1 <= k <= 2000
 */