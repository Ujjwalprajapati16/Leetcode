public class Maximum_Difference_Between_Adjacent_Elements_in_a_Circular_Array {
    public int maxAdjacentDistance(int[] nums) {
        int n = nums.length;
        int maxDiff = Math.abs(nums[0] - nums[n - 1]);

        for (int i = 1; i < n; i++) {
            maxDiff = Math.max(maxDiff, Math.abs(nums[i] - nums[i - 1]));
        }

        return maxDiff;
    }

    public static void main(String[] args) {
        Maximum_Difference_Between_Adjacent_Elements_in_a_Circular_Array solution = new Maximum_Difference_Between_Adjacent_Elements_in_a_Circular_Array();

        int[] nums1 = { 1, 2, 4 }; // Example input
        System.out.println(solution.maxAdjacentDistance(nums1)); // Output: 3

        int[] nums2 = { -5, -10, -5 }; // Another example input
        System.out.println(solution.maxAdjacentDistance(nums2)); // Output: 5
    }
}

/*
 * 3423. Maximum Difference Between Adjacent Elements in a Circular Array Solved
 * Easy Topics premium lock icon Companies Hint Given a circular array nums,
 * find the maximum absolute difference between adjacent elements.
 * 
 * Note: In a circular array, the first and last elements are adjacent.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,4]
 * 
 * Output: 3
 * 
 * Explanation:
 * 
 * Because nums is circular, nums[0] and nums[2] are adjacent. They have the
 * maximum absolute difference of |4 - 1| = 3.
 * 
 * Example 2:
 * 
 * Input: nums = [-5,-10,-5]
 * 
 * Output: 5
 * 
 * Explanation:
 * 
 * The adjacent elements nums[0] and nums[1] have the maximum absolute
 * difference of |-5 - (-10)| = 5.
 * 
 * 
 * 
 * Constraints:
 * 
 * 2 <= nums.length <= 100 -100 <= nums[i] <= 100
 */