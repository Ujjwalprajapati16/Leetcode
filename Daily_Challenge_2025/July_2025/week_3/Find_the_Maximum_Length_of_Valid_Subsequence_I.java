public class Find_the_Maximum_Length_of_Valid_Subsequence_I {
    public int maximumLength(int[] nums) {
        int n = nums.length;
        int odd = 0;
        int even = 0;
        int evenOdd = 0;
        int oldParity = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 0) {
                even++;
            } else if (nums[i] % 2 == 1) {
                odd++;
            }

            int parity = nums[i] % 2 == 0 ? 0 : 1;

            if (i == 0 || parity != oldParity) {
                evenOdd++;
                oldParity = nums[i] % 2 == 0 ? 0 : 1;
            }
        }

        return Math.max(Math.max(even, odd), evenOdd);
    }

    public static void main(String[] args) {
        Find_the_Maximum_Length_of_Valid_Subsequence_I solution = new Find_the_Maximum_Length_of_Valid_Subsequence_I();
        int[] nums1 = { 1, 2, 3, 4 };
        System.out.println(solution.maximumLength(nums1)); // Output: 4

        int[] nums2 = { 1, 2, 1, 1, 2, 1, 2 };
        System.out.println(solution.maximumLength(nums2)); // Output: 6

        int[] nums3 = { 1, 3 };
        System.out.println(solution.maximumLength(nums3)); // Output: 2
    }
}

/*
 * 3201. Find the Maximum Length of Valid Subsequence I Solved Medium Topics
 * premium lock icon Companies Hint You are given an integer array nums. A
 * subsequence sub of nums with length x is called valid if it satisfies:
 * 
 * (sub[0] + sub[1]) % 2 == (sub[1] + sub[2]) % 2 == ... == (sub[x - 2] + sub[x
 * - 1]) % 2. Return the length of the longest valid subsequence of nums.
 * 
 * A subsequence is an array that can be derived from another array by deleting
 * some or no elements without changing the order of the remaining elements.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,3,4]
 * 
 * Output: 4
 * 
 * Explanation:
 * 
 * The longest valid subsequence is [1, 2, 3, 4].
 * 
 * Example 2:
 * 
 * Input: nums = [1,2,1,1,2,1,2]
 * 
 * Output: 6
 * 
 * Explanation:
 * 
 * The longest valid subsequence is [1, 2, 1, 2, 1, 2].
 * 
 * Example 3:
 * 
 * Input: nums = [1,3]
 * 
 * Output: 2
 * 
 * Explanation:
 * 
 * The longest valid subsequence is [1, 3].
 * 
 * 
 * 
 * Constraints:
 * 
 * 2 <= nums.length <= 2 * 105 1 <= nums[i] <= 107
 */