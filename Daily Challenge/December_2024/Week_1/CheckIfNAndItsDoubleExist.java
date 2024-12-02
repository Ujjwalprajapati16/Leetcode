
import java.util.HashSet;

public class CheckIfNAndItsDoubleExist {

    public boolean checkIfExist(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int element : arr) {
            if (set.contains(element * 2) || ((element % 2 == 0) && (set.contains(element / 2)))) {
                return true;
            }
            set.add(element);
        }
        return false;
    }

    public static void main(String[] args) {
        CheckIfNAndItsDoubleExist solution = new CheckIfNAndItsDoubleExist();
        int[] arr = {10, 2, 5, 3};
        boolean result = solution.checkIfExist(arr);
        System.out.println(result);
        int[] arr1 = {3, 1, 7, 11};
        boolean result1 = solution.checkIfExist(arr1);
        System.out.println(result1);

    }
}

/*
 * 
 * 1346. Check If N and Its Double Exist
Solved
Easy
Topics
Companies
Hint
Given an array arr of integers, check if there exist two indices i and j such that :

i != j
0 <= i, j < arr.length
arr[i] == 2 * arr[j]
 

Example 1:

Input: arr = [10,2,5,3]
Output: true
Explanation: For i = 0 and j = 2, arr[i] == 10 == 2 * 5 == 2 * arr[j]
Example 2:

Input: arr = [3,1,7,11]
Output: false
Explanation: There is no i and j that satisfy the conditions.
 

Constraints:

2 <= arr.length <= 500
-103 <= arr[i] <= 103
 */
