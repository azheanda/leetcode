/*
	O(n) time complexity solution
	Rewritten from http://www.leetcode.com/2010/11/finding-minimum-window-in-s-which.html.
*/

public class Solution {
    public String minWindow(String S, String T) {
            int SLen=S.length();
	        int TLen=T.length();
	        int[] needToFind = new int[256];
	        
	        for(int i=0;i<TLen;i++)
	            needToFind[T.charAt(i)]++;

	        int[] hasFound = new int[256];
	        int minWindowLen =Integer.MAX_VALUE;
	        int count=0;
	        int minWindowBegin=0;
	        int minWindowEnd =0;
	        for(int begin=0,end=0;end<SLen;end++){
	        		char bchar = S.charAt(begin);
	        		char echar = S.charAt(end);

	        		if(needToFind[echar]==0)
	                    continue;
	                    
					hasFound[echar]++;       
					if(hasFound[echar]<=needToFind[echar])    
						count++;

					if(count == TLen){
						while(needToFind[bchar]==0|| hasFound[bchar] > needToFind[bchar]){
							if(hasFound[bchar] > needToFind[bchar])
									hasFound[bchar]--;
							bchar = S.charAt(++begin);
							
						}

						int windowLen = end-begin+1;
						if(windowLen < minWindowLen){
							minWindowBegin = begin;
							minWindowEnd = end;
							minWindowLen = windowLen;
						}
					} 
	        }
	        return count==TLen?S.substring(minWindowBegin,minWindowEnd+1):"";
	        
	    }
}