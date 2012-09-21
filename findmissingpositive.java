/*
    The idea is to apply bucket sort to make A[i]=i if possible
*/

public class Solution {
    public int firstMissingPositive(int[] A) {

        if(A.length==0)
            return 1;
        
        int i=0;
        while(i<A.length){
            if(A[i]>=0  && A[i]<A.length && A[i]!=i && A[A[i]]!=A[i]){
                int temp = A[A[i]];
                A[A[i]] = A[i];
                A[i] = temp;
                continue;
            }
            i++;
        }
        
        // j from 1 to A.length-1, if A[j]!=j , then j must be the missing number
        for(int j=1;j<A.length;j++)
            if(A[j]!=j)
                return j;
        
        // if the sorted array is like [3,1,2], then return A.length+1
        if (A[0]==A.length) return A.length+1;

        // if the sorted array is like [0,1,2,3], then return 
        return A.length;
        
    }
}