public class Maximum_Number_of_Fish_in_a_Grid {
    int rows;
    int cols;

    public int findMaxFish(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        int maxFishes = 0;

        // find max of all components
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] != 0) {
                    maxFishes = Math.max(maxFishes, dfs(i, j, grid));
                }
            }
        }

        return maxFishes;
    }

    public int dfs(int r, int c, int grid[][]) {
        // base case
        // out of matrix/ land cell -> 0 / visited -> 0
        if (r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c] == 0) {
            return 0;
        }

        int ans = grid[r][c];
        grid[r][c] = 0;
        ans += dfs(r - 1, c, grid) + dfs(r, c + 1, grid) + dfs(r + 1, c, grid) + dfs(r, c - 1, grid);
        return ans;
    }

    public static void main(String[] args) {
        Maximum_Number_of_Fish_in_a_Grid obj = new Maximum_Number_of_Fish_in_a_Grid();
        int grid[][] = { { 0, 2, 1, 0 }, { 4, 0, 0, 3 }, { 1, 0, 0, 4 }, { 0, 3, 2, 0 } };
        System.out.println(obj.findMaxFish(grid));

        grid = new int[][] { { 1, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 1 } };
        System.out.println(obj.findMaxFish(grid));
    }
}

/*
 * 2658. Maximum Number of Fish in a Grid Solved Medium Topics Companies Hint
 * You are given a 0-indexed 2D matrix grid of size m x n, where (r, c)
 * represents:
 * 
 * A land cell if grid[r][c] = 0, or A water cell containing grid[r][c] fish, if
 * grid[r][c] > 0. A fisher can start at any water cell (r, c) and can do the
 * following operations any number of times:
 * 
 * Catch all the fish at cell (r, c), or Move to any adjacent water cell. Return
 * the maximum number of fish the fisher can catch if he chooses his starting
 * cell optimally, or 0 if no water cell exists.
 * 
 * An adjacent cell of the cell (r, c), is one of the cells (r, c + 1), (r, c -
 * 1), (r + 1, c) or (r - 1, c) if it exists.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: grid = [[0,2,1,0],[4,0,0,3],[1,0,0,4],[0,3,2,0]] Output: 7
 * Explanation: The fisher can start at cell (1,3) and collect 3 fish, then move
 * to cell (2,3) and collect 4 fish. Example 2:
 * 
 * 
 * Input: grid = [[1,0,0,0],[0,0,0,0],[0,0,0,0],[0,0,0,1]] Output: 1
 * Explanation: The fisher can start at cells (0,0) or (3,3) and collect a
 * single fish.
 * 
 * 
 * Constraints:
 * 
 * m == grid.length n == grid[i].length 1 <= m, n <= 10 0 <= grid[i][j] <= 10
 */