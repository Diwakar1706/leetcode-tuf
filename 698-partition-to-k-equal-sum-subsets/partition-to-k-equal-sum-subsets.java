class Solution {
    public boolean canPartitionKSubsets(int[] a, int k) {
        int sum = 0;
        for (int x : a) sum += x;

        if (sum % k != 0) return false;

        int target = sum / k;
        Arrays.sort(a);

        int n = a.length;
        if (a[n - 1] > target) return false;

        int[] b = new int[k];
        return dfs(a, n - 1, b, target);
    }

    boolean dfs(int[] a, int i, int[] b, int t) {
        if (i < 0) return true;

        int x = a[i];

        for (int j = 0; j < b.length; j++) {
            if (b[j] + x <= t) {
                b[j] += x;

                if (dfs(a, i - 1, b, t)) return true;

                b[j] -= x;
            }

            // pruning: avoid same empty bucket
            if (b[j] == 0) break;
        }
        return false;
    }
}
