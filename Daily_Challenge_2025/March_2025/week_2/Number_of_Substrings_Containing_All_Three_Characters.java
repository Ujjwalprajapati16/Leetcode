public class Number_of_Substrings_Containing_All_Three_Characters {
    public int numberOfSubstrings(String s) {
        int freq[] = new int[3];
        int count = 0;
        int curCount = 0;
        int left = 0;
        int n = s.length();

        for (int right = 0; right < n; right++) {
            char ch = s.charAt(right);
            freq[ch - 'a']++;
            if (freq[ch - 'a'] == 1) {
                curCount++;
            }
            while (curCount == 3) {
                count += (n - right);
                char c = s.charAt(left);
                freq[c - 'a']--;
                if (freq[c - 'a'] == 0) {
                    curCount--;
                }
                left++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Number_of_Substrings_Containing_All_Three_Characters obj = new Number_of_Substrings_Containing_All_Three_Characters();
        System.out.println(obj.numberOfSubstrings("abcabc"));
        System.out.println(obj.numberOfSubstrings("abc"));
        System.out.println(obj.numberOfSubstrings("aaacb"));
    }
}

/*
 * 1358. Number of Substrings Containing All Three Characters Solved Medium
 * Topics Companies Hint Given a string s consisting only of characters a, b and
 * c.
 * 
 * Return the number of substrings containing at least one occurrence of all
 * these characters a, b and c.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "abcabc" Output: 10 Explanation: The substrings containing at
 * least one occurrence of the characters a, b and c are "abc", "abca", "abcab",
 * "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again). Example 2:
 * 
 * Input: s = "aaacb" Output: 3 Explanation: The substrings containing at least
 * one occurrence of the characters a, b and c are "aaacb", "aacb" and "acb".
 * Example 3:
 * 
 * Input: s = "abc" Output: 1
 * 
 * 
 * Constraints:
 * 
 * 3 <= s.length <= 5 x 10^4 s only consists of a, b or c characters.
 */