import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Zero_Array_Transformation_III {
    public int maxRemoval(int[] nums, int[][] queries) {
        Arrays.sort(queries, Comparator.comparingInt(a -> a[0]));
        int[] diffs = new int[nums.length + 1];
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        int total = 0;
        int res = 0;
        int j = 0;

        for (int i = 0; i < nums.length; i++) {
            total += diffs[i];
            while (j < queries.length && queries[j][0] == i) {
                heap.add(queries[j++][1]);
            }
            while (nums[i] + total > 0) {
                if (heap.isEmpty()) {
                    return -1;
                }
                int num = heap.remove();
                if (num < i) {
                    continue;
                }
                total--;
                res++;
                diffs[num + 1]++;
            }
        }
        return queries.length - res;
    }

    public static void main(String[] args) {
        Zero_Array_Transformation_III obj = new Zero_Array_Transformation_III();
        int[] nums = { 2, 0, 2 };
        int[][] queries = { { 0, 2 }, { 0, 2 }, { 1, 1 } };
        int res = obj.maxRemoval(nums, queries);
        System.out.println(res); // 1

        nums = new int[] { 1, 1, 1, 1 };
        queries = new int[][] { { 1, 3 }, { 0, 2 }, { 1, 3 }, { 1, 2 } };
        res = obj.maxRemoval(nums, queries);
        System.out.println(res); // 2
    }
}

/*
 * 3362. Zero Array Transformation III
 * Solved
 * Medium
 * Topics
 * Companies
 * Hint
 * You are given an integer array nums of length n and a 2D array queries where
 * queries[i] = [li, ri].
 * 
 * Each queries[i] represents the following action on nums:
 * 
 * Decrement the value at each index in the range [li, ri] in nums by at most 1.
 * The amount by which the value is decremented can be chosen independently for
 * each index.
 * A Zero Array is an array with all its elements equal to 0.
 * 
 * Return the maximum number of elements that can be removed from queries, such
 * that nums can still be converted to a zero array using the remaining queries.
 * If it is not possible to convert nums to a zero array, return -1.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [2,0,2], queries = [[0,2],[0,2],[1,1]]
 * 
 * Output: 1
 * 
 * Explanation:
 * 
 * After removing queries[2], nums can still be converted to a zero array.
 * 
 * Using queries[0], decrement nums[0] and nums[2] by 1 and nums[1] by 0.
 * Using queries[1], decrement nums[0] and nums[2] by 1 and nums[1] by 0.
 * Example 2:
 * 
 * Input: nums = [1,1,1,1], queries = [[1,3],[0,2],[1,3],[1,2]]
 * 
 * Output: 2
 * 
 * Explanation:
 * 
 * We can remove queries[2] and queries[3].
 * 
 * Example 3:
 * 
 * Input: nums = [1,2,3,4], queries = [[0,3]]
 * 
 * Output: -1
 * 
 * Explanation:
 * 
 * nums cannot be converted to a zero array even after using all the queries.
 * 
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 105
 * 0 <= nums[i] <= 105
 * 1 <= queries.length <= 105
 * queries[i].length == 2
 * 0 <= li <= ri < nums.length
 */