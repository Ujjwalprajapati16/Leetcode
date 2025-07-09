public class Reschedule_Meetings_for_Maximum_Free_Time_I {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n = startTime.length;
        int maxFreeTime = 0;
        int currentWindowDuration = 0;
        for (int right = 0; right < n; right++) {
            int duration = endTime[right] - startTime[right];
            currentWindowDuration += duration;
            if (right >= k - 1) {
                int leftIndex = right - k + 1;
                int leftBound = (leftIndex == 0) ? 0 : endTime[leftIndex - 1];
                int rightBound = (right == n - 1) ? eventTime : startTime[right + 1];
                int mergedFreeTime = rightBound - leftBound - currentWindowDuration;
                maxFreeTime = Math.max(maxFreeTime, mergedFreeTime);
                int leftDuration = endTime[leftIndex] - startTime[leftIndex];
                currentWindowDuration -= leftDuration;
            }
        }
        return maxFreeTime;
    }

    public static void main(String[] args) {
        Reschedule_Meetings_for_Maximum_Free_Time_I obj = new Reschedule_Meetings_for_Maximum_Free_Time_I();
        int eventTime = 5, k = 1;
        int[] startTime = new int[]{1, 3};
        int[] endTime = new int[]{2, 5};
        System.out.println(obj.maxFreeTime(eventTime, k, startTime, endTime)); // Output: 2

        eventTime = 10; k = 1; startTime = new int[]{0, 2, 9};
        endTime = new int[]{1, 4, 10};
        System.out.println(obj.maxFreeTime(eventTime, k, startTime, endTime)); // Output: 6
    }
}

/*3439. Reschedule Meetings for Maximum Free Time I
Solved
Medium
Topics
premium lock icon
Companies
Hint
You are given an integer eventTime denoting the duration of an event, where the event occurs from time t = 0 to time t = eventTime.

You are also given two integer arrays startTime and endTime, each of length n. These represent the start and end time of n non-overlapping meetings, where the ith meeting occurs during the time [startTime[i], endTime[i]].

You can reschedule at most k meetings by moving their start time while maintaining the same duration, to maximize the longest continuous period of free time during the event.

The relative order of all the meetings should stay the same and they should remain non-overlapping.

Return the maximum amount of free time possible after rearranging the meetings.

Note that the meetings can not be rescheduled to a time outside the event.

 

Example 1:

Input: eventTime = 5, k = 1, startTime = [1,3], endTime = [2,5]

Output: 2

Explanation:



Reschedule the meeting at [1, 2] to [2, 3], leaving no meetings during the time [0, 2].

Example 2:

Input: eventTime = 10, k = 1, startTime = [0,2,9], endTime = [1,4,10]

Output: 6

Explanation:



Reschedule the meeting at [2, 4] to [1, 3], leaving no meetings during the time [3, 9].

Example 3:

Input: eventTime = 5, k = 2, startTime = [0,1,2,3,4], endTime = [1,2,3,4,5]

Output: 0

Explanation:

There is no time during the event not occupied by meetings.

 

Constraints:

1 <= eventTime <= 109
n == startTime.length == endTime.length
2 <= n <= 105
1 <= k <= n
0 <= startTime[i] < endTime[i] <= eventTime
endTime[i] <= startTime[i + 1] where i lies in the range [0, n - 2].
 */