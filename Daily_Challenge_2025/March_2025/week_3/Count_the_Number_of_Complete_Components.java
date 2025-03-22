
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class DSU {

    int[] parent;
    int[] size;

    DSU(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        Arrays.fill(size, 1);
    }

    int find(int node) {
        if (parent[node] == node) {
            return node;
        }
        parent[node] = find(parent[node]);
        return parent[node];
    }

    void union(int node1, int node2) {
        int rootParent1 = find(node1);
        int rootParent2 = find(node2);

        if (rootParent1 == rootParent2) {
            return;
        }

        if (size[rootParent1] > size[rootParent2]) {
            parent[rootParent2] = rootParent1;
            size[rootParent1] += size[rootParent2];
        } else {
            parent[rootParent1] = rootParent2;
            size[rootParent2] += size[rootParent1];
        }
    }
}

public class Count_the_Number_of_Complete_Components {

    public int countCompleteComponents(int n, int[][] edges) {
        DSU dsu = new DSU(n);
        Map<Integer, Integer> edgeCount = new HashMap<>();
        for (int[] edge : edges) {
            dsu.union(edge[0], edge[1]);
        }

        for (int[] edge : edges) {
            int root = dsu.find(edge[0]);
            edgeCount.put(root, edgeCount.getOrDefault(root, 0) + 1);
        }

        int completeCount = 0;
        for (int vertex = 0; vertex < n; vertex++) {
            if (dsu.find(vertex) == vertex) {
                int nodeCount = dsu.size[vertex];
                int expectedEdges = (nodeCount * (nodeCount - 1)) / 2;
                if (edgeCount.getOrDefault(vertex, 0) == expectedEdges) {
                    completeCount++;
                }
            }
        }

        return completeCount;
    }

    public static void main(String[] args) {
        Count_the_Number_of_Complete_Components obj = new Count_the_Number_of_Complete_Components();
        int n = 6;
        int[][] edges = {{0, 1}, {0, 2}, {1, 2}, {3, 4}};
        System.out.println(obj.countCompleteComponents(n, edges)); // 3

        n = 6;
        edges = new int[][]{{0, 1}, {0, 2}, {1, 2}, {3, 4}, {3, 5}};
        System.out.println(obj.countCompleteComponents(n, edges)); // 1
    }
}

/*2685. Count the Number of Complete Components
Solved
Medium
Topics
Companies
Hint
You are given an integer n. There is an undirected graph with n vertices, numbered from 0 to n - 1. You are given a 2D integer array edges where edges[i] = [ai, bi] denotes that there exists an undirected edge connecting vertices ai and bi.

Return the number of complete connected components of the graph.

A connected component is a subgraph of a graph in which there exists a path between any two vertices, and no vertex of the subgraph shares an edge with a vertex outside of the subgraph.

A connected component is said to be complete if there exists an edge between every pair of its vertices.

 

Example 1:



Input: n = 6, edges = [[0,1],[0,2],[1,2],[3,4]]
Output: 3
Explanation: From the picture above, one can see that all of the components of this graph are complete.
Example 2:



Input: n = 6, edges = [[0,1],[0,2],[1,2],[3,4],[3,5]]
Output: 1
Explanation: The component containing vertices 0, 1, and 2 is complete since there is an edge between every pair of two vertices. On the other hand, the component containing vertices 3, 4, and 5 is not complete since there is no edge between vertices 4 and 5. Thus, the number of complete components in this graph is 1.
 

Constraints:

1 <= n <= 50
0 <= edges.length <= n * (n - 1) / 2
edges[i].length == 2
0 <= ai, bi <= n - 1
ai != bi
There are no repeated edges. */
