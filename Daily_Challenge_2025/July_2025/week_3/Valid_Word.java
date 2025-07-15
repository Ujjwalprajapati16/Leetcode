public class Valid_Word {
    public boolean isValid(String word) {
        int n = word.length();
        if (n < 3) {
            return false;
        }

        boolean isVowel = false;
        boolean isConsonant = false;

        for (int i = 0; i < n; i++) {
            char c = word.charAt(i);
            boolean isDigit = c >= '0' && c <= '9';
            boolean isUpper = c >= 'A' && c <= 'Z';
            boolean isLower = c >= 'a' && c <= 'z';

            if (!(isDigit || isUpper || isLower)) {
                return false;
            }

            if (isUpper || isLower) {
                char lower = isUpper ? (char) (c + 32) : c;
                if (lower == 'a' || lower == 'e' || lower == 'i' || lower == 'o' || lower == 'u') {
                    isVowel = true;
                } else {
                    isConsonant = true;
                }
            }
        }

        return isVowel && isConsonant;
    }

    public static void main(String[] args) {
        Valid_Word vw = new Valid_Word();
        System.out.println(vw.isValid("234Adas")); // true
        System.out.println(vw.isValid("b3")); // false
        System.out.println(vw.isValid("a3$e")); // false
    }
}

/*
 * 3136. Valid Word
 * Solved
 * Easy
 * Topics
 * premium lock icon
 * Companies
 * Hint
 * A word is considered valid if:
 * 
 * It contains a minimum of 3 characters.
 * It contains only digits (0-9), and English letters (uppercase and lowercase).
 * It includes at least one vowel.
 * It includes at least one consonant.
 * You are given a string word.
 * 
 * Return true if word is valid, otherwise, return false.
 * 
 * Notes:
 * 
 * 'a', 'e', 'i', 'o', 'u', and their uppercases are vowels.
 * A consonant is an English letter that is not a vowel.
 * 
 * 
 * Example 1:
 * 
 * Input: word = "234Adas"
 * 
 * Output: true
 * 
 * Explanation:
 * 
 * This word satisfies the conditions.
 * 
 * Example 2:
 * 
 * Input: word = "b3"
 * 
 * Output: false
 * 
 * Explanation:
 * 
 * The length of this word is fewer than 3, and does not have a vowel.
 * 
 * Example 3:
 * 
 * Input: word = "a3$e"
 * 
 * Output: false
 * 
 * Explanation:
 * 
 * This word contains a '$' character and does not have a consonant.
 * 
 * 
 * 
 * Constraints:
 * 
 * 1 <= word.length <= 20
 * word consists of English uppercase and lowercase letters, digits, '@', '#',
 * and '$'.
 */