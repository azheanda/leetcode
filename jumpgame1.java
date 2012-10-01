/*
    Judge small : passed 490ms
    Judge large : passed 560ms

*/

public class Solution {
    public boolean canJump(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A.length==0)
            return true;
            
        boolean[] dp = new boolean[A.length];
        dp[0] = true;
        for(int i=0;i<dp.length;i++)
            for(int j=1;j<=A[i] && i+j<dp.length && dp[i]==true &&dp[i+j]!=true;j++)
                    dp[i+j]=true;
            
        return dp[dp.length-1];
        
        
        
    }
}