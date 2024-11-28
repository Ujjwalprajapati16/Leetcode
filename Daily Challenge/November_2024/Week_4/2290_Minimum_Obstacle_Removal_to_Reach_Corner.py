from collections import deque
from typing import List

class Solution:
    def minimumObstacles(self, grid: List[List[int]]) -> int:
        ROWS, COLS = len(grid), len(grid[0])

        # BFS queue: stores (obstacle_count, row, col)
        q = deque([(0, 0, 0)])
        # A set to track visited coordinates
        visit = set([(0, 0)])

        # Directions for moving up, down, left, right
        directions = [(1, 0), (-1, 0), (0, 1), (0, -1)]

        while q:
            obstacles, r, c = q.popleft()

            # If we reached the bottom-right corner, return the number of obstacles
            if (r, c) == (ROWS - 1, COLS - 1):
                return obstacles

            # Explore neighbors
            for dr, dc in directions:
                nr, nc = r + dr, c + dc

                # Check if the new position is within bounds
                if 0 <= nr < ROWS and 0 <= nc < COLS and (nr, nc) not in visit:
                    # If it's an obstacle, increment obstacle count, otherwise stay the same
                    if grid[nr][nc] == 1:
                        q.append((obstacles + 1, nr, nc))
                    else:
                        q.appendleft((obstacles, nr, nc))
                    
                    # Mark the position as visited
                    visit.add((nr, nc))

        # In case no path exists, though there should always be one
        return -1
    
print(Solution().minimumObstacles([[0,1,1],[1,1,0],[1,1,0]]))
print(Solution().minimumObstacles([[0,1,0,0,0],[0,1,0,1,0],[0,0,0,1,0]]))

'''
2290. Minimum Obstacle Removal to Reach Corner
Solved
Hard
Topics
Companies
Hint
You are given a 0-indexed 2D integer array grid of size m x n. Each cell has one of two values:

0 represents an empty cell,
1 represents an obstacle that may be removed.
You can move up, down, left, or right from and to an empty cell.

Return the minimum number of obstacles to remove so you can move from the upper left corner (0, 0) to the lower right corner (m - 1, n - 1).

 

Example 1:


Input: grid = [[0,1,1],[1,1,0],[1,1,0]]
Output: 2
Explanation: We can remove the obstacles at (0, 1) and (0, 2) to create a path from (0, 0) to (2, 2).
It can be shown that we need to remove at least 2 obstacles, so we return 2.
Note that there may be other ways to remove 2 obstacles to create a path.
Example 2:


Input: grid = [[0,1,0,0,0],[0,1,0,1,0],[0,0,0,1,0]]
Output: 0
Explanation: We can move from (0, 0) to (2, 4) without removing any obstacles, so we return 0.
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 105
2 <= m * n <= 105
grid[i][j] is either 0 or 1.
grid[0][0] == grid[m - 1][n - 1] == 0
'''