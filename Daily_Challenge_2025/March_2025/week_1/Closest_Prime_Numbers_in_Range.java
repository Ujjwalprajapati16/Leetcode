import java.util.Arrays;

public class Closest_Prime_Numbers_in_Range {
    public int[] closestPrimes(int left, int right) {
        boolean prime[] = new boolean[right + 1];
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;

        for (int p = 2; p * p <= right; p++) {
            if (prime[p]) {
                for (int i = p * p; i <= right; i += p) {
                    prime[i] = false;
                }
            }
        }

        int res[] = new int[] { -1, -1 };
        int minDiff = Integer.MAX_VALUE;
        int prev = -1;
        for (int i = left; i <= right; i++) {
            if (prime[i]) {
                if (prev == -1) {
                    prev = i;
                } else {
                    if (i - prev < minDiff) {
                        res[0] = prev;
                        res[1] = i;
                        minDiff = i - prev;
                    }
                    prev = i;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Closest_Prime_Numbers_in_Range closest_prime_numbers_in_range = new Closest_Prime_Numbers_in_Range();
        int[] res = closest_prime_numbers_in_range.closestPrimes(4, 6);
        System.out.println(Arrays.toString(res)); // Output: [-1,-1]

        res = closest_prime_numbers_in_range.closestPrimes(10, 19);
        System.out.println(Arrays.toString(res)); // Output: [11,13]
    }
}

/*
 * 2523. Closest Prime Numbers in Range
 * Solved
 * Medium
 * Topics
 * Companies
 * Hint
 * Given two positive integers left and right, find the two integers num1 and
 * num2 such that:
 * 
 * left <= num1 < num2 <= right .
 * Both num1 and num2 are prime numbers.
 * num2 - num1 is the minimum amongst all other pairs satisfying the above
 * conditions.
 * Return the positive integer array ans = [num1, num2]. If there are multiple
 * pairs satisfying these conditions, return the one with the smallest num1
 * value. If no such numbers exist, return [-1, -1].
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: left = 10, right = 19
 * Output: [11,13]
 * Explanation: The prime numbers between 10 and 19 are 11, 13, 17, and 19.
 * The closest gap between any pair is 2, which can be achieved by [11,13] or
 * [17,19].
 * Since 11 is smaller than 17, we return the first pair.
 * Example 2:
 * 
 * Input: left = 4, right = 6
 * Output: [-1,-1]
 * Explanation: There exists only one prime number in the given range, so the
 * conditions cannot be satisfied.
 * 
 * 
 * Constraints:
 * 
 * 1 <= left <= right <= 106
 */