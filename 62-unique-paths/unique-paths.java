class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[101][101];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
    
        return solve(0,0,m,n,dp);
        
        
    }
    int solve(int i, int j, int m, int n,int[][] dp){
        if(i==m-1 && j==n-1){
            return 1;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(i>=m || i<0 || j>=n || j<0){
            return 0;
        }
        int right=solve(i,j+1,m,n,dp);
        int down=solve(i+1,j,m,n,dp);
        return dp[i][j]=right+down;
    }
}