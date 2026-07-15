class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
               int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int[][] dp=new int[m+1][n+1];
        for(int[] r:dp){
            Arrays.fill(r,-1);
        }
 
        return solve(0,0,obstacleGrid,m,n,dp);      
    }
    int solve(int i,int j, int[][]arr,int m, int n,int[][]dp){
        if(i>=m || j>=n){
            return 0;
        }
        if(arr[i][j]==1){
            return 0;
        }
        if(i==m-1 && j==n-1){
            return 1;
        }

        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int down=solve(i+1,j,arr,m,n,dp);
        int right=solve(i,j+1,arr,m,n,dp);
        return dp[i][j]=down+right;
    }
}