class Solution {
    public int maxFrequency(int[] nums, int k) {
        int n=nums.length;
        Arrays.sort(nums);
        int result=0;
        long currSum=0;
        int i=0;
        for(int j=0; j<n; j++){
            int target=nums[j];
            currSum+=nums[j];  
            while((long) nums[j] * (j - i + 1) - currSum>k){
                currSum-=nums[i];
                i++;
            }
            result=Math.max(result,j-i+1);
        }
        return result;
        
        
    }
}