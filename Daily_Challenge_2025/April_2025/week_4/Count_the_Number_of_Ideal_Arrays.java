public class Count_the_Number_of_Ideal_Arrays {
    int n, maxValue;
    int MOD = 1_000_000_007;
    long[][] comb;
    Integer[][] memo;

    public int idealArrays(int n, int maxValue) {
        this.n = n;
        this.maxValue = maxValue;

        comb = new long[n + 1][15];
        for (int i = 0; i <= n; i++) {
            comb[i][0] = 1;
            for (int j = 1; j <= Math.min(i, 14); j++) {
                comb[i][j] = (comb[i - 1][j - 1] + comb[i - 1][j]) % MOD;
            }
        }

        memo = new Integer[maxValue + 1][15];

        long total = 0;
        for (int start = 1; start <= maxValue; start++) {
            for (int len = 1; len <= 14; len++) {
                int ways = dfs(start, len);
                total = (total + ways * comb[n - 1][len - 1]) % MOD;
            }
        }

        return (int) total;
    }

    private int dfs(int val, int len) {
        if (len == 1) {
            return 1;
        }

        if (memo[val][len] != null) {
            return memo[val][len];
        }

        long count = 0;
        for (int next = val * 2; next <= maxValue; next += val) {
            count = (count + dfs(next, len - 1)) % MOD;
        }

        return memo[val][len] = (int) count;
    }

    public static void main(String[] args) {
        Count_the_Number_of_Ideal_Arrays obj = new Count_the_Number_of_Ideal_Arrays();
        int n = 2, maxValue = 5;
        System.out.println(obj.idealArrays(n, maxValue)); // Output: 10

        n = 5;
        maxValue = 3;
        System.out.println(obj.idealArrays(n, maxValue)); // Output: 11
    }
}

/*
 * 2338. Count the Number of Ideal Arrays Solved Hard Topics Companies Hint You
 * are given two integers n and maxValue, which are used to describe an ideal
 * array.
 * 
 * A 0-indexed integer array arr of length n is considered ideal if the
 * following conditions hold:
 * 
 * Every arr[i] is a value from 1 to maxValue, for 0 <= i < n. Every arr[i] is
 * divisible by arr[i - 1], for 0 < i < n. Return the number of distinct ideal
 * arrays of length n. Since the answer may be very large, return it modulo 109
 * + 7.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: n = 2, maxValue = 5 Output: 10 Explanation: The following are the
 * possible ideal arrays: - Arrays starting with the value 1 (5 arrays): [1,1],
 * [1,2], [1,3], [1,4], [1,5] - Arrays starting with the value 2 (2 arrays):
 * [2,2], [2,4] - Arrays starting with the value 3 (1 array): [3,3] - Arrays
 * starting with the value 4 (1 array): [4,4] - Arrays starting with the value 5
 * (1 array): [5,5] There are a total of 5 + 2 + 1 + 1 + 1 = 10 distinct ideal
 * arrays. Example 2:
 * 
 * Input: n = 5, maxValue = 3 Output: 11 Explanation: The following are the
 * possible ideal arrays: - Arrays starting with the value 1 (9 arrays): - With
 * no other distinct values (1 array): [1,1,1,1,1] - With 2nd distinct value 2
 * (4 arrays): [1,1,1,1,2], [1,1,1,2,2], [1,1,2,2,2], [1,2,2,2,2] - With 2nd
 * distinct value 3 (4 arrays): [1,1,1,1,3], [1,1,1,3,3], [1,1,3,3,3],
 * [1,3,3,3,3] - Arrays starting with the value 2 (1 array): [2,2,2,2,2] -
 * Arrays starting with the value 3 (1 array): [3,3,3,3,3] There are a total of
 * 9 + 1 + 1 = 11 distinct ideal arrays.
 * 
 * 
 * Constraints:
 * 
 * 2 <= n <= 104 1 <= maxValue <= 104
 */