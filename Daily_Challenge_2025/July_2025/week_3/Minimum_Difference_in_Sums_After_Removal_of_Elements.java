import java.util.Collections;
import java.util.PriorityQueue;

public class Minimum_Difference_in_Sums_After_Removal_of_Elements {
    public long minimumDifference(int[] nums) {
        int n = nums.length / 3;
        int len = nums.length;

        PriorityQueue<Integer> leftMaxHeap = new PriorityQueue<>(Collections.reverseOrder());
        long[] leftSum = new long[len];
        long leftTotal = 0;

        for (int i = 0; i < len; i++) {
            leftTotal += nums[i];
            leftMaxHeap.offer(nums[i]);
            if (leftMaxHeap.size() > n) {
                leftTotal -= leftMaxHeap.poll();
            }

            if (leftMaxHeap.size() == n) {
                leftSum[i] = leftTotal;
            } else {
                leftSum[i] = Long.MAX_VALUE;
            }
        }

        PriorityQueue<Integer> rightMinHeap = new PriorityQueue<>();
        long[] rightSum = new long[len];
        long rightTotal = 0;
        for (int i = len - 1; i >= 0; i--) {
            rightTotal += nums[i];
            rightMinHeap.offer(nums[i]);
            if (rightMinHeap.size() > n) {
                rightTotal -= rightMinHeap.poll();
            }

            if (rightMinHeap.size() == n) {
                rightSum[i] = rightTotal;
            } else {
                rightSum[i] = Long.MIN_VALUE;
            }
        }

        long result = Long.MAX_VALUE;
        for (int i = n - 1; i < 2 * n; i++) {
            if (leftSum[i] != Long.MAX_VALUE && rightSum[i] != Long.MIN_VALUE) {
                result = Math.min(result, leftSum[i] - rightSum[i + 1]);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Minimum_Difference_in_Sums_After_Removal_of_Elements solution = new Minimum_Difference_in_Sums_After_Removal_of_Elements();
        int[] nums1 = { 3, 1, 2 };
        System.out.println(solution.minimumDifference(nums1)); // Output: -1

        int[] nums2 = { 7, 9, 5, 8, 1, 3 };
        System.out.println(solution.minimumDifference(nums2)); // Output: 1

        int[] nums3 = { 1, 2, 3, 4, 5, 6 };
        System.out.println(solution.minimumDifference(nums3)); // Output: -8
    }
}

/*
 * 2163. Minimum Difference in Sums After Removal of Elements Solved Hard Topics
 * premium lock icon Companies Hint You are given a 0-indexed integer array nums
 * consisting of 3 * n elements.
 * 
 * You are allowed to remove any subsequence of elements of size exactly n from
 * nums. The remaining 2 * n elements will be divided into two equal parts:
 * 
 * The first n elements belonging to the first part and their sum is sumfirst.
 * The next n elements belonging to the second part and their sum is sumsecond.
 * The difference in sums of the two parts is denoted as sumfirst - sumsecond.
 * 
 * For example, if sumfirst = 3 and sumsecond = 2, their difference is 1.
 * Similarly, if sumfirst = 2 and sumsecond = 3, their difference is -1. Return
 * the minimum difference possible between the sums of the two parts after the
 * removal of n elements.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [3,1,2] Output: -1 Explanation: Here, nums has 3 elements, so n
 * = 1. Thus we have to remove 1 element from nums and divide the array into two
 * equal parts. - If we remove nums[0] = 3, the array will be [1,2]. The
 * difference in sums of the two parts will be 1 - 2 = -1. - If we remove
 * nums[1] = 1, the array will be [3,2]. The difference in sums of the two parts
 * will be 3 - 2 = 1. - If we remove nums[2] = 2, the array will be [3,1]. The
 * difference in sums of the two parts will be 3 - 1 = 2. The minimum difference
 * between sums of the two parts is min(-1,1,2) = -1. Example 2:
 * 
 * Input: nums = [7,9,5,8,1,3] Output: 1 Explanation: Here n = 2. So we must
 * remove 2 elements and divide the remaining array into two parts containing
 * two elements each. If we remove nums[2] = 5 and nums[3] = 8, the resultant
 * array will be [7,9,1,3]. The difference in sums will be (7+9) - (1+3) = 12.
 * To obtain the minimum difference, we should remove nums[1] = 9 and nums[4] =
 * 1. The resultant array becomes [7,5,8,3]. The difference in sums of the two
 * parts is (7+5) - (8+3) = 1. It can be shown that it is not possible to obtain
 * a difference smaller than 1.
 * 
 * 
 * Constraints:
 * 
 * nums.length == 3 * n 1 <= n <= 105 1 <= nums[i] <= 105
 */