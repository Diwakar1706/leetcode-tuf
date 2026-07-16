class Solution {
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] dp=new int[m+1][n+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return solve(0,0,grid,m,n,dp);   
    }
    int solve(int i, int j, int[][] grid,int m, int n,int[][]dp){
        if(i>=m || j>=n){
            return Integer.MAX_VALUE;
        }
        if(i==m-1 && j==n-1){
            return grid[i][j];
        }
        if(dp[i][j]!=-1) return dp[i][j];
        int down=+solve(i+1,j,grid,m,n,dp);
        int right=+solve(i,j+1,grid,m,n,dp);
        return dp[i][j]=grid[i][j]+Math.min(down,right);
    }
}