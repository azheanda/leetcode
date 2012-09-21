/*
    judge small: passed
    judge larget: runtime error(there is a input array is extremely long that leads to stackoverflow error)
*/    


    public class Solution {
        public int largestRectangleArea(int[] height) {
            // Start typing your Java solution below
            // DO NOT write main() function
            return find_largestRectangleArea(height,0,height.length-1);    
        }
        
        public int find_largestRectangleArea(int[] height,int l, int r){
            int lowest=0, maxArea = 0;
            if(l<=r){
                lowest = find_min(height,l,r);
                int area = height[lowest]*(r+1-l);
                
                maxArea = Math.max(
                find_largestRectangleArea(height,l,lowest-1),
                find_largestRectangleArea(height,lowest+1,r));
                
                return area>maxArea?area:maxArea;
            }
            return 0;    
        }
        
        
        public int find_min(int[] A,int l, int r){
            int minIndex =l;
            if(l<=r)
                for(int i=l;i<=r;i++)
                    if(A[i]<A[minIndex])
                        minIndex = i;
            return minIndex;
                
        }
        
    }