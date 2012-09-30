/*
    judge small:590 ms
    judge large:640 ms

    dynamic programming. For each pair of the indexes i&j and value in matrix dp, it means whether the interleaving of s1.substring(0:i) and s2.substring(0:j) forms s3.substring(0,i+j). Yes if value == true, No if value ==false.

*/

public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s1.length()+s2.length()!=s3.length())
            return false;

            int M = s1.length();
            int N = s2.length();
            
        boolean[][] dp = new boolean[M+1][N+1];

        /*-------------------block start----------------*/
        dp[0][0] = true;
        for(int i=1;i<M+1;i++)
            dp[i][0]= s1.charAt(i-1)==s3.charAt(i-1) && dp[i-1][0];
            
        for(int j=1;j<N+1;j++)
            dp[0][j] = s2.charAt(j-1)==s3.charAt(j-1) && dp[0][j-1];
                        
        for(int i=1;i<M+1;i++)                
            for(int j=1;j<N+1;j++)
                dp[i][j] =(dp[i-1][j]&& s1.charAt(i-1)==s3.charAt(i+j-1))||
                    (dp[i][j-1] && s2.charAt(j-1)==s3.charAt(i+j-1));
        /*-------------------block end----------------*/
            
        return dp[M][N];    
             
    }
}

/*
        The block can be revised as:
        dp[0][0] =true;
        for(int i=0;i<M+1;i++)                
            for(int j=0;j<N+1;j++){
                if(i>0 && s1.charAt(i-1)==s3.charAt(i+j-1))
                    dp[i][j] |= dp[i-1][j];
                if(j>0 && s2.charAt(j-1)==s3.charAt(i+j-1))
                    dp[i][j] |= dp[i][j-1];
            }
        }


*/