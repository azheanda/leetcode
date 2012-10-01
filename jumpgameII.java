/*
    By christian on mitbbs
*/

public class Solution {
    public int jump(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int count = 0;
        int start=0, end=0, newend;
        while (end < A.length-1){
            count++;
            newend = 0;
            for (int i=start; i<=end; i++)
                newend = i+A[i]>newend ? (i+A[i]) : newend;
            start = end+1;
            end = newend;
        }
        return count;
    }
}


