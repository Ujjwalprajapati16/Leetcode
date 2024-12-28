from typing import List


class Solution:
    def maxSumOfThreeSubarrays(self, nums: List[int], k: int) -> List[int]:
        k_sum = [sum(nums[:k])]
        for i in range(k, len(nums)):
            k_sum.append(k_sum[-1] + nums[i] - nums[i - k])

        dp = {}

        def get_max_sum(i, cnt):
            if cnt == 3 or i > len(nums) - k:
                return 0
            if (i, cnt) in dp:
                return dp[(i, cnt)]

            # Include
            include = k_sum[i] + get_max_sum(i + k, cnt + 1)
            # Skip
            skip = get_max_sum(i + 1, cnt)
            dp[(i, cnt)] = max(include, skip)
            return dp[(i, cnt)]

        def get_indices():
            i = 0
            indices = []

            while i <= len(nums) - k and len(indices) < 3:
                include = k_sum[i] + get_max_sum(i + k, len(indices) + 1)
                skip = get_max_sum(i + 1, len(indices))

                if include >= skip:
                    indices.append(i)
                    i += k
                else:
                    i += 1
            return indices

        return get_indices()


print(Solution().maxSumOfThreeSubarrays([1, 2, 1, 2, 6, 7, 5, 1], 2))
print(Solution().maxSumOfThreeSubarrays([1, 2, 1, 2, 1, 2, 1, 2, 1], 2))

'''
689. Maximum Sum of 3 Non-Overlapping Subarrays
Solved
Hard
Topics
Companies
Given an integer array nums and an integer k, find three non-overlapping subarrays of length k with maximum sum and return them.

Return the result as a list of indices representing the starting position of each interval (0-indexed). If there are multiple answers, return the lexicographically smallest one.

 

Example 1:

Input: nums = [1,2,1,2,6,7,5,1], k = 2
Output: [0,3,5]
Explanation: Subarrays [1, 2], [2, 6], [7, 5] correspond to the starting indices [0, 3, 5].
We could have also taken [2, 1], but an answer of [1, 3, 5] would be lexicographically larger.
Example 2:

Input: nums = [1,2,1,2,1,2,1,2,1], k = 2
Output: [0,2,4]
 

Constraints:

1 <= nums.length <= 2 * 104
1 <= nums[i] < 216
1 <= k <= floor(nums.length / 3)
'''