from typing import List

class Solution:
    def countUnguarded(self, m: int, n: int, guards: List[List[int]], walls: List[List[int]]) -> int:
        mat = [[0] * n for _ in range(m)]

        for (r, c) in guards:
            mat[r][c] = 1
        for (r, c) in walls:
            mat[r][c] = 2

        for r in range(m):
            guard = False
            for c in range(n):
                if mat[r][c] == 1:
                    guard = True
                elif mat[r][c] == 2:
                    guard = False
                if not mat[r][c] and guard:
                    mat[r][c] = 3
            guard = False
            for c in reversed(range(n)):
                if mat[r][c] == 1:
                    guard = True
                elif mat[r][c] == 2:
                    guard = False
                if not mat[r][c] and guard:
                    mat[r][c] = 3

        for c in range(n):
            guard = False
            for r in range(m):
                if mat[r][c] == 1:
                    guard = True
                elif mat[r][c] == 2:
                    guard = False
                if not mat[r][c] and guard:
                    mat[r][c] = 3
            guard = False
            for r in reversed(range(m)):
                if mat[r][c] == 1:
                    guard = True
                elif mat[r][c] == 2:
                    guard = False
                if not mat[r][c] and guard:
                    mat[r][c] = 3

        res = 0
        for row in mat:
            for n in row:
                if n == 0:
                    res += 1
        return res
    
# Input: m = 4, n = 6, guards = [[0,0],[1,1],[2,3]], walls = [[0,1],[2,2],[1,4]]
# Output: 7
# Explanation: The guarded and unguarded cells are shown in red and green respectively in the above diagram.
# There are a total of 7 unguarded cells, so we return 7.

# Input: m = 3, n = 3, guards = [[1,1]], walls = [[0,1],[1,0],[2,1],[1,2]]
# Output: 4
# Explanation: The unguarded cells are shown in green in the above diagram.
# There are a total of 4 unguarded cells, so we return 4.