public class Check_if_One_String_Swap_Can_Make_Strings_Equal {
    public boolean areAlmostEqual(String s1, String s2) {
        int count = 0;
        int i = 0;
        int j = 0;
        int n = s1.length();

        for (int p = 0; p < n; p++) {
            if (s1.charAt(p) != s2.charAt(p)) {
                count++;
                if (count > 2) {
                    return false;
                } else {
                    if (count == 1) {
                        i = p;
                    } else {
                        j = p;
                    }
                }
            }
        }

        return (s1.charAt(i) == s2.charAt(j) && s2.charAt(i) == s1.charAt(j));
    }

    public static void main(String[] args) {
        Check_if_One_String_Swap_Can_Make_Strings_Equal obj = new Check_if_One_String_Swap_Can_Make_Strings_Equal();
        String s1 = "bank";
        String s2 = "kanb";
        System.out.println(obj.areAlmostEqual(s1, s2));

        String s3 = "attack";
        String s4 = "defend";
        System.out.println(obj.areAlmostEqual(s3, s4));

        String s5 = "kelb";
        String s6 = "kelb";
        System.out.println(obj.areAlmostEqual(s5, s6));
    }
}

/*
 * 1790. Check if One String Swap Can Make Strings Equal Solved Easy Topics
 * Companies Hint You are given two strings s1 and s2 of equal length. A string
 * swap is an operation where you choose two indices in a string (not
 * necessarily different) and swap the characters at these indices.
 * 
 * Return true if it is possible to make both strings equal by performing at
 * most one string swap on exactly one of the strings. Otherwise, return false.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s1 = "bank", s2 = "kanb" Output: true Explanation: For example, swap
 * the first character with the last character of s2 to make "bank". Example 2:
 * 
 * Input: s1 = "attack", s2 = "defend" Output: false Explanation: It is
 * impossible to make them equal with one string swap. Example 3:
 * 
 * Input: s1 = "kelb", s2 = "kelb" Output: true Explanation: The two strings are
 * already equal, so no string swap operation is required.
 * 
 * 
 * Constraints:
 * 
 * 1 <= s1.length, s2.length <= 100 s1.length == s2.length s1 and s2 consist of
 * only lowercase English letters.
 */