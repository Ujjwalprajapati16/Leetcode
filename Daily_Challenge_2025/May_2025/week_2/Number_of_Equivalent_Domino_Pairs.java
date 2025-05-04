public class Number_of_Equivalent_Domino_Pairs {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[][] count = new int[10][10];
        int ans = 0;
        for (int[] d : dominoes) {
            int first = d[0];
            int second = d[1];
            if (first > second) {
                int temp = first;
                first = second;
                second = temp;
            }
            ans += count[first][second]++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Number_of_Equivalent_Domino_Pairs obj = new Number_of_Equivalent_Domino_Pairs();
        int[][] dominoes = { { 1, 2 }, { 2, 1 }, { 3, 4 }, { 5, 6 } };
        int ans = obj.numEquivDominoPairs(dominoes);
        System.out.println(ans); // 1

        int[][] dominoes2 = { { 1, 2 }, { 1, 2 }, { 1, 1 }, { 1, 2 }, { 2, 2 } };
        ans = obj.numEquivDominoPairs(dominoes2);
        System.out.println(ans); // 3
    }
}

/*
 * 1128. Number of Equivalent Domino Pairs Solved Easy Topics Companies Hint
 * Given a list of dominoes, dominoes[i] = [a, b] is equivalent to dominoes[j] =
 * [c, d] if and only if either (a == c and b == d), or (a == d and b == c) -
 * that is, one domino can be rotated to be equal to another domino.
 * 
 * Return the number of pairs (i, j) for which 0 <= i < j < dominoes.length, and
 * dominoes[i] is equivalent to dominoes[j].
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: dominoes = [[1,2],[2,1],[3,4],[5,6]] Output: 1 Example 2:
 * 
 * Input: dominoes = [[1,2],[1,2],[1,1],[1,2],[2,2]] Output: 3
 * 
 * 
 * Constraints:
 * 
 * 1 <= dominoes.length <= 4 * 104 dominoes[i].length == 2 1 <= dominoes[i][j]
 * <= 9
 */