import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Group_Anagrams {
    private String getFrequencyString(String str) {
        int[] freq = new int[26];

        for (char c : str.toCharArray()) {
            freq[c - 'a']++;
        }

        StringBuilder frequencyString = new StringBuilder("");
        char c = 'a';
        for (int i : freq) {
            frequencyString.append(c);
            frequencyString.append(i);
            c++;
        }

        return frequencyString.toString();
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> frequencyStringMap = new HashMap<>();

        for (String str : strs) {
            String frequencyString = getFrequencyString(str);

            if (frequencyStringMap.containsKey(frequencyString)) {
                frequencyStringMap.get(frequencyString).add(str);
            } else {
                List<String> strList = new ArrayList<>();
                strList.add(str);
                frequencyStringMap.put(frequencyString, strList);
            }
        }

        return new ArrayList<>(frequencyStringMap.values());
    }
    public static void main(String[] args) {
        Group_Anagrams obj = new Group_Anagrams();
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> result = obj.groupAnagrams(strs);
        for (List<String> list : result) {
            System.out.print(list);
        }
        System.out.println();

        strs = new String[]{""};
        result = obj.groupAnagrams(strs);
        for (List<String> list : result) {
            System.out.print(list);
        }
        System.out.println();

        strs = new String[]{"a"};
        result = obj.groupAnagrams(strs);
        for (List<String> list : result) {
            System.out.print(list);
        }
    }
}

/*49. Group Anagrams
Solved
Medium
Topics
Companies
Given an array of strings strs, group the 
anagrams
 together. You can return the answer in any order.

 

Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]

Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Explanation:

There is no string in strs that can be rearranged to form "bat".
The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.
Example 2:

Input: strs = [""]

Output: [[""]]

Example 3:

Input: strs = ["a"]

Output: [["a"]]

 

Constraints:

1 <= strs.length <= 104
0 <= strs[i].length <= 100
strs[i] consists of lowercase English letters. */