public class Lexicographically_Smallest_Equivalent_String {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int[] parent = new int[26];
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < s1.length(); i++) {
            int a = s1.charAt(i) - 'a';
            int b = s2.charAt(i) - 'a';
            union(parent, a, b);
        }

        StringBuilder result = new StringBuilder();
        for (char ch : baseStr.toCharArray()) {
            result.append((char) (find(parent, ch - 'a') + 'a'));
        }

        return result.toString();
    }

    private int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }

    private void union(int[] parent, int x, int y) {
        int rootX = find(parent, x);
        int rootY = find(parent, y);
        if (rootX < rootY) {
            parent[rootY] = rootX;
        } else {
            parent[rootX] = rootY;
        }
    }

    public static void main(String[] args) {
        Lexicographically_Smallest_Equivalent_String solution = new Lexicographically_Smallest_Equivalent_String();
        System.out.println(solution.smallestEquivalentString("parker", "morris", "parser")); // Output: "makkek"
        System.out.println(solution.smallestEquivalentString("hello", "world", "hold")); // Output: "hdld"
        System.out.println(solution.smallestEquivalentString("leetcode", "programs", "sourcecode")); // Output:
                                                                                                     // "aauaaaaada"
    }
}

/*
 * 1061. Lexicographically Smallest Equivalent String
 * Solved
 * Medium
 * Topics
 * premium lock icon
 * Companies
 * Hint
 * You are given two strings of the same length s1 and s2 and a string baseStr.
 * 
 * We say s1[i] and s2[i] are equivalent characters.
 * 
 * For example, if s1 = "abc" and s2 = "cde", then we have 'a' == 'c', 'b' ==
 * 'd', and 'c' == 'e'.
 * Equivalent characters follow the usual rules of any equivalence relation:
 * 
 * Reflexivity: 'a' == 'a'.
 * Symmetry: 'a' == 'b' implies 'b' == 'a'.
 * Transitivity: 'a' == 'b' and 'b' == 'c' implies 'a' == 'c'.
 * For example, given the equivalency information from s1 = "abc" and s2 =
 * "cde", "acd" and "aab" are equivalent strings of baseStr = "eed", and "aab"
 * is the lexicographically smallest equivalent string of baseStr.
 * 
 * Return the lexicographically smallest equivalent string of baseStr by using
 * the equivalency information from s1 and s2.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s1 = "parker", s2 = "morris", baseStr = "parser"
 * Output: "makkek"
 * Explanation: Based on the equivalency information in s1 and s2, we can group
 * their characters as [m,p], [a,o], [k,r,s], [e,i].
 * The characters in each group are equivalent and sorted in lexicographical
 * order.
 * So the answer is "makkek".
 * Example 2:
 * 
 * Input: s1 = "hello", s2 = "world", baseStr = "hold"
 * Output: "hdld"
 * Explanation: Based on the equivalency information in s1 and s2, we can group
 * their characters as [h,w], [d,e,o], [l,r].
 * So only the second letter 'o' in baseStr is changed to 'd', the answer is
 * "hdld".
 * Example 3:
 * 
 * Input: s1 = "leetcode", s2 = "programs", baseStr = "sourcecode"
 * Output: "aauaaaaada"
 * Explanation: We group the equivalent characters in s1 and s2 as
 * [a,o,e,r,s,c], [l,p], [g,t] and [d,m], thus all letters in baseStr except 'u'
 * and 'd' are transformed to 'a', the answer is "aauaaaaada".
 * 
 * 
 * Constraints:
 * 
 * 1 <= s1.length, s2.length, baseStr <= 1000
 * s1.length == s2.length
 * s1, s2, and baseStr consist of lowercase English letters.
 */