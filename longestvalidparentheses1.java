/*
    judge small : passed
    judge large : TLE
    This is an obvious lame solution in term of complexity of the code structure.
    I first came up with stack, in which we store '('. But since the only 
    element we store is '(', we can use a counter instead. However, a better way
    is using stack to store the position of '(' and ')',which is in longestvalidprentheses2.java.

*/

public class Solution {
    public int longestValidParentheses(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int max=0;
        int i=0;
        
        while(i<s.length()){
            int end=i;
            int numLeftprent=1;
            if(s.charAt(end)=='(' && end!=s.length()-1){
                while( ++end<s.length()){
                    if(s.charAt(end)=='(')
                        numLeftprent++;
                    else
                        numLeftprent--;
                    if(numLeftprent==0)
                        max = Math.max(max,end-i+1+numLeftprent);
                    if(numLeftprent==-1 || (numLeftprent==0 && end==s.length()-1)){
                        max = Math.max(max,end-i+1+numLeftprent);
                        i = end+1;    
                        break;
                    }else if(end==s.length()-1)
                        i++;                   
                 }
                   
            }else
                i++;
        }
        return max;
    }
}