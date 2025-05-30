import java.util.HashMap;
import java.util.Map;

public class Find_Closest_Node_to_Given_Two_Nodes {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        Map<Integer, Integer> nodeOneNodes = new HashMap<>();
        Map<Integer, Integer> nodeTwoNodes = new HashMap<>();

        computeDistance(edges, node1, nodeOneNodes);
        computeDistance(edges, node2, nodeTwoNodes);

        int node = -1;
        int dist = Integer.MAX_VALUE;

        for (var entry : nodeOneNodes.entrySet()) {
            int key = entry.getKey();
            int nodeOneValue = entry.getValue();
            int nodeTwoValue = nodeTwoNodes.getOrDefault(key, Integer.MAX_VALUE);
            int maxDist = Math.max(nodeOneValue, nodeTwoValue);
            if (maxDist < dist || (dist == maxDist && key < node)) {
                dist = maxDist;
                node = key;
            }
        }

        return node;
    }

    private void computeDistance(int[] edges, int start, Map<Integer, Integer> distances) {
        int distance = 0;
        while (start != -1 && !distances.containsKey(start)) {
            distances.put(start, distance++);
            start = edges[start];
        }
    }

    public static void main(String[] args) {
        Find_Closest_Node_to_Given_Two_Nodes solution = new Find_Closest_Node_to_Given_Two_Nodes();
        int[] edges = { 2, 2, 3, -1 };
        int node1 = 0;
        int node2 = 1;
        System.out.println(solution.closestMeetingNode(edges, node1, node2)); // Output: 2

        edges = new int[] { 1, 2, -1 };
        node1 = 0;
        node2 = 2;
        System.out.println(solution.closestMeetingNode(edges, node1, node2)); // Output: 2
    }
}

/*
 * 2359. Find Closest Node to Given Two Nodes Solved Medium Topics premium lock
 * icon Companies Hint You are given a directed graph of n nodes numbered from 0
 * to n - 1, where each node has at most one outgoing edge.
 * 
 * The graph is represented with a given 0-indexed array edges of size n,
 * indicating that there is a directed edge from node i to node edges[i]. If
 * there is no outgoing edge from i, then edges[i] == -1.
 * 
 * You are also given two integers node1 and node2.
 * 
 * Return the index of the node that can be reached from both node1 and node2,
 * such that the maximum between the distance from node1 to that node, and from
 * node2 to that node is minimized. If there are multiple answers, return the
 * node with the smallest index, and if no possible answer exists, return -1.
 * 
 * Note that edges may contain cycles.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: edges = [2,2,3,-1], node1 = 0, node2 = 1 Output: 2 Explanation: The
 * distance from node 0 to node 2 is 1, and the distance from node 1 to node 2
 * is 1. The maximum of those two distances is 1. It can be proven that we
 * cannot get a node with a smaller maximum distance than 1, so we return node
 * 2. Example 2:
 * 
 * 
 * Input: edges = [1,2,-1], node1 = 0, node2 = 2 Output: 2 Explanation: The
 * distance from node 0 to node 2 is 2, and the distance from node 2 to itself
 * is 0. The maximum of those two distances is 2. It can be proven that we
 * cannot get a node with a smaller maximum distance than 2, so we return node
 * 2.
 * 
 * 
 * Constraints:
 * 
 * n == edges.length 2 <= n <= 105 -1 <= edges[i] < n edges[i] != i 0 <= node1,
 * node2 < n
 */