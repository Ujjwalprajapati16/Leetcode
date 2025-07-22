import java.util.HashSet;
import java.util.Set;

public class Maximum_Erasure_Value {
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        int left = 0;
        int currentSum = 0;
        int maxSum = 0;

        for (int right = 0; right < nums.length; right++) {
            while (seen.contains(nums[right])) {
                seen.remove(nums[left]);
                currentSum -= nums[left];
                left++;
            }

            seen.add(nums[right]);
            currentSum += nums[right];
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        Maximum_Erasure_Value solution = new Maximum_Erasure_Value();
        int[] nums = { 4, 2, 4, 5, 6 };
        int result = solution.maximumUniqueSubarray(nums);
        System.out.println(result); // Output: 17

        int[] nums2 = { 5, 2, 1, 2, 5, 2, 1, 2, 5 };
        int result2 = solution.maximumUniqueSubarray(nums2);
        System.out.println(result2); // Output: 8
    }
}

/*
 * 1695. Maximum Erasure Value
 * Solved
 * Medium
 * Topics
 * premium lock icon
 * Companies
 * Hint
 * You are given an array of positive integers nums and want to erase a subarray
 * containing unique elements. The score you get by erasing the subarray is
 * equal to the sum of its elements.
 * 
 * Return the maximum score you can get by erasing exactly one subarray.
 * 
 * An array b is called to be a subarray of a if it forms a contiguous
 * subsequence of a, that is, if it is equal to a[l],a[l+1],...,a[r] for some
 * (l,r).
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [4,2,4,5,6]
 * Output: 17
 * Explanation: The optimal subarray here is [2,4,5,6].
 * Example 2:
 * 
 * Input: nums = [5,2,1,2,5,2,1,2,5]
 * Output: 8
 * Explanation: The optimal subarray here is [5,2,1] or [1,2,5].
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 104
 */