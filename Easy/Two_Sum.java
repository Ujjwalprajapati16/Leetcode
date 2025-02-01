import java.util.HashMap;
import java.util.Map;

public class Two_Sum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }

            map.put(nums[i], i);
        }

        return new int[] {};
    }

    public static void main(String[] args) {
        Two_Sum ts = new Two_Sum();

        int[] nums = { 2, 7, 11, 15 };
        int target = 9;

        int[] result = ts.twoSum(nums, target);

        for (int i : result) {
            System.out.print(i + " ");
        }

        System.out.println();

        int[] nums2 = { 3, 2, 4 };
        int target2 = 6;
        int[] result2 = ts.twoSum(nums2, target2);
        for (int i : result2) {
            System.out.print(i + " ");
        }

        System.out.println();

        int[] nums3 = { 3, 3 };
        int target3 = 6;
        int[] result3 = ts.twoSum(nums3, target3);

        for (int i : result3) {
            System.out.print(i + " ");
        }
    }
}

/*
 * 1. Two Sum Solved Easy Topics Companies Hint Given an array of integers nums
 * and an integer target, return indices of the two numbers such that they add
 * up to target.
 * 
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 * 
 * You can return the answer in any order.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [2,7,11,15], target = 9 Output: [0,1] Explanation: Because
 * nums[0] + nums[1] == 9, we return [0, 1]. Example 2:
 * 
 * Input: nums = [3,2,4], target = 6 Output: [1,2] Example 3:
 * 
 * Input: nums = [3,3], target = 6 Output: [0,1]
 * 
 * 
 * Constraints:
 * 
 * 2 <= nums.length <= 104 -109 <= nums[i] <= 109 -109 <= target <= 109 Only one
 * valid answer exists.
 * 
 * 
 * Follow-up: Can you come up with an algorithm that is less than O(n2) time
 * complexity?
 */