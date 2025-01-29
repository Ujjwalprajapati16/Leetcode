public class Redundant_Connection {
    int totalNodes;

    public int[] findRedundantConnection(int[][] edges) {
        totalNodes = edges.length;
        int res[] = new int[2];
        DisjointSet dsu = new DisjointSet(totalNodes);

        for (int[] edge : edges) {
            if (!dsu.unionBySize(edge[0] - 1, edge[1] - 1)) {
                res = edge;
            }
        }

        return res;
    }
    public static void main(String[] args) {
        Redundant_Connection obj = new Redundant_Connection();
        int edges[][] = { { 1, 2 }, { 1, 3 }, { 2, 3 } };
        int res[] = obj.findRedundantConnection(edges);

        for (int i : res) {
            System.out.print(i + " ");
        }

        System.out.println();

        edges = new int[][] { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 4 }, { 1, 5 } };
        res = obj.findRedundantConnection(edges);
        for (int i : res) {
            System.out.print(i + " ");
        }

        System.out.println();
    }
}

class DisjointSet {
    int parent[];
    int size[];

    DisjointSet(int nodes) {
        this.parent = new int[nodes];
        this.size = new int[nodes];

        for (int i = 0; i < nodes; i++) {
            this.parent[i] = i;
            this.size[i] = 1;
        }
    }

    public int findRootParent(int node) {
        if (node == parent[node]) {
            return node;
        }

        parent[node] = findRootParent(parent[node]);
        return parent[node];
    }

    public boolean unionBySize(int node1, int node2) {
        int rootParent1 = findRootParent(node1);
        int rootParent2 = findRootParent(node2);

        if (rootParent1 == rootParent2) {
            return false;
        }

        if (size[rootParent1] < size[rootParent2]) {
            parent[rootParent1] = rootParent2;
            size[rootParent2] += size[rootParent1];
        } else {
            parent[rootParent2] = rootParent1;
            size[rootParent1] += size[rootParent2];
        }

        return true;
    }
}

/*684. Redundant Connection
Solved
Medium
Topics
Companies
In this problem, a tree is an undirected graph that is connected and has no cycles.

You are given a graph that started as a tree with n nodes labeled from 1 to n, with one additional edge added. The added edge has two different vertices chosen from 1 to n, and was not an edge that already existed. The graph is represented as an array edges of length n where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the graph.

Return an edge that can be removed so that the resulting graph is a tree of n nodes. If there are multiple answers, return the answer that occurs last in the input.

 

Example 1:


Input: edges = [[1,2],[1,3],[2,3]]
Output: [2,3]
Example 2:


Input: edges = [[1,2],[2,3],[3,4],[1,4],[1,5]]
Output: [1,4]
 

Constraints:

n == edges.length
3 <= n <= 1000
edges[i].length == 2
1 <= ai < bi <= edges.length
ai != bi
There are no repeated edges.
The given graph is connected. */