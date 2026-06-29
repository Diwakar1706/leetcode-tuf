import java.util.*;

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a[1] == b[1])
                    return b[0] - a[0];   // larger element first
                return b[1] - a[1];       // larger difference first
            }
        );

        for (int val : arr) {
            int diff = Math.abs(val - x);

            pq.offer(new int[]{val, diff});

            if (pq.size() > k)
                pq.poll();
        }

        List<Integer> ans = new ArrayList<>();

        while (!pq.isEmpty()) {
            ans.add(pq.poll()[0]);
        }

        Collections.sort(ans);

        return ans;
    }
}