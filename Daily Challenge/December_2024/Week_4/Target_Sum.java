import java.util.HashMap;
import java.util.Map;

public class Target_Sum {
    public int findTargetSumWays(int[] nums, int target) {
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(0, 1);

        for (int num : nums) {
            Map<Integer, Integer> nextDp = new HashMap<>();
            for (int sum : dp.keySet()) {
                int count = dp.get(sum);
                nextDp.put(sum + num, nextDp.getOrDefault(sum + num, 0) + count);

                nextDp.put(sum - num, nextDp.getOrDefault(sum - num, 0) + count);
            }
            dp = nextDp;
        }
        return dp.getOrDefault(target, 0);
    }

    public static void main(String[] args) {
        Target_Sum solution = new Target_Sum();
        int nums[] = {1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(solution.findTargetSumWays(nums, target));
    }
}

/*494. Target Sum
Solved
Medium
Topics
Companies
You are given an integer array nums and an integer target.

You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.

For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
Return the number of different expressions that you can build, which evaluates to target.

 

Example 1:

Input: nums = [1,1,1,1,1], target = 3
Output: 5
Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
-1 + 1 + 1 + 1 + 1 = 3
+1 - 1 + 1 + 1 + 1 = 3
+1 + 1 - 1 + 1 + 1 = 3
+1 + 1 + 1 - 1 + 1 = 3
+1 + 1 + 1 + 1 - 1 = 3
Example 2:

Input: nums = [1], target = 1
Output: 1
 

Constraints:

1 <= nums.length <= 20
0 <= nums[i] <= 1000
0 <= sum(nums[i]) <= 1000
-1000 <= target <= 1000 */