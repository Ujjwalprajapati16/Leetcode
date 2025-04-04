
import java.util.Arrays;


public class Special_Array_II {

    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        int count[] = new int[n];
        for (int i = 1; i < n; i++) {
            int parity = (nums[i] % 2 == nums[i - 1] % 2) ? 1 : 0;
            count[i] = count[i - 1] + parity;
        }
        int m = queries.length;
        boolean res[] = new boolean[m];
        for (int i = 0; i < m; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            res[i] = ((count[end] - count[start]) == 0);
        }

        return res;
    }

    public static void main(String[] args) {
        Special_Array_II solution = new Special_Array_II();
        int[] nums = { 4, 3, 1, 6 };
        int[][] queries = { { 0, 2 }, { 2, 3 } };
        boolean[] result = solution.isArraySpecial(nums, queries);
        System.out.println(Arrays.toString(result));

        int[] nums1 = { 3, 4, 1, 2, 6 };
        int[][] queries1 = { { 0, 4 } };
        boolean[] result1 = solution.isArraySpecial(nums1, queries1);
        System.out.println(Arrays.toString(result1));
    }
}

/*
3152. Special Array II
Solved
Medium
Topics
Companies
Hint
An array is considered special if every pair of its adjacent elements contains two numbers with different parity.

You are given an array of integer nums and a 2D integer matrix queries, where for queries[i] = [fromi, toi] your task is to check that 
subarray
 nums[fromi..toi] is special or not.

Return an array of booleans answer such that answer[i] is true if nums[fromi..toi] is special.

 

Example 1:

Input: nums = [3,4,1,2,6], queries = [[0,4]]

Output: [false]

Explanation:

The subarray is [3,4,1,2,6]. 2 and 6 are both even.

Example 2:

Input: nums = [4,3,1,6], queries = [[0,2],[2,3]]

Output: [false,true]

Explanation:

The subarray is [4,3,1]. 3 and 1 are both odd. So the answer to this query is false.
The subarray is [1,6]. There is only one pair: (1,6) and it contains numbers with different parity. So the answer to this query is true.
 

Constraints:

1 <= nums.length <= 105
1 <= nums[i] <= 105
1 <= queries.length <= 105
queries[i].length == 2
0 <= queries[i][0] <= queries[i][1] <= nums.length - 1
 */