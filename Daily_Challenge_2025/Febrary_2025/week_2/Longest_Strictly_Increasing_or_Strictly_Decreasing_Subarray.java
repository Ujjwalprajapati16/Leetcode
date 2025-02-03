public class Longest_Strictly_Increasing_or_Strictly_Decreasing_Subarray {
    public int longestMonotonicSubarray(int[] nums) {
        int cur = 1;
        int res = 1;
        int inc = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < nums[i]) {
                if (inc > 0) {
                    cur += 1;
                } else {
                    cur = 2;
                    inc = 1;
                }
            } else if (nums[i - 1] > nums[i]) {
                if (inc < 0) {
                    cur += 1;
                } else {
                    cur = 2;
                    inc = -1;
                }
            } else {
                cur = 1;
                inc = 0;
            }

            res = Math.max(res, cur);
        }

        return res;
    }

    public static void main(String[] args) {
        Longest_Strictly_Increasing_or_Strictly_Decreasing_Subarray obj = new Longest_Strictly_Increasing_or_Strictly_Decreasing_Subarray();
        int[] nums = { 1, 4, 3, 3, 2 };
        System.out.println(obj.longestMonotonicSubarray(nums));

        int[] nums1 = { 3, 3, 3, 3 };
        System.out.println(obj.longestMonotonicSubarray(nums1));

        int[] nums2 = { 3, 2, 1 };
        System.out.println(obj.longestMonotonicSubarray(nums2));
    }
}

/*
 * 3105. Longest Strictly Increasing or Strictly Decreasing Subarray Solved Easy
 * Topics Companies You are given an array of integers nums. Return the length
 * of the longest subarray of nums which is either strictly increasing or
 * strictly decreasing .
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,4,3,3,2]
 * 
 * Output: 2
 * 
 * Explanation:
 * 
 * The strictly increasing subarrays of nums are [1], [2], [3], [3], [4], and
 * [1,4].
 * 
 * The strictly decreasing subarrays of nums are [1], [2], [3], [3], [4], [3,2],
 * and [4,3].
 * 
 * Hence, we return 2.
 * 
 * Example 2:
 * 
 * Input: nums = [3,3,3,3]
 * 
 * Output: 1
 * 
 * Explanation:
 * 
 * The strictly increasing subarrays of nums are [3], [3], [3], and [3].
 * 
 * The strictly decreasing subarrays of nums are [3], [3], [3], and [3].
 * 
 * Hence, we return 1.
 * 
 * Example 3:
 * 
 * Input: nums = [3,2,1]
 * 
 * Output: 3
 * 
 * Explanation:
 * 
 * The strictly increasing subarrays of nums are [3], [2], and [1].
 * 
 * The strictly decreasing subarrays of nums are [3], [2], [1], [3,2], [2,1],
 * and [3,2,1].
 * 
 * Hence, we return 3.
 * 
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 50 1 <= nums[i] <= 50
 */