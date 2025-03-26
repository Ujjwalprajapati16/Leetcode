from typing import List


class Solution:
    def minOperations(self, grid: List[List[int]], x: int) -> int:
        for row in grid:
            for n in row:
                if n % x != grid[0][0] % x:
                    return -1

        nums = sorted([n for row in grid for n in row])
        nums.sort()
        total = sum(nums)
        prefix = 0
        res = float("inf")
        for i in range(len(nums)):
            cost_left = nums[i] * i - prefix
            cost_right = total - prefix - (nums[i] * (len(nums) - i))
            operations = (cost_left + cost_right) // x
            res = min(res, operations)
            prefix += nums[i]

        return res
    
sol = Solution()
print(sol.minOperations([[2,4],[6,8]], 2)) # 4
print(sol.minOperations([[1,5],[2,3]], 1)) # 5
print(sol.minOperations([[3,8],[1,7],[6,2]], 2)) # 5

# Time complexity: O(n^2logn)
# Space complexity: O(n^2)
# Approach: Check if the grid can be converted to a uniform grid by checking if all the elements in the grid are divisible by x.
# If not return -1. Sort the grid and calculate the prefix sum. Calculate the cost of operations by calculating the cost of operations
# to convert the first half of the grid and the second half of the grid. Finally return the minimum cost.

'''
2033. Minimum Operations to Make a Uni-Value Grid
Solved
Medium
Topics
Companies
Hint
You are given a 2D integer grid of size m x n and an integer x. In one operation, you can add x to or subtract x from any element in the grid.

A uni-value grid is a grid where all the elements of it are equal.

Return the minimum number of operations to make the grid uni-value. If it is not possible, return -1.

 

Example 1:


Input: grid = [[2,4],[6,8]], x = 2
Output: 4
Explanation: We can make every element equal to 4 by doing the following: 
- Add x to 2 once.
- Subtract x from 6 once.
- Subtract x from 8 twice.
A total of 4 operations were used.
Example 2:


Input: grid = [[1,5],[2,3]], x = 1
Output: 5
Explanation: We can make every element equal to 3.
Example 3:


Input: grid = [[1,2],[3,4]], x = 2
Output: -1
Explanation: It is impossible to make every element equal.
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 105
1 <= m * n <= 105
1 <= x, grid[i][j] <= 104
'''