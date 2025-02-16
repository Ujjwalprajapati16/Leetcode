import java.util.Arrays;

public class Find_the_Punishment_Number_of_an_Integer {
    public boolean isPartition(int j, String i2, int i, int curSum, int dp[][]) {
        int n = i2.length();
        if (j == n) {
            return (curSum == i);
        }

        if (curSum > i) {
            return false;
        }

        if (dp[j][curSum] != -1) {
            return (dp[j][curSum] == 1);
        }

        for (int index = j; index < n; index++) {
            int val = Integer.parseInt(i2.substring(j, index + 1));
            if (isPartition(index + 1, i2, i, curSum + val, dp)) {
                dp[j][curSum] = 1;
                return true;
            }
        }

        dp[j][curSum] = 0;
        return false;
    }

    public int punishmentNumber(int n) {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            String i2 = Integer.toString(i * i);
            int len = i2.length();
            int dp[][] = new int[len][i + 1];
            for (int k = 0; k < len; k++) {
                Arrays.fill(dp[k], -1);
            }

            if (isPartition(0, i2, i, 0, dp)) {
                res += (i * i);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Find_the_Punishment_Number_of_an_Integer solution = new Find_the_Punishment_Number_of_an_Integer();
        System.out.println(solution.punishmentNumber(10)); // Output: 182
        System.out.println(solution.punishmentNumber(37)); // Output: 1478
    }
}

/*
 * 2698. Find the Punishment Number of an Integer
 * Solved
 * Medium
 * Topics
 * Companies
 * Hint
 * Given a positive integer n, return the punishment number of n.
 * 
 * The punishment number of n is defined as the sum of the squares of all
 * integers i such that:
 * 
 * 1 <= i <= n
 * The decimal representation of i * i can be partitioned into contiguous
 * substrings such that the sum of the integer values of these substrings equals
 * i.
 * 
 * 
 * Example 1:
 * 
 * Input: n = 10
 * Output: 182
 * Explanation: There are exactly 3 integers i in the range [1, 10] that satisfy
 * the conditions in the statement:
 * - 1 since 1 * 1 = 1
 * - 9 since 9 * 9 = 81 and 81 can be partitioned into 8 and 1 with a sum equal
 * to 8 + 1 == 9.
 * - 10 since 10 * 10 = 100 and 100 can be partitioned into 10 and 0 with a sum
 * equal to 10 + 0 == 10.
 * Hence, the punishment number of 10 is 1 + 81 + 100 = 182
 * Example 2:
 * 
 * Input: n = 37
 * Output: 1478
 * Explanation: There are exactly 4 integers i in the range [1, 37] that satisfy
 * the conditions in the statement:
 * - 1 since 1 * 1 = 1.
 * - 9 since 9 * 9 = 81 and 81 can be partitioned into 8 + 1.
 * - 10 since 10 * 10 = 100 and 100 can be partitioned into 10 + 0.
 * - 36 since 36 * 36 = 1296 and 1296 can be partitioned into 1 + 29 + 6.
 * Hence, the punishment number of 37 is 1 + 81 + 100 + 1296 = 1478
 * 
 * 
 * Constraints:
 * 
 * 1 <= n <= 1000
 */