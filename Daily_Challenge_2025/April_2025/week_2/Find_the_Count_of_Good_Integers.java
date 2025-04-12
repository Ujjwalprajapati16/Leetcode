import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Find_the_Count_of_Good_Integers {
    List<String> palindroms;

    public long countGoodIntegers(int n, int k) {
        palindroms = new ArrayList<>();

        // generate all the permutations of 4 digits
        palindrom(n, 0, new char[n]);

        // check uniqueness of the permutations
        long total = 0l;
        Set<String> seen = new HashSet<>();

        for (String p : palindroms) {
            long val = Long.parseLong(p);
            if (val % k != 0) {
                continue;
            }

            // count how many unique permutations of digits can form this palindrome
            int[] freq = new int[10];
            for (char c : p.toCharArray()) {
                freq[c - '0']++;
            }

            String sig = buildSignature(freq);
            if (seen.contains(sig)) {
                continue;
            }
            seen.add(sig);

            long count = countPermutations(freq, n);
            total += count;
        }

        return total;
    }

    private String buildSignature(int[] freq) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= 9; i++) {
            if (freq[i] > 0) {
                sb.append(i).append('x').append(freq[i]).append('_');
            }
        }
        return sb.toString();
    }

    private long countPermutations(int[] freq, int n) {
        long totalPerms = factorial(n);
        for (int f : freq) {
            totalPerms /= factorial(f);
        }

        if (freq[0] == 0) {
            return totalPerms;
        }

        freq[0]--;

        long invalid = factorial(n - 1);

        for (int f : freq) {
            invalid /= factorial(f);
        }

        freq[0]++;
        return totalPerms - invalid;
    }

    private long factorial(int x) {
        long res = 1;
        for (int i = 2; i <= x; i++) {
            res *= i;
        }
        return res;
    }

    private void palindrom(int n, int idx, char[] temp) {
        if (idx >= (n + 1) / 2) {
            palindroms.add(new String(temp));
            return;
        }

        for (int i = 0; i <= 9; i++) {
            if (i == 0 && idx == 0) {
                continue;
            }

            char ch = (char) (i + '0');
            temp[idx] = ch;
            temp[n - 1 - idx] = ch;
            palindrom(n, idx + 1, temp);
        }
    }

    public static void main(String[] args) {
        Find_the_Count_of_Good_Integers obj = new Find_the_Count_of_Good_Integers();
        System.out.println(obj.countGoodIntegers(3, 5)); // 27
        System.out.println(obj.countGoodIntegers(1, 4)); // 2
        System.out.println(obj.countGoodIntegers(5, 6)); // 2468
    }
}

/*
 * 3272. Find the Count of Good Integers Solved Hard Topics Companies Hint You
 * are given two positive integers n and k.
 * 
 * An integer x is called k-palindromic if:
 * 
 * x is a palindrome. x is divisible by k. An integer is called good if its
 * digits can be rearranged to form a k-palindromic integer. For example, for k
 * = 2, 2020 can be rearranged to form the k-palindromic integer 2002, whereas
 * 1010 cannot be rearranged to form a k-palindromic integer.
 * 
 * Return the count of good integers containing n digits.
 * 
 * Note that any integer must not have leading zeros, neither before nor after
 * rearrangement. For example, 1010 cannot be rearranged to form 101.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: n = 3, k = 5
 * 
 * Output: 27
 * 
 * Explanation:
 * 
 * Some of the good integers are:
 * 
 * 551 because it can be rearranged to form 515. 525 because it is already
 * k-palindromic. Example 2:
 * 
 * Input: n = 1, k = 4
 * 
 * Output: 2
 * 
 * Explanation:
 * 
 * The two good integers are 4 and 8.
 * 
 * Example 3:
 * 
 * Input: n = 5, k = 6
 * 
 * Output: 2468
 * 
 * 
 * 
 * Constraints:
 * 
 * 1 <= n <= 10 1 <= k <= 9
 */