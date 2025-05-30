public class Partition_Equal_Subset_Sum {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }

        if (sum % 2 != 0) {
            return false;
        }

        sum = sum / 2;

        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;

        for (int i : nums) {
            for (int j = sum; j >= i; j--) {
                dp[j] = dp[j] | dp[j - i];
            }
        }

        return dp[sum];
    }

    public static void main(String[] args) {
        Partition_Equal_Subset_Sum obj = new Partition_Equal_Subset_Sum();
        int[] nums = { 1, 5, 11, 5 };
        System.out.println(obj.canPartition(nums)); // true

        nums = new int[] { 1, 2, 3, 5 };
        System.out.println(obj.canPartition(nums)); // false
    }
}

/*
 * 416. Partition Equal Subset Sum
 * Solved
 * Medium
 * Topics
 * Companies
 * Given an integer array nums, return true if you can partition the array into
 * two subsets such that the sum of the elements in both subsets is equal or
 * false otherwise.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,5,11,5]
 * Output: true
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 * Example 2:
 * 
 * Input: nums = [1,2,3,5]
 * Output: false
 * Explanation: The array cannot be partitioned into equal sum subsets.
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 100
 */