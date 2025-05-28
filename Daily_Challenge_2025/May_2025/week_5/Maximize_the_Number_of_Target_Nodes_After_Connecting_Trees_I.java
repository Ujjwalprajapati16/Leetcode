import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Maximize_the_Number_of_Target_Nodes_After_Connecting_Trees_I {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int n = edges1.length + 1;
        int m = edges2.length + 1;

        Map<Integer, List<Integer>> tree1 = buildTree(edges1, n);
        Map<Integer, List<Integer>> tree2 = buildTree(edges2, m);

        int[] result = new int[n];
        int maxTree2Reach = 0;

        for (int i = 0; i < m; i++) {
            maxTree2Reach = Math.max(maxTree2Reach, bfsCount(i, tree2, k - 1));
        }

        for (int i = 0; i < n; i++) {
            result[i] = bfsCount(i, tree1, k) + maxTree2Reach;
        }

        return result;
    }

    private Map<Integer, List<Integer>> buildTree(int[][] edges, int size) {
        Map<Integer, List<Integer>> tree = new HashMap<>();

        for (int i = 0; i < size; i++) {
            tree.put(i, new ArrayList<>());
        }

        for (int[] e : edges) {
            tree.get(e[0]).add(e[1]);
            tree.get(e[1]).add(e[0]);
        }

        return tree;
    }

    private int bfsCount(int start, Map<Integer, List<Integer>> tree, int maxDist) {
        if (maxDist < 0) {
            return 0;
        }

        boolean[] visited = new boolean[tree.size()];
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.offer(start);

        int count = 1, dist = 0;

        while (!queue.isEmpty() && dist++ < maxDist) {
            for (int i = queue.size(); i > 0; i--) {
                int curr = queue.poll();
                for (int neighbor : tree.get(curr)) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        queue.offer(neighbor);
                        count++;
                    }
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Maximize_the_Number_of_Target_Nodes_After_Connecting_Trees_I solution = new Maximize_the_Number_of_Target_Nodes_After_Connecting_Trees_I();
        int[][] edges1 = { { 0, 1 }, { 0, 2 }, { 2, 3 }, { 2, 4 } };
        int[][] edges2 = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 2, 7 }, { 1, 4 }, { 4, 5 }, { 4, 6 } };
        int k = 2;
        int[] result = solution.maxTargetNodes(edges1, edges2, k);

        for (int res : result) {
            System.out.print(res + " ");
        }

        // Output: [9, 7, 9, 8, 8]
    }
}

/*
 * 3372. Maximize the Number of Target Nodes After Connecting Trees I Solved
 * Medium Topics premium lock icon Companies Hint There exist two undirected
 * trees with n and m nodes, with distinct labels in ranges [0, n - 1] and [0, m
 * - 1], respectively.
 * 
 * You are given two 2D integer arrays edges1 and edges2 of lengths n - 1 and m
 * - 1, respectively, where edges1[i] = [ai, bi] indicates that there is an edge
 * between nodes ai and bi in the first tree and edges2[i] = [ui, vi] indicates
 * that there is an edge between nodes ui and vi in the second tree. You are
 * also given an integer k.
 * 
 * Node u is target to node v if the number of edges on the path from u to v is
 * less than or equal to k. Note that a node is always target to itself.
 * 
 * Return an array of n integers answer, where answer[i] is the maximum possible
 * number of nodes target to node i of the first tree if you have to connect one
 * node from the first tree to another node in the second tree.
 * 
 * Note that queries are independent from each other. That is, for every query
 * you will remove the added edge before proceeding to the next query.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: edges1 = [[0,1],[0,2],[2,3],[2,4]], edges2 =
 * [[0,1],[0,2],[0,3],[2,7],[1,4],[4,5],[4,6]], k = 2
 * 
 * Output: [9,7,9,8,8]
 * 
 * Explanation:
 * 
 * For i = 0, connect node 0 from the first tree to node 0 from the second tree.
 * For i = 1, connect node 1 from the first tree to node 0 from the second tree.
 * For i = 2, connect node 2 from the first tree to node 4 from the second tree.
 * For i = 3, connect node 3 from the first tree to node 4 from the second tree.
 * For i = 4, connect node 4 from the first tree to node 4 from the second tree.
 * 
 * Example 2:
 * 
 * Input: edges1 = [[0,1],[0,2],[0,3],[0,4]], edges2 = [[0,1],[1,2],[2,3]], k =
 * 1
 * 
 * Output: [6,3,3,3,3]
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
 * 2 <= n, m <= 1000 edges1.length == n - 1 edges2.length == m - 1
 * edges1[i].length == edges2[i].length == 2 edges1[i] = [ai, bi] 0 <= ai, bi <
 * n edges2[i] = [ui, vi] 0 <= ui, vi < m The input is generated such that
 * edges1 and edges2 represent valid trees. 0 <= k <= 1000
 */