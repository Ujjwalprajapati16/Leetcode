public class Remove_All_Occurrences_of_a_Substring {
    public String removeOccurrences(String s, String part) {
        StringBuilder sb = new StringBuilder();
        // int n = s.length();
        int m = part.length();

        for (char ch : s.toCharArray()) {
            sb.append(ch);
            if (sb.length() >= m) {
                String sub = sb.substring(sb.length() - m);
                if (sub.equals(part)) {
                    sb.setLength(sb.length() - m);
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Remove_All_Occurrences_of_a_Substring solution = new Remove_All_Occurrences_of_a_Substring();
        String s = "daabcbaabcbc";
        String part = "abc";
        String result = solution.removeOccurrences(s, part);

        System.out.println(result); // Output: dab

        s = "axxxxyyyyb";
        part = "xy";
        result = solution.removeOccurrences(s, part);
        System.out.println(result); // Output: axxyy

        s = "x";
        part = "y";
        result = solution.removeOccurrences(s, part);
        System.out.println(result); // Output: x
    }
}

/*
 * 1910. Remove All Occurrences of a Substring Solved Medium Topics Companies
 * Hint Given two strings s and part, perform the following operation on s until
 * all occurrences of the substring part are removed:
 * 
 * Find the leftmost occurrence of the substring part and remove it from s.
 * Return s after removing all occurrences of part.
 * 
 * A substring is a contiguous sequence of characters in a string.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "daabcbaabcbc", part = "abc" Output: "dab" Explanation: The
 * following operations are done: - s = "daabcbaabcbc", remove "abc" starting at
 * index 2, so s = "dabaabcbc". - s = "dabaabcbc", remove "abc" starting at
 * index 4, so s = "dababc". - s = "dababc", remove "abc" starting at index 3,
 * so s = "dab". Now s has no occurrences of "abc". Example 2:
 * 
 * Input: s = "axxxxyyyyb", part = "xy" Output: "ab" Explanation: The following
 * operations are done: - s = "axxxxyyyyb", remove "xy" starting at index 4 so s
 * = "axxxyyyb". - s = "axxxyyyb", remove "xy" starting at index 3 so s =
 * "axxyyb". - s = "axxyyb", remove "xy" starting at index 2 so s = "axyb". - s
 * = "axyb", remove "xy" starting at index 1 so s = "ab". Now s has no
 * occurrences of "xy".
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 1000 1 <= part.length <= 1000 s​​​​​​ and part consists of
 * lowercase English letters.
 */