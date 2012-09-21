/*
	judge small:passed
	judge larget: time limit exceeded in the last test case.
*/
    public class Solution {
        public int largestRectangleArea(int[] height) {
            // Start typing your Java solution below
            // DO NOT write main() function
            if(height.length==0)
                return 0;
                    
            int max = 0;
            for(int i=0;i<height.length;i++){
                int lowest = height[i];
                for(int j=i;j<height.length;j++){
                        if(height[j]<lowest)
                            lowest = height[j];
                        int area = lowest*(j+1-i);
                        if(area>max)
                            max =area;
                }
            }
                                
            return max;
        }
    }