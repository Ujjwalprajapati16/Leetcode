import java.util.Arrays;

public class Count_the_Number_of_Fair_Pairs {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        return helper(nums, upper + 1) - helper(nums, lower);
    }

    private long helper(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        long ans = 0l;

        while (l < r) {
            int sum = nums[l] + nums[r];
            if (sum < target) {
                ans += (r - l);
                l++;
            } else {
                r--;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Count_the_Number_of_Fair_Pairs obj = new Count_the_Number_of_Fair_Pairs();
        int nums[] = { 0, 1, 7, 4, 4, 5 };
        int lower = 3, upper = 6;
        long ans = obj.countFairPairs(nums, lower, upper);

        System.out.println("Number of fair pairs: " + ans); // Output: 6

        int nums2[] = { 1, 7, 9, 2, 5 };
        int lower2 = 11, upper2 = 11;
        long ans2 = obj.countFairPairs(nums2, lower2, upper2);

        System.out.println("Number of fair pairs: " + ans2); // Output: 1
    }
}

/*
 * 2563. Count the Number of Fair Pairs Solved Medium Topics Companies Hint
 * Given a 0-indexed integer array nums of size n and two integers lower and
 * upper, return the number of fair pairs.
 * 
 * A pair (i, j) is fair if:
 * 
 * 0 <= i < j < n, and lower <= nums[i] + nums[j] <= upper
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [0,1,7,4,4,5], lower = 3, upper = 6 Output: 6 Explanation:
 * There are 6 fair pairs: (0,3), (0,4), (0,5), (1,3), (1,4), and (1,5). Example
 * 2:
 * 
 * Input: nums = [1,7,9,2,5], lower = 11, upper = 11 Output: 1 Explanation:
 * There is a single fair pair: (2,3).
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 105 nums.length == n -109 <= nums[i] <= 109 -109 <= lower
 * <= upper <= 109
 */