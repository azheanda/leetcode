/*
    3-way partition
    loop invariant:
        A[0->p]==0
        A[p->r]== unknown
        A[r->A.length-1]==2 
*/

public class Solution {
    public void sortColors(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int p=-1,r=A.length;
        for(int q=0;q<r;q++){
            if(A[q]==0){
                p++;
                swap(A,p,q);
            }else if(A[q]==2){
                r--;
                swap(A,r,q);
                q--;   // This is because when q hits a 2, the A[r] I swap it with is an unknown value. So I let "q--",then next loop will check that value.
            }
        }       
    }
    
    public void swap(int[] A,int i,int j){
        int temp = A[i];
        A[i]=A[j];
        A[j] = temp;
    }
}