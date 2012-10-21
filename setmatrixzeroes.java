// constant space solution

public class Solution {
    public void setZeroes(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int M = matrix.length;
        int N = matrix[0].length;
        int firstRow = 1;
        
        for(int i=0;i<M;i++)
     		for(int j=0;j<N;j++)
     			if(matrix[i][j]==0){
     				matrix[0][j]=0;
     				if(i==0)
     					firstRow = 0;
     				else
     					matrix[i][0]=0;
     			}
     		
	
     	// set those rows and colomns to 0. Notice: the order matters!
     	// 1. set those rows except for the first one to 0
		for(int i=1;i<M;i++)
			if(matrix[i][0]==0)
				for(int j=0;j<N;j++)
					matrix[i][j]=0;
         
        // 2. set those columns to 0
        for(int j=0;j<N;j++)
			if(matrix[0][j]==0)
				for(int i=0;i<M;i++)
					matrix[i][j]=0; 

		// 3. set first row to 0
		if(firstRow==0)
			for(int j=0;j<N;j++)
				matrix[0][j]=0;
    }
}