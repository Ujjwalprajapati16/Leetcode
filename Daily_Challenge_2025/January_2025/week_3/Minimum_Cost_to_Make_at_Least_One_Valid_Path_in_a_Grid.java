import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Minimum_Cost_to_Make_at_Least_One_Valid_Path_in_a_Grid {
    int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int minCost(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int[][] minCost = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            Arrays.fill(minCost[row], Integer.MAX_VALUE);
        }

        Deque<int[]> deque = new ArrayDeque<>();
        deque.offer(new int[] { 0, 0 });
        minCost[0][0] = 0;

        while (!deque.isEmpty()) {
            int[] curr = deque.poll();
            int row = curr[0], col = curr[1];

            for (int dir = 0; dir < 4; dir++) {
                int nextRow = row + dirs[dir][0];
                int nextCol = col + dirs[dir][1];

                if (nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols) {
                    int cost = minCost[row][col];
                    int nextCellCost = (dir + 1 == grid[row][col]) ? 0 : 1;
                    int newCost = cost + nextCellCost;

                    if (newCost < minCost[nextRow][nextCol]) {
                        minCost[nextRow][nextCol] = newCost;
                        if (nextCellCost == 0) {
                            deque.offerFirst(new int[] { nextRow, nextCol });
                        } else {
                            deque.offerLast(new int[] { nextRow, nextCol });
                        }
                    }
                }
            }
        }

        return minCost[rows - 1][cols - 1];
    }

    public static void main(String[] args) {
        Minimum_Cost_to_Make_at_Least_One_Valid_Path_in_a_Grid solution = new Minimum_Cost_to_Make_at_Least_One_Valid_Path_in_a_Grid();
        int[][] grid = { { 1, 1, 1, 1 }, { 2, 2, 2, 2 }, { 1, 1, 1, 1 }, { 2, 2, 2, 2 } };
        int result = solution.minCost(grid);
        System.out.println(result);

        int[][] grid1 = { { 1, 2 }, { 3, 4 } };
        int result1 = solution.minCost(grid1);
        System.out.println(result1);

        int[][] grid2 = { { 1, 1, 3 }, { 3, 2, 2 }, { 1, 1, 4 } };
        int result2 = solution.minCost(grid2);
        System.out.println(result2);
    }
}

/*
 * 1368. Minimum Cost to Make at Least One Valid Path in a Grid Solved Hard
 * Topics Companies Hint Given an m x n grid. Each cell of the grid has a sign
 * pointing to the next cell you should visit if you are currently in this cell.
 * The sign of grid[i][j] can be:
 * 
 * 1 which means go to the cell to the right. (i.e go from grid[i][j] to
 * grid[i][j + 1]) 2 which means go to the cell to the left. (i.e go from
 * grid[i][j] to grid[i][j - 1]) 3 which means go to the lower cell. (i.e go
 * from grid[i][j] to grid[i + 1][j]) 4 which means go to the upper cell. (i.e
 * go from grid[i][j] to grid[i - 1][j]) Notice that there could be some signs
 * on the cells of the grid that point outside the grid.
 * 
 * You will initially start at the upper left cell (0, 0). A valid path in the
 * grid is a path that starts from the upper left cell (0, 0) and ends at the
 * bottom-right cell (m - 1, n - 1) following the signs on the grid. The valid
 * path does not have to be the shortest.
 * 
 * You can modify the sign on a cell with cost = 1. You can modify the sign on a
 * cell one time only.
 * 
 * Return the minimum cost to make the grid have at least one valid path.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: grid = [[1,1,1,1],[2,2,2,2],[1,1,1,1],[2,2,2,2]] Output: 3
 * Explanation: You will start at point (0, 0). The path to (3, 3) is as
 * follows. (0, 0) --> (0, 1) --> (0, 2) --> (0, 3) change the arrow to down
 * with cost = 1 --> (1, 3) --> (1, 2) --> (1, 1) --> (1, 0) change the arrow to
 * down with cost = 1 --> (2, 0) --> (2, 1) --> (2, 2) --> (2, 3) change the
 * arrow to down with cost = 1 --> (3, 3) The total cost = 3. Example 2:
 * 
 * 
 * Input: grid = [[1,1,3],[3,2,2],[1,1,4]] Output: 0 Explanation: You can follow
 * the path from (0, 0) to (2, 2). Example 3:
 * 
 * 
 * Input: grid = [[1,2],[4,3]] Output: 1
 * 
 * 
 * Constraints:
 * 
 * m == grid.length n == grid[i].length 1 <= m, n <= 100 1 <= grid[i][j] <= 4
 */