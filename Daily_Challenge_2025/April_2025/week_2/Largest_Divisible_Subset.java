import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Largest_Divisible_Subset {
    List<Integer> res;
    int[] mem;

    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        mem = new int[nums.length];
        Arrays.fill(mem, -1);
        res = new ArrayList<>();
        helper(nums, 0, new ArrayList<>(), 1);
        return res;
    }

    private void helper(int[] nums, int index, List<Integer> curr, int prev) {
        if (curr.size() > res.size()) {
            res = new ArrayList<>(curr);
        }

        for (int i = index; i < nums.length; i++) {
            if (curr.size() > mem[i] && nums[i] % prev == 0) {
                mem[i] = curr.size();
                curr.add(nums[i]);
                helper(nums, i + 1, curr, nums[i]);
                curr.remove(curr.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Largest_Divisible_Subset lds = new Largest_Divisible_Subset();
        int[] nums = { 1, 2, 3 };
        System.out.println(lds.largestDivisibleSubset(nums)); // Output: [1, 2]

        int[] nums2 = { 1, 2, 4, 8 };
        System.out.println(lds.largestDivisibleSubset(nums2)); // Output: [1, 2, 4, 8]
    }
}

/*
 * 368. Largest Divisible Subset Solved Medium Topics Companies Given a set of
 * distinct positive integers nums, return the largest subset answer such that
 * every pair (answer[i], answer[j]) of elements in this subset satisfies:
 * 
 * answer[i] % answer[j] == 0, or answer[j] % answer[i] == 0 If there are
 * multiple solutions, return any of them.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,3] Output: [1,2] Explanation: [1,3] is also accepted.
 * Example 2:
 * 
 * Input: nums = [1,2,4,8] Output: [1,2,4,8]
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 1000 1 <= nums[i] <= 2 * 109 All the integers in nums are
 * unique.
 */