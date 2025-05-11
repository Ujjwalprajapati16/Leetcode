public class Three_Consecutive_Odds {
    public boolean threeConsecutiveOdds(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                count = 0;
            } else {
                count++;
            }
            if (count == 3) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Three_Consecutive_Odds obj = new Three_Consecutive_Odds();
        int[] arr = { 1, 2, 34, 3, 4, 5, 7, 23, 12 };
        System.out.println(obj.threeConsecutiveOdds(arr)); // true

        int[] arr1 = { 2, 6, 4, 1 };
        System.out.println(obj.threeConsecutiveOdds(arr1)); // false
    }
}

/*
 * 1550. Three Consecutive Odds Solved Easy Topics Companies Hint Given an
 * integer array arr, return true if there are three consecutive odd numbers in
 * the array. Otherwise, return false.
 * 
 * 
 * Example 1:
 * 
 * Input: arr = [2,6,4,1] Output: false Explanation: There are no three
 * consecutive odds. Example 2:
 * 
 * Input: arr = [1,2,34,3,4,5,7,23,12] Output: true Explanation: [5,7,23] are
 * three consecutive odds.
 * 
 * 
 * Constraints:
 * 
 * 1 <= arr.length <= 1000 1 <= arr[i] <= 1000
 */