public class Solution {
    public int minPathSum(int[][] grid) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        for(int i=0;i<grid.length;i++)
            for(int j=0;j<grid[i].length;j++){
                if(i==0 && j>0)
                    grid[i][j] += grid[i][j-1];
                else if(i>0&&j==0)
                    grid[i][j] += grid[i-1][j];
                else if(i>0 && j>0)
                    grid[i][j] += Math.min(grid[i][j-1],grid[i-1][j]);                                   
                
            }
        return grid[grid.length-1][grid[0].length-1];
        
    }
}