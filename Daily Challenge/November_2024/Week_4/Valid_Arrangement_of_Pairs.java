
import java.util.*;

public class Valid_Arrangement_of_Pairs {

    private void dfs(Map<Integer, Stack<Integer>> graph, List<int[]> result, int node) {
        // Get the stack of neighbors for the current node or an empty stack if none exist
        Stack<Integer> stack = graph.getOrDefault(node, new Stack<>());
        while (!stack.isEmpty()) {
            int neighbor = stack.pop(); // Visit the next node in the stack
            dfs(graph, result, neighbor); // Recursively perform DFS
            result.add(new int[]{node, neighbor}); // Add the edge to the result list
        }
    }

    public int[][] validArrangement(int[][] pairs) {
        // Graph representation: Map from node to a stack of neighbors
        Map<Integer, Stack<Integer>> graph = new HashMap<>();
        // Track the in-degree and out-degree of each node
        Map<Integer, Integer> inDegree = new HashMap<>();
        Map<Integer, Integer> outDegree = new HashMap<>();

        // Build the graph and calculate degrees
        for (int[] pair : pairs) {
            int u = pair[0], v = pair[1];
            // Add edge u -> v to the graph
            graph.computeIfAbsent(u, k -> new Stack<>()).push(v);
            // Update out-degree and in-degree
            outDegree.put(u, outDegree.getOrDefault(u, 0) + 1);
            inDegree.put(v, inDegree.getOrDefault(v, 0) + 1);
        }

        // Determine the start node:
        // Find a node with out-degree - in-degree == 1 (if exists), otherwise pick any node
        int startNode = graph.keySet().stream()
                .filter(node -> outDegree.getOrDefault(node, 0) - inDegree.getOrDefault(node, 0) == 1)
                .findFirst()
                .orElse(graph.keySet().iterator().next()); // Default to any node in the graph

        // List to store the valid arrangement
        List<int[]> result = new ArrayList<>();
        // Perform DFS starting from the determined start node
        dfs(graph, result, startNode);

        // Reverse the result because edges are added in post-order during DFS
        Collections.reverse(result);

        // Convert the result list to a 2D array and return
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        Valid_Arrangement_of_Pairs solution = new Valid_Arrangement_of_Pairs();

        int[][] pairs1 = {{5, 1}, {4, 5}, {11, 9}, {9, 4}};
        int[][] result1 = solution.validArrangement(pairs1);

        int[][] pairs2 = {{1, 3}, {3, 2}, {2, 1}};
        int[][] result2 = solution.validArrangement(pairs2);

        int[][] pairs3 = {{1, 2}, {2, 3}, {3, 1}};
        int[][] result3 = solution.validArrangement(pairs3);

        // Print the results
        for (int[] result11 : result1) {
            System.out.println(Arrays.toString(result11));
        }
        for (int[] result21 : result2) {
            System.out.println(Arrays.toString(result21));
        }
        for (int[] result31 : result3) {
            System.out.println(Arrays.toString(result31));
        }

    }
}

/*
 * 
 * 2097. Valid Arrangement of Pairs
Solved
Hard
Topics
Companies
Hint
You are given a 0-indexed 2D integer array pairs where pairs[i] = [starti, endi]. An arrangement of pairs is valid if for every index i where 1 <= i < pairs.length, we have endi-1 == starti.

Return any valid arrangement of pairs.

Note: The inputs will be generated such that there exists a valid arrangement of pairs.

 

Example 1:

Input: pairs = [[5,1],[4,5],[11,9],[9,4]]
Output: [[11,9],[9,4],[4,5],[5,1]]
Explanation:
This is a valid arrangement since endi-1 always equals starti.
end0 = 9 == 9 = start1 
end1 = 4 == 4 = start2
end2 = 5 == 5 = start3
Example 2:

Input: pairs = [[1,3],[3,2],[2,1]]
Output: [[1,3],[3,2],[2,1]]
Explanation:
This is a valid arrangement since endi-1 always equals starti.
end0 = 3 == 3 = start1
end1 = 2 == 2 = start2
The arrangements [[2,1],[1,3],[3,2]] and [[3,2],[2,1],[1,3]] are also valid.
Example 3:

Input: pairs = [[1,2],[1,3],[2,1]]
Output: [[1,2],[2,1],[1,3]]
Explanation:
This is a valid arrangement since endi-1 always equals starti.
end0 = 2 == 2 = start1
end1 = 1 == 1 = start2
 

Constraints:

1 <= pairs.length <= 105
pairs[i].length == 2
0 <= starti, endi <= 109
starti != endi
No two pairs are exactly the same.
There exists a valid arrangement of pairs.
 */
