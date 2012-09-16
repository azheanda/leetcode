/*
    judge small : passed
    judge large : time limit exceeded
*/


public class Solution {
    public int climbStairs(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(n==0)
            return 0;
        else
            return climbStairs(0,n);
        
    }
    
    public int climbStairs(int level,int n){
        if(level> n)
            return 0;
        else if(level==n)
            return 1;
        else 
            return climbStairs(level+1,n)+climbStairs(level+2,n);
        
    }
}