public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        int[][] dp = new int[m][n];
        
        
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++){               
                if(obstacleGrid[i][j]==1)
                    continue; 
                else if(i==0 && j==0)
                    dp[i][j] = 1;                
                else if(i==0 || j==0)
                    dp[i][j]=i==0?dp[i][j-1]:dp[i-1][j];
                else 
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        return dp[m-1][n-1];
    }
}