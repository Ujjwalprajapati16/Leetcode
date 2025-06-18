public class Divide_Array_Into_Arrays_With_Max_Difference {
    public int[][] divideArray(int[] nums, int k) {
        int n = nums.length;
        int max = 0;

        for (int i = 0; i < n; i++) {
            max = Math.max(nums[i], max);
        }

        int counts[] = new int[max + 1];
        for (int i = 0; i < n; i++) {
            counts[nums[i]]++;
        }

        int[][] arr = new int[n / 3][3];
        int idx = 0;
        int x = 0;

        for (int i = 0; i <= max; i++) {
            while (counts[i] > 0) {
                arr[idx][x] = i;
                x++;

                if (x == 3) {
                    if (arr[idx][2] - arr[idx][0] > k) {
                        return new int[][] {};
                    }
                    x = 0;
                    idx++;
                }

                counts[i]--;
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        Divide_Array_Into_Arrays_With_Max_Difference solution = new Divide_Array_Into_Arrays_With_Max_Difference();
        int[] nums1 = { 1, 3, 4, 8, 7, 9, 3, 5, 1 };
        int k1 = 2;
        int[][] result1 = solution.divideArray(nums1, k1);
        for (int[] arr : result1) {
            System.out.println(java.util.Arrays.toString(arr));
        }

        int[] nums2 = { 2, 4, 2, 2, 5, 2 };
        int k2 = 2;
        int[][] result2 = solution.divideArray(nums2, k2);
        System.out.println(java.util.Arrays.deepToString(result2)); // Should print an empty array
    }
}

/*
 * 2966. Divide Array Into Arrays With Max Difference Solved Medium Topics
 * premium lock icon Companies Hint You are given an integer array nums of size
 * n where n is a multiple of 3 and a positive integer k.
 * 
 * Divide the array nums into n / 3 arrays of size 3 satisfying the following
 * condition:
 * 
 * The difference between any two elements in one array is less than or equal to
 * k. Return a 2D array containing the arrays. If it is impossible to satisfy
 * the conditions, return an empty array. And if there are multiple answers,
 * return any of them.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,3,4,8,7,9,3,5,1], k = 2
 * 
 * Output: [[1,1,3],[3,4,5],[7,8,9]]
 * 
 * Explanation:
 * 
 * The difference between any two elements in each array is less than or equal
 * to 2.
 * 
 * Example 2:
 * 
 * Input: nums = [2,4,2,2,5,2], k = 2
 * 
 * Output: []
 * 
 * Explanation:
 * 
 * Different ways to divide nums into 2 arrays of size 3 are:
 * 
 * [[2,2,2],[2,4,5]] (and its permutations) [[2,2,4],[2,2,5]] (and its
 * permutations) Because there are four 2s there will be an array with the
 * elements 2 and 5 no matter how we divide it. since 5 - 2 = 3 > k, the
 * condition is not satisfied and so there is no valid division.
 * 
 * Example 3:
 * 
 * Input: nums = [4,2,9,8,2,12,7,12,10,5,8,5,5,7,9,2,5,11], k = 14
 * 
 * Output: [[2,2,12],[4,8,5],[5,9,7],[7,8,5],[5,9,10],[11,12,2]]
 * 
 * Explanation:
 * 
 * The difference between any two elements in each array is less than or equal
 * to 14.
 * 
 * 
 * 
 * Constraints:
 * 
 * n == nums.length 1 <= n <= 105 n is a multiple of 3 1 <= nums[i] <= 105 1 <=
 * k <= 105
 */