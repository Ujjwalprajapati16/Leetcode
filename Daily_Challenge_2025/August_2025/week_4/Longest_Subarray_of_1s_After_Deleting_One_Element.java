public class Longest_Subarray_of_1s_After_Deleting_One_Element {
    public int longestSubarray(int[] nums) {
        int left = 0;
        int zeros = 0;
        int maxLen = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zeros++;
            }

            while (zeros > 1) {
                if (nums[left] == 0) {
                    zeros--;
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Longest_Subarray_of_1s_After_Deleting_One_Element solution = new Longest_Subarray_of_1s_After_Deleting_One_Element();
        int[] nums = { 1, 1, 0, 1 };
        System.out.println(solution.longestSubarray(nums)); // Output: 3

        int[] nums2 = { 0, 1, 1, 1, 0, 1, 1, 0, 1 };
        System.out.println(solution.longestSubarray(nums2)); // Output: 5

        int[] nums3 = { 1, 1, 1 };
        System.out.println(solution.longestSubarray(nums3)); // Output: 2
    }
}

/*
 * 1493. Longest Subarray of 1's After Deleting One Element Solved Medium Topics
 * premium lock icon Companies Hint Given a binary array nums, you should delete
 * one element from it.
 * 
 * Return the size of the longest non-empty subarray containing only 1's in the
 * resulting array. Return 0 if there is no such subarray.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,1,0,1] Output: 3 Explanation: After deleting the number in
 * position 2, [1,1,1] contains 3 numbers with value of 1's. Example 2:
 * 
 * Input: nums = [0,1,1,1,0,1,1,0,1] Output: 5 Explanation: After deleting the
 * number in position 4, [0,1,1,1,1,1,0,1] longest subarray with value of 1's is
 * [1,1,1,1,1]. Example 3:
 * 
 * Input: nums = [1,1,1] Output: 2 Explanation: You must delete one element.
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 105 nums[i] is either 0 or 1.
 * 
 */
