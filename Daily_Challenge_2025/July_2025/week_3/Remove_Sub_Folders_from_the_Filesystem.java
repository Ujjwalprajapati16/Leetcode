import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Remove_Sub_Folders_from_the_Filesystem {
    class TrieNode {
        TrieNode children[];
        boolean isLast;

        TrieNode() {
            children = new TrieNode[27];
            isLast = false;
        }
    }

    TrieNode root;

    public List<String> removeSubfolders(String[] folder) {
        root = new TrieNode();
        Arrays.sort(folder, (a, b) -> a.length() - b.length());
        List<String> ans = new ArrayList<>();
        for (String f : folder) {
            if (!search(f)) {
                insert(f);
                ans.add(f);
            }
        }
        return ans;
    }

    private int getIndex(char c) {
        return c == '/' ? 26 : c - 'a';
    }

    private void insert(String s) {
        TrieNode node = root;
        for (char c : s.toCharArray()) {
            int index = getIndex(c);
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.children[26] = new TrieNode();
        node = node.children[26];
        node.isLast = true;
    }

    private boolean search(String s) {
        TrieNode node = root;
        for (char c : s.toCharArray()) {
            if (node.isLast) {
                return true;
            }
            int index = getIndex(c);
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }
        return node.isLast;
    }

    public static void main(String[] args) {
        Remove_Sub_Folders_from_the_Filesystem solution = new Remove_Sub_Folders_from_the_Filesystem();
        String[] folder1 = { "/a", "/a/b", "/c/d", "/c/d/e", "/c/f" };
        System.out.println(solution.removeSubfolders(folder1)); // Output: ["/a", "/c/d", "/c/f"]

        String[] folder2 = { "/a", "/a/b/c", "/a/b/d" };
        System.out.println(solution.removeSubfolders(folder2)); // Output: ["/a"]

        String[] folder3 = { "/a/b/c", "/a/b/ca", "/a/b/d" };
        System.out.println(solution.removeSubfolders(folder3)); // Output: ["/a/b/c", "/a/b/ca", "/a/b/d"]
    }
}

/*
 * 1233. Remove Sub-Folders from the Filesystem Solved Medium Topics premium
 * lock icon Companies Hint Given a list of folders folder, return the folders
 * after removing all sub-folders in those folders. You may return the answer in
 * any order.
 * 
 * If a folder[i] is located within another folder[j], it is called a sub-folder
 * of it. A sub-folder of folder[j] must start with folder[j], followed by a
 * "/". For example, "/a/b" is a sub-folder of "/a", but "/b" is not a
 * sub-folder of "/a/b/c".
 * 
 * The format of a path is one or more concatenated strings of the form: '/'
 * followed by one or more lowercase English letters.
 * 
 * For example, "/leetcode" and "/leetcode/problems" are valid paths while an
 * empty string and "/" are not.
 * 
 * 
 * Example 1:
 * 
 * Input: folder = ["/a","/a/b","/c/d","/c/d/e","/c/f"] Output:
 * ["/a","/c/d","/c/f"] Explanation: Folders "/a/b" is a subfolder of "/a" and
 * "/c/d/e" is inside of folder "/c/d" in our filesystem. Example 2:
 * 
 * Input: folder = ["/a","/a/b/c","/a/b/d"] Output: ["/a"] Explanation: Folders
 * "/a/b/c" and "/a/b/d" will be removed because they are subfolders of "/a".
 * Example 3:
 * 
 * Input: folder = ["/a/b/c","/a/b/ca","/a/b/d"] Output:
 * ["/a/b/c","/a/b/ca","/a/b/d"]
 * 
 * 
 * Constraints:
 * 
 * 1 <= folder.length <= 4 * 104 2 <= folder[i].length <= 100 folder[i] contains
 * only lowercase letters and '/'. folder[i] always starts with the character
 * '/'. Each folder name is unique.
 */