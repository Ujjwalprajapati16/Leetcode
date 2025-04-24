import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Count_Complete_Subarrays_in_an_Array {
    public int countCompleteSubarrays(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int total = set.size();

        int i = 0, j = 0, ans = 0, n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        while (j < n) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

            while (map.size() == total) {
                ans += n - j;
                map.put(nums[i], map.get(nums[i]) - 1);
                if (map.get(nums[i]) == 0) {
                    map.remove(nums[i]);
                }
                i++;
            }
            j++;
        }

        return ans;
    }

    public static void main(String[] args) {
        Count_Complete_Subarrays_in_an_Array obj = new Count_Complete_Subarrays_in_an_Array();
        int nums[] = { 1, 3, 1, 2, 2 };
        int ans = obj.countCompleteSubarrays(nums);
        System.out.println(ans); // Output: 4

        int nums2[] = { 5, 5, 5, 5 };
        ans = obj.countCompleteSubarrays(nums2);
        System.out.println(ans); // Output: 10
    }
}

/*2799. Count Complete Subarrays in an Array
Solved
Medium
Topics
Companies
Hint
You are given an array nums consisting of positive integers.

We call a subarray of an array complete if the following condition is satisfied:

The number of distinct elements in the subarray is equal to the number of distinct elements in the whole array.
Return the number of complete subarrays.

A subarray is a contiguous non-empty part of an array.

 

Example 1:

Input: nums = [1,3,1,2,2]
Output: 4
Explanation: The complete subarrays are the following: [1,3,1,2], [1,3,1,2,2], [3,1,2] and [3,1,2,2].
Example 2:

Input: nums = [5,5,5,5]
Output: 10
Explanation: The array consists only of the integer 5, so any subarray is complete. The number of subarrays that we can choose is 10.
 

Constraints:

1 <= nums.length <= 1000
1 <= nums[i] <= 2000 */