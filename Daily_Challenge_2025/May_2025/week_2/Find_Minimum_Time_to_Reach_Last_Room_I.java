import java.util.Arrays;
import java.util.PriorityQueue;

public class Find_Minimum_Time_to_Reach_Last_Room_I {
    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length, m = moveTime[0].length;
        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++)
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        dist[0][0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[] { 0, 0, 0 });

        int[] dr = { 1, -1, 0, 0 }, dc = { 0, 0, 1, -1 };
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int t = cur[0], r = cur[1], c = cur[2];
            if (r == n - 1 && c == m - 1)
                return t;
            if (t > dist[r][c])
                continue;

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d], nc = c + dc[d];
                if (nr < 0 || nr >= n || nc < 0 || nc >= m)
                    continue;
                int depart = Math.max(t, moveTime[nr][nc]);
                int arrive = depart + 1;
                if (arrive < dist[nr][nc]) {
                    dist[nr][nc] = arrive;
                    pq.offer(new int[] { arrive, nr, nc });
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Find_Minimum_Time_to_Reach_Last_Room_I f = new Find_Minimum_Time_to_Reach_Last_Room_I();
        System.out.println(f.minTimeToReach(new int[][] { { 0, 4 }, { 4, 4 } })); // 6
        System.out.println(f.minTimeToReach(new int[][] { { 0, 0, 0 }, { 0, 0, 0 } })); // 3
    }
}

/*
 * 3341. Find Minimum Time to Reach Last Room I Solved Medium Topics Companies
 * Hint There is a dungeon with n x m rooms arranged as a grid.
 * 
 * You are given a 2D array moveTime of size n x m, where moveTime[i][j]
 * represents the minimum time in seconds when you can start moving to that
 * room. You start from the room (0, 0) at time t = 0 and can move to an
 * adjacent room. Moving between adjacent rooms takes exactly one second.
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
 * Output: 6
 * 
 * Explanation:
 * 
 * The minimum time required is 6 seconds.
 * 
 * At time t == 4, move from room (0, 0) to room (1, 0) in one second. At time t
 * == 5, move from room (1, 0) to room (1, 1) in one second. Example 2:
 * 
 * Input: moveTime = [[0,0,0],[0,0,0]]
 * 
 * Output: 3
 * 
 * Explanation:
 * 
 * The minimum time required is 3 seconds.
 * 
 * At time t == 0, move from room (0, 0) to room (1, 0) in one second. At time t
 * == 1, move from room (1, 0) to room (1, 1) in one second. At time t == 2,
 * move from room (1, 1) to room (1, 2) in one second. Example 3:
 * 
 * Input: moveTime = [[0,1],[1,2]]
 * 
 * Output: 3
 * 
 * 
 * 
 * Constraints:
 * 
 * 2 <= n == moveTime.length <= 50 2 <= m == moveTime[i].length <= 50 0 <=
 * moveTime[i][j] <= 109
 */