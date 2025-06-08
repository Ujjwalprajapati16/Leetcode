import java.util.ArrayList;
import java.util.List;

public class Lexicographical_Numbers {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        while (res.size() < n) {
            int curr = res.get(res.size() - 1);
            if (curr * 10 <= n) {
                res.add(curr * 10);
                continue;
            }

            while (curr + 1 > n || curr % 10 == 9) {
                curr /= 10;
            }

            res.add(curr + 1);
        }

        return res;
    }

    public static void main(String[] args) {
        Lexicographical_Numbers solution = new Lexicographical_Numbers();
        int n = 13; // Example input
        List<Integer> result = solution.lexicalOrder(n);
        System.out.println(result); // Output: [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9]

        n = 2; // Another example input
        result = solution.lexicalOrder(n);
        System.out.println(result); // Output: [1, 2]
    }
}

/*
 * 386. Lexicographical Numbers Solved Medium Topics premium lock icon Companies
 * Given an integer n, return all the numbers in the range [1, n] sorted in
 * lexicographical order.
 * 
 * You must write an algorithm that runs in O(n) time and uses O(1) extra space.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: n = 13 Output: [1,10,11,12,13,2,3,4,5,6,7,8,9] Example 2:
 * 
 * Input: n = 2 Output: [1,2]
 * 
 * 
 * Constraints:
 * 
 * 1 <= n <= 5 * 104
 */