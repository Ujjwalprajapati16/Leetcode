
public class Minimum_Limit_of_Balls_in_a_Bag {

    public int minimumSize(int[] nums, int maxOperations) {
        int low = 1, high = 0;

        // Find the maximum size in the array
        for (int num : nums) {
            high = Math.max(high, num);
        }

        // Binary search for the minimum possible penalty
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (canDivide(nums, mid, maxOperations)) {
                high = mid; // Try smaller penalties
            } else {
                low = mid + 1; // Try larger penalties
            }
        }

        return low; // The smallest penalty that works
    }

    // Helper method to check if we can achieve penalty `maxPenalty` within `maxOperations`
    private boolean canDivide(int[] nums, int maxPenalty, int maxOperations) {
        int operations = 0;
        for (int num : nums) {
            // Calculate the number of splits needed for this bag
            operations += (num - 1) / maxPenalty;
            if (operations > maxOperations) {
                return false; // Too many operations needed
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Minimum_Limit_of_Balls_in_a_Bag solution = new Minimum_Limit_of_Balls_in_a_Bag();
        int[] nums = {9};
        int maxOperations = 2;
        int result = solution.minimumSize(nums, maxOperations);
        System.out.println(result);

        int[] nums1 = {2, 4, 8, 2};
        int maxOperations1 = 4;
        int result1 = solution.minimumSize(nums1, maxOperations1);
        System.out.println(result1);

        int[] nums2 = {7, 17};
        int maxOperations2 = 2;
        int result2 = solution.minimumSize(nums2, maxOperations2);
        System.out.println(result2);
    }
}

/*
1760. Minimum Limit of Balls in a Bag
Solved
Medium
Topics
Companies
Hint
You are given an integer array nums where the ith bag contains nums[i] balls. You are also given an integer maxOperations.

You can perform the following operation at most maxOperations times:

Take any bag of balls and divide it into two new bags with a positive number of balls.
For example, a bag of 5 balls can become two new bags of 1 and 4 balls, or two new bags of 2 and 3 balls.
Your penalty is the maximum number of balls in a bag. You want to minimize your penalty after the operations.

Return the minimum possible penalty after performing the operations.

 

Example 1:

Input: nums = [9], maxOperations = 2
Output: 3
Explanation: 
- Divide the bag with 9 balls into two bags of sizes 6 and 3. [9] -> [6,3].
- Divide the bag with 6 balls into two bags of sizes 3 and 3. [6,3] -> [3,3,3].
The bag with the most number of balls has 3 balls, so your penalty is 3 and you should return 3.
Example 2:

Input: nums = [2,4,8,2], maxOperations = 4
Output: 2
Explanation:
- Divide the bag with 8 balls into two bags of sizes 4 and 4. [2,4,8,2] -> [2,4,4,4,2].
- Divide the bag with 4 balls into two bags of sizes 2 and 2. [2,4,4,4,2] -> [2,2,2,4,4,2].
- Divide the bag with 4 balls into two bags of sizes 2 and 2. [2,2,2,4,4,2] -> [2,2,2,2,2,4,2].
- Divide the bag with 4 balls into two bags of sizes 2 and 2. [2,2,2,2,2,4,2] -> [2,2,2,2,2,2,2,2].
The bag with the most number of balls has 2 balls, so your penalty is 2, and you should return 2.
 

Constraints:

1 <= nums.length <= 105
1 <= maxOperations, nums[i] <= 109
 */
