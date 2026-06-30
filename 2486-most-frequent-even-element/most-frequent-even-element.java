class Solution {
    public int mostFrequentEven(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int ele : nums) {
            if (ele % 2 == 0) {
                map.put(ele, map.getOrDefault(ele, 0) + 1);
            }
        }

        int ans = -1;
        int maxFreq = 0;
        for (int key : map.keySet()) {
            int freq = map.get(key);

            if (freq > maxFreq || (freq == maxFreq && key < ans)) {
                maxFreq = freq;
                ans = key;
            }
        }

        return ans;
    }
}