public class Find_Numbers_with_Even_Number_of_Digits {
    public int findNumbers(int[] nums) {
        int ans = 0;
        for (int i : nums) {
            if ((i > 9 && i < 100) || (i > 999 && i < 10000) || i == 100000) {
                ans += 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Find_Numbers_with_Even_Number_of_Digits obj = new Find_Numbers_with_Even_Number_of_Digits();
        int nums[] = { 12, 345, 2, 6, 7896 };
        int ans = obj.findNumbers(nums);
        System.out.println(ans);

        int nums2[] = { 555, 901, 482, 1771 };
        ans = obj.findNumbers(nums2);
        System.out.println(ans);
    }
}

/*
 * 1295. Find Numbers with Even Number of Digits Solved Easy Topics Companies
 * Hint Given an array nums of integers, return how many of them contain an even
 * number of digits.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [12,345,2,6,7896] Output: 2 Explanation: 12 contains 2 digits
 * (even number of digits). 345 contains 3 digits (odd number of digits). 2
 * contains 1 digit (odd number of digits). 6 contains 1 digit (odd number of
 * digits). 7896 contains 4 digits (even number of digits). Therefore only 12
 * and 7896 contain an even number of digits. Example 2:
 * 
 * Input: nums = [555,901,482,1771] Output: 1 Explanation: Only 1771 contains an
 * even number of digits.
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 500 1 <= nums[i] <= 105
 */