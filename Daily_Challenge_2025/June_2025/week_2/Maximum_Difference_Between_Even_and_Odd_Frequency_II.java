import java.util.Arrays;

public class Maximum_Difference_Between_Even_and_Odd_Frequency_II {
    private int getState(int countA, int countB) {
        int parityA = countA % 2;
        int parityB = countB % 2;

        return (parityA << 1) | parityB;
    }

    public int maxDifference(String s, int k) {
        int n = s.length();
        int maxDiff = Integer.MIN_VALUE;

        for (char a = '0'; a <= '4'; a++) {
            for (char b = '0'; b <= '4'; b++) {
                if (a == b) {
                    continue;
                }

                int[] minPrefixDiff = new int[4];
                Arrays.fill(minPrefixDiff, Integer.MAX_VALUE);

                int totalA = 0, totalB = 0;
                int prefixA = 0, prefixB = 0;
                int left = -1;

                for (int right = 0; right < n; right++) {
                    if (s.charAt(right) == a) {
                        totalA++;
                    }

                    if (s.charAt(right) == b) {
                        totalB++;
                    }

                    while (right - left >= k && totalB - prefixB >= 2 && totalA - prefixA >= 1) {
                        int state = getState(prefixA, prefixB);
                        minPrefixDiff[state] = Math.min(minPrefixDiff[state], prefixA - prefixB);
                        left++;

                        if (s.charAt(left) == a) {
                            prefixA++;
                        }
                        if (s.charAt(left) == b) {
                            prefixB++;
                        }
                    }

                    int currentState = getState(totalA, totalB);
                    int oppositeState = currentState ^ 2;

                    if (minPrefixDiff[oppositeState] != Integer.MAX_VALUE) {
                        int currentDiff = (totalA - totalB) - minPrefixDiff[oppositeState];
                        maxDiff = Math.max(maxDiff, currentDiff);
                    }
                }
            }
        }

        return maxDiff;
    }

    public static void main(String[] args) {
        Maximum_Difference_Between_Even_and_Odd_Frequency_II solution = new Maximum_Difference_Between_Even_and_Odd_Frequency_II();
        String s1 = "12233"; // Example input
        int k1 = 4;
        System.out.println(solution.maxDifference(s1, k1)); // Output: -1

        String s2 = "1122211"; // Another example input
        int k2 = 3;
        System.out.println(solution.maxDifference(s2, k2)); // Output: 1

        String s3 = "110"; // Another example input
        int k3 = 3;
        System.out.println(solution.maxDifference(s3, k3)); // Output: -1
    }
}

/*
 * 3445. Maximum Difference Between Even and Odd Frequency II Solved Hard Topics
 * premium lock icon Companies Hint You are given a string s and an integer k.
 * Your task is to find the maximum difference between the frequency of two
 * characters, freq[a] - freq[b], in a substring subs of s, such that:
 * 
 * subs has a size of at least k. Character a has an odd frequency in subs.
 * Character b has an even frequency in subs. Return the maximum difference.
 * 
 * Note that subs can contain more than 2 distinct characters.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "12233", k = 4
 * 
 * Output: -1
 * 
 * Explanation:
 * 
 * For the substring "12233", the frequency of '1' is 1 and the frequency of '3'
 * is 2. The difference is 1 - 2 = -1.
 * 
 * Example 2:
 * 
 * Input: s = "1122211", k = 3
 * 
 * Output: 1
 * 
 * Explanation:
 * 
 * For the substring "11222", the frequency of '2' is 3 and the frequency of '1'
 * is 2. The difference is 3 - 2 = 1.
 * 
 * Example 3:
 * 
 * Input: s = "110", k = 3
 * 
 * Output: -1
 * 
 * 
 * 
 * Constraints:
 * 
 * 3 <= s.length <= 3 * 104 s consists only of digits '0' to '4'. The input is
 * generated that at least one substring has a character with an even frequency
 * and a character with an odd frequency. 1 <= k <= s.length
 */