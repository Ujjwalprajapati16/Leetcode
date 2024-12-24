import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Find_Minimum_Diameter_After_Merging_Two_Trees {
    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        int[] tree1 = findMinHeight(edges1.length + 1, edges1);
        int[] tree2 = findMinHeight(edges2.length + 1, edges2);
        return Math.max(Math.max(tree1[1], tree2[1]), tree1[0] + tree2[0] + 1);
    }

    public int[] findMinHeight(int n, int[][] edges) {
        if (n <= 2) {
            return new int[] { n - 1, n - 1 };
        }
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        int[] degree = new int[n];
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            degree[edge[0]] += 1;
            adj.get(edge[1]).add(edge[0]);
            degree[edge[1]] += 1;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                q.add(i);
            }
        }
        int height = 0, lastLevelSize = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int curr = q.remove();
                for (int nbr : adj.get(curr)) {
                    degree[nbr] -= 1;
                    if (degree[nbr] == 1) {
                        q.add(nbr);
                    }
                }
            }
            lastLevelSize = size;
            height += 1;
        }
        height -= 1;
        int diam = 2 * height;
        if (lastLevelSize > 1) {
            height += 1;
            diam += 1;
        }

        return new int[] { height, diam };
    }

    public static void main(String[] args) {
        Find_Minimum_Diameter_After_Merging_Two_Trees solution = new Find_Minimum_Diameter_After_Merging_Two_Trees();
        int[][] edges1 = { { 0, 1 }, { 0, 2 }, { 0, 3 } };
        int[][] edges2 = { { 0, 1 } };
        System.out.println(solution.minimumDiameterAfterMerge(edges1, edges2));

        int[][] edges3 = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 2, 4 }, { 2, 5 }, { 3, 6 }, { 2, 7 } };
        int[][] edges4 = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 2, 4 }, { 2, 5 }, { 3, 6 }, { 2, 7 } };
        System.out.println(solution.minimumDiameterAfterMerge(edges3, edges4));
    }
}

/*
 * 3203. Find Minimum Diameter After Merging Two Trees Solved Hard Topics
 * Companies Hint There exist two undirected trees with n and m nodes, numbered
 * from 0 to n - 1 and from 0 to m - 1, respectively. You are given two 2D
 * integer arrays edges1 and edges2 of lengths n - 1 and m - 1, respectively,
 * where edges1[i] = [ai, bi] indicates that there is an edge between nodes ai
 * and bi in the first tree and edges2[i] = [ui, vi] indicates that there is an
 * edge between nodes ui and vi in the second tree.
 * 
 * You must connect one node from the first tree with another node from the
 * second tree with an edge.
 * 
 * Return the minimum possible diameter of the resulting tree.
 * 
 * The diameter of a tree is the length of the longest path between any two
 * nodes in the tree.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: edges1 = [[0,1],[0,2],[0,3]], edges2 = [[0,1]]
 * 
 * Output: 3
 * 
 * Explanation:
 * 
 * We can obtain a tree of diameter 3 by connecting node 0 from the first tree
 * with any node from the second tree.
 * 
 * Example 2:
 * 
 * 
 * Input: edges1 = [[0,1],[0,2],[0,3],[2,4],[2,5],[3,6],[2,7]], edges2 =
 * [[0,1],[0,2],[0,3],[2,4],[2,5],[3,6],[2,7]]
 * 
 * Output: 5
 * 
 * Explanation:
 * 
 * We can obtain a tree of diameter 5 by connecting node 0 from the first tree
 * with node 0 from the second tree.
 * 
 * 
 * 
 * Constraints:
 * 
 * 1 <= n, m <= 105 edges1.length == n - 1 edges2.length == m - 1
 * edges1[i].length == edges2[i].length == 2 edges1[i] = [ai, bi] 0 <= ai, bi <
 * n edges2[i] = [ui, vi] 0 <= ui, vi < m The input is generated such that
 * edges1 and edges2 represent valid trees.
 */