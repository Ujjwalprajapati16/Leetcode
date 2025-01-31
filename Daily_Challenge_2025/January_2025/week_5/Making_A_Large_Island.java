import java.util.*;

public class Making_A_Large_Island {
    int[][] grid;
    int id = -1;
    Map<Integer, Integer> map = new HashMap<>();
    int m, n;
    final int[][] DIRECTIONS = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public int largestIsland(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 1) {
                    int size = dfs(row, col);
                    map.put(id, size);
                    id--;
                }
            }
        }

        int maxIsland = 0;
        for (int ids : map.keySet()) {
            maxIsland = Math.max(map.get(ids), maxIsland);
        }

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 0) {
                    int curMaxIsland = calculateMaxIsland(row, col);
                    maxIsland = Math.max(maxIsland, curMaxIsland);
                }
            }
        }

        return maxIsland;
    }

    private int dfs(int row, int col) {
        // Base case
        if (row < 0 || row == m || col < 0 || col == n) {
            return 0;
        }

        if (grid[row][col] != 1) {
            return 0;
        }

        grid[row][col] = id;

        // dfs all 4 directions
        int down = dfs(row + 1, col);
        int top = dfs(row - 1, col);
        int right = dfs(row, col + 1);
        int left = dfs(row, col - 1);

        return down + top + right + left + 1;
    }

    private int calculateMaxIsland(int row, int col) {
        Set<Integer> set = new HashSet<>();
        for (int[] directions : DIRECTIONS) {
            int curRow = directions[0] + row;
            int curCol = directions[1] + col;

            if (curCol < 0 || curRow == m || curRow < 0 || curCol == n) {
                continue;
            }

            if (grid[curRow][curCol] == 0) {
                continue;
            }

            int curId = grid[curRow][curCol];
            set.add(curId);
        }

        int sum = 0;
        for (Integer curId : set) {
            sum += map.get(curId);
        }

        return sum + 1;
    }

    public static void main(String[] args) {
        Making_A_Large_Island solution = new Making_A_Large_Island();
        int[][] grid = { { 1, 0 }, { 0, 1 } };
        System.out.println(solution.largestIsland(grid));

        grid = new int[][] { { 1, 1 }, { 1, 0 } };
        System.out.println(solution.largestIsland(grid));

        grid = new int[][] { { 1, 1 }, { 1, 1 } };
        System.out.println(solution.largestIsland(grid));
    }

}

/*
 * 827. Making A Large Island
 * Solved
 * Hard
 * Topics
 * Companies
 * You are given an n x n binary matrix grid. You are allowed to change at most
 * one 0 to be 1.
 * 
 * Return the size of the largest island in grid after applying this operation.
 * 
 * An island is a 4-directionally connected group of 1s.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: grid = [[1,0],[0,1]]
 * Output: 3
 * Explanation: Change one 0 to 1 and connect two 1s, then we get an island with
 * area = 3.
 * Example 2:
 * 
 * Input: grid = [[1,1],[1,0]]
 * Output: 4
 * Explanation: Change the 0 to 1 and make the island bigger, only one island
 * with area = 4.
 * Example 3:
 * 
 * Input: grid = [[1,1],[1,1]]
 * Output: 4
 * Explanation: Can't change any 0 to 1, only one island with area = 4.
 * 
 * 
 * Constraints:
 * 
 * n == grid.length
 * n == grid[i].length
 * 1 <= n <= 500
 * grid[i][j] is either 0 or 1.
 */
