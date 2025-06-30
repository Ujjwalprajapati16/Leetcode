import java.util.Arrays;

public class Number_of_Subsequences_That_Satisfy_the_Given_Sum_Condition {
    int mod = 1000000007;

    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;

        int power[] = new int[n];
        power[0] = 1;

        for (int i = 1; i < n; i++) {
            power[i] = (power[i - 1] * 2) % mod;
        }

        int left = 0, right = n - 1;
        int ans = 0;

        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                ans = (ans + power[right - left]) % mod;
                left++;
            } else {
                right--;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Number_of_Subsequences_That_Satisfy_the_Given_Sum_Condition solution = new Number_of_Subsequences_That_Satisfy_the_Given_Sum_Condition();

        int[] nums1 = { 3, 5, 6, 7 };
        int target1 = 9;
        System.out.println(solution.numSubseq(nums1, target1)); // Output: 4

        int[] nums2 = { 3, 3, 6, 8 };
        int target2 = 10;
        System.out.println(solution.numSubseq(nums2, target2)); // Output: 6

        int[] nums3 = { 2, 3, 3, 4, 6, 7 };
        int target3 = 12;
        System.out.println(solution.numSubseq(nums3, target3)); // Output: 61
    }
}

/*
 * 1498. Number of Subsequences That Satisfy the Given Sum Condition Solved
 * Medium Topics premium lock icon Companies Hint You are given an array of
 * integers nums and an integer target.
 * 
 * Return the number of non-empty subsequences of nums such that the sum of the
 * minimum and maximum element on it is less or equal to target. Since the
 * answer may be too large, return it modulo 109 + 7.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [3,5,6,7], target = 9 Output: 4 Explanation: There are 4
 * subsequences that satisfy the condition. [3] -> Min value + max value <=
 * target (3 + 3 <= 9) [3,5] -> (3 + 5 <= 9) [3,5,6] -> (3 + 6 <= 9) [3,6] -> (3
 * + 6 <= 9) Example 2:
 * 
 * Input: nums = [3,3,6,8], target = 10 Output: 6 Explanation: There are 6
 * subsequences that satisfy the condition. (nums can have repeated numbers).
 * [3] , [3] , [3,3], [3,6] , [3,6] , [3,3,6] Example 3:
 * 
 * Input: nums = [2,3,3,4,6,7], target = 12 Output: 61 Explanation: There are 63
 * non-empty subsequences, two of them do not satisfy the condition ([6,7],
 * [7]). Number of valid subsequences (63 - 2 = 61).
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 105 1 <= nums[i] <= 106 1 <= target <= 106
 */