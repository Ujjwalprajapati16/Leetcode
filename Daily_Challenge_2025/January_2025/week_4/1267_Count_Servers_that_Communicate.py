from typing import List


class Solution:
    def countServers(self, grid: List[List[int]]) -> int:
        res = 0
        ROWS, COLS = len(grid), len(grid[0])

        # Rows
        for r in range(ROWS):
            row_sum = sum(grid[r])
            if row_sum <= 1:
                continue  # don't mark
            res += row_sum

            for c in range(COLS):
                if grid[r][c]:
                    grid[r][c] = -1  # mark

        # COLS
        for c in range(COLS):
            col_sum = 0
            unmarked = 0
            for r in range(ROWS):
                col_sum += abs(grid[r][c])
                if grid[r][c] > 0:
                    unmarked += 1
                elif grid[r][c] < 0:
                    grid[r][c] = 1  # unmark

            if col_sum >= 2:
                res += unmarked

        return res

sol = Solution()
print(sol.countServers([[1,0],[0,1]])) # 0
print(sol.countServers([[1,0],[1,1]])) # 3
print(sol.countServers([[1,1,0,0],[0,0,1,0],[0,0,1,0],[0,0,0,1]])) # 4

'''
1267. Count Servers that Communicate
Solved
Medium
Topics
Companies
Hint
You are given a map of a server center, represented as a m * n integer matrix grid, where 1 means that on that cell there is a server and 0 means that it is no server. Two servers are said to communicate if they are on the same row or on the same column.

Return the number of servers that communicate with any other server.

 

Example 1:



Input: grid = [[1,0],[0,1]]
Output: 0
Explanation: No servers can communicate with others.
Example 2:



Input: grid = [[1,0],[1,1]]
Output: 3
Explanation: All three servers can communicate with at least one other server.
Example 3:



Input: grid = [[1,1,0,0],[0,0,1,0],[0,0,1,0],[0,0,0,1]]
Output: 4
Explanation: The two servers in the first row can communicate with each other. The two servers in the third column can communicate with each other. The server at right bottom corner can't communicate with any other server.
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m <= 250
1 <= n <= 250
grid[i][j] == 0 or 1
'''