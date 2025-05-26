import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Largest_Color_Value_in_a_Directed_Graph {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        int[] indegree = new int[n];
        int[][] colorCounts = new int[n][26];
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            int x = edge[0], y = edge[1];
            graph.get(x).add(y);
            indegree[y]++;
        }

        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
                colorCounts[i][colors.charAt(i) - 'a'] = 1;
            }
        }

        int visited = 0;
        int maxColorCount = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            visited++;

            for (int neighbor : graph.get(node)) {
                for (int c = 0; c < 26; c++) {
                    colorCounts[neighbor][c] = Math.max(colorCounts[neighbor][c], colorCounts[node][c]);
                }

                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    int colorIndex = colors.charAt(neighbor) - 'a';
                    colorCounts[neighbor][colorIndex]++;
                    queue.offer(neighbor);
                }
            }

            for (int c = 0; c < 26; c++) {
                maxColorCount = Math.max(maxColorCount, colorCounts[node][c]);
            }
        }

        return (visited == n) ? maxColorCount : -1;
    }

    public static void main(String[] args) {
        Largest_Color_Value_in_a_Directed_Graph obj = new Largest_Color_Value_in_a_Directed_Graph();
        System.out.println(obj.largestPathValue("abaca", new int[][] { { 0, 1 }, { 0, 2 }, { 2, 3 }, { 3, 4 } })); // 3
        System.out.println(obj.largestPathValue("a", new int[][] { { 0, 0 } })); // -1
    }
}

/*
 * 1857. Largest Color Value in a Directed Graph Solved Hard Topics Companies
 * Hint There is a directed graph of n colored nodes and m edges. The nodes are
 * numbered from 0 to n - 1.
 * 
 * You are given a string colors where colors[i] is a lowercase English letter
 * representing the color of the ith node in this graph (0-indexed). You are
 * also given a 2D array edges where edges[j] = [aj, bj] indicates that there is
 * a directed edge from node aj to node bj.
 * 
 * A valid path in the graph is a sequence of nodes x1 -> x2 -> x3 -> ... -> xk
 * such that there is a directed edge from xi to xi+1 for every 1 <= i < k. The
 * color value of the path is the number of nodes that are colored the most
 * frequently occurring color along that path.
 * 
 * Return the largest color value of any valid path in the given graph, or -1 if
 * the graph contains a cycle.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * Input: colors = "abaca", edges = [[0,1],[0,2],[2,3],[3,4]] Output: 3
 * Explanation: The path 0 -> 2 -> 3 -> 4 contains 3 nodes that are colored "a"
 * (red in the above image). 
 * 
 * Example 2:
 * 
 * Input: colors = "a", edges = [[0,0]] Output: -1 Explanation: There is a cycle
 * from 0 to 0.
 * 
 * 
 * Constraints:
 * 
 * n == colors.length m == edges.length 1 <= n <= 105 0 <= m <= 105 colors
 * consists of lowercase English letters. 0 <= aj, bj < n
 */