/*
	Catalan number
	http://stackoverflow.com/questions/1352776/the-possible-number-of-binary-search-trees-that-can-be-created-with-n-keys-is-gi
*/
public class Solution {
    public int numTrees(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(n==0) return 1;
        int sum=0;
        for(int i=0;i<n;i++)
        		sum+=numTrees(i)*numTrees(n-i-1);
        return sum;
    }
}