import java.util.Stack;

@SuppressWarnings("unused")
public class Recover_a_Tree_From_Preorder_Traversal {
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

    int index = 0;
    int n = 0;

    private TreeNode recoverFromPreorder(String traversal) {
        n = traversal.length();
        return recur(traversal);
    }

    private TreeNode recur(String traversal) {
        Stack<TreeNode> stack = new Stack<>();
        while (index < n) {
            int count = 0;
            while (index < n && !Character.isDigit(traversal.charAt(index))) {
                count++;
                index++;
            }
            int depth = stack.size();
            while (depth > count) {
                stack.pop();
                depth--;
            }

            // find the number
            int val = 0;
            while (index < n && Character.isDigit(traversal.charAt(index))) {
                val = val * 10 + (traversal.charAt(index) - '0');
                index++;
            }

            TreeNode node = new TreeNode(val);
            if (!stack.isEmpty()) {
                if (stack.peek().left == null) {
                    stack.peek().left = node;
                } else {
                    stack.peek().right = node;
                }
            }

            stack.push(node);
        }

        while (stack.size() > 1) {
            stack.pop();
        }

        return stack.peek();
    }

    private void printTree(TreeNode node) {
        if (node == null)
            return;
        System.out.print(node.val + " -> ");
        printTree(node.left);
        printTree(node.right);
    }

    public static void main(String[] args) {
        Recover_a_Tree_From_Preorder_Traversal sol = new Recover_a_Tree_From_Preorder_Traversal();
        TreeNode root = sol.recoverFromPreorder("1-2--3--4-5--6--7");
        sol.printTree(root);
        System.out.println("\n---");
        root = sol.recoverFromPreorder("1-401--349---90--88");
        sol.printTree(root);
    }
}

/*
 * 1028. Recover a Tree From Preorder Traversal Solved Hard Topics Companies
 * Hint We run a preorder depth-first search (DFS) on the root of a binary tree.
 * 
 * At each node in this traversal, we output D dashes (where D is the depth of
 * this node), then we output the value of this node. If the depth of a node is
 * D, the depth of its immediate child is D + 1. The depth of the root node is
 * 0.
 * 
 * If a node has only one child, that child is guaranteed to be the left child.
 * 
 * Given the output traversal of this traversal, recover the tree and return its
 * root.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: traversal = "1-2--3--4-5--6--7" Output: [1,2,5,3,4,6,7] Example 2:
 * 
 * 
 * Input: traversal = "1-2--3---4-5--6---7" Output:
 * [1,2,5,3,null,6,null,4,null,7] Example 3:
 * 
 * 
 * Input: traversal = "1-401--349---90--88" Output: [1,401,null,349,88,90]
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the original tree is in the range [1, 1000]. 1 <=
 * Node.val <= 109
 */