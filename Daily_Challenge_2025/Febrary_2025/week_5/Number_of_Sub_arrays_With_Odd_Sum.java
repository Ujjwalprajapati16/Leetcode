public class Number_of_Sub_arrays_With_Odd_Sum {
    public int numOfSubarrays(int[] arr) {
        int Mod = 1000000007;
        int evenC = 1;
        int oddC = 0;
        int prefix = 0;
        int res = 0;

        for (int num : arr) {
            prefix += num;
            if (prefix % 2 == 0) {
                res += oddC;
                evenC++;
            } else {
                res += evenC;
                oddC++;
            }
            res = res % Mod;
        }

        return res;
    }

    public static void main(String[] args) {
        Number_of_Sub_arrays_With_Odd_Sum obj = new Number_of_Sub_arrays_With_Odd_Sum();
        int arr[] = { 1, 3, 5 };
        System.out.println(obj.numOfSubarrays(arr)); // Output: 4

        int arr2[] = { 2, 4, 6 };
        System.out.println(obj.numOfSubarrays(arr2)); // Output: 0

        int arr3[] = { 1, 2, 3, 4, 5, 6, 7 };
        System.out.println(obj.numOfSubarrays(arr3)); // Output: 16
    }
}

/*
 * 1524. Number of Sub-arrays With Odd Sum Solved Medium Topics Companies Hint
 * Given an array of integers arr, return the number of subarrays with an odd
 * sum.
 * 
 * Since the answer can be very large, return it modulo 109 + 7.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: arr = [1,3,5] Output: 4 Explanation: All subarrays are
 * [[1],[1,3],[1,3,5],[3],[3,5],[5]] All sub-arrays sum are [1,4,9,3,8,5]. Odd
 * sums are [1,9,3,5] so the answer is 4. Example 2:
 * 
 * Input: arr = [2,4,6] Output: 0 Explanation: All subarrays are
 * [[2],[2,4],[2,4,6],[4],[4,6],[6]] All sub-arrays sum are [2,6,12,4,10,6]. All
 * sub-arrays have even sum and the answer is 0. Example 3:
 * 
 * Input: arr = [1,2,3,4,5,6,7] Output: 16
 * 
 * 
 * Constraints:
 * 
 * 1 <= arr.length <= 105 1 <= arr[i] <= 100
 */