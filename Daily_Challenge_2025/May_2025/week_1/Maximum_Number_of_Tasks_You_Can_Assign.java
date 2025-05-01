
import java.util.Arrays;
import java.util.TreeMap;

public class Maximum_Number_of_Tasks_You_Can_Assign {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        Arrays.sort(workers);

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int w : workers) {
            map.put(w, map.getOrDefault(w, 0) + 1);
        }

        int n = tasks.length;
        int m = workers.length;
        int start = 0, end = Math.min(n, m);
        int ans = 0;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (isPossible(mid, tasks, map, pills, strength)) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return ans;
    }

    private boolean isPossible(int mid, int[] tasks, TreeMap<Integer, Integer> map, int pills, int strength) {
        TreeMap<Integer, Integer> clone = new TreeMap<>(map);
        int p = pills;

        for (int i = mid - 1; i >= 0; i--) {
            int t = tasks[i];
            Integer hi = clone.floorKey(Integer.MAX_VALUE); // strongest available
            if (hi != null && hi >= t) {
                decrease(clone, hi);
            } else {
                if (p == 0)
                    return false;
                Integer lo = clone.ceilingKey(t - strength);
                if (lo == null)
                    return false;
                decrease(clone, lo);
                p--;
            }
        }
        return true;
    }

    private void decrease(TreeMap<Integer, Integer> map, int key) {
        if (map.get(key) == 1) {
            map.remove(key);
        } else {
            map.put(key, map.get(key) - 1);
        }
    }

    public static void main(String[] args) {
        Maximum_Number_of_Tasks_You_Can_Assign obj = new Maximum_Number_of_Tasks_You_Can_Assign();
        System.out.println(obj.maxTaskAssign(new int[] { 3, 2, 1 }, new int[] { 0, 3, 3 }, 1, 1));
        System.out.println(obj.maxTaskAssign(new int[] { 1, 2, 3 }, new int[] { 0, 3, 3 }, 2, 2));
    }
}

/*
 * 2071. Maximum Number of Tasks You Can Assign Solved Hard Topics Companies
 * Hint You have n tasks and m workers. Each task has a strength requirement
 * stored in a 0-indexed integer array tasks, with the ith task requiring
 * tasks[i] strength to complete. The strength of each worker is stored in a
 * 0-indexed integer array workers, with the jth worker having workers[j]
 * strength. Each worker can only be assigned to a single task and must have a
 * strength greater than or equal to the task's strength requirement (i.e.,
 * workers[j] >= tasks[i]).
 * 
 * Additionally, you have pills magical pills that will increase a worker's
 * strength by strength. You can decide which workers receive the magical pills,
 * however, you may only give each worker at most one magical pill.
 * 
 * Given the 0-indexed integer arrays tasks and workers and the integers pills
 * and strength, return the maximum number of tasks that can be completed.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: tasks = [3,2,1], workers = [0,3,3], pills = 1, strength = 1 Output: 3
 * Explanation: We can assign the magical pill and tasks as follows: - Give the
 * magical pill to worker 0. - Assign worker 0 to task 2 (0 + 1 >= 1) - Assign
 * worker 1 to task 1 (3 >= 2) - Assign worker 2 to task 0 (3 >= 3) Example 2:
 * 
 * Input: tasks = [5,4], workers = [0,0,0], pills = 1, strength = 5 Output: 1
 * Explanation: We can assign the magical pill and tasks as follows: - Give the
 * magical pill to worker 0. - Assign worker 0 to task 0 (0 + 5 >= 5) Example 3:
 * 
 * Input: tasks = [10,15,30], workers = [0,10,10,10,10], pills = 3, strength =
 * 10 Output: 2 Explanation: We can assign the magical pills and tasks as
 * follows: - Give the magical pill to worker 0 and worker 1. - Assign worker 0
 * to task 0 (0 + 10 >= 10) - Assign worker 1 to task 1 (10 + 10 >= 15) The last
 * pill is not given because it will not make any worker strong enough for the
 * last task.
 * 
 * 
 * Constraints:
 * 
 * n == tasks.length m == workers.length 1 <= n, m <= 5 * 104 0 <= pills <= m 0
 * <= tasks[i], workers[j], strength <= 109
 */