
import java.util.HashMap;
import java.util.Map;

public class Find_Longest_Special_Substring_That_Occurs_Thrice_I {

    public int maximumLength(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        int n = s.length();

        //gen all special substring and store in map
        for (int i = 0; i < n; i++) {
            StringBuilder currString = new StringBuilder();
            for (int j = i; j < n; j++) {
                if (currString.length() == 0 || s.charAt(j) == currString.charAt(currString.length() - 1)) {
                    currString.append(s.charAt(j));
                    String cur = currString.toString();
                    map.put(cur, map.getOrDefault(cur, 0) + 1);
                } else {
                    break;
                }
            }
        }
        int maxLen = -1;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String str = entry.getKey();
            int freq = entry.getValue();
            if (freq > 2) {
                maxLen = Math.max(maxLen, str.length());
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Find_Longest_Special_Substring_That_Occurs_Thrice_I solution = new Find_Longest_Special_Substring_That_Occurs_Thrice_I();
        String s = "aaaa";
        int result = solution.maximumLength(s);
        System.out.println(result);

        String s1 = "abcdef";
        int result1 = solution.maximumLength(s1);
        System.out.println(result1);

        String s2 = "abcaba";
        int result2 = solution.maximumLength(s2);
        System.out.println(result2);
    }
}

/*
2981. Find Longest Special Substring That Occurs Thrice I
Solved
Medium
Topics
Companies
Hint
You are given a string s that consists of lowercase English letters.

A string is called special if it is made up of only a single character. For example, the string "abc" is not special, whereas the strings "ddd", "zz", and "f" are special.

Return the length of the longest special substring of s which occurs at least thrice, or -1 if no special substring occurs at least thrice.

A substring is a contiguous non-empty sequence of characters within a string.

 

Example 1:

Input: s = "aaaa"
Output: 2
Explanation: The longest special substring which occurs thrice is "aa": substrings "aaaa", "aaaa", and "aaaa".
It can be shown that the maximum length achievable is 2.
Example 2:

Input: s = "abcdef"
Output: -1
Explanation: There exists no special substring which occurs at least thrice. Hence return -1.
Example 3:

Input: s = "abcaba"
Output: 1
Explanation: The longest special substring which occurs thrice is "a": substrings "abcaba", "abcaba", and "abcaba".
It can be shown that the maximum length achievable is 1.
 

Constraints:

3 <= s.length <= 50
s consists of only lowercase English letters.
 */
