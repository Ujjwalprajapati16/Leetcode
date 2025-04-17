import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Count_Equal_and_Divisible_Pairs_in_an_Array {
    public int countPairs(int[] nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], x -> new ArrayList<>()).add(i);
        }

        int ans = 0;
        for (List<Integer> indices : map.values()) {
            int n = indices.size();
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    int idx1 = indices.get(i);
                    int idx2 = indices.get(j);
                    if ((idx1 * idx2) % k == 0) {
                        ans++;
                    }
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Count_Equal_and_Divisible_Pairs_in_an_Array obj = new Count_Equal_and_Divisible_Pairs_in_an_Array();
        int[] nums1 = { 3, 1, 2, 2, 2, 1, 3 };
        int k1 = 2;
        System.out.println(obj.countPairs(nums1, k1)); // Output: 4

        int[] nums2 = { 1, 2, 3, 4 };
        int k2 = 1;
        System.out.println(obj.countPairs(nums2, k2)); // Output: 0
    }
}

/*
 * 2176. Count Equal and Divisible Pairs in an Array Solved Easy Topics
 * Companies Hint Given a 0-indexed integer array nums of length n and an
 * integer k, return the number of pairs (i, j) where 0 <= i < j < n, such that
 * nums[i] == nums[j] and (i * j) is divisible by k.
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [3,1,2,2,2,1,3], k = 2 Output: 4 Explanation: There are 4 pairs
 * that meet all the requirements: - nums[0] == nums[6], and 0 * 6 == 0, which
 * is divisible by 2. - nums[2] == nums[3], and 2 * 3 == 6, which is divisible
 * by 2. - nums[2] == nums[4], and 2 * 4 == 8, which is divisible by 2. -
 * nums[3] == nums[4], and 3 * 4 == 12, which is divisible by 2. Example 2:
 * 
 * Input: nums = [1,2,3,4], k = 1 Output: 0 Explanation: Since no value in nums
 * is repeated, there are no pairs (i,j) that meet all the requirements.
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 100 1 <= nums[i], k <= 100
 */