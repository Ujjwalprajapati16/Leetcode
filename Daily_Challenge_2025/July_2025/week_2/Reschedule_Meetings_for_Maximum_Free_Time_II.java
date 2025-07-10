public class Reschedule_Meetings_for_Maximum_Free_Time_II {
    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int n = startTime.length;
        boolean[] canBeMoves = new boolean[n];
        int maxLeftGap = 0;
        int maxRightGap = 0;

        for (int i = 0; i < n; i++) {
            int leftDuration = endTime[i] - startTime[i];
            if (leftDuration <= maxLeftGap) {
                canBeMoves[i] = true;
            }
            if (i == 0) {
                maxLeftGap = startTime[i];
            } else {
                maxLeftGap = Math.max(maxLeftGap, startTime[i] - endTime[i - 1]);
            }
            int j = n - i - 1;
            int rightDuration = endTime[j] - startTime[j];
            if (rightDuration <= maxRightGap) {
                canBeMoves[j] = true;
            }
            if (j == n - 1) {
                maxRightGap = eventTime - endTime[j];
            } else {
                maxRightGap = Math.max(maxRightGap, startTime[j + 1] - endTime[j]);
            }
        }
        int maxFreeTime = 0;
        for (int i = 0; i < n; i++) {
            int left = (i == 0) ? 0 : endTime[i - 1];
            int right = (i == n - 1) ? eventTime : startTime[i + 1];
            int meetingDuration = endTime[i] - startTime[i];
            if (canBeMoves[i]) {
                maxFreeTime = Math.max(maxFreeTime, right - left);
            } else {
                int freeTime = right - left - meetingDuration;
                maxFreeTime = Math.max(maxFreeTime, freeTime);
            }
        }
        return maxFreeTime;
    }

    public static void main(String[] args) {
        Reschedule_Meetings_for_Maximum_Free_Time_II obj = new Reschedule_Meetings_for_Maximum_Free_Time_II();
        int eventTime = 5;
        int[] startTime = new int[] { 1, 3 };
        int[] endTime = new int[] { 2, 5 };
        System.out.println(obj.maxFreeTime(eventTime, startTime, endTime)); // Output: 2

        eventTime = 10;
        startTime = new int[] { 0, 7, 9 };
        endTime = new int[] { 1, 8, 10 };
        System.out.println(obj.maxFreeTime(eventTime, startTime, endTime)); // Output: 6
    }
}

/*
 * 3440. Reschedule Meetings for Maximum Free Time II Solved Medium Topics
 * premium lock icon Companies Hint You are given an integer eventTime denoting
 * the duration of an event. You are also given two integer arrays startTime and
 * endTime, each of length n.
 * 
 * These represent the start and end times of n non-overlapping meetings that
 * occur during the event between time t = 0 and time t = eventTime, where the
 * ith meeting occurs during the time [startTime[i], endTime[i]].
 * 
 * You can reschedule at most one meeting by moving its start time while
 * maintaining the same duration, such that the meetings remain non-overlapping,
 * to maximize the longest continuous period of free time during the event.
 * 
 * Return the maximum amount of free time possible after rearranging the
 * meetings.
 * 
 * Note that the meetings can not be rescheduled to a time outside the event and
 * they should remain non-overlapping.
 * 
 * Note: In this version, it is valid for the relative ordering of the meetings
 * to change after rescheduling one meeting.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: eventTime = 5, startTime = [1,3], endTime = [2,5]
 * 
 * Output: 2
 * 
 * Explanation:
 * 
 * 
 * 
 * Reschedule the meeting at [1, 2] to [2, 3], leaving no meetings during the
 * time [0, 2].
 * 
 * Example 2:
 * 
 * Input: eventTime = 10, startTime = [0,7,9], endTime = [1,8,10]
 * 
 * Output: 7
 * 
 * Explanation:
 * 
 * 
 * 
 * Reschedule the meeting at [0, 1] to [8, 9], leaving no meetings during the
 * time [0, 7].
 * 
 * Example 3:
 * 
 * Input: eventTime = 10, startTime = [0,3,7,9], endTime = [1,4,8,10]
 * 
 * Output: 6
 * 
 * Explanation:
 * 
 * 
 * 
 * Reschedule the meeting at [3, 4] to [8, 9], leaving no meetings during the
 * time [1, 7].
 * 
 * Example 4:
 * 
 * Input: eventTime = 5, startTime = [0,1,2,3,4], endTime = [1,2,3,4,5]
 * 
 * Output: 0
 * 
 * Explanation:
 * 
 * There is no time during the event not occupied by meetings.
 * 
 * 
 * 
 * Constraints:
 * 
 * 1 <= eventTime <= 109 n == startTime.length == endTime.length 2 <= n <= 105 0
 * <= startTime[i] < endTime[i] <= eventTime endTime[i] <= startTime[i + 1]
 * where i lies in the range [0, n - 2].
 */