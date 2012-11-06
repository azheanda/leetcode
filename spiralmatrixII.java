/*
    A little revision of spiralmatrix.java
*/

public class Solution {
    public int[][] generateMatrix(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[][] res = new int[n][n];
        if(n==0)
            return res;
        
        int lvl = (n+1)/2;
        int c=1;
        
        
        for(int clvl=0;clvl<lvl;clvl++){          
            for(int j=clvl;j<n-clvl;j++)        // top
                res[clvl][j]=c++;
            for(int i=clvl+1;i<n-clvl;i++)      // right
                res[i][n-clvl-1]=c++;     
            if(clvl < n-clvl-1)
                for(int j=n-clvl-2;j>=clvl;j--)     // bot
                    res[n-clvl-1][j]=c++;
            if(clvl < n-clvl-1)
                for(int i=n-clvl-2;i>clvl;i--)      // left
                    res[i][clvl]=c++;              
        }
                    
        
        return res;
        
        
        
        
    }
}