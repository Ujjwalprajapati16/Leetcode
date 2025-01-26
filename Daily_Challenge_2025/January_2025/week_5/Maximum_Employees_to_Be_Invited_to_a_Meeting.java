import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Maximum_Employees_to_Be_Invited_to_a_Meeting {
    public int maximumInvitations(int[] favorite) {
        int n = favorite.length;
        int longestCycle = 0;

        ArrayList<int[]> twoLenCycles = new ArrayList<>();

        boolean vis[] = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (vis[i]) {
                continue;
            }
            HashSet<Integer> set = new HashSet<>();
            int start = i;
            int cur = i;

            while (!vis[cur]) {
                vis[cur] = true;
                set.add(cur);
                cur = favorite[cur];
            }
            int len = set.size();
            while (start != cur) {
                len--;
                start = favorite[start];
            }

            longestCycle = Math.max(longestCycle, len);
            if (len == 2) {
                twoLenCycles.add(new int[] { cur, favorite[cur] });
            }
        }

        List<List<Integer>> reverseList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            reverseList.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            reverseList.get(favorite[i]).add(i);
        }
        int max2lenCyclePath = 0;

        for (int arr[] : twoLenCycles) {
            max2lenCyclePath += f(arr[0], arr[1], reverseList) + f(arr[1], arr[0], reverseList) + 2;
        }

        return Math.max(max2lenCyclePath, longestCycle);
    }

    private int f(int node, int skip, List<List<Integer>> reverseList) {
        int len = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { node, 0 });
        while (!queue.isEmpty()) {
            int cur[] = queue.poll();
            len = Math.max(len, cur[1]);
            for (int neighbour : reverseList.get(cur[0])) {
                if (neighbour == skip) {
                    continue;
                }
                queue.offer(new int[] { neighbour, cur[1] + 1 });
            }
        }

        return len;
    }

    public static void main(String[] args) {
        Maximum_Employees_to_Be_Invited_to_a_Meeting obj = new Maximum_Employees_to_Be_Invited_to_a_Meeting();
        int favorite[] = { 2, 2, 1, 2 };
        System.out.println(obj.maximumInvitations(favorite)); // Output: 3

        favorite = new int[] { 1, 2, 0 };
        System.out.println(obj.maximumInvitations(favorite)); // Output: 3

        favorite = new int[] { 3, 0, 1, 4, 1 };
        System.out.println(obj.maximumInvitations(favorite)); // Output: 4
    }
}

/*
 * 2127. Maximum Employees to Be Invited to a Meeting Solved Hard Topics
 * Companies Hint A company is organizing a meeting and has a list of n
 * employees, waiting to be invited. They have arranged for a large circular
 * table, capable of seating any number of employees.
 * 
 * The employees are numbered from 0 to n - 1. Each employee has a favorite
 * person and they will attend the meeting only if they can sit next to their
 * favorite person at the table. The favorite person of an employee is not
 * themself.
 * 
 * Given a 0-indexed integer array favorite, where favorite[i] denotes the
 * favorite person of the ith employee, return the maximum number of employees
 * that can be invited to the meeting.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: favorite = [2,2,1,2] Output: 3 Explanation: The above figure shows how
 * the company can invite employees 0, 1, and 2, and seat them at the round
 * table. All employees cannot be invited because employee 2 cannot sit beside
 * employees 0, 1, and 3, simultaneously. Note that the company can also invite
 * employees 1, 2, and 3, and give them their desired seats. The maximum number
 * of employees that can be invited to the meeting is 3. Example 2:
 * 
 * Input: favorite = [1,2,0] Output: 3 Explanation: Each employee is the
 * favorite person of at least one other employee, and the only way the company
 * can invite them is if they invite every employee. The seating arrangement
 * will be the same as that in the figure given in example 1: - Employee 0 will
 * sit between employees 2 and 1. - Employee 1 will sit between employees 0 and
 * 2. - Employee 2 will sit between employees 1 and 0. The maximum number of
 * employees that can be invited to the meeting is 3. Example 3:
 * 
 * 
 * Input: favorite = [3,0,1,4,1] Output: 4 Explanation: The above figure shows
 * how the company will invite employees 0, 1, 3, and 4, and seat them at the
 * round table. Employee 2 cannot be invited because the two spots next to their
 * favorite employee 1 are taken. So the company leaves them out of the meeting.
 * The maximum number of employees that can be invited to the meeting is 4.
 * 
 * 
 * Constraints:
 * 
 * n == favorite.length 2 <= n <= 105 0 <= favorite[i] <= n - 1 favorite[i] != i
 */