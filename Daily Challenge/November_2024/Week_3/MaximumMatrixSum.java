
public class MaximumMatrixSum {

    public long maxMatrixSum(int[][] matrix) {
        int minPos = Integer.MAX_VALUE;
        int maxNeg = Integer.MIN_VALUE;
        int negatives = 0;
        long sum = 0;

        for (int[] matrix1 : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix1[j] < 0) {
                    negatives += 1;
                    sum -= (matrix1[j]);
                    maxNeg = Math.max(maxNeg, matrix1[j]);
                } else {
                    sum += matrix1[j];
                    minPos = Math.min(minPos, matrix1[j]);
                }
            }
        }

        if ((negatives & 1) == 0) {
            return sum;
        }
        return sum - 2 * Math.min(-maxNeg, minPos);
    }
}

/*
1975. Maximum Matrix Sum
Solved
Medium
Topics
Companies
Hint
You are given an n x n integer matrix. You can do the following operation any number of times:

Choose any two adjacent elements of matrix and multiply each of them by -1.
Two elements are considered adjacent if and only if they share a border.

Your goal is to maximize the summation of the matrix's elements. Return the maximum sum of the matrix's elements using the operation mentioned above.

 

Example 1:


Input: matrix = [[1,-1],[-1,1]]
Output: 4
Explanation: We can follow the following steps to reach sum equals 4:
- Multiply the 2 elements in the first row by -1.
- Multiply the 2 elements in the first column by -1.
Example 2:


Input: matrix = [[1,2,3],[-1,-2,-3],[1,2,3]]
Output: 16
Explanation: We can follow the following step to reach sum equals 16:
- Multiply the 2 last elements in the second row by -1.
 

Constraints:

n == matrix.length == matrix[i].length
2 <= n <= 250
-105 <= matrix[i][j] <= 105
 */
