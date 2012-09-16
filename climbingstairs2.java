/*
    judge small : passed 540ms
    judge large : passed 520ms

    Added cache to the previous solution.
*/

import java.util.*;
public class Solution {
    public int climbStairs(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(n==0)
            return 0;
        else{
            HashMap<Integer,Integer> cache = new HashMap<Integer,Integer>();
            return climbStairs(0,n,cache);
        }
    }
    
    public int climbStairs(int level,int n,HashMap<Integer,Integer> cache){
        if(level> n)
            return 0;
        else if(level==n)
            return 1;
        else {
            int count1=0;
            int count2=0;
            if(cache.containsKey(level+1))
                count1 = cache.get(level+1);
            else{
                count1 = climbStairs(level+1,n,cache);
                cache.put(level+1,count1);
            }
            if(cache.containsKey(level+2))
                count2 = cache.get(level+2);
            else{
                count2 = climbStairs(level+2,n,cache);
                cache.put(level+2,count2);
            }
            
            return count1+count2;
        }
        
    }
}