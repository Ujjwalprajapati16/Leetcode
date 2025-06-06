import java.util.Comparator;
import java.util.PriorityQueue;

public class Find_Minimum_Time_to_Reach_Last_Room_II {
    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length, m = moveTime[0].length;
        int[][][] time = new int[n][m][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 2; k++) {
                    time[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[] { 0, 0, 0, 0 });
        int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currTime = curr[0];
            int x = curr[1];
            int y = curr[2];
            int parity = curr[3];

            for (int[] d : dirs) {
                int nx = x + d[0];
                int ny = y + d[1];
                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    int moveCost = (parity == 0) ? 1 : 2;
                    int waitTime = Math.max(currTime, moveTime[nx][ny]);
                    int arrivalTime = waitTime + moveCost;
                    int nextParity = 1 - parity;

                    if (arrivalTime < time[nx][ny][nextParity]) {
                        time[nx][ny][nextParity] = arrivalTime;
                        pq.offer(new int[] { arrivalTime, nx, ny, nextParity });
                    }
                }
            }
        }
        return Math.min(time[n - 1][m - 1][0], time[n - 1][m - 1][1]);
    }

    public static void main(String[] args) {
        Find_Minimum_Time_to_Reach_Last_Room_II obj = new Find_Minimum_Time_to_Reach_Last_Room_II();
        int[][] moveTime = { { 0, 4 }, { 4, 4 } };
        System.out.println(obj.minTimeToReach(moveTime)); // 7

        int[][] moveTime2 = { { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };
        System.out.println(obj.minTimeToReach(moveTime2)); // 6
    }
}

/*
 * 3342. Find Minimum Time to Reach Last Room II Solved Medium Topics Companies
 * Hint There is a dungeon with n x m rooms arranged as a grid.
 * 
 * You are given a 2D array moveTime of size n x m, where moveTime[i][j]
 * represents the minimum time in seconds when you can start moving to that
 * room. You start from the room (0, 0) at time t = 0 and can move to an
 * adjacent room. Moving between adjacent rooms takes one second for one move
 * and two seconds for the next, alternating between the two.
 * 
 * Return the minimum time to reach the room (n - 1, m - 1).
 * 
 * Two rooms are adjacent if they share a common wall, either horizontally or
 * vertically.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: moveTime = [[0,4],[4,4]]
 * 
 * Output: 7
 * 
 * Explanation:
 * 
 * The minimum time required is 7 seconds.
 * 
 * At time t == 4, move from room (0, 0) to room (1, 0) in one second. At time t
 * == 5, move from room (1, 0) to room (1, 1) in two seconds. Example 2:
 * 
 * Input: moveTime = [[0,0,0,0],[0,0,0,0]]
 * 
 * Output: 6
 * 
 * Explanation:
 * 
 * The minimum time required is 6 seconds.
 * 
 * At time t == 0, move from room (0, 0) to room (1, 0) in one second. At time t
 * == 1, move from room (1, 0) to room (1, 1) in two seconds. At time t == 3,
 * move from room (1, 1) to room (1, 2) in one second. At time t == 4, move from
 * room (1, 2) to room (1, 3) in two seconds. Example 3:
 * 
 * Input: moveTime = [[0,1],[1,2]]
 * 
 * Output: 4
 * 
 * 
 * 
 * Constraints:
 * 
 * 2 <= n == moveTime.length <= 750 2 <= m == moveTime[i].length <= 750 0 <=
 * moveTime[i][j] <= 109
 */