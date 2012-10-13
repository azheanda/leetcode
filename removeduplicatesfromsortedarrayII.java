/*
    Some minor modifications of remove duplicates from sorted array.
*/
public class Solution {
    public int removeDuplicates(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int i=2;   // modification here

        while(i<A.length){
            if(A[i]>A[i-1] || A[i]>A[i-2]) // and here 
                i++;
            else{
                if(A[i-1]>=A[A.length-1] && A[i-2]>=A[A.length-1])  // here 
                    return i;
                
                for(int j=i+1;j<A.length;j++)
                    if(A[j]>A[i-1] || A[j]>A[i-2]){  // here    
                        swap(A,i,j);
                        break;
                    }            
            }
        }   
        return A.length;
    }
    
    public void swap(int[] A,int i,int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}