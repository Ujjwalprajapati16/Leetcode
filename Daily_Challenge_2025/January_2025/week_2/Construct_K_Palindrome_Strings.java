import java.util.HashMap;

public class Construct_K_Palindrome_Strings {
    public boolean canConstruct(String s, int k) {
        int n = s.length();
        int odd = 0;

        if (n < k) {
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i : map.values()) {
            if (i % 2 != 0) {
                odd++;
            }
        }

        return odd <= k;
    }

    public static void main(String[] args) {
        Construct_K_Palindrome_Strings obj = new Construct_K_Palindrome_Strings();
        System.out.println(obj.canConstruct("annabelle", 2));

        System.out.println(obj.canConstruct("leetcode", 3));

        System.out.println(obj.canConstruct("true", 4));
    }
}

/*
 * 1400. Construct K Palindrome Strings Solved Medium Topics Companies Hint
 * Given a string s and an integer k, return true if you can use all the
 * characters in s to construct k palindrome strings or false otherwise.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "annabelle", k = 2 Output: true Explanation: You can construct two
 * palindromes using all characters in s. Some possible constructions "anna" +
 * "elble", "anbna" + "elle", "anellena" + "b" Example 2:
 * 
 * Input: s = "leetcode", k = 3 Output: false Explanation: It is impossible to
 * construct 3 palindromes using all the characters of s. Example 3:
 * 
 * Input: s = "true", k = 4 Output: true Explanation: The only possible solution
 * is to put each character in a separate string.
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 105 s consists of lowercase English letters. 1 <= k <= 105
 */