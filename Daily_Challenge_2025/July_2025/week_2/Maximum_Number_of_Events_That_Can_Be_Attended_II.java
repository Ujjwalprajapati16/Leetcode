import java.util.Arrays;

public class Maximum_Number_of_Events_That_Can_Be_Attended_II {
    int[][] memo;

    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
        int n = events.length;
        memo = new int[n][k + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return dfs(0, k, events);
    }

    private int dfs(int index, int remaining, int[][] events) {
        if (index == events.length || remaining == 0) {
            return 0;
        }

        if (memo[index][remaining] != -1) {
            return memo[index][remaining];
        }
        int skip = dfs(index + 1, remaining, events);
        int nextIndex = findNext(events, events[index][1]);
        int take = events[index][2] + dfs(nextIndex, remaining - 1, events);

        return memo[index][remaining] = Math.max(skip, take);
    }

    private int findNext(int[][] events, int endDay) {
        int low = 0, high = events.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (events[mid][0] > endDay) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        Maximum_Number_of_Events_That_Can_Be_Attended_II solution = new Maximum_Number_of_Events_That_Can_Be_Attended_II();
        int[][] events1 = { { 1, 2, 4 }, { 3, 4, 3 }, { 2, 3, 1 } };
        System.out.println(solution.maxValue(events1, 2)); // Output: 7

        int[][] events2 = { { 1, 2, 4 }, { 3, 4, 3 }, { 2, 3, 10 } };
        System.out.println(solution.maxValue(events2, 2)); // Output: 10

        int[][] events3 = { { 1, 1, 1 }, { 2, 2, 2 }, { 3, 3, 3 }, { 4, 4, 4 } };
        System.out.println(solution.maxValue(events3, 3)); // Output: 9
    }
}

/*
 * 1751. Maximum Number of Events That Can Be Attended II Solved Hard Topics
 * premium lock icon Companies Hint You are given an array of events where
 * events[i] = [startDayi, endDayi, valuei]. The ith event starts at startDayi
 * and ends at endDayi, and if you attend this event, you will receive a value
 * of valuei. You are also given an integer k which represents the maximum
 * number of events you can attend.
 * 
 * You can only attend one event at a time. If you choose to attend an event,
 * you must attend the entire event. Note that the end day is inclusive: that
 * is, you cannot attend two events where one of them starts and the other ends
 * on the same day.
 * 
 * Return the maximum sum of values that you can receive by attending events.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * Input: events = [[1,2,4],[3,4,3],[2,3,1]], k = 2 Output: 7 Explanation:
 * Choose the green events, 0 and 1 (0-indexed) for a total value of 4 + 3 = 7.
 * Example 2:
 * 
 * 
 * 
 * Input: events = [[1,2,4],[3,4,3],[2,3,10]], k = 2 Output: 10 Explanation:
 * Choose event 2 for a total value of 10. Notice that you cannot attend any
 * other event as they overlap, and that you do not have to attend k events.
 * Example 3:
 * 
 * 
 * 
 * Input: events = [[1,1,1],[2,2,2],[3,3,3],[4,4,4]], k = 3 Output: 9
 * Explanation: Although the events do not overlap, you can only attend 3
 * events. Pick the highest valued three.
 * 
 * 
 * Constraints:
 * 
 * 1 <= k <= events.length 1 <= k * events.length <= 106 1 <= startDayi <=
 * endDayi <= 109 1 <= valuei <= 106
 */