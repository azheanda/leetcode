/*
	The Rabin-Karp Algorithm for string matching.
	If BASE = 101 , then it won't pass 3 out of 67 test cases in judge large.
	If BASE = 31, then it won't 1 out of 67.
	If BASE = 11, then passed.
	
	I assume that it won't pass the judge when BASE = 101 or 31 is because some hash results
	overflow.

	What the most frustrating thing is that the naive algorithm is even a little bit faster than this 
	Rabin-Karp algorithm with leetcode's test cases.


*/

public class Solution {
    public String strStr(String haystack, String needle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int M = haystack.length();
    	int N = needle.length();
        
        if(M<N)
        	return null;

        int BASE = 11;
        long hashneedle = hash(needle,BASE);
        long hashsubstr = hash(haystack.substring(0,N),BASE);

        if(hashneedle==hashsubstr && needle.equals(haystack.substring(0,N)))
        	return haystack;

        for(int i=1;i<M-N+1;i++){
        	hashsubstr = hashsubstr - (long)(haystack.charAt(i-1)*Math.pow(BASE,N-1));
        	hashsubstr = BASE*hashsubstr+haystack.charAt(i+N-1);
        	if (hashneedle == hashsubstr && needle.equals(haystack.substring(i,N+i)))
        			return haystack.substring(i);
        }
        return null;

    }
    
    
    public long hash(String str,int BASE){
    	long h=0;
    	for(int i=0;i<str.length();i++)
    		h=BASE*h+str.charAt(i);
    	return h;
    }

}