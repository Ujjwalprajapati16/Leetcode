import java.util.ArrayList;
import java.util.List;

public class String_Matching_in_an_Array {
    public List<String> stringMatching(String[] words) {
        List<String> res = new ArrayList<>();
        int n = words.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j || words[i].length() > words[j].length()) {
                    continue;
                }

                if (words[j].contains(words[i])) {
                    res.add(words[i]);
                    break;
                }
            }
        }

        return res;
    }

    public boolean isSubstring(String sub, String word) {
        int n = word.length();
        int m = sub.length();

        for (int j = 0; j < n; j++) {
            boolean isMatch = true;
            int k = j;
            int i = 0;

            while (i < m) {
                if (k >= word.length() || word.charAt(k) != sub.charAt(i)) {
                    isMatch = false;
                    break;
                }
                k++;
                i++;
            }

            if (isMatch) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        String_Matching_in_an_Array solution = new String_Matching_in_an_Array();
        String[] words = { "mass", "as", "hero", "superhero" };
        List<String> result = solution.stringMatching(words);
        System.out.println(result);

        String[] words1 = { "leetcode", "et", "code" };
        List<String> result1 = solution.stringMatching(words1);
        System.out.println(result1);

        String[] words2 = { "blue", "green", "bu" };
        List<String> result2 = solution.stringMatching(words2);
        System.out.println(result2);
    }
}

/*
 * 1408. String Matching in an Array Solved Easy Topics Companies Hint Given an
 * array of string words, return all strings in words that is a substring of
 * another word. You can return the answer in any order.
 * 
 * A substring is a contiguous sequence of characters within a string
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: words = ["mass","as","hero","superhero"] Output: ["as","hero"]
 * Explanation: "as" is substring of "mass" and "hero" is substring of
 * "superhero". ["hero","as"] is also a valid answer. Example 2:
 * 
 * Input: words = ["leetcode","et","code"] Output: ["et","code"] Explanation:
 * "et", "code" are substring of "leetcode". Example 3:
 * 
 * Input: words = ["blue","green","bu"] Output: [] Explanation: No string of
 * words is substring of another string.
 * 
 * 
 * Constraints:
 * 
 * 1 <= words.length <= 100 1 <= words[i].length <= 30 words[i] contains only
 * lowercase English letters. All the strings of words are unique.
 */