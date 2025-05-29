import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Maximize_the_Number_of_Target_Nodes_After_Connecting_Trees_II {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
        int n = edges1.length + 1;
        int m = edges2.length + 1;

        List<List<Integer>> tree1 = buildTree(n, edges1);
        List<List<Integer>> tree2 = buildTree(m, edges2);

        int[] depth1 = bfsDepth(tree1, 0);
        int[] depth2 = bfsDepth(tree2, 0);

        int[] parity1 = countParity(depth1);
        int[] parity2 = countParity(depth2);

        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            if (depth1[i] % 2 == 0) {
                answer[i] = parity1[0] + Math.max(parity2[0], parity2[1]);
            } else {
                answer[i] = parity1[1] + Math.max(parity2[0], parity2[1]);
            }
        }

        return answer;
    }

    private List<List<Integer>> buildTree(int size, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        return graph;
    }

    private int[] bfsDepth(List<List<Integer>> tree, int root) {
        int[] depth = new int[tree.size()];
        Arrays.fill(depth, -1);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(root);
        depth[root] = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : tree.get(node)) {
                if (depth[neighbor] == -1) {
                    depth[neighbor] = depth[node] + 1;
                    queue.offer(neighbor);
                }
            }
        }

        return depth;
    }

    private int[] countParity(int[] depth) {
        int[] count = new int[2];
        for (int d : depth) {
            count[d % 2]++;
        }
        return count;
    }

    public static void main(String[] args) {
        Maximize_the_Number_of_Target_Nodes_After_Connecting_Trees_II solution = new Maximize_the_Number_of_Target_Nodes_After_Connecting_Trees_II();

        // Example test cases
        int[][] edges1 = { { 0, 1 }, { 0, 2 }, { 2, 3 }, { 2, 4 } };
        int[][] edges2 = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 2, 7 }, { 1, 4 }, { 4, 5 }, { 4, 6 } };
        System.out.println(Arrays.toString(solution.maxTargetNodes(edges1, edges2))); // Output: [8, 7, 7, 8, 8]

        int[][] edges3 = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 0, 4 } };
        int[][] edges4 = { { 0, 1 }, { 1, 2 }, { 2, 3 } };
        System.out.println(Arrays.toString(solution.maxTargetNodes(edges3, edges4))); // Output: [3, 6, 6, 6, 6]
    }
}

/*
 * 3373. Maximize the Number of Target Nodes After Connecting Trees II Solved
 * Hard Topics premium lock icon Companies Hint There exist two undirected trees
 * with n and m nodes, labeled from [0, n - 1] and [0, m - 1], respectively.
 * 
 * You are given two 2D integer arrays edges1 and edges2 of lengths n - 1 and m
 * - 1, respectively, where edges1[i] = [ai, bi] indicates that there is an edge
 * between nodes ai and bi in the first tree and edges2[i] = [ui, vi] indicates
 * that there is an edge between nodes ui and vi in the second tree.
 * 
 * Node u is target to node v if the number of edges on the path from u to v is
 * even. Note that a node is always target to itself.
 * 
 * Return an array of n integers answer, where answer[i] is the maximum possible
 * number of nodes that are target to node i of the first tree if you had to
 * connect one node from the first tree to another node in the second tree.
 * 
 * Note that queries are independent from each other. That is, for every query
 * you will remove the added edge before proceeding to the next query.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: edges1 = [[0,1],[0,2],[2,3],[2,4]], edges2 =
 * [[0,1],[0,2],[0,3],[2,7],[1,4],[4,5],[4,6]]
 * 
 * Output: [8,7,7,8,8]
 * 
 * Explanation:
 * 
 * For i = 0, connect node 0 from the first tree to node 0 from the second tree.
 * For i = 1, connect node 1 from the first tree to node 4 from the second tree.
 * For i = 2, connect node 2 from the first tree to node 7 from the second tree.
 * For i = 3, connect node 3 from the first tree to node 0 from the second tree.
 * For i = 4, connect node 4 from the first tree to node 4 from the second tree.
 * 
 * Example 2:
 * 
 * Input: edges1 = [[0,1],[0,2],[0,3],[0,4]], edges2 = [[0,1],[1,2],[2,3]]
 * 
 * Output: [3,6,6,6,6]
 * 
 * Explanation:
 * 
 * For every i, connect node i of the first tree with any node of the second
 * tree.
 * 
 * 
 * 
 * 
 * Constraints:
 * 
 * 2 <= n, m <= 105 edges1.length == n - 1 edges2.length == m - 1
 * edges1[i].length == edges2[i].length == 2 edges1[i] = [ai, bi] 0 <= ai, bi <
 * n edges2[i] = [ui, vi] 0 <= ui, vi < m The input is generated such that
 * edges1 and edges2 represent valid trees.
 */