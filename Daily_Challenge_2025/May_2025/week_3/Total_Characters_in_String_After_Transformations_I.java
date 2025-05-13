public class Total_Characters_in_String_After_Transformations_I {
    public int MOD = 1_000_000_007;

    public int lengthAfterTransformations(String s, int t) {
        long length = s.length();
        long[] count = new long[26];

        // count initial character
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        // Apply transformation
        for (int i = 0; i < t; i++) {
            long[] nextCount = new long[26];

            for (int j = 0; j < 26; j++) {
                if (j == 25) {
                    length = (length + count[25]) % MOD;
                    nextCount[0] = (nextCount[0] + count[25]) % MOD;
                    nextCount[1] = (nextCount[1] + count[25]) % MOD;
                } else {
                    nextCount[j + 1] = (nextCount[j + 1] + count[j]) % MOD;
                }
            }

            count = nextCount;
        }

        return (int) length;
    }

    public static void main(String[] args) {
        Total_Characters_in_String_After_Transformations_I obj = new Total_Characters_in_String_After_Transformations_I();
        System.out.println(obj.lengthAfterTransformations("abcyy", 2)); // 7
        System.out.println(obj.lengthAfterTransformations("azbk", 1)); // 5
    }
}

/*
 * 3335. Total Characters in String After Transformations I Solved Medium Topics
 * Companies Hint You are given a string s and an integer t, representing the
 * number of transformations to perform. In one transformation, every character
 * in s is replaced according to the following rules:
 * 
 * If the character is 'z', replace it with the string "ab". Otherwise, replace
 * it with the next character in the alphabet. For example, 'a' is replaced with
 * 'b', 'b' is replaced with 'c', and so on. Return the length of the resulting
 * string after exactly t transformations.
 * 
 * Since the answer may be very large, return it modulo 109 + 7.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "abcyy", t = 2
 * 
 * Output: 7
 * 
 * Explanation:
 * 
 * First Transformation (t = 1): 'a' becomes 'b' 'b' becomes 'c' 'c' becomes 'd'
 * 'y' becomes 'z' 'y' becomes 'z' String after the first transformation:
 * "bcdzz" Second Transformation (t = 2): 'b' becomes 'c' 'c' becomes 'd' 'd'
 * becomes 'e' 'z' becomes "ab" 'z' becomes "ab" String after the second
 * transformation: "cdeabab" Final Length of the string: The string is
 * "cdeabab", which has 7 characters. Example 2:
 * 
 * Input: s = "azbk", t = 1
 * 
 * Output: 5
 * 
 * Explanation:
 * 
 * First Transformation (t = 1): 'a' becomes 'b' 'z' becomes "ab" 'b' becomes
 * 'c' 'k' becomes 'l' String after the first transformation: "babcl" Final
 * Length of the string: The string is "babcl", which has 5 characters.
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 105 s consists only of lowercase English letters. 1 <= t <=
 * 105
 */