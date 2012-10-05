/*
	http://stackoverflow.com/questions/2478447/find-largest-rectangle-containing-only-zeros-in-an-nn-binary-matrix/4671342#4671342
	Basically, I rewrote the python version of answer in Java.
	judge small :passed
	judge large :TLE  How can this be possbile?! This solution's already decent.
*/

import java.util.*;
public class Solution {
    public int maximalRectangle(char[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(matrix.length==0)
            return 0;
        int M=matrix.length;
        int N=matrix[0].length;
            
        int[] prevRow = new int[N];
        int[] currRow = new int[N];
        int max_size=0;

        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++)
            	currRow[j] = matrix[i][j]=='1'?prevRow[j]+1:0;

        	max_size= Math.max(largestRectangleArea(currRow),max_size);
        	prevRow = currRow;
        	currRow = new int[N];
        }
        return max_size;        
    }

	 public int largestRectangleArea(int[] height) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        Stack<Pair> stack = new Stack<Pair>();
	        int max_area=0;
	        int pos=0;

	        for(pos=0;pos<height.length;pos++){
	            int start = pos;
	        	while(true){
	        		if(stack.empty() || height[pos]>stack.peek().height)
	        			stack.push(new Pair(height[pos],start));
	        		else if(!stack.empty() && height[pos]<stack.peek().height){
	        			max_area = Math.max(max_area,stack.peek().height*(pos-stack.peek().start));
	        			start = stack.pop().start;
	        			continue;
	        		}
	        		break;
	        	}

	        }

	        while(!stack.empty()){
	        	Pair p = stack.pop();
	        	max_area = Math.max(max_area,p.height*(pos-p.start));//pos=height.length
	        }
	        return max_area;

	    }

	    private class Pair{
	    	public int height;
	    	public int start;
	    	public Pair(int height,int start){
	    		this.height = height;
	    		this.start = start;
	    	}
	    }

}


/*

There is some corner we can optimize into--- we can tell the largset possbile
area of a histogram by the sumOfheights, and compare it to the current max_area to 
see if the histogram worth exploring or not.

judge large: Half of the times AC, another half TLE

	public int maximalRectangle(char[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(matrix.length==0)
            return 0;
        int M=matrix.length;
        int N=matrix[0].length;
            
        int[] prevRow = new int[N];
        int[] currRow = new int[N];
        int max_size=0;

        for(int i=0;i<M;i++){
            int sumOfheights = 0;
            for(int j=0;j<N;j++){
            	currRow[j] = matrix[i][j]=='1'?prevRow[j]+1:0;
                sumOfheights += currRow[j];
            }
                
            
            if(sumOfheights*N>max_size)
        	    max_size= Math.max(largestRectangleArea(currRow),max_size);
        	prevRow = currRow;
        	currRow = new int[N];
        }
        return max_size;        
    }


*/
