import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class The_Earliest_and_Latest_Rounds_Where_Players_Compete {
    Map<String, int[]> memo = new HashMap<>();

    public int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        return dfs(1, initPlayers(n), firstPlayer, secondPlayer);
    }

    private List<Integer> initPlayers(int n) {
        List<Integer> players = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            players.add(i);
        }
        return players;
    }

    private int[] dfs(int round, List<Integer> players, int fp, int sp) {
        String key = round + ":" + players.toString();
        if (memo.containsKey(key))
            return memo.get(key);

        int size = players.size();
        int left = 0, right = size - 1;

        // Check if fp and sp will face each other in this round
        while (left < right) {
            int a = players.get(left);
            int b = players.get(right);
            if ((a == fp && b == sp) || (a == sp && b == fp)) {
                return new int[] { round, round };
            }
            left++;
            right--;
        }

        // Next round
        List<List<Integer>> nextRounds = generateNextRounds(players, fp, sp);
        int minRound = Integer.MAX_VALUE;
        int maxRound = Integer.MIN_VALUE;

        for (List<Integer> next : nextRounds) {
            int[] res = dfs(round + 1, next, fp, sp);
            minRound = Math.min(minRound, res[0]);
            maxRound = Math.max(maxRound, res[1]);
        }

        int[] result = new int[] { minRound, maxRound };
        memo.put(key, result);
        return result;
    }

    private List<List<Integer>> generateNextRounds(List<Integer> players, int fp, int sp) {
        List<List<Integer>> results = new ArrayList<>();
        backtrack(players, 0, players.size() - 1, new ArrayList<>(), results, fp, sp);
        return results;
    }

    private void backtrack(List<Integer> players, int i, int j, List<Integer> current, List<List<Integer>> results,
            int fp, int sp) {
        if (i > j) {
            List<Integer> sorted = new ArrayList<>(current);
            Collections.sort(sorted);
            results.add(sorted);
            return;
        }
        if (i == j) {
            current.add(players.get(i));
            backtrack(players, i + 1, j, current, results, fp, sp);
            current.remove(current.size() - 1);
            return;
        }

        int a = players.get(i), b = players.get(j);

        if ((a == fp && b == sp) || (a == sp && b == fp)) {
            return; // already handled, skip
        }

        if (a == fp || a == sp) {
            current.add(a);
            backtrack(players, i + 1, j - 1, current, results, fp, sp);
            current.remove(current.size() - 1);
        } else if (b == fp || b == sp) {
            current.add(b);
            backtrack(players, i + 1, j - 1, current, results, fp, sp);
            current.remove(current.size() - 1);
        } else {
            // try both outcomes
            current.add(a);
            backtrack(players, i + 1, j - 1, current, results, fp, sp);
            current.remove(current.size() - 1);

            current.add(b);
            backtrack(players, i + 1, j - 1, current, results, fp, sp);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        The_Earliest_and_Latest_Rounds_Where_Players_Compete obj = new The_Earliest_and_Latest_Rounds_Where_Players_Compete();
        int[] result = obj.earliestAndLatest(5, 2, 4);
        System.out.println(result[0] + " " + result[1]); // Output: 1 1

        result = obj.earliestAndLatest(11, 2, 4);
        System.out.println(result[0] + " " + result[1]); // Output: 3 4
    }
}

/*
 * 1900. The Earliest and Latest Rounds Where Players Compete Solved Hard Topics
 * premium lock icon Companies Hint There is a tournament where n players are
 * participating. The players are standing in a single row and are numbered from
 * 1 to n based on their initial standing position (player 1 is the first player
 * in the row, player 2 is the second player in the row, etc.).
 * 
 * The tournament consists of multiple rounds (starting from round number 1). In
 * each round, the ith player from the front of the row competes against the ith
 * player from the end of the row, and the winner advances to the next round.
 * When the number of players is odd for the current round, the player in the
 * middle automatically advances to the next round.
 * 
 * For example, if the row consists of players 1, 2, 4, 6, 7 Player 1 competes
 * against player 7. Player 2 competes against player 6. Player 4 automatically
 * advances to the next round. After each round is over, the winners are lined
 * back up in the row based on the original ordering assigned to them initially
 * (ascending order).
 * 
 * The players numbered firstPlayer and secondPlayer are the best in the
 * tournament. They can win against any other player before they compete against
 * each other. If any two other players compete against each other, either of
 * them might win, and thus you may choose the outcome of this round.
 * 
 * Given the integers n, firstPlayer, and secondPlayer, return an integer array
 * containing two values, the earliest possible round number and the latest
 * possible round number in which these two players will compete against each
 * other, respectively.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: n = 11, firstPlayer = 2, secondPlayer = 4 Output: [3,4] Explanation:
 * One possible scenario which leads to the earliest round number: First round:
 * 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 Second round: 2, 3, 4, 5, 6, 11 Third
 * round: 2, 3, 4 One possible scenario which leads to the latest round number:
 * First round: 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 Second round: 1, 2, 3, 4, 5, 6
 * Third round: 1, 2, 4 Fourth round: 2, 4 Example 2:
 * 
 * Input: n = 5, firstPlayer = 1, secondPlayer = 5 Output: [1,1] Explanation:
 * The players numbered 1 and 5 compete in the first round. There is no way to
 * make them compete in any other round.
 * 
 * 
 * Constraints:
 * 
 * 2 <= n <= 28 1 <= firstPlayer < secondPlayer <= n
 */