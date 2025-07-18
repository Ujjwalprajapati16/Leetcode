public class Count_the_Number_of_Arrays_with_K_Matching_Adjacent_Elements {
    private static final int MOD = (int) 1e9 + 7;
    private int[] fact;
    private int[] invFact;

    private int binaryExp(long a, long b) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                res = (res * a) % MOD;
            }
            a = (a * a) % MOD;
            b >>= 1;
        }
        return (int) res;
    }

    private int mmi(int val) {
        return binaryExp(val, MOD - 2);
    }

    private void inverseFact(int n) {
        invFact = new int[n + 1];
        invFact[n] = mmi(fact[n]);
        for (int i = n; i > 0; i--) {
            invFact[i - 1] = (int) ((1L * invFact[i] * i) % MOD);
        }
    }

    private void factorial(int n) {
        fact = new int[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = (int) ((1L * i * fact[i - 1]) % MOD);
        }
    }

    private void precompute(int n) {
        factorial(n);
        inverseFact(n);
    }

    public int countGoodArrays(int n, int m, int k) {
        precompute(n);

        int runWays = (int) ((1L * fact[n - 1] * invFact[n - k - 1] % MOD * invFact[k]) % MOD);
        int waysToAssign = (int) (1L * m * binaryExp(m - 1, n - k - 1) % MOD);
        return (int) (1L * runWays * waysToAssign % MOD);
    }

    public static void main(String[] args) {
        Count_the_Number_of_Arrays_with_K_Matching_Adjacent_Elements solution = new Count_the_Number_of_Arrays_with_K_Matching_Adjacent_Elements();
        System.out.println(solution.countGoodArrays(3, 2, 1)); // Output: 4
        System.out.println(solution.countGoodArrays(4, 2, 2)); // Output: 6
        System.out.println(solution.countGoodArrays(5, 2, 0)); // Output: 2
    }
}

/*
 * 3405. Count the Number of Arrays with K Matching Adjacent Elements Solved
 * Hard Topics premium lock icon Companies Hint You are given three integers n,
 * m, k. A good array arr of size n is defined as follows:
 * 
 * Each element in arr is in the inclusive range [1, m]. Exactly k indices i
 * (where 1 <= i < n) satisfy the condition arr[i - 1] == arr[i]. Return the
 * number of good arrays that can be formed.
 * 
 * Since the answer may be very large, return it modulo 109 + 7.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: n = 3, m = 2, k = 1
 * 
 * Output: 4
 * 
 * Explanation:
 * 
 * There are 4 good arrays. They are [1, 1, 2], [1, 2, 2], [2, 1, 1] and [2, 2,
 * 1]. Hence, the answer is 4. Example 2:
 * 
 * Input: n = 4, m = 2, k = 2
 * 
 * Output: 6
 * 
 * Explanation:
 * 
 * The good arrays are [1, 1, 1, 2], [1, 1, 2, 2], [1, 2, 2, 2], [2, 1, 1, 1],
 * [2, 2, 1, 1] and [2, 2, 2, 1]. Hence, the answer is 6. Example 3:
 * 
 * Input: n = 5, m = 2, k = 0
 * 
 * Output: 2
 * 
 * Explanation:
 * 
 * The good arrays are [1, 2, 1, 2, 1] and [2, 1, 2, 1, 2]. Hence, the answer is
 * 2.
 * 
 * 
 * Constraints:
 * 
 * 1 <= n <= 105 1 <= m <= 105 0 <= k <= n - 1
 */