/*
    judge small : passed 470ms
    judge large : passed 510ms

    This is Chi Su's solution on his github. His solution reminds me of me reading this problem and similar answer before囧.
    Anyway, this solution is more elegant than climbingstairs2.java and more effecient than climbingstairs1.java.
*/


import java.util.*;
public class Solution {
    public int climbStairs(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] level =  new int[n+1];
        level[0] = 1;
        level[1] = 1;
        for(int i=2;i<level.length;i++)
            level[i] = level[i-1]+level[i-2];
        return level[n];
         
    } 
}