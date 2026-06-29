import java.util.*;

class Solution {

    static class Pair {
        int x, y, dist;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
            this.dist = x * x + y * y;
        }
    }

    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> b.dist - a.dist
        );

        for (int[] p : points) {
            pq.offer(new Pair(p[0], p[1]));

            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[][] ans = new int[k][2];

        for (int i = 0; i < k; i++) {
            Pair cur = pq.poll();
            ans[i][0] = cur.x;
            ans[i][1] = cur.y;
        }

        return ans;
    }
}