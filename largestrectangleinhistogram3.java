/*
  Explanation here: http://tech-queries.blogspot.com/2011/03/maximum-area-rectangle-in-histogram.html
*/

import java.util.*;
public class Solution {
    public int largestRectangleArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] area = new int[height.length];
        int t=0;
        Stack<Integer> stack = new Stack<Integer>();

        for(int i=0;i<height.length;i++){
          while(!stack.empty() && height[i]<=height[stack.peek()])
                stack.pop();
          
          if(stack.empty())
            t = -1;
          else
            t = stack.peek();

          area[i] = i-t-1;
          stack.push(i);
        }

        while(!stack.empty())
          stack.pop();

        for(int i=height.length-1;i>=0;i--){
          while(!stack.empty() && height[i]<=height[stack.peek()])
                stack.pop();
          
          if(stack.empty())
            t = height.length;
          else
            t = stack.peek();

          area[i] += t-i-1;
          stack.push(i);
        }

        int max = 0;  
        //Calculating Area[i] and find max Area  
        for (int i=0; i<area.length; i++)  {  
            area[i] = height[i] * (area[i] + 1);  
            if (area[i] > max)  
              max = area[i];  
        }  
          
        return max;  
    }
}
 