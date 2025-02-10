public class Clear_Digits {
    public String clearDigits(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();

        for (int i = 0; i < n; i++) {
            if (!Character.isDigit(s.charAt(i))) {
                sb.append(s.charAt(i));
            } else {
                if (sb.length() != 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Clear_Digits clearDigits = new Clear_Digits();
        System.out.println(clearDigits.clearDigits("abc")); // Output: abc
        System.out.println(clearDigits.clearDigits("cb34")); // Output: ""
    }
}

/*
 * 3174. Clear Digits
 * Solved
 * Easy
 * Topics
 * Companies
 * Hint
 * You are given a string s.
 * 
 * Your task is to remove all digits by doing this operation repeatedly:
 * 
 * Delete the first digit and the closest non-digit character to its left.
 * Return the resulting string after removing all digits.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "abc"
 * 
 * Output: "abc"
 * 
 * Explanation:
 * 
 * There is no digit in the string.
 * 
 * Example 2:
 * 
 * Input: s = "cb34"
 * 
 * Output: ""
 * 
 * Explanation:
 * 
 * First, we apply the operation on s[2], and s becomes "c4".
 * 
 * Then we apply the operation on s[1], and s becomes "".
 * 
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 100
 * s consists only of lowercase English letters and digits.
 * The input is generated such that it is possible to delete all digits.
 */