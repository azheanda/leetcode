/*
    Another solution to this problem to try divide and conquer as "more practice" indicates. The time complexity is O(nlogn).
*/


public class Solution {
    public int maxSubArray(int[] A) {
        return maxSubArray(A,0,A.length-1); 
    } 
    
    public int maxSubArray(int[] A,int l, int r){
        int leftSum=Integer.MIN_VALUE,rightSum=Integer.MIN_VALUE,sum=0;
               
        if(l==r)   //base case
            return A[l];
            
        int mid = (l+r)/2;
        int maxLeftSum = maxSubArray(A,l,mid);
        int maxRightSum = maxSubArray(A,mid+1,r);
        
        for(int i=mid;i>=l;i--){   // Note:this part is subtle.
            sum+=A[i];
            if(sum>leftSum)
                leftSum =sum;
        }
        sum=0;
        for(int i=mid+1;i<=r;i++){
            sum+=A[i];
            if(sum>rightSum)
                rightSum=sum;
        }
       
        return Math.max(Math.max(maxLeftSum,maxRightSum),rightSum+leftSum);
               
    }

    
}