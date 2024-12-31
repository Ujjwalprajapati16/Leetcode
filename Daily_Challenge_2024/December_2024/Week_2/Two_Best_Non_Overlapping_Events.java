
import java.util.Arrays;
import java.util.PriorityQueue;

public class Two_Best_Non_Overlapping_Events {

    public int maxTwoEvents(int[][] events) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        int prevMax = 0;
        int res = 0;

        for (int event[] : events) {
            while (!pq.isEmpty() && pq.peek()[1] < event[0]) {
                prevMax = Math.max(prevMax, pq.peek()[2]);
                pq.poll();
            }
            res = Math.max(res, prevMax + event[2]);
            pq.offer(event);
        }
        return res;
    }

    public static void main(String[] args) {
        Two_Best_Non_Overlapping_Events solution = new Two_Best_Non_Overlapping_Events();
        int[][] events = {{1, 3, 2}, {4, 5, 2}, {2, 4, 3}};
        int result = solution.maxTwoEvents(events);
        System.out.println(result);

        int[][] events1 = {{1, 3, 2}, {4, 5, 2}, {1, 5, 5}};
        int result1 = solution.maxTwoEvents(events1);
        System.out.println(result1);

        int[][] events2 = {{1, 5, 3}, {1, 5, 1}, {6, 6, 5}};
        int result2 = solution.maxTwoEvents(events2);
        System.out.println(result2);
    }
}

/*
2054. Two Best Non-Overlapping Events
Solved
Medium
Topics
Companies
Hint
You are given a 0-indexed 2D integer array of events where events[i] = [startTimei, endTimei, valuei]. The ith event starts at startTimei and ends at endTimei, and if you attend this event, you will receive a value of valuei. You can choose at most two non-overlapping events to attend such that the sum of their values is maximized.

Return this maximum sum.

Note that the start time and end time is inclusive: that is, you cannot attend two events where one of them starts and the other ends at the same time. More specifically, if you attend an event with end time t, the next event must start at or after t + 1.

 

Example 1:


Input: events = [[1,3,2],[4,5,2],[2,4,3]]
Output: 4
Explanation: Choose the green events, 0 and 1 for a sum of 2 + 2 = 4.
Example 2:

Example 1 Diagram
Input: events = [[1,3,2],[4,5,2],[1,5,5]]
Output: 5
Explanation: Choose event 2 for a sum of 5.
Example 3:


Input: events = [[1,5,3],[1,5,1],[6,6,5]]
Output: 8
Explanation: Choose events 0 and 2 for a sum of 3 + 5 = 8.
 

Constraints:

2 <= events.length <= 105
events[i].length == 3
1 <= startTimei <= endTimei <= 109
1 <= valuei <= 106
 */
