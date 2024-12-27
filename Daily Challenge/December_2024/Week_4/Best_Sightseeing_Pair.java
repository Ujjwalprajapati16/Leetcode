public class Best_Sightseeing_Pair {
    public int maxScoreSightseeingPair(int[] values) {
        int res = 0;
        int n = values.length;
        int leftMax = values[0];
        for(int j=1; j<n; j++){
            int rightVal = values[j] - j;
            res = Math.max(res, leftMax + rightVal);
            leftMax = Math.max(leftMax, values[j] + j);
        }

        return res;
    }
    public static void main(String[] args) {
        Best_Sightseeing_Pair solution = new Best_Sightseeing_Pair();
        int values[] = {8,1,5,2,6};
        System.out.println(solution.maxScoreSightseeingPair(values));

        int values1[] = {1,2};
        System.out.println(solution.maxScoreSightseeingPair(values1));
    }
}

/*1014. Best Sightseeing Pair
Solved
Medium
Topics
Companies
Hint
You are given an integer array values where values[i] represents the value of the ith sightseeing spot. Two sightseeing spots i and j have a distance j - i between them.

The score of a pair (i < j) of sightseeing spots is values[i] + values[j] + i - j: the sum of the values of the sightseeing spots, minus the distance between them.

Return the maximum score of a pair of sightseeing spots.

 

Example 1:

Input: values = [8,1,5,2,6]
Output: 11
Explanation: i = 0, j = 2, values[i] + values[j] + i - j = 8 + 5 + 0 - 2 = 11
Example 2:

Input: values = [1,2]
Output: 2
 

Constraints:

2 <= values.length <= 5 * 104
1 <= values[i] <= 1000 */