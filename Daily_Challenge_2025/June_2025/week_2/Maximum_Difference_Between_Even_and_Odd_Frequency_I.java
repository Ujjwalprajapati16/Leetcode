public class Maximum_Difference_Between_Even_and_Odd_Frequency_I {
    public int maxDifference(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int maxOdd = Integer.MIN_VALUE;
        int minEven = Integer.MAX_VALUE;

        for (int f : freq) {
            if (f == 0)
                continue;
            if (f % 2 == 0) {
                minEven = Math.min(minEven, f);
            } else {
                maxOdd = Math.max(maxOdd, f);
            }
        }

        return maxOdd - minEven;
    }

    public static void main(String[] args) {
        Maximum_Difference_Between_Even_and_Odd_Frequency_I solution = new Maximum_Difference_Between_Even_and_Odd_Frequency_I();
        String s1 = "aaaaabbc"; // Example input
        System.out.println(solution.maxDifference(s1)); // Output: 3

        String s2 = "abcabcab"; // Another example input
        System.out.println(solution.maxDifference(s2)); // Output: 1
    }
}

/*
 * 3442. Maximum Difference Between Even and Odd Frequency I
 * Solved
 * Easy
 * Topics
 * premium lock icon
 * Companies
 * Hint
 * You are given a string s consisting of lowercase English letters.
 * 
 * Your task is to find the maximum difference diff = freq(a1) - freq(a2)
 * between the frequency of characters a1 and a2 in the string such that:
 * 
 * a1 has an odd frequency in the string.
 * a2 has an even frequency in the string.
 * Return this maximum difference.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "aaaaabbc"
 * 
 * Output: 3
 * 
 * Explanation:
 * 
 * The character 'a' has an odd frequency of 5, and 'b' has an even frequency of
 * 2.
 * The maximum difference is 5 - 2 = 3.
 * Example 2:
 * 
 * Input: s = "abcabcab"
 * 
 * Output: 1
 * 
 * Explanation:
 * 
 * The character 'a' has an odd frequency of 3, and 'c' has an even frequency of
 * 2.
 * The maximum difference is 3 - 2 = 1.
 * 
 * 
 * Constraints:
 * 
 * 3 <= s.length <= 100
 * s consists only of lowercase English letters.
 * s contains at least one character with an odd frequency and one with an even
 * frequency.
 */