import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Painting_a_Grid_With_Three_Different_Colors {
    List<List<Integer>> combs;

    public int colorTheGrid(int m, int n) {
        combs = new ArrayList<>();
        backtrack(new ArrayList<>(), m);

        int[][] cache = new int[n][combs.size()];
        for (int[] row : cache) {
            Arrays.fill(row, -1);
        }

        int res = 0;
        for (int i = 0; i < combs.size(); i++) {
            res = (res + dp(1, i, cache, n)) % 1_000_000_007;
        }

        return res;
    }

    private int dp(int col, int prevIdx, int[][] cache, int n) {
        if (col == n) {
            return 1;
        }
        if (cache[col][prevIdx] != -1) {
            return cache[col][prevIdx];
        }

        int res = 0;
        List<Integer> prev = combs.get(prevIdx);

        for (int i = 0; i < combs.size(); i++) {
            if (isValid(prev, combs.get(i))) {
                res = (res + dp(col + 1, i, cache, n)) % 1_000_000_007;
            }
        }

        return cache[col][prevIdx] = res;
    }

    private void backtrack(List<Integer> curr, int m) {
        if (curr.size() == m) {
            combs.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (curr.isEmpty() || curr.get(curr.size() - 1) != i) {
                curr.add(i);
                backtrack(curr, m);
                curr.remove(curr.size() - 1);
            }
        }
    }

    private boolean isValid(List<Integer> a, List<Integer> b) {
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).equals(b.get(i))) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Painting_a_Grid_With_Three_Different_Colors obj = new Painting_a_Grid_With_Three_Different_Colors();
        System.out.println(obj.colorTheGrid(1, 1)); // 3
        System.out.println(obj.colorTheGrid(1, 2)); // 6
        System.out.println(obj.colorTheGrid(5, 5)); // 580986
    }
}

/*
 * 1931. Painting a Grid With Three Different Colors Solved Hard Topics
 * Companies Hint You are given two integers m and n. Consider an m x n grid
 * where each cell is initially white. You can paint each cell red, green, or
 * blue. All cells must be painted.
 * 
 * Return the number of ways to color the grid with no two adjacent cells having
 * the same color. Since the answer can be very large, return it modulo 109 + 7.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: m = 1, n = 1 Output: 3 Explanation: The three possible colorings are
 * shown in the image above. Example 2:
 * 
 * 
 * Input: m = 1, n = 2 Output: 6 Explanation: The six possible colorings are
 * shown in the image above. Example 3:
 * 
 * Input: m = 5, n = 5 Output: 580986
 * 
 * 
 * Constraints:
 * 
 * 1 <= m <= 5 1 <= n <= 1000
 */