public class Max_Sum_of_a_Pair_With_Equal_Sum_of_Digits {
    public int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += (num % 10);
            num /= 10;
        }
        return sum;
    }

    public int maximumSum(int[] nums) {
        int map[] = new int[82];
        int ans = -1;

        for (int num : nums) {
            int digitSum = getDigitSum(num);
            if (map[digitSum] > 0) {
                int prevNum = map[digitSum];
                ans = Math.max(prevNum + num, ans);
                map[digitSum] = Math.max(prevNum, num);
            } else {
                map[digitSum] = num;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Max_Sum_of_a_Pair_With_Equal_Sum_of_Digits obj = new Max_Sum_of_a_Pair_With_Equal_Sum_of_Digits();
        int[] nums = { 18, 43, 36, 13, 7 };
        System.out.println(obj.maximumSum(nums)); // Output: 54

        int[] nums1 = { 10, 12, 19, 14 };
        System.out.println(obj.maximumSum(nums1)); // Output: -1
    }
}

/*
 * 2342. Max Sum of a Pair With Equal Sum of Digits Solved Medium Topics
 * Companies Hint You are given a 0-indexed array nums consisting of positive
 * integers. You can choose two indices i and j, such that i != j, and the sum
 * of digits of the number nums[i] is equal to that of nums[j].
 * 
 * Return the maximum value of nums[i] + nums[j] that you can obtain over all
 * possible indices i and j that satisfy the conditions.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [18,43,36,13,7] Output: 54 Explanation: The pairs (i, j) that
 * satisfy the conditions are: - (0, 2), both numbers have a sum of digits equal
 * to 9, and their sum is 18 + 36 = 54. - (1, 4), both numbers have a sum of
 * digits equal to 7, and their sum is 43 + 7 = 50. So the maximum sum that we
 * can obtain is 54. Example 2:
 * 
 * Input: nums = [10,12,19,14] Output: -1 Explanation: There are no two numbers
 * that satisfy the conditions, so we return -1.
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 105 1 <= nums[i] <= 109
 */