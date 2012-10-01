/*
    if split() is a taboo, then...

*/

public class Solution {
    public int lengthOfLastWord(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
            int lastletter=-1,firstletter=0;
            for(int i=s.length()-1;i>=0;i--)
                if(s.charAt(i)!=' ') {
                    lastletter = i;
                    break;
                }
            
            for(int i=lastletter-1;i>=0;i--)
                if(s.charAt(i)==' '){
                    firstletter = i+1;
                    break;
                }
                    
            return lastletter-firstletter+1;
    }
}