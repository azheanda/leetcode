/*
	http://stackoverflow.com/questions/4311694/maximize-the-rectangular-area-under-histogram
	It was originially written in Python which has tuple to store height and start. I rewrote 
	with Java ,with which I had to create a pair class. This is lame.
*/

import java.util.*;
public class Solution {
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