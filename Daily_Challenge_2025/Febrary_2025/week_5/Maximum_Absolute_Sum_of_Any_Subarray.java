public class Maximum_Absolute_Sum_of_Any_Subarray {
    public int maxAbsoluteSum(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int minSum = Integer.MAX_VALUE;
        int curPSum = 0;
        int curNSum = 0;

        for (int num : nums) {
            // pos
            curPSum += num;
            maxSum = Math.max(maxSum, curPSum);
            if (curPSum < 0) {
                curPSum = 0;
            }
            // neg
            curNSum += num;
            minSum = Math.min(minSum, curNSum);
            if (curNSum > 0) {
                curNSum = 0;
            }
        }

        return Math.max(maxSum, Math.abs(minSum));
    }

    public static void main(String[] args) {
        Maximum_Absolute_Sum_of_Any_Subarray obj = new Maximum_Absolute_Sum_of_Any_Subarray();
        int nums[] = { 1, -3, 2, 3, -4 };
        System.out.println(obj.maxAbsoluteSum(nums)); // Output: 5

        int nums2[] = { 2, -5, 1, -4, 3, -2 };
        System.out.println(obj.maxAbsoluteSum(nums2)); // Output: 8
    }
}

/*
 * 1749. Maximum Absolute Sum of Any Subarray Solved Medium Topics Companies
 * Hint You are given an integer array nums. The absolute sum of a subarray
 * [numsl, numsl+1, ..., numsr-1, numsr] is abs(numsl + numsl+1 + ... + numsr-1
 * + numsr).
 * 
 * Return the maximum absolute sum of any (possibly empty) subarray of nums.
 * 
 * Note that abs(x) is defined as follows:
 * 
 * If x is a negative integer, then abs(x) = -x. If x is a non-negative integer,
 * then abs(x) = x.
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,-3,2,3,-4] Output: 5 Explanation: The subarray [2,3] has
 * absolute sum = abs(2+3) = abs(5) = 5. Example 2:
 * 
 * Input: nums = [2,-5,1,-4,3,-2] Output: 8 Explanation: The subarray [-5,1,-4]
 * has absolute sum = abs(-5+1-4) = abs(-8) = 8.
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 105 -104 <= nums[i] <= 104
 */