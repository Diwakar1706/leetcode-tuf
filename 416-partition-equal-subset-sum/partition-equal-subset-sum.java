class Solution {
    public boolean canPartition(int[] nums) {
        
        int n=nums.length;
        int sum=0;
        for(int i=0; i<n; i++){
            sum+=nums[i];
        }
        Boolean[][] dp=new Boolean[n+1][sum+1];
        if(sum%2!=0){
            return false;
        }else{
            return solve(nums,n-1, (sum/2),dp);
        }
        
    }
     static boolean solve(int[] nums, int n, int sum,Boolean[][] dp){
        if(sum==0){
            return true;
        }
        if(n==0){
            return nums[0]==sum;
        }
        if(dp[n][sum]!=null){
            return dp[n][sum];
        }
        boolean skip=solve(nums,n-1,sum,dp);
        boolean take=false;
        if(nums[n]<=sum){
            take=solve(nums,n-1,sum-nums[n],dp);
        }
        return dp[n][sum]=skip || take;
     }
}