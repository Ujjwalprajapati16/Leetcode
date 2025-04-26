public class Count_Subarrays_With_Fixed_Bounds {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long ans = 0;
        int skip = -1, minI = -1, maxI = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < minK || nums[i] > maxK) {
                skip = i;
            }
            if (nums[i] == minK) {
                minI = i;
            }
            if (nums[i] == maxK) {
                maxI = i;
            }
            ans += Math.max(0L, Math.min(minI, maxI) - skip);
        }

        return ans;
    }

    public static void main(String[] args) {
        Count_Subarrays_With_Fixed_Bounds obj = new Count_Subarrays_With_Fixed_Bounds();
        int nums[] = { 1, 3, 5, 2, 7, 5 };
        int minK = 1, maxK = 5;
        long ans = obj.countSubarrays(nums, minK, maxK);
        System.out.println(ans); // Output: 2

        int nums2[] = { 1, 1, 1, 1 };
        minK = 1;
        maxK = 1;
        ans = obj.countSubarrays(nums2, minK, maxK);
        System.out.println(ans); // Output: 10
    }
}

/*
 * 2444. Count Subarrays With Fixed Bounds
 * Solved
 * Hard
 * Topics
 * Companies
 * Hint
 * You are given an integer array nums and two integers minK and maxK.
 * 
 * A fixed-bound subarray of nums is a subarray that satisfies the following
 * conditions:
 * 
 * The minimum value in the subarray is equal to minK.
 * The maximum value in the subarray is equal to maxK.
 * Return the number of fixed-bound subarrays.
 * 
 * A subarray is a contiguous part of an array.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,3,5,2,7,5], minK = 1, maxK = 5
 * Output: 2
 * Explanation: The fixed-bound subarrays are [1,3,5] and [1,3,5,2].
 * Example 2:
 * 
 * Input: nums = [1,1,1,1], minK = 1, maxK = 1
 * Output: 10
 * Explanation: Every subarray of nums is a fixed-bound subarray. There are 10
 * possible subarrays.
 * 
 * 
 * Constraints:
 * 
 * 2 <= nums.length <= 105
 * 1 <= nums[i], minK, maxK <= 106
 */