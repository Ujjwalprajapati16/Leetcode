import java.util.Arrays;
import java.util.PriorityQueue;

public class Maximum_Number_of_Events_That_Can_Be_Attended {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int i = 0;
        int res = 0;
        int n = events.length;
        int day = 1;

        while (i < n || !pq.isEmpty()) {
            while (i < n && events[i][0] == day) {
                pq.offer(events[i][1]);
                i++;
            }

            while (!pq.isEmpty() && pq.peek() < day) {
                pq.poll();
            }

            if (!pq.isEmpty()) {
                pq.poll();
                res++;
            }

            day++;
        }

        return res;
    }

    public static void main(String[] args) {
        Maximum_Number_of_Events_That_Can_Be_Attended solution = new Maximum_Number_of_Events_That_Can_Be_Attended();
        int[][] events1 = { { 1, 2 }, { 2, 3 }, { 3, 4 } };
        System.out.println(solution.maxEvents(events1)); // Output: 3

        int[][] events2 = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 2 } };
        System.out.println(solution.maxEvents(events2)); // Output: 4
    }
}

/*
 * 1353. Maximum Number of Events That Can Be Attended Solved Medium Topics
 * premium lock icon Companies Hint You are given an array of events where
 * events[i] = [startDayi, endDayi]. Every event i starts at startDayi and ends
 * at endDayi.
 * 
 * You can attend an event i at any day d where startTimei <= d <= endTimei. You
 * can only attend one event at any time d.
 * 
 * Return the maximum number of events you can attend.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: events = [[1,2],[2,3],[3,4]] Output: 3 Explanation: You can attend all
 * the three events. One way to attend them all is as shown. Attend the first
 * event on day 1. Attend the second event on day 2. Attend the third event on
 * day 3. Example 2:
 * 
 * Input: events= [[1,2],[2,3],[3,4],[1,2]] Output: 4
 * 
 * 
 * Constraints:
 * 
 * 1 <= events.length <= 105 events[i].length == 2 1 <= startDayi <= endDayi <=
 * 105
 */