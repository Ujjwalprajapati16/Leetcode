import java.util.PriorityQueue;

public class Find_Subsequence_of_Length_K_With_the_Largest_Sum {
    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<int[]> pq1 = new PriorityQueue<>((a, b) -> (a[0] - b[0]));

        for (int i = 0; i < nums.length; i++) {
            pq1.add(new int[] { nums[i], i });
            if (pq1.size() > k) {
                pq1.poll();
            }
        }

        PriorityQueue<int[]> pq2 = new PriorityQueue<>((a, b) -> (a[1] - b[1]));

        while (!pq1.isEmpty()) {
            pq2.add(pq1.poll());
        }

        int[] ans = new int[k];
        int idx = 0;

        while (!pq2.isEmpty()) {
            int[] val = pq2.poll();
            ans[idx++] = val[0];
        }

        return ans;
    }

    public static void main(String[] args) {
        Find_Subsequence_of_Length_K_With_the_Largest_Sum solution = new Find_Subsequence_of_Length_K_With_the_Largest_Sum();
        int[] nums1 = { 2, 1, 3, 3 };
        int k1 = 2;
        int[] result1 = solution.maxSubsequence(nums1, k1);
        System.out.println(java.util.Arrays.toString(result1)); // Output: [3, 3]

        int[] nums2 = { -1, -2, 3, 4 };
        int k2 = 3;
        int[] result2 = solution.maxSubsequence(nums2, k2);
        System.out.println(java.util.Arrays.toString(result2)); // Output: [-1, 3, 4]

        int[] nums3 = { 3, 4, 3, 3 };
        int k3 = 2;
        int[] result3 = solution.maxSubsequence(nums3, k3);
        System.out.println(java.util.Arrays.toString(result3)); // Output: [3, 4]
    }
}

/*
 * 2099. Find Subsequence of Length K With the Largest Sum Solved Easy Topics
 * premium lock icon Companies Hint You are given an integer array nums and an
 * integer k. You want to find a subsequence of nums of length k that has the
 * largest sum.
 * 
 * Return any such subsequence as an integer array of length k.
 * 
 * A subsequence is an array that can be derived from another array by deleting
 * some or no elements without changing the order of the remaining elements.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [2,1,3,3], k = 2 Output: [3,3] Explanation: The subsequence has
 * the largest sum of 3 + 3 = 6. Example 2:
 * 
 * Input: nums = [-1,-2,3,4], k = 3 Output: [-1,3,4] Explanation: The
 * subsequence has the largest sum of -1 + 3 + 4 = 6. Example 3:
 * 
 * Input: nums = [3,4,3,3], k = 2 Output: [3,4] Explanation: The subsequence has
 * the largest sum of 3 + 4 = 7. Another possible subsequence is [4, 3].
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 1000 -105 <= nums[i] <= 105 1 <= k <= nums.length
 */