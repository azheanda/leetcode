/*
    http://askmecode.wordpress.com/2012/09/26/median-of-two-sorted-arrays/
    http://blog.unieagle.net/?p=703

    These above two links have right answers for this problem,but they both are too complicated.

    Here is a more concise one:
    http://stackoverflow.com/questions/12584648/understanding-the-algorithm-of-median-of-two-sorted-arrays
    (Helpful for understanding:http://www.leetcode.com/2011/01/find-k-th-smallest-element-in-union-of.html)
    And I rewrote it in Java:
*/

public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) { 
        return findMedianHelper(A, B, Math.max(0, (A.length-B.length)/2), Math.min(A.length-1,(A.length+B.length)/2));// don't really understand this line
    }

    public double findMedianHelper(int A[], int B[], int l, int r) {
        int m= A.length;
        int n= B.length;
        
        if (l > r) 
            return findMedianHelper2(B, A, Math.max(0, (n-m)/2), Math.min(n-1, (m+n)/2));
        int i = (l+r)/2;
        int j = (m+n)/2-i;

        assert(i >= 0 && i <= m && j >= 0 && j <= n);
        int Ai_1 = ((i == 0) ? Integer.MIN_VALUE : A[i-1]);
        int Bj_1 = ((j == 0) ? Integer.MIN_VALUE : B[j-1]);
        int Ai = ((i == m) ? Integer.MAX_VALUE : A[i]);
        int Bj = ((j == n) ? Integer.MAX_VALUE : B[j]);

        if (Ai < Bj_1) return findMedianHelper2(A,B,i+1,r);
        if (Ai > Bj) return findMedianHelper2(A,B,l,i-1);

        if (((m+n) % 2) == 1) return A[i];
        return (Math.max(Ai_1, Bj_1) + Ai) / 2.0;
    }


}
