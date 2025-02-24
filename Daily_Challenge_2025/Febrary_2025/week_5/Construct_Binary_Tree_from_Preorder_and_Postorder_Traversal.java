import java.util.HashMap;

@SuppressWarnings("unused")
public class Construct_Binary_Tree_from_Preorder_and_Postorder_Traversal {

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

    HashMap<Integer, Integer> map = new HashMap<>();

    private TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n = postorder.length;
        for (int i = 0; i < n; i++) {
            map.put(postorder[i], i);
        }
        return recur(0, n - 1, 0, n - 1, preorder, postorder);
    }

    private TreeNode recur(int i1, int i2, int j1, int j2, int preorder[], int postorder[]) {
        if (i1 > i2 || j1 > j2) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[i1]);
        if (i1 == i2) {
            return root;
        }

        int r = map.get(preorder[i1 + 1]);
        int size = r - j1 + 1;
        root.left = recur(i1 + 1, i1 + size, j1, r, preorder, postorder);
        root.right = recur(i1 + size + 1, i2, r + 1, j2 - 1, preorder, postorder);
        return root;
    }

    private static void print(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + " ");
        print(node.left);
        print(node.right);
    }

    public static void main(String[] args) {
        Construct_Binary_Tree_from_Preorder_and_Postorder_Traversal main = new Construct_Binary_Tree_from_Preorder_and_Postorder_Traversal();
        int[] preorder = { 1, 2, 4, 5, 3, 6, 7 };
        int[] postorder = { 4, 5, 2, 6, 7, 3, 1 };
        TreeNode root = main.constructFromPrePost(preorder, postorder);
        print(root);
    }
}

/*
 * 889. Construct Binary Tree from Preorder and Postorder Traversal Solved
 * Medium Topics Companies Given two integer arrays, preorder and postorder
 * where preorder is the preorder traversal of a binary tree of distinct values
 * and postorder is the postorder traversal of the same tree, reconstruct and
 * return the binary tree.
 * 
 * If there exist multiple answers, you can return any of them.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: preorder = [1,2,4,5,3,6,7], postorder = [4,5,2,6,7,3,1] Output:
 * [1,2,3,4,5,6,7] Example 2:
 * 
 * Input: preorder = [1], postorder = [1] Output: [1]
 * 
 * 
 * Constraints:
 * 
 * 1 <= preorder.length <= 30 1 <= preorder[i] <= preorder.length All the values
 * of preorder are unique. postorder.length == preorder.length 1 <= postorder[i]
 * <= postorder.length All the values of postorder are unique. It is guaranteed
 * that preorder and postorder are the preorder traversal and postorder
 * traversal of the same binary tree.
 */