import java.util.HashMap;

public class Count_Number_of_Bad_Pairs {
    public long countBadPairs(int[] nums) {
        long n = nums.length;
        long goodPairs = 0;
        long totalPairs = n * (n - 1) / 2;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int val = i - nums[i];
            int prevCount = map.getOrDefault(val, 0);
            goodPairs += prevCount;
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        return totalPairs - goodPairs;
    }

    public static void main(String[] args) {
        Count_Number_of_Bad_Pairs sol = new Count_Number_of_Bad_Pairs();
        int[] nums = { 4, 1, 3, 3 };
        System.out.println(sol.countBadPairs(nums));

        int[] nums1 = { 1, 2, 3, 4, 5 };
        System.out.println(sol.countBadPairs(nums1));

        int[] nums2 = { 1, 1, 1, 1, 1 };
        System.out.println(sol.countBadPairs(nums2));
    }
}

/*
 * 2364. Count Number of Bad Pairs Solved Medium Topics Companies Hint You are
 * given a 0-indexed integer array nums. A pair of indices (i, j) is a bad pair
 * if i < j and j - i != nums[j] - nums[i].
 * 
 * Return the total number of bad pairs in nums.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [4,1,3,3] Output: 5 Explanation: The pair (0, 1) is a bad pair
 * since 1 - 0 != 1 - 4. The pair (0, 2) is a bad pair since 2 - 0 != 3 - 4, 2
 * != -1. The pair (0, 3) is a bad pair since 3 - 0 != 3 - 4, 3 != -1. The pair
 * (1, 2) is a bad pair since 2 - 1 != 3 - 1, 1 != 2. The pair (2, 3) is a bad
 * pair since 3 - 2 != 3 - 3, 1 != 0. There are a total of 5 bad pairs, so we
 * return 5. Example 2:
 * 
 * Input: nums = [1,2,3,4,5] Output: 0 Explanation: There are no bad pairs.
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 105 1 <= nums[i] <= 109
 */