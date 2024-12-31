
public class Continuous_Subarrays {
    public long continuousSubarrays(int[] nums) {
        int start = 0;
        int end = 0;
        int curMin = Integer.MAX_VALUE;
        int curMax = Integer.MIN_VALUE;
        long count = 0;
        int n = nums.length;

        while (end < n) {
            curMin = Math.min(curMin, nums[end]);
            curMax = Math.max(curMax, nums[end]);
            if (curMax - curMin > 2) {
                start = end;
                curMin = nums[end];
                curMax = nums[end];
                while (start - 1 >= 0 && Math.abs(nums[start - 1] - nums[end]) <= 2) {
                    start--;
                    curMin = Math.min(curMin, nums[start]);
                    curMax = Math.max(curMax, nums[start]);
                }
            }
            count += (end - start + 1);
            end++;
        }
        return count;
    }

    public static void main(String[] args) {
        Continuous_Subarrays solution = new Continuous_Subarrays();
        int[] nums = { 5, 4, 2, 4 };
        long result = solution.continuousSubarrays(nums);
        System.out.println(result);

        int[] nums1 = { 2, 1, 3, 4, 5, 2 };
        long result1 = solution.continuousSubarrays(nums1);
        System.out.println(result1);
    }
}

/*
 * 2762. Continuous Subarrays Solved Medium Topics Companies Hint You are given
 * a 0-indexed integer array nums. A subarray of nums is called continuous if:
 * 
 * Let i, i + 1, ..., j be the indices in the subarray. Then, for each pair of
 * indices i <= i1, i2 <= j, 0 <= |nums[i1] - nums[i2]| <= 2. Return the total
 * number of continuous subarrays.
 * 
 * A subarray is a contiguous non-empty sequence of elements within an array.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [5,4,2,4] Output: 8 Explanation: Continuous subarray of size 1:
 * [5], [4], [2], [4]. Continuous subarray of size 2: [5,4], [4,2], [2,4].
 * Continuous subarray of size 3: [4,2,4]. Thereare no subarrys of size 4. Total
 * continuous subarrays = 4 + 3 + 1 = 8. It can be shown that there are no more
 * continuous subarrays.
 * 
 * 
 * Example 2:
 * 
 * Input: nums = [1,2,3] Output: 6 Explanation: Continuous subarray of size 1:
 * [1], [2], [3]. Continuous subarray of size 2: [1,2], [2,3]. Continuous
 * subarray of size 3: [1,2,3]. Total continuous subarrays = 3 + 2 + 1 = 6.
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 105 1 <= nums[i] <= 109
 */