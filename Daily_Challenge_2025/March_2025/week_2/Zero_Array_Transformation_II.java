
public class Zero_Array_Transformation_II {

    @SuppressWarnings("unused")
    public int minZeroArray(int[] nums, int[][] queries) {
        int n = nums.length, m = queries.length;
        boolean alreadyZero = true;

        for (int num : nums) {
            if (num != 0) {
                alreadyZero = false;
                break;
            }
        }

        if (alreadyZero) {
            return 0;
        }

        int low = 1;
        int high = m;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canTransform(nums, queries, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    private boolean canTransform(int[] nums, int[][] queries, int k) {
        int n = nums.length;
        long[] diff = new long[n + 1];
        for (int i = 0; i < k; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            int val = queries[i][2];

            diff[left] += val;
            if (right + 1 < n) {
                diff[right + 1] -= val;
            }
        }

        long current = 0;
        for (int i = 0; i < n; i++) {
            current += diff[i];
            if (current < nums[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Zero_Array_Transformation_II sol = new Zero_Array_Transformation_II();

        // Example 1:
        int[] nums1 = {2, 0, 2};
        int[][] queries1 = {
            {0, 2, 1},
            {0, 2, 1},
            {1, 1, 3}
        };
        System.out.println(sol.minZeroArray(nums1, queries1));  // Expected output: 2

        // Example 2:
        int[] nums2 = {4, 3, 2, 1};
        int[][] queries2 = {
            {1, 3, 2},
            {0, 2, 1}
        };
        System.out.println(sol.minZeroArray(nums2, queries2));  // Expected output: -1
    }
}

/*3356. Zero Array Transformation II
Solved
Medium
Topics
Companies
Hint
You are given an integer array nums of length n and a 2D array queries where queries[i] = [li, ri, vali].

Each queries[i] represents the following action on nums:

Decrement the value at each index in the range [li, ri] in nums by at most vali.
The amount by which each value is decremented can be chosen independently for each index.
A Zero Array is an array with all its elements equal to 0.

Return the minimum possible non-negative value of k, such that after processing the first k queries in sequence, nums becomes a Zero Array. If no such k exists, return -1.

 

Example 1:

Input: nums = [2,0,2], queries = [[0,2,1],[0,2,1],[1,1,3]]

Output: 2

Explanation:

For i = 0 (l = 0, r = 2, val = 1):
Decrement values at indices [0, 1, 2] by [1, 0, 1] respectively.
The array will become [1, 0, 1].
For i = 1 (l = 0, r = 2, val = 1):
Decrement values at indices [0, 1, 2] by [1, 0, 1] respectively.
The array will become [0, 0, 0], which is a Zero Array. Therefore, the minimum value of k is 2.
Example 2:

Input: nums = [4,3,2,1], queries = [[1,3,2],[0,2,1]]

Output: -1

Explanation:

For i = 0 (l = 1, r = 3, val = 2):
Decrement values at indices [1, 2, 3] by [2, 2, 1] respectively.
The array will become [4, 1, 0, 0].
For i = 1 (l = 0, r = 2, val = 1):
Decrement values at indices [0, 1, 2] by [1, 1, 0] respectively.
The array will become [3, 0, 0, 0], which is not a Zero Array.
 

Constraints:

1 <= nums.length <= 105
0 <= nums[i] <= 5 * 105
1 <= queries.length <= 105
queries[i].length == 3
0 <= li <= ri < nums.length
1 <= vali <= 5 */
