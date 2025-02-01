public class Special_Array_I {
    public boolean isArraySpecial(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if ((nums[i] % 2) == (nums[i + 1] % 2)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Special_Array_I obj = new Special_Array_I();
        int[] nums = { 4, 3, 1, 6 };
        System.out.println(obj.isArraySpecial(nums));

        nums = new int[] { 2, 1, 4 };
        System.out.println(obj.isArraySpecial(nums));

        nums = new int[] { 1 };
        System.out.println(obj.isArraySpecial(nums));
    }
}

/*
 * 3151. Special Array I Solved Easy Topics Companies Hint An array is
 * considered special if every pair of its adjacent elements contains two
 * numbers with different parity.
 * 
 * You are given an array of integers nums. Return true if nums is a special
 * array, otherwise, return false.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1]
 * 
 * Output: true
 * 
 * Explanation:
 * 
 * There is only one element. So the answer is true.
 * 
 * Example 2:
 * 
 * Input: nums = [2,1,4]
 * 
 * Output: true
 * 
 * Explanation:
 * 
 * There is only two pairs: (2,1) and (1,4), and both of them contain numbers
 * with different parity. So the answer is true.
 * 
 * Example 3:
 * 
 * Input: nums = [4,3,1,6]
 * 
 * Output: false
 * 
 * Explanation:
 * 
 * nums[1] and nums[2] are both odd. So the answer is false.
 * 
 */