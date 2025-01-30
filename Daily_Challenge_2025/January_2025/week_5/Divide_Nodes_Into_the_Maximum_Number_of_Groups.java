import java.util.*;

public class Divide_Nodes_Into_the_Maximum_Number_of_Groups {
    public int magnificentSets(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjList.get(edge[0] - 1).add(edge[1] - 1);
            adjList.get(edge[1] - 1).add(edge[0] - 1);
        }

        int[] colors = new int[n];
        for (int node = 0; node < n; node++) {
            if (colors[node] == 0 && !isBipartite(adjList, node, colors)) {
                return -1;
            }
        }

        int[] distances = new int[n];
        for (int node = 0; node < n; node++) {
            distances[node] = getLongestLength(adjList, node, n);
        }

        int maxNumberOfGroups = 0;
        boolean[] visited = new boolean[n];
        for (int node = 0; node < n; node++) {
            if (!visited[node]) {
                maxNumberOfGroups += getNumberOfGroupsForComponent(adjList, node, distances, visited);
            }
        }

        return maxNumberOfGroups;
    }

    private boolean isBipartite(ArrayList<ArrayList<Integer>> adjList, int node, int[] colors) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        colors[node] = 1; // Start with one color

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int neighbor : adjList.get(current)) {
                if (colors[neighbor] == colors[current]) {
                    return false;
                }
                if (colors[neighbor] == 0) {
                    colors[neighbor] = -colors[current];
                    queue.add(neighbor);
                }
            }
        }
        return true;
    }

    private int getLongestLength(ArrayList<ArrayList<Integer>> adjList, int node, int n) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        queue.add(node);
        visited[node] = true;
        int distance = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                for (int neighbor : adjList.get(current)) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        queue.add(neighbor);
                    }
                }
            }
            distance++;
        }

        return distance;
    }

    private int getNumberOfGroupsForComponent(ArrayList<ArrayList<Integer>> adjList, int node, int[] distances, boolean[] visited) {
        int maxNumberOfGroups = distances[node];
        visited[node] = true;

        for (int neighbor : adjList.get(node)) {
            if (!visited[neighbor]) {
                maxNumberOfGroups = Math.max(maxNumberOfGroups, getNumberOfGroupsForComponent(adjList, neighbor, distances, visited));
            }
        }

        return maxNumberOfGroups;
    }

    public static void main(String[] args) {
        Divide_Nodes_Into_the_Maximum_Number_of_Groups solution = new Divide_Nodes_Into_the_Maximum_Number_of_Groups();
        int n = 6;
        int[][] edges = {{1, 2}, {1, 4}, {1, 5}, {2, 6}, {2, 3}, {4, 6}};
        int result = solution.magnificentSets(n, edges);
        System.out.println(result); // Output: 4

        n = 3;
        edges = new int[][]{{1, 2}, {2, 3}, {3, 1}};
        result = solution.magnificentSets(n, edges);
        System.out.println(result); // Output: -1
    }
}

/*2493. Divide Nodes Into the Maximum Number of Groups
Solved
Hard
Topics
Companies
Hint
You are given a positive integer n representing the number of nodes in an undirected graph. The nodes are labeled from 1 to n.

You are also given a 2D integer array edges, where edges[i] = [ai, bi] indicates that there is a bidirectional edge between nodes ai and bi. Notice that the given graph may be disconnected.

Divide the nodes of the graph into m groups (1-indexed) such that:

Each node in the graph belongs to exactly one group.
For every pair of nodes in the graph that are connected by an edge [ai, bi], if ai belongs to the group with index x, and bi belongs to the group with index y, then |y - x| = 1.
Return the maximum number of groups (i.e., maximum m) into which you can divide the nodes. Return -1 if it is impossible to group the nodes with the given conditions.

 

Example 1:


Input: n = 6, edges = [[1,2],[1,4],[1,5],[2,6],[2,3],[4,6]]
Output: 4
Explanation: As shown in the image we:
- Add node 5 to the first group.
- Add node 1 to the second group.
- Add nodes 2 and 4 to the third group.
- Add nodes 3 and 6 to the fourth group.
We can see that every edge is satisfied.
It can be shown that that if we create a fifth group and move any node from the third or fourth group to it, at least on of the edges will not be satisfied.
Example 2:

Input: n = 3, edges = [[1,2],[2,3],[3,1]]
Output: -1
Explanation: If we add node 1 to the first group, node 2 to the second group, and node 3 to the third group to satisfy the first two edges, we can see that the third edge will not be satisfied.
It can be shown that no grouping is possible.
 

Constraints:

1 <= n <= 500
1 <= edges.length <= 104
edges[i].length == 2
1 <= ai, bi <= n
ai != bi
There is at most one edge between any pair of vertices. */