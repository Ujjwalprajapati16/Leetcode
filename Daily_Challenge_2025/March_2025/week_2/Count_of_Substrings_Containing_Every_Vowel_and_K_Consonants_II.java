public class Count_of_Substrings_Containing_Every_Vowel_and_K_Consonants_II {
    public long countOfSubstrings(String word, int k) {
        return atleast(k, word) - atleast(k + 1, word);
    }

    private boolean isConsonant(char ch) {
        return (ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u');
    }

    private boolean isAllVowelsPresent(int freq[]) {
        return (freq['a' - 'a'] > 0 && freq['e' - 'a'] > 0 && freq['i' - 'a'] > 0 && freq['o' - 'a'] > 0
                && freq['u' - 'a'] > 0);
    }

    private long atleast(int k, String words) {
        long count = 0;
        int curConsonant = 0;
        int freq[] = new int[26];
        int n = words.length();
        int left = 0;

        for (int right = 0; right < n; right++) {
            char ch = words.charAt(right);
            if (isConsonant(ch)) {
                curConsonant++;
            }
            freq[ch - 'a']++;
            while (curConsonant >= k && isAllVowelsPresent(freq)) {
                count += (n - right);
                char c = words.charAt(left);
                if (isConsonant(c)) {
                    curConsonant--;
                }
                freq[c - 'a']--;
                left++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Count_of_Substrings_Containing_Every_Vowel_and_K_Consonants_II obj = new Count_of_Substrings_Containing_Every_Vowel_and_K_Consonants_II();
        System.out.println(obj.countOfSubstrings("aeioqq", 1));
        System.out.println(obj.countOfSubstrings("aeiou", 0));
        System.out.println(obj.countOfSubstrings("ieaouqqieaouqq", 1));

        System.out.println(obj.countOfSubstrings("leetcode", 3));
        System.out.println(obj.countOfSubstrings("leetcode", 2));
    }
}

/*
 * 3306. Count of Substrings Containing Every Vowel and K Consonants II Solved
 * Medium Topics Companies Hint You are given a string word and a non-negative
 * integer k.
 * 
 * Return the total number of substrings of word that contain every vowel ('a',
 * 'e', 'i', 'o', and 'u') at least once and exactly k consonants.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: word = "aeioqq", k = 1
 * 
 * Output: 0
 * 
 * Explanation:
 * 
 * There is no substring with every vowel.
 * 
 * Example 2:
 * 
 * Input: word = "aeiou", k = 0
 * 
 * Output: 1
 * 
 * Explanation:
 * 
 * The only substring with every vowel and zero consonants is word[0..4], which
 * is "aeiou".
 * 
 * Example 3:
 * 
 * Input: word = "ieaouqqieaouqq", k = 1
 * 
 * Output: 3
 * 
 * Explanation:
 * 
 * The substrings with every vowel and one consonant are:
 * 
 * word[0..5], which is "ieaouq". word[6..11], which is "qieaou". word[7..12],
 * which is "ieaouq".
 * 
 * 
 * Constraints:
 * 
 * 5 <= word.length <= 2 * 105 word consists only of lowercase English letters.
 * 0 <= k <= word.length - 5
 */