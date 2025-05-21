public class Set_Matrix_Zeroes {
    public void setZeroes(int[][] matrix) {
        boolean firstRow = false;
        boolean firstCol = false;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) {
                        firstRow = true;
                    }
                    if (j == 0) {
                        firstCol = true;
                    }
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (firstRow) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }

        if (firstCol) {
            for (int[] matrix1 : matrix) {
                matrix1[0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Set_Matrix_Zeroes obj = new Set_Matrix_Zeroes();
        int[][] matrix = { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };
        obj.setZeroes(matrix);

        for (int[] matrix1 : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix1[j] + " ");
            }
            System.out.println();
        }
        System.out.println("-----------------");

        int[][] matrix2 = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
        obj.setZeroes(matrix2);

        for (int[] matrix21 : matrix2) {
            for (int j = 0; j < matrix2[0].length; j++) {
                System.out.print(matrix21[j] + " ");
            }
            System.out.println();
        }
    }
}

/*
 * 73. Set Matrix Zeroes
 * Solved
 * Medium
 * Topics
 * Companies
 * Hint
 * Given an m x n integer matrix matrix, if an element is 0, set its entire row
 * and column to 0's.
 * 
 * You must do it in place.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * Output: [[1,0,1],[0,0,0],[1,0,1]]
 * Example 2:
 * 
 * 
 * Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 * Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 * 
 * 
 * Constraints:
 * 
 * m == matrix.length
 * n == matrix[0].length
 * 1 <= m, n <= 200
 * -231 <= matrix[i][j] <= 231 - 1
 * 
 * 
 * Follow up:
 * 
 * A straightforward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best solution.
 * Could you devise a constant space solution?
 */