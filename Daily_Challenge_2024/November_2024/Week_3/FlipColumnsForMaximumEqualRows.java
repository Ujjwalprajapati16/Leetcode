import java.util.HashMap;
import java.util.Map;

public class FlipColumnsForMaximumEqualRows {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String, Integer> map = new HashMap<>();
        for (int[] row : matrix) {
            StringBuilder values = new StringBuilder();
            StringBuilder flipped = new StringBuilder();

            for (int r : row) {
                values.append(r);
                flipped.append(1 - r);
            }

            String vs = values.toString();
            String fs = flipped.toString();

            map.put(vs, map.getOrDefault(vs, 0) + 1);
            map.put(fs, map.getOrDefault(fs, 0) + 1);
        }

        int ans = 0;
        for (int v : map.values()) {
            ans = Math.max(ans, v);
        }
        return ans;
    }
}

/* 
1072. Flip Columns For Maximum Number of Equal Rows
Solved
Medium
Topics
Companies
Hint
You are given an m x n binary matrix matrix.

You can choose any number of columns in the matrix and flip every cell in that column (i.e., Change the value of the cell from 0 to 1 or vice versa).

Return the maximum number of rows that have all values equal after some number of flips.

 

Example 1:

Input: matrix = [[0,1],[1,1]]
Output: 1
Explanation: After flipping no values, 1 row has all values equal.
Example 2:

Input: matrix = [[0,1],[1,0]]
Output: 2
Explanation: After flipping values in the first column, both rows have equal values.
Example 3:

Input: matrix = [[0,0,0],[0,0,1],[1,1,0]]
Output: 2
Explanation: After flipping values in the first two columns, the last two rows have equal values.
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 300
matrix[i][j] is either 0 or 1.
*/
