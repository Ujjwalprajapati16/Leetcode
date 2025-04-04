public class Lowest_Common_Ancestor_of_Deepest_Leaves {
    public static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int item) {
            val = item;
            left = right = null;
        }
    }

    private int maxDepth;
    private TreeNode lca;

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        maxDepth = 0;
        dfs(root, 0);
        return lca;
    }

    private int dfs(TreeNode root, int currD) {
        maxDepth = Math.max(maxDepth, currD);
        if (root == null) {
            return currD;
        }

        int left = dfs(root.left, currD + 1);
        int right = dfs(root.right, currD + 1);

        if (left == maxDepth && right == maxDepth) {
            lca = root;
        }

        return Math.max(left, right);
    }

    public static void main(String[] args) {
        Lowest_Common_Ancestor_of_Deepest_Leaves obj = new Lowest_Common_Ancestor_of_Deepest_Leaves();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        TreeNode result = obj.lcaDeepestLeaves(root);
        System.out.println(result.val); // Output: 2
    }
}

/*
 * 1123. Lowest Common Ancestor of Deepest Leaves
 * Solved
 * Medium
 * Topics
 * Companies
 * Hint
 * Given the root of a binary tree, return the lowest common ancestor of its
 * deepest leaves.
 * 
 * Recall that:
 * 
 * The node of a binary tree is a leaf if and only if it has no children
 * The depth of the root of the tree is 0. if the depth of a node is d, the
 * depth of each of its children is d + 1.
 * The lowest common ancestor of a set S of nodes, is the node A with the
 * largest depth such that every node in S is in the subtree with root A.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4]
 * Output: [2,7,4]
 * Explanation: We return the node with value 2, colored in yellow in the
 * diagram.
 * The nodes coloured in blue are the deepest leaf-nodes of the tree.
 * Note that nodes 6, 0, and 8 are also leaf nodes, but the depth of them is 2,
 * but the depth of nodes 7 and 4 is 3.
 * Example 2:
 * 
 * Input: root = [1]
 * Output: [1]
 * Explanation: The root is the deepest node in the tree, and it's the lca of
 * itself.
 * Example 3:
 * 
 * Input: root = [0,1,3,null,2]
 * Output: [2]
 * Explanation: The deepest leaf node in the tree is 2, the lca of one node is
 * itself.
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the tree will be in the range [1, 1000].
 * 0 <= Node.val <= 1000
 * The values of the nodes in the tree are unique.
 * 
 * 
 * Note: This question is the same as 865:
 * https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/
 */