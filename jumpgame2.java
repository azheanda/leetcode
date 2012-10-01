/*
    judge small: passed 510ms
    judge large: passed 540ms
    Inspired by Su Shao. 
*/

public class Solution {
    public boolean canJump(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int i=0;
        int range= 0;
        
        while(i<=range){
            range = Math.max(range,i+A[i]);
            if(range>=A.length-1)
                return true;
            i++;
        }
        return false;
        
    }
}