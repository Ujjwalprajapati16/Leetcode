public class Check_if_Array_Is_Sorted_and_Rotated {
    public boolean check(int[] nums) {
        int count = 0;
        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                count++;
            }
        }

        if (nums[n - 1] > nums[0]) {
            count++;
        }

        return count <= 1;
    }

    public static void main(String[] args) {
        Check_if_Array_Is_Sorted_and_Rotated obj = new Check_if_Array_Is_Sorted_and_Rotated();
        int[] nums = { 3, 4, 5, 1, 2 };
        System.out.println(obj.check(nums));

        int[] nums1 = { 2, 1, 3, 4 };
        System.out.println(obj.check(nums1));

        int[] nums2 = { 1, 2, 3 };
        System.out.println(obj.check(nums2));

        int[] nums3 = { 1, 1, 1 };
        System.out.println(obj.check(nums3));
    }
}

/*
 * 1752. Check if Array Is Sorted and Rotated Solved Easy Topics Companies Hint
 * Given an array nums, return true if the array was originally sorted in
 * non-decreasing order, then rotated some number of positions (including zero).
 * Otherwise, return false.
 * 
 * There may be duplicates in the original array.
 * 
 * Note: An array A rotated by x positions results in an array B of the same
 * length such that A[i] == B[(i+x) % A.length], where % is the modulo
 * operation.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [3,4,5,1,2] Output: true Explanation: [1,2,3,4,5] is the
 * original sorted array. You can rotate the array by x = 3 positions to begin
 * on the the element of value 3: [3,4,5,1,2]. Example 2:
 * 
 * Input: nums = [2,1,3,4] Output: false Explanation: There is no sorted array
 * once rotated that can make nums. Example 3:
 * 
 * Input: nums = [1,2,3] Output: true Explanation: [1,2,3] is the original
 * sorted array. You can rotate the array by x = 0 positions (i.e. no rotation)
 * to make nums.
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 100 1 <= nums[i] <= 100
 */
