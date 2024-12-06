public class Maximum_Number_of_Integers_to_Choose_From_a_Range_I {
    public int maxCount(int[] banned, int n, int maxSum) {
        boolean set[] = new boolean[10001];
        for(int ban : banned){
            set[ban] = true;
        }
        int sum = 0;
        int count = 0;
        for(int i=1; i<=n; i++){
            if(set[i] == true){
                continue;
            }
            sum += i;
            if(sum > maxSum){
                break;
            }
            count++;
        }
        return count;
    }
    public static void main(String[] args) {
        Maximum_Number_of_Integers_to_Choose_From_a_Range_I solution = new Maximum_Number_of_Integers_to_Choose_From_a_Range_I();
        int[] banned = {1,6,5};
        int n = 5;
        int maxSum = 6;
        int result = solution.maxCount(banned, n, maxSum);
        System.out.println(result);

        int[] banned1 = {1,2,3,4,5,6,7};
        int n1 = 8;
        int maxSum1 = 1;
        int result1 = solution.maxCount(banned1, n1, maxSum1);
        System.out.println(result1);

        int[] banned2 = {11};
        int n2 = 7;
        int maxSum2 = 50;
        int result2 = solution.maxCount(banned2, n2, maxSum2);
        System.out.println(result2);
    }
}

/*
2554. Maximum Number of Integers to Choose From a Range I
Solved
Medium
Topics
Companies
Hint
You are given an integer array banned and two integers n and maxSum. You are choosing some number of integers following the below rules:

The chosen integers have to be in the range [1, n].
Each integer can be chosen at most once.
The chosen integers should not be in the array banned.
The sum of the chosen integers should not exceed maxSum.
Return the maximum number of integers you can choose following the mentioned rules.

 

Example 1:

Input: banned = [1,6,5], n = 5, maxSum = 6
Output: 2
Explanation: You can choose the integers 2 and 4.
2 and 4 are from the range [1, 5], both did not appear in banned, and their sum is 6, which did not exceed maxSum.
Example 2:

Input: banned = [1,2,3,4,5,6,7], n = 8, maxSum = 1
Output: 0
Explanation: You cannot choose any integer while following the mentioned conditions.
Example 3:

Input: banned = [11], n = 7, maxSum = 50
Output: 7
Explanation: You can choose the integers 1, 2, 3, 4, 5, 6, and 7.
They are from the range [1, 7], all did not appear in banned, and their sum is 28, which did not exceed maxSum.
 

Constraints:

1 <= banned.length <= 104
1 <= banned[i], n <= 104
1 <= maxSum <= 109
 */