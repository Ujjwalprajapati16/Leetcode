
import java.util.ArrayList;
import java.util.List;


public class Partition_Labels {

    public List<Integer> partitionLabels(String str) {
        List<Integer> partitions = new ArrayList<>();
        for (int i = 0; i < str.length();) {
            int startIndex = i;
            int endIndex = str.lastIndexOf(str.charAt(startIndex));

            for (int s = startIndex + 1; s <= endIndex - 1; s++) {
                int lastIndexOfNextChar = str.lastIndexOf(str.charAt(s));
                if (lastIndexOfNextChar > endIndex) {
                    endIndex = lastIndexOfNextChar;
                }
            }

            partitions.add(endIndex - startIndex + 1);
            i = endIndex + 1;
        }

        return partitions;
    }

    public static void main(String[] args) {
        Partition_Labels pl = new Partition_Labels();
        List<Integer> result = pl.partitionLabels("ababcbacadefegdehijhklij");
        System.out.println(result); // [9, 7, 8]

        result = pl.partitionLabels("eccbbbbdec");
        System.out.println(result); // [10]
    }
}

/*763. Partition Labels
Solved
Medium
Topics
Companies
Hint
You are given a string s. We want to partition the string into as many parts as possible so that each letter appears in at most one part. For example, the string "ababcc" can be partitioned into ["abab", "cc"], but partitions such as ["aba", "bcc"] or ["ab", "ab", "cc"] are invalid.

Note that the partition is done so that after concatenating all the parts in order, the resultant string should be s.

Return a list of integers representing the size of these parts.

 

Example 1:

Input: s = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.
Example 2:

Input: s = "eccbbbbdec"
Output: [10]
 

Constraints:

1 <= s.length <= 500
s consists of lowercase English letters.
 */
