class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int n=nums.length;
        int maxval=nums[0];
        int minval=nums[0];
        for(int i=1; i<n; i++){
            maxval=Math.max(maxval,nums[i]);
            minval=Math.min(minval,nums[i]);
        }

        return 1L*k*(maxval-minval);    
    }
}