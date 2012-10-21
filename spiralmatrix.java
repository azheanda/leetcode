/*
    It took a lot of time for me to figure out about the base case and how to add it into the program. 
    It would be easier to write a recursive verison:http://www.leetcode.com/2010/05/printing-matrix-in-spiral-order.html
*/
public class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function        
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(matrix.length==0)
            return res;
        
        int M = matrix.length;
        int N = matrix[0].length;
        int lvl = M<=N? (M+1)/2:(N+1)/2;
        
        
        for(int clvl=0;clvl<lvl;clvl++){          
            for(int j=clvl;j<N-clvl;j++)        // top
                res.add(matrix[clvl][j]);
            for(int i=clvl+1;i<M-clvl;i++)      // right
                res.add(matrix[i][N-clvl-1]);
            
            if(clvl < M-clvl-1)
                for(int j=N-clvl-2;j>=clvl;j--)     // bot
                    res.add(matrix[M-clvl-1][j]);
            if(clvl < N-clvl-1)
                for(int i=M-clvl-2;i>clvl;i--)      // left
                    res.add(matrix[i][clvl]);              
        }
                    
        
        return res;
        
    }
}