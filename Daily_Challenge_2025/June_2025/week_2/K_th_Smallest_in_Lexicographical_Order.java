public class K_th_Smallest_in_Lexicographical_Order {
    public int findKthNumber(int n, int k) {
        long curr = 1;
        while (k > 1) {
            long nodes = countNodesInTree(curr, n);
            if (nodes >= k) {
                k--;
                curr *= 10;
            } else {
                k -= nodes;
                curr++;
            }
        }
        return (int) curr;
    }

    private long countNodesInTree(long root, int n) {
        long curr = root;
        long next = curr + 1;
        long res = 0;

        while (curr <= n) {
            res += Math.min(n - curr + 1, next - curr);
            curr *= 10;
            next *= 10;
        }

        return res;
    }

    public static void main(String[] args) {
        K_th_Smallest_in_Lexicographical_Order solution = new K_th_Smallest_in_Lexicographical_Order();
        int n = 13; // Example input
        int k = 2; // Example input
        int result = solution.findKthNumber(n, k);
        System.out.println(result); // Output: 10

        n = 1; // Another example input
        k = 1; // Another example input
        result = solution.findKthNumber(n, k);
        System.out.println(result); // Output: 1
    }
}

/*
 * 440. K-th Smallest in Lexicographical Order Solved Hard Topics premium lock
 * icon Companies Given two integers n and k, return the kth lexicographically
 * smallest integer in the range [1, n].
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: n = 13, k = 2 Output: 10 Explanation: The lexicographical order is [1,
 * 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9], so the second smallest number is 10.
 * Example 2:
 * 
 * Input: n = 1, k = 1 Output: 1
 * 
 * 
 * Constraints:
 * 
 * 1 <= k <= n <= 109
 */