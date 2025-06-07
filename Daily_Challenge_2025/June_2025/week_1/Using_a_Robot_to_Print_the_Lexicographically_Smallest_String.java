public class Using_a_Robot_to_Print_the_Lexicographically_Smallest_String {
    public String robotWithString(String s) {
        int[] charCounts = new int[26];

        for (int i = 0; i < s.length(); i++) {
            charCounts[s.charAt(i) - 'a']++;
        }

        StringBuilder result = new StringBuilder();
        StringBuilder stack = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            charCounts[currentChar - 'a']--;
            stack.append(currentChar);

            while (!stack.isEmpty()) {
                char topChar = stack.charAt(stack.length() - 1);
                int topIndex = topChar - 'a';

                boolean hasSmaller = false;
                for (int j = 0; j < topIndex; j++) {
                    if (charCounts[j] > 0) {
                        hasSmaller = true;
                        break;
                    }
                }

                if (hasSmaller) {
                    break;
                }

                result.append(topChar);
                stack.deleteCharAt(stack.length() - 1);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Using_a_Robot_to_Print_the_Lexicographically_Smallest_String solution = new Using_a_Robot_to_Print_the_Lexicographically_Smallest_String();
        System.out.println(solution.robotWithString("zza")); // Output: "azz"
        System.out.println(solution.robotWithString("bac")); // Output: "abc"
        System.out.println(solution.robotWithString("bdda")); // Output: "addb"
    }
}

/*
 * 2434. Using a Robot to Print the Lexicographically Smallest String Solved
 * Medium Topics premium lock icon Companies Hint You are given a string s and a
 * robot that currently holds an empty string t. Apply one of the following
 * operations until s and t are both empty:
 * 
 * Remove the first character of a string s and give it to the robot. The robot
 * will append this character to the string t. Remove the last character of a
 * string t and give it to the robot. The robot will write this character on
 * paper. Return the lexicographically smallest string that can be written on
 * the paper.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "zza" Output: "azz" Explanation: Let p denote the written string.
 * Initially p="", s="zza", t="". Perform first operation three times p="",
 * s="", t="zza". Perform second operation three times p="azz", s="", t="".
 * Example 2:
 * 
 * Input: s = "bac" Output: "abc" Explanation: Let p denote the written string.
 * Perform first operation twice p="", s="c", t="ba". Perform second operation
 * twice p="ab", s="c", t="". Perform first operation p="ab", s="", t="c".
 * Perform second operation p="abc", s="", t="". Example 3:
 * 
 * Input: s = "bdda" Output: "addb" Explanation: Let p denote the written
 * string. Initially p="", s="bdda", t="". Perform first operation four times
 * p="", s="", t="bdda". Perform second operation four times p="addb", s="",
 * t="".
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 105 s consists of only English lowercase letters.
 */