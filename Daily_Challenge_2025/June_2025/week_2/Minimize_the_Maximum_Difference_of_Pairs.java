import java.util.Arrays;

public class Minimize_the_Maximum_Difference_of_Pairs {
    private boolean possiblePairs(int[] nums, int m, int p) {
        int n = nums.length;
        int pairs = 0;
        for (int i = 0; i < n - 1; i++) {
            if (Math.abs(nums[i] - nums[i + 1]) <= m) {
                pairs++;
                i++;
            }
        }

        return pairs >= p;
    }

    public int minimizeMax(int[] nums, int p) {
        int n = nums.length;
        Arrays.sort(nums);
        int l = 0, h = nums[n - 1] - nums[0];
        int res = 0;

        while (l <= h) {
            int m = (l + h) / 2;
            if (possiblePairs(nums, m, p)) {
                res = m;
                h = m - 1;
            } else {
                l = m + 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Minimize_the_Maximum_Difference_of_Pairs solution = new Minimize_the_Maximum_Difference_of_Pairs();
        int[] nums1 = { 10, 1, 2, 7, 1, 3 }; // Example input
        int p1 = 2; // Example input
        System.out.println(solution.minimizeMax(nums1, p1)); // Output: 1

        int[] nums2 = { 4, 2, 1, 2 }; // Another example input
        int p2 = 1; // Another example input
        System.out.println(solution.minimizeMax(nums2, p2)); // Output: 0
    }
}

/*
 * 2616. Minimize the Maximum Difference of Pairs Solved Medium Topics premium
 * lock icon Companies Hint You are given a 0-indexed integer array nums and an
 * integer p. Find p pairs of indices of nums such that the maximum difference
 * amongst all the pairs is minimized. Also, ensure no index appears more than
 * once amongst the p pairs.
 * 
 * Note that for a pair of elements at the index i and j, the difference of this
 * pair is |nums[i] - nums[j]|, where |x| represents the absolute value of x.
 * 
 * Return the minimum maximum difference among all p pairs. We define the
 * maximum of an empty set to be zero.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [10,1,2,7,1,3], p = 2 Output: 1 Explanation: The first pair is
 * formed from the indices 1 and 4, and the second pair is formed from the
 * indices 2 and 5. The maximum difference is max(|nums[1] - nums[4]|, |nums[2]
 * - nums[5]|) = max(0, 1) = 1. Therefore, we return 1. Example 2:
 * 
 * Input: nums = [4,2,1,2], p = 1 Output: 0 Explanation: Let the indices 1 and 3
 * form a pair. The difference of that pair is |2 - 2| = 0, which is the minimum
 * we can attain.
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 105 0 <= nums[i] <= 109 0 <= p <= (nums.length)/2
 */