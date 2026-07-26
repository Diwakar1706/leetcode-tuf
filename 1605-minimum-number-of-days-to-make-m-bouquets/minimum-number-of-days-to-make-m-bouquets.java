class Solution {

    public int minDays(int[] bloomDay, int m, int k) {

        if ((long)m * k > bloomDay.length)
            return -1;

        int low = min(bloomDay);
        int high = max(bloomDay);

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (canMake(bloomDay, mid, m, k)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    static boolean canMake(int[] bloomDay, int day, int m, int k) {

        int bouquet = 0;
        int count = 0;

        for (int bloom : bloomDay) {

            if (bloom <= day) {

                count++;

                if (count == k) {
                    bouquet++;
                    count = 0;
                }

            } else {
                count = 0;
            }
        }

        return bouquet >= m;
    }

    static int min(int[] arr) {

        int min = Integer.MAX_VALUE;

        for (int x : arr)
            min = Math.min(min, x);

        return min;
    }

    static int max(int[] arr) {

        int max = Integer.MIN_VALUE;

        for (int x : arr)
            max = Math.max(max, x);

        return max;
    }
}