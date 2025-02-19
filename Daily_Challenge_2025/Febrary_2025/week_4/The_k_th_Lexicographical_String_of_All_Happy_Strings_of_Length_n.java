public class The_k_th_Lexicographical_String_of_All_Happy_Strings_of_Length_n {
    String res;
    int count;

    public boolean backtrack(int n, int k, StringBuilder cur) {
        if (cur.length() == n) {
            count++;
            if (count == k) {
                res = cur.toString();
                return true;
            }
            return false;
        }

        for (char ch = 'a'; ch <= 'c'; ch++) {
            int len = cur.length();
            if (len > 0 && cur.charAt(len - 1) == ch) {
                continue;
            }
            cur.append(ch);
            if (backtrack(n, k, cur)) {
                return true;
            }
            cur.deleteCharAt(cur.length() - 1);
        }

        return false;
    }

    public String getHappyString(int n, int k) {
        count = 0;
        res = "";
        backtrack(n, k, new StringBuilder(""));
        return res;
    }

    public static void main(String[] args) {
        The_k_th_Lexicographical_String_of_All_Happy_Strings_of_Length_n obj = new The_k_th_Lexicographical_String_of_All_Happy_Strings_of_Length_n();
        String res = obj.getHappyString(3, 9);
        System.out.println(res); // cab

        res = obj.getHappyString(1, 3);
        System.out.println(res); // c
    }
}

/*
 * 1415. The k-th Lexicographical String of All Happy Strings of Length n Solved
 * Medium Topics Companies Hint A happy string is a string that:
 * 
 * consists only of letters of the set ['a', 'b', 'c']. s[i] != s[i + 1] for all
 * values of i from 1 to s.length - 1 (string is 1-indexed). For example,
 * strings "abc", "ac", "b" and "abcbabcbcb" are all happy strings and strings
 * "aa", "baa" and "ababbc" are not happy strings.
 * 
 * Given two integers n and k, consider a list of all happy strings of length n
 * sorted in lexicographical order.
 * 
 * Return the kth string of this list or return an empty string if there are
 * less than k happy strings of length n.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: n = 1, k = 3 Output: "c" Explanation: The list ["a", "b", "c"]
 * contains all happy strings of length 1. The third string is "c". Example 2:
 * 
 * Input: n = 1, k = 4 Output: "" Explanation: There are only 3 happy strings of
 * length 1. Example 3:
 * 
 * Input: n = 3, k = 9 Output: "cab" Explanation: There are 12 different happy
 * string of length 3 ["aba", "abc", "aca", "acb", "bab", "bac", "bca", "bcb",
 * "cab", "cac", "cba", "cbc"]. You will find the 9th string = "cab"
 * 
 * 
 * Constraints:
 * 
 * 1 <= n <= 10 1 <= k <= 100
 */