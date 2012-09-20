public class Solution {
    public int maxArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int max = 0 , left=0,right= height.length-1;
        while(left<right){
            int d = Math.min(height[left],height[right]);
            int area = d*(right-left);
            if(area>max)
                max = area;
            
            if(d == height[left])
                while(left<height.length && height[left]<=d)
                    left++;            
            else
                while(right>=0 && height[right]<=d)
                    right--;
        }  
        return max;
    }
}