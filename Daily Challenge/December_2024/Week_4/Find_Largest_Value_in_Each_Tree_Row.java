import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Find_Largest_Value_in_Each_Tree_Row {
    // Definition for a binary tree node.
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.remove();
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
                max = Math.max(max, curr.val);
            }
            ans.add(max);
        }

        return ans;
    }

    public static void main(String[] args) {
        Find_Largest_Value_in_Each_Tree_Row solution = new Find_Largest_Value_in_Each_Tree_Row();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);
        List<Integer> result = solution.largestValues(root);
        System.out.println(result);
    }
}

/*
 * 515. Find Largest Value in Each Tree Row Solved Medium Topics Companies Given
 * the root of a binary tree, return an array of the largest value in each row
 * of the tree (0-indexed).
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [1,3,2,5,3,null,9] Output: [1,3,9] Example 2:
 * 
 * Input: root = [1,2,3] Output: [1,3]
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the tree will be in the range [0, 104]. -231 <=
 * Node.val <= 231 - 1
 */