import java.util.Arrays;
import java.util.List;

public class Total_Characters_in_String_After_Transformations_II {
    private static final int MOD = 1_000_000_007;

    public int lengthAfterTransformations(String s, int t, List<Integer> nums) {
        int[][] base = new int[26][26];
        for (int i = 0; i < 26; i++) {
            for (int j = 1; j <= nums.get(i); j++) {
                base[i][(i + j) % 26] = (base[i][(i + j) % 26] + 1) % MOD;
            }
        }

        int[][] mat = matrixPower(base, t);

        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        long result = 0;
        for (int i = 0; i < 26; i++) {
            long sum = 0;
            for (int j = 0; j < 26; j++) {
                sum = (sum + (1L * freq[j] * mat[j][i]) % MOD) % MOD;
            }
            result = (result + sum) % MOD;
        }

        return (int) result;
    }

    private int[][] matrixMultiply(int[][] A, int[][] B) {
        int[][] res = new int[26][26];
        for (int i = 0; i < 26; i++) {
            for (int k = 0; k < 26; k++) {
                if (A[i][k] == 0)
                    continue;
                for (int j = 0; j < 26; j++) {
                    res[i][j] = (int) ((res[i][j] + 1L * A[i][k] * B[k][j]) % MOD);
                }
            }
        }
        return res;
    }

    private int[][] matrixPower(int[][] mat, int power) {
        int[][] result = new int[26][26];
        for (int i = 0; i < 26; i++)
            result[i][i] = 1;
        while (power > 0) {
            if ((power & 1) == 1)
                result = matrixMultiply(result, mat);
            mat = matrixMultiply(mat, mat);
            power >>= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        Total_Characters_in_String_After_Transformations_II solution = new Total_Characters_in_String_After_Transformations_II();
        String s = "abcyy";
        int t = 2;
        List<Integer> nums = Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2);
        int result = solution.lengthAfterTransformations(s, t, nums);
        System.out.println(result); // Output: 7

        s = "xyz";
        t = 2;
        nums = Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
        result = solution.lengthAfterTransformations(s, t, nums);
        System.out.println(result); // Output: 3
    }
}

/*
 * 3337. Total Characters in String After Transformations II Solved Hard Topics
 * Companies Hint You are given a string s consisting of lowercase English
 * letters, an integer t representing the number of transformations to perform,
 * and an array nums of size 26. In one transformation, every character in s is
 * replaced according to the following rules:
 * 
 * Replace s[i] with the next nums[s[i] - 'a'] consecutive characters in the
 * alphabet. For example, if s[i] = 'a' and nums[0] = 3, the character 'a'
 * transforms into the next 3 consecutive characters ahead of it, which results
 * in "bcd". The transformation wraps around the alphabet if it exceeds 'z'. For
 * example, if s[i] = 'y' and nums[24] = 3, the character 'y' transforms into
 * the next 3 consecutive characters ahead of it, which results in "zab". Return
 * the length of the resulting string after exactly t transformations.
 * 
 * Since the answer may be very large, return it modulo 109 + 7.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "abcyy", t = 2, nums =
 * [1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2]
 * 
 * Output: 7
 * 
 * Explanation:
 * 
 * First Transformation (t = 1):
 * 
 * 'a' becomes 'b' as nums[0] == 1 'b' becomes 'c' as nums[1] == 1 'c' becomes
 * 'd' as nums[2] == 1 'y' becomes 'z' as nums[24] == 1 'y' becomes 'z' as
 * nums[24] == 1 String after the first transformation: "bcdzz" Second
 * Transformation (t = 2):
 * 
 * 'b' becomes 'c' as nums[1] == 1 'c' becomes 'd' as nums[2] == 1 'd' becomes
 * 'e' as nums[3] == 1 'z' becomes 'ab' as nums[25] == 2 'z' becomes 'ab' as
 * nums[25] == 2 String after the second transformation: "cdeabab" Final Length
 * of the string: The string is "cdeabab", which has 7 characters.
 * 
 * Example 2:
 * 
 * Input: s = "azbk", t = 1, nums =
 * [2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2]
 * 
 * Output: 8
 * 
 * Explanation:
 * 
 * First Transformation (t = 1):
 * 
 * 'a' becomes 'bc' as nums[0] == 2 'z' becomes 'ab' as nums[25] == 2 'b'
 * becomes 'cd' as nums[1] == 2 'k' becomes 'lm' as nums[10] == 2 String after
 * the first transformation: "bcabcdlm" Final Length of the string: The string
 * is "bcabcdlm", which has 8 characters.
 * 
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 105 s consists only of lowercase English letters. 1 <= t <=
 * 109 nums.length == 26 1 <= nums[i] <= 25
 */