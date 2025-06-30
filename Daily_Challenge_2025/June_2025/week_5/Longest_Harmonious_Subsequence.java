import java.util.HashMap;
import java.util.Map;

public class Longest_Harmonious_Subsequence {
    public int findLHS(int[] nums) {
        int result = 0;
        Map<Integer, Integer> count = new HashMap<>();
        for (int i : nums) {
            count.put(i, count.getOrDefault(i, 0) + 1);
        }

        for (int i : count.keySet()) {
            if (count.containsKey(i + 1)) {
                result = Math.max(result, count.get(i) + count.get(i + 1));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Longest_Harmonious_Subsequence solution = new Longest_Harmonious_Subsequence();

        int[] nums1 = { 1, 3, 2, 2, 5, 2, 3, 7 };
        System.out.println(solution.findLHS(nums1)); // Output: 5

        int[] nums2 = { 1, 2, 3, 4 };
        System.out.println(solution.findLHS(nums2)); // Output: 2

        int[] nums3 = { 1, 1, 1, 1 };
        System.out.println(solution.findLHS(nums3)); // Output: 0
    }
}

/*
 * 594. Longest Harmonious Subsequence Solved Easy Topics premium lock icon
 * Companies We define a harmonious array as an array where the difference
 * between its maximum value and its minimum value is exactly 1.
 * 
 * Given an integer array nums, return the length of its longest harmonious
 * subsequence among all its possible subsequences.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,3,2,2,5,2,3,7]
 * 
 * Output: 5
 * 
 * Explanation:
 * 
 * The longest harmonious subsequence is [3,2,2,2,3].
 * 
 * Example 2:
 * 
 * Input: nums = [1,2,3,4]
 * 
 * Output: 2
 * 
 * Explanation:
 * 
 * The longest harmonious subsequences are [1,2], [2,3], and [3,4], all of which
 * have a length of 2.
 * 
 * Example 3:
 * 
 * Input: nums = [1,1,1,1]
 * 
 * Output: 0
 * 
 * Explanation:
 * 
 * No harmonic subsequence exists.
 * 
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 2 * 104 -109 <= nums[i] <= 109
 */