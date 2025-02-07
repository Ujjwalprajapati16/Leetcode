import java.util.HashMap;

public class Find_the_Number_of_Distinct_Colors_Among_the_Balls {
    public int[] queryResults(int limit, int[][] queries) {
        HashMap<Integer, Integer> colorMap = new HashMap<>();
        HashMap<Integer, Integer> ballMap = new HashMap<>();
        int n = queries.length;
        int res[] = new int[n];

        for (int i = 0; i < n; i++) {
            int ball = queries[i][0];
            int color = queries[i][1];

            if (!ballMap.containsKey(ball)) {
                ballMap.put(ball, color);
                colorMap.put(color, colorMap.getOrDefault(color, 0) + 1);
            } else {
                int oldColor = ballMap.get(ball);
                colorMap.put(oldColor, colorMap.get(oldColor) - 1);
                if (colorMap.get(oldColor) == 0) {
                    colorMap.remove(oldColor);
                }
                ballMap.put(ball, color);
                colorMap.put(color, colorMap.getOrDefault(color, 0) + 1);
            }

            res[i] = colorMap.size();
        }

        return res;
    }

    public static void main(String[] args) {
        Find_the_Number_of_Distinct_Colors_Among_the_Balls obj = new Find_the_Number_of_Distinct_Colors_Among_the_Balls();
        int limit = 4, queries[][] = { { 1, 4 }, { 2, 5 }, { 1, 3 }, { 3, 4 } };
        int res[] = obj.queryResults(limit, queries);
        for (int i : res) {
            System.out.print(i + " ");
        }
        System.out.println();

        int limit1 = 4, queries1[][] = { { 0, 1 }, { 1, 2 }, { 2, 2 }, { 3, 4 }, { 4, 5 } };
        int res1[] = obj.queryResults(limit1, queries1);
        for (int i : res1) {
            System.out.print(i + " ");
        }
        System.out.println();

    }
}

/*
 * 3160. Find the Number of Distinct Colors Among the Balls Solved Medium Topics
 * Companies Hint You are given an integer limit and a 2D array queries of size
 * n x 2.
 * 
 * There are limit + 1 balls with distinct labels in the range [0, limit].
 * Initially, all balls are uncolored. For every query in queries that is of the
 * form [x, y], you mark ball x with the color y. After each query, you need to
 * find the number of distinct colors among the balls.
 * 
 * Return an array result of length n, where result[i] denotes the number of
 * distinct colors after ith query.
 * 
 * Note that when answering a query, lack of a color will not be considered as a
 * color.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: limit = 4, queries = [[1,4],[2,5],[1,3],[3,4]]
 * 
 * Output: [1,2,2,3]
 * 
 * Explanation:
 * 
 * 
 * 
 * After query 0, ball 1 has color 4. After query 1, ball 1 has color 4, and
 * ball 2 has color 5. After query 2, ball 1 has color 3, and ball 2 has color
 * 5. After query 3, ball 1 has color 3, ball 2 has color 5, and ball 3 has
 * color 4. Example 2:
 * 
 * Input: limit = 4, queries = [[0,1],[1,2],[2,2],[3,4],[4,5]]
 * 
 * Output: [1,2,2,3,4]
 * 
 * Explanation:
 * 
 * 
 * 
 * After query 0, ball 0 has color 1. After query 1, ball 0 has color 1, and
 * ball 1 has color 2. After query 2, ball 0 has color 1, and balls 1 and 2 have
 * color 2. After query 3, ball 0 has color 1, balls 1 and 2 have color 2, and
 * ball 3 has color 4. After query 4, ball 0 has color 1, balls 1 and 2 have
 * color 2, ball 3 has color 4, and ball 4 has color 5.
 * 
 * 
 * Constraints:
 * 
 * 1 <= limit <= 109 1 <= n == queries.length <= 105 queries[i].length == 2 0 <=
 * queries[i][0] <= limit 1 <= queries[i][1] <= 109
 */