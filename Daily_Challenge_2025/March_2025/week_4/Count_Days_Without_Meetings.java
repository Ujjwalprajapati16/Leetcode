import java.util.Arrays;
import java.util.Comparator;

public class Count_Days_Without_Meetings {

    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt(meeting -> meeting[0]));
        int end = meetings[0][1];
        int noMeetingDays = meetings[0][0] - 1;
        for (int i = 1; i < meetings.length; i++) {
            if (end < meetings[i][0]) {
                noMeetingDays += meetings[i][0] - end - 1;
            }
            end = Math.max(end, meetings[i][1]);
        }
        return noMeetingDays + (days - end);
    }

    public static void main(String[] args) {
        Count_Days_Without_Meetings obj = new Count_Days_Without_Meetings();
        int days = 10;
        int[][] meetings = {{5, 7}, {1, 3}, {9, 10}};
        System.out.println(obj.countDays(days, meetings)); // Output: 2

        days = 5;
        meetings = new int[][]{{2, 4}, {1, 3}};
        System.out.println(obj.countDays(days, meetings)); // Output: 1

        days = 6;
        meetings = new int[][]{{1, 6}};
        System.out.println(obj.countDays(days, meetings)); // Output: 0
    }
}

/*3169. Count Days Without Meetings
Solved
Medium
Topics
Companies
Hint
You are given a positive integer days representing the total number of days an employee is available for work (starting from day 1). You are also given a 2D array meetings of size n where, meetings[i] = [start_i, end_i] represents the starting and ending days of meeting i (inclusive).

Return the count of days when the employee is available for work but no meetings are scheduled.

Note: The meetings may overlap.

 

Example 1:

Input: days = 10, meetings = [[5,7],[1,3],[9,10]]

Output: 2

Explanation:

There is no meeting scheduled on the 4th and 8th days.

Example 2:

Input: days = 5, meetings = [[2,4],[1,3]]

Output: 1

Explanation:

There is no meeting scheduled on the 5th day.

Example 3:

Input: days = 6, meetings = [[1,6]]

Output: 0

Explanation:

Meetings are scheduled for all working days.

 

Constraints:

1 <= days <= 109
1 <= meetings.length <= 105
meetings[i].length == 2
1 <= meetings[i][0] <= meetings[i][1] <= days */
