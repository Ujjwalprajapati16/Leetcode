public class Sort_Colors {
    public void swap(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void sortColors(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int index = 0;

        while (index <= end) {
            switch (nums[index]) {
                case 0 -> {
                    swap(nums, index, start);
                    index++;
                    start++;
                }
                case 2 -> {
                    swap(nums, index, end);
                    end--;
                }
                default -> index++;
            }
        }
    }

    public static void main(String[] args) {
        Sort_Colors obj = new Sort_Colors();
        int[] nums = { 2, 0, 2, 1, 1, 0 };
        obj.sortColors(nums);

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}

/*
 * 75. Sort Colors Solved Medium Topics Companies Hint Given an array nums with
 * n objects colored red, white, or blue, sort them in-place so that objects of
 * the same color are adjacent, with the colors in the order red, white, and
 * blue.
 * 
 * We will use the integers 0, 1, and 2 to represent the color red, white, and
 * blue, respectively.
 * 
 * You must solve this problem without using the library's sort function.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [2,0,2,1,1,0] Output: [0,0,1,1,2,2] Example 2:
 * 
 * Input: nums = [2,0,1] Output: [0,1,2]
 * 
 * 
 * Constraints:
 * 
 * n == nums.length 1 <= n <= 300 nums[i] is either 0, 1, or 2.
 * 
 * 
 * Follow up: Could you come up with a one-pass algorithm using only constant
 * extra space?
 */