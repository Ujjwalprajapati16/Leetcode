import java.util.Map;
import java.util.HashMap;

public class Count_the_Number_of_Good_Subarrays {
    public long countGood(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int same = 0, j = 0;
        long good = 0;

        for (int i = 0; i < n; i++) {
            while (same < k && j < n) {
                same += map.getOrDefault(nums[j], 0);
                map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
                j++;
            }

            if (same >= k) {
                good += n - (j - 1);
            }

            map.put(nums[i], map.get(nums[i]) - 1);
            same -= map.get(nums[i]);
        }

        return good;
    }

    public static void main(String[] args) {
        Count_the_Number_of_Good_Subarrays obj = new Count_the_Number_of_Good_Subarrays();
        int[] nums1 = {1, 1, 1, 1, 1};
        int k1 = 10;
        System.out.println(obj.countGood(nums1, k1)); // Output: 1

        int[] nums2 = {3, 1, 4, 3, 2, 2, 4};
        int k2 = 2;
        System.out.println(obj.countGood(nums2, k2)); // Output: 4
    }
}

/*2537. Count the Number of Good Subarrays
Solved
Medium
Topics
Companies
Hint
Given an integer array nums and an integer k, return the number of good subarrays of nums.

A subarray arr is good if there are at least k pairs of indices (i, j) such that i < j and arr[i] == arr[j].

A subarray is a contiguous non-empty sequence of elements within an array.

 

Example 1:

Input: nums = [1,1,1,1,1], k = 10
Output: 1
Explanation: The only good subarray is the array nums itself.
Example 2:

Input: nums = [3,1,4,3,2,2,4], k = 2
Output: 4
Explanation: There are 4 different good subarrays:
- [3,1,4,3,2,2] that has 2 pairs.
- [3,1,4,3,2,2,4] that has 3 pairs.
- [1,4,3,2,2,4] that has 2 pairs.
- [4,3,2,2,4] that has 2 pairs.
 

Constraints:

1 <= nums.length <= 105
1 <= nums[i], k <= 109 */