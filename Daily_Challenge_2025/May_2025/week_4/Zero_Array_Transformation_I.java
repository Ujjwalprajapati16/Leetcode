public class Zero_Array_Transformation_I {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int N = nums.length;
        int[] diff = new int[N + 1];

        for (int[] q : queries) {
            diff[q[0]]--;
            diff[q[1] + 1]++;
        }
        int total = 0;

        for (int i = 0; i < nums.length; i++) {
            total += diff[i];
            if (nums[i] + total > 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Zero_Array_Transformation_I solution = new Zero_Array_Transformation_I();
        int[] nums1 = { 1, 0, 1 };
        int[][] queries1 = { { 0, 2 } };
        System.out.println(solution.isZeroArray(nums1, queries1)); // Output: true

        int[] nums2 = { 4, 3, 2, 1 };
        int[][] queries2 = { { 1, 3 }, { 0, 2 } };
        System.out.println(solution.isZeroArray(nums2, queries2)); // Output: false
    }
}

/*
 * 3355. Zero Array Transformation I Solved Medium Topics Companies Hint You are
 * given an integer array nums of length n and a 2D array queries, where
 * queries[i] = [li, ri].
 * 
 * For each queries[i]:
 * 
 * Select a subset of indices within the range [li, ri] in nums. Decrement the
 * values at the selected indices by 1. A Zero Array is an array where all
 * elements are equal to 0.
 * 
 * Return true if it is possible to transform nums into a Zero Array after
 * processing all the queries sequentially, otherwise return false.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,0,1], queries = [[0,2]]
 * 
 * Output: true
 * 
 * Explanation:
 * 
 * For i = 0: Select the subset of indices as [0, 2] and decrement the values at
 * these indices by 1. The array will become [0, 0, 0], which is a Zero Array.
 * Example 2:
 * 
 * Input: nums = [4,3,2,1], queries = [[1,3],[0,2]]
 * 
 * Output: false
 * 
 * Explanation:
 * 
 * For i = 0: Select the subset of indices as [1, 2, 3] and decrement the values
 * at these indices by 1. The array will become [4, 2, 1, 0]. For i = 1: Select
 * the subset of indices as [0, 1, 2] and decrement the values at these indices
 * by 1. The array will become [3, 1, 0, 0], which is not a Zero Array.
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 105 0 <= nums[i] <= 105 1 <= queries.length <= 105
 * queries[i].length == 2 0 <= li <= ri < nums.length
 */