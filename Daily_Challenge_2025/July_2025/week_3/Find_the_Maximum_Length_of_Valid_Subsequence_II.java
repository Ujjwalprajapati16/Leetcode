public class Find_the_Maximum_Length_of_Valid_Subsequence_II {
    public int maximumLength(int[] nums, int k) {
        int[][] dp = new int[k][k];
        int res = 0;
        for (int num : nums) {
            int currMod = num % k;
            for (int prevMod = 0; prevMod < k; prevMod++) {
                dp[prevMod][currMod] = dp[currMod][prevMod] + 1;
                res = Math.max(res, dp[prevMod][currMod]);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Find_the_Maximum_Length_of_Valid_Subsequence_II solution = new Find_the_Maximum_Length_of_Valid_Subsequence_II();
        int[] nums1 = { 1, 2, 3, 4, 5 };
        System.out.println(solution.maximumLength(nums1, 2)); // Output: 5

        int[] nums2 = { 1, 4, 2, 3, 1, 4 };
        System.out.println(solution.maximumLength(nums2, 3)); // Output: 4

        int[] nums3 = { 1, 3 };
        System.out.println(solution.maximumLength(nums3, 2)); // Output: 2
    }
}

/*
 * 3202. Find the Maximum Length of Valid Subsequence II Solved Medium Topics
 * premium lock icon Companies Hint You are given an integer array nums and a
 * positive integer k. A subsequence sub of nums with length x is called valid
 * if it satisfies:
 * 
 * (sub[0] + sub[1]) % k == (sub[1] + sub[2]) % k == ... == (sub[x - 2] + sub[x
 * - 1]) % k. Return the length of the longest valid subsequence of nums.
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,3,4,5], k = 2
 * 
 * Output: 5
 * 
 * Explanation:
 * 
 * The longest valid subsequence is [1, 2, 3, 4, 5].
 * 
 * Example 2:
 * 
 * Input: nums = [1,4,2,3,1,4], k = 3
 * 
 * Output: 4
 * 
 * Explanation:
 * 
 * The longest valid subsequence is [1, 4, 1, 4].
 * 
 * 
 * 
 * Constraints:
 * 
 * 2 <= nums.length <= 103 1 <= nums[i] <= 107 1 <= k <= 103
 */